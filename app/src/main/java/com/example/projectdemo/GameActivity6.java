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

public class GameActivity6 extends AppCompatActivity {
    int randomInt;
    SharedPreferences pref;
    Context context;
    public static final String REGEX_STORE = "RegexStore";
    double randomDouble;
    HashSet<Integer> s;
    TextView tv;
    ImageButton gre,red,blu,yel,cor,pu,bl;
    int flag=0;
    String[] text={"red","yellow","green","blue","purple","black"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game6);
        context=this;
        tv=findViewById(R.id.text);
        gre=findViewById(R.id.g);
        red=findViewById(R.id.r);
        blu=findViewById(R.id.bl);
        yel=findViewById(R.id.y);
        pu=findViewById(R.id.pu);
        bl=findViewById(R.id.b);
        cor=findViewById(R.id.correct);
        cor.setVisibility(View.INVISIBLE);
        s=new HashSet<>();
        if(s.size()==6)
        {
            Toast.makeText(this,"Completed",Toast.LENGTH_SHORT);
        }
        randomDouble = Math.random()*text.length;
        randomInt = (int) randomDouble;
        if(!s.contains(randomInt)) {
            s.add(randomInt);
            tv.setText("Click on the "+text[randomInt]+" Colour");
        }
        else
        {
            while(s.contains(randomInt))
            {
                randomDouble = Math.random()*text.length;
                randomInt = (int) randomDouble;
            }
            s.add(randomInt);
            tv.setText("Click on the "+text[randomInt]+" Colour");
        }
    }
    public void next(View view) {
        ImageButton btn=(ImageButton)view;
        pref = context.getSharedPreferences(GameActivity.REGEX_STORE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        Log.d("ADebugTag", "Value: " + s.toString());
        if (btn.getId() == R.id.r && randomInt == 0) {
            gre.setVisibility(View.INVISIBLE);
            red.setVisibility(View.INVISIBLE);
            yel.setVisibility(View.INVISIBLE);
            blu.setVisibility(View.INVISIBLE);
            cor.setVisibility(View.VISIBLE);
            Log.d("ADebugTag", "Value: " + "first if");
            editor.putInt("Coins",pref.getInt("Coins",0)+5);
            editor.commit();
        } else if (btn.getId() == R.id.y && randomInt == 1) {
            gre.setVisibility(View.INVISIBLE);
            red.setVisibility(View.INVISIBLE);
            yel.setVisibility(View.INVISIBLE);
            blu.setVisibility(View.INVISIBLE);
            cor.setVisibility(View.VISIBLE);
            Log.d("ADebugTag", "Value: " + "second if");
            editor.putInt("Coins",pref.getInt("Coins",0)+5);
            editor.commit();
        } else if (btn.getId() == R.id.g && randomInt == 2) {
            gre.setVisibility(View.INVISIBLE);
            red.setVisibility(View.INVISIBLE);
            yel.setVisibility(View.INVISIBLE);
            blu.setVisibility(View.INVISIBLE);
            cor.setVisibility(View.VISIBLE);
            editor.putInt("Coins",pref.getInt("Coins",0)+5);
            editor.commit();
            Log.d("ADebugTag", "Value: " + "third if");
        } else if (btn.getId() == R.id.bl && randomInt == 3) {
            gre.setVisibility(View.INVISIBLE);
            red.setVisibility(View.INVISIBLE);
            yel.setVisibility(View.INVISIBLE);
            blu.setVisibility(View.INVISIBLE);
            cor.setVisibility(View.VISIBLE);
            Log.d("ADebugTag", "Value: " + "fourth if");
            editor.putInt("Coins",pref.getInt("Coins",0)+5);
            editor.commit();
        }else if (btn.getId() == R.id.pu && randomInt == 4) {
            gre.setVisibility(View.INVISIBLE);
            red.setVisibility(View.INVISIBLE);
            yel.setVisibility(View.INVISIBLE);
            blu.setVisibility(View.INVISIBLE);
            cor.setVisibility(View.VISIBLE);
            Log.d("ADebugTag", "Value: " + "fourth if");
            editor.putInt("Coins",pref.getInt("Coins",0)+5);
            editor.commit();
        }else if (btn.getId() == R.id.b && randomInt == 5) {
            gre.setVisibility(View.INVISIBLE);
            red.setVisibility(View.INVISIBLE);
            yel.setVisibility(View.INVISIBLE);
            blu.setVisibility(View.INVISIBLE);
            cor.setVisibility(View.VISIBLE);
            Log.d("ADebugTag", "Value: " + "fourth if");
            editor.putInt("Coins",pref.getInt("Coins",0)+5);
            editor.commit();
        } else if (btn.getId() == R.id.correct) {
            cor.setVisibility(View.INVISIBLE);
            gre.setVisibility(View.VISIBLE);
            red.setVisibility(View.VISIBLE);
            yel.setVisibility(View.VISIBLE);
            blu.setVisibility(View.VISIBLE);
            Log.d("ADebugTag", "Value: " + "fifth if");
            if (s.size() == 6) {
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
                    tv.setText("Click on the " + text[randomInt] + " Colour");
                } else {
                    while (s.contains(randomInt)) {
                        randomDouble = Math.random() * text.length;
                        randomInt = (int) randomDouble;
                    }
                    s.add(randomInt);
                    tv.setText("Click on the " + text[randomInt] + " Colour");
                }

            }
        } else {
            Log.d("ADebugTag", "Value: " + "out else");
            Toast toast = Toast.makeText(this, "Wrong", Toast.LENGTH_LONG);
            toast.show();
            tv.setText("Click on the " + text[randomInt] + " Colour");
        }
    }
}
