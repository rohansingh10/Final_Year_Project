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
public class ShapeActivity extends AppCompatActivity {

    int randomInt;
    SharedPreferences pref;
    Context context;
    double randomDouble;
    HashSet<Integer> s;
    TextView tv;
    ImageButton tr,cr,sq,st,cor;
    int flag=0;int coins;
    String[] text={"Triangle","Circle","Square","Star"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        context=this;
        super.onCreate(savedInstanceState);
        pref = context.getSharedPreferences(GameActivity.REGEX_STORE,Context.MODE_PRIVATE);
        coins=pref.getInt("Coins",0);
        setContentView(R.layout.activity_shape);
        tv=findViewById(R.id.tv);
        tr=findViewById(R.id.tr);
        cr=findViewById(R.id.cr);
        sq=findViewById(R.id.sq);
        st=findViewById(R.id.st);
        cor=findViewById(R.id.correct);
        cor.setVisibility(View.INVISIBLE);
        s=new HashSet<>();
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
        pref = context.getSharedPreferences(GameActivity.REGEX_STORE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        ImageButton btn=(ImageButton)view;
        Log.d("ADebugTag", "Value: " + s.toString());
        if (btn.getId() == R.id.tr && randomInt == 0) {
            tr.setVisibility(View.INVISIBLE);
            cr.setVisibility(View.INVISIBLE);
            sq.setVisibility(View.INVISIBLE);
            st.setVisibility(View.INVISIBLE);
            cor.setVisibility(View.VISIBLE);
            Log.d("ADebugTag", "Value: " + "first if");
            editor.putInt("Coins",pref.getInt("Coins",0)+5);
            editor.commit();
            Log.d("ADebugTag", "Value: " + "Coins: "+ pref.getInt("Coins",0));
        } else if (btn.getId() == R.id.cr && randomInt == 1) {
            tr.setVisibility(View.INVISIBLE);
            cr.setVisibility(View.INVISIBLE);
            sq.setVisibility(View.INVISIBLE);
            st.setVisibility(View.INVISIBLE);
            cor.setVisibility(View.VISIBLE);
            Log.d("ADebugTag", "Value: " + "second if");
            editor.putInt("Coins",pref.getInt("Coins",0)+5);
            editor.commit();
        } else if (btn.getId() == R.id.sq && randomInt == 2) {
            tr.setVisibility(View.INVISIBLE);
            cr.setVisibility(View.INVISIBLE);
            sq.setVisibility(View.INVISIBLE);
            st.setVisibility(View.INVISIBLE);
            cor.setVisibility(View.VISIBLE);
            Log.d("ADebugTag", "Value: " + "third if");
        } else if (btn.getId() == R.id.st && randomInt == 3) {
            tr.setVisibility(View.INVISIBLE);
            cr.setVisibility(View.INVISIBLE);
            sq.setVisibility(View.INVISIBLE);
            st.setVisibility(View.INVISIBLE);
            cor.setVisibility(View.VISIBLE);
            Log.d("ADebugTag", "Value: " + "fourth if");
            editor.putInt("Coins",pref.getInt("Coins",0)+5);
            editor.commit();
        } else if (btn.getId() == R.id.correct) {
            cor.setVisibility(View.INVISIBLE);
            tr.setVisibility(View.VISIBLE);
            cr.setVisibility(View.VISIBLE);
            sq.setVisibility(View.VISIBLE);
            st.setVisibility(View.VISIBLE);
            Log.d("ADebugTag", "Value: " + "fifth if");
            if (s.size() == 4) {
                Toast toast = Toast.makeText(this, "Completed", Toast.LENGTH_LONG);
                toast.show();
                Intent intent=new Intent(this,ShapeActivityTwo.class);
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
