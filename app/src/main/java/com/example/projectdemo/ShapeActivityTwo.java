package com.example.projectdemo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashSet;

public class ShapeActivityTwo extends AppCompatActivity {
    int randomInt;
    double randomDouble;
    SharedPreferences pref;
    HashSet<Integer> s;
    int coins;
    Context context;
    TextView tv;
    ImageButton grtr,retr,yetr,bltr,cor;
    int flag=0;
    String[] text={"Green Triangle","Yellow Triangle","Blue Triangle","Red Triangle"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=this;
        pref = context.getSharedPreferences(GameActivity.REGEX_STORE, Context.MODE_PRIVATE);
        coins=pref.getInt("Coins",0);
        setContentView(R.layout.activity_shapetwo);
        tv=findViewById(R.id.tv);
        grtr=findViewById(R.id.grtr);
        retr=findViewById(R.id.retr);
        bltr=findViewById(R.id.bltr);
        yetr=findViewById(R.id.yetr);
        cor=findViewById(R.id.correct);
        cor.setVisibility(View.INVISIBLE);
        ;        s=new HashSet<>();
        if(s.size()==4)
        {
            Toast.makeText(this,"Completed",Toast.LENGTH_SHORT);
        }
        randomDouble = Math.random()*text.length;
        randomInt = (int) randomDouble;
        if(!s.contains(randomInt)) {
            s.add(randomInt);
            tv.setText("Click on the "+text[randomInt]);
        }
        else
        {
            while(s.contains(randomInt))
            {
                randomDouble = Math.random()*text.length;
                randomInt = (int) randomDouble;
            }
            s.add(randomInt);
            tv.setText("Click on the "+text[randomInt]);
        }

    }

    public void next(View view) {
        ImageButton btn=(ImageButton)view;
        pref = context.getSharedPreferences(GameActivity.REGEX_STORE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        Log.d("ADebugTag", "Value: " + s.toString());
        if (btn.getId() == R.id.grtr && randomInt == 0) {
            retr.setVisibility(View.INVISIBLE);
            yetr.setVisibility(View.INVISIBLE);
            bltr.setVisibility(View.INVISIBLE);
            grtr.setVisibility(View.INVISIBLE);
            cor.setVisibility(View.VISIBLE);
            editor.putInt("Coins",pref.getInt("Coins",0)+5);
            editor.commit();
            Log.d("ADebugTag", "Value: " + "first if");
        } else if (btn.getId() == R.id.yetr && randomInt == 1) {
            retr.setVisibility(View.INVISIBLE);
            grtr.setVisibility(View.INVISIBLE);
            bltr.setVisibility(View.INVISIBLE);
            yetr.setVisibility(View.INVISIBLE);
            cor.setVisibility(View.VISIBLE);
            editor.putInt("Coins",pref.getInt("Coins",0)+5);
            editor.commit();
            Log.d("ADebugTag", "Value: " + "second if");
        } else if (btn.getId() == R.id.bltr && randomInt == 2) {
            retr.setVisibility(View.INVISIBLE);
            grtr.setVisibility(View.INVISIBLE);
            yetr.setVisibility(View.INVISIBLE);
            bltr.setVisibility(View.INVISIBLE);
            cor.setVisibility(View.VISIBLE);
            editor.putInt("Coins",pref.getInt("Coins",0)+5);
            editor.commit();
            Log.d("ADebugTag", "Value: " + "third if");
        } else if (btn.getId() == R.id.retr && randomInt == 3) {
            retr.setVisibility(View.INVISIBLE);
            grtr.setVisibility(View.INVISIBLE);
            yetr.setVisibility(View.INVISIBLE);
            bltr.setVisibility(View.INVISIBLE);
            cor.setVisibility(View.VISIBLE);
            editor.putInt("Coins",pref.getInt("Coins",0)+5);
            editor.commit();
            Log.d("ADebugTag", "Value: " + "fourth if");
        } else if (btn.getId() == R.id.correct) {
            cor.setVisibility(View.INVISIBLE);
            retr.setVisibility(View.VISIBLE);
            yetr.setVisibility(View.VISIBLE);
            bltr.setVisibility(View.VISIBLE);
            grtr.setVisibility(View.VISIBLE);
            Log.d("ADebugTag", "Value: " + "fifth if");
            if (s.size() == 4) {
                Toast toast = Toast.makeText(this, "Completed", Toast.LENGTH_LONG);
                toast.show();
                Intent intent=new Intent(this,MainActivity.class);
                startActivity(intent);
                finish();
                Log.d("ADebugTag", "Value: " +"inner if");
            } else {
                randomDouble = Math.random() * text.length;
                randomInt = (int) randomDouble;
                if (!s.contains(randomInt)) {
                    s.add(randomInt);
                    tv.setText("Click on the " + text[randomInt]);
                } else {
                    while (s.contains(randomInt)) {
                        randomDouble = Math.random() * text.length;
                        randomInt = (int) randomDouble;
                    }
                    s.add(randomInt);
                    tv.setText("Click on the " + text[randomInt]);
                }

            }
        } else {
            Log.d("ADebugTag", "Value: " + "out else");
            Toast toast = Toast.makeText(this, "Wrong", Toast.LENGTH_LONG);
            toast.show();
            tv.setText("Click on the " + text[randomInt]);
        }
    }
}
