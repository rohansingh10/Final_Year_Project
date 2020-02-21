package com.example.projectdemo;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BabyActivity extends AppCompatActivity {
    private String[] babyimage={"babycuddle","babysleep","babycry","babyfeed","babyplay"};
    int id;
    ImageButton ib;
    SharedPreferences pref;
    Context context;
    int randomInt;
    TextView babydisplay;
   // private int hunger,tiredness;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baby);
        context =this;
        pref = context.getSharedPreferences(GameActivity.REGEX_STORE, Context.MODE_PRIVATE);
        babydisplay=findViewById(R.id.babydisplay);
        Log.d("ADebugTag", "till here");

        long timenow=System.currentTimeMillis();
        Log.d("PrefTimeafterfeed", ((Long)Math.abs(pref.getLong("Time",0))).toString());
        Log.d("Difference", ((Long)Math.abs(pref.getLong("Time",0)-System.currentTimeMillis())).toString());
        if(Math.abs(pref.getLong("Time",0)-System.currentTimeMillis())>14400000)
        {
            //Log.d("Preftimebeforefeed", ((Long)Math.abs(pref.getLong("Time",0))).toString());
            id = getResources().getIdentifier(babyimage[2], "drawable", getPackageName());
            ib=findViewById(R.id.baby);
            ib.setImageResource(id);
            babydisplay.setText("The Baby Has Not Been Fed For Long");
        }
        else
        {

            do{
                double randomDouble = Math.random();
                randomDouble = randomDouble * babyimage.length;
                randomInt = (int) randomDouble;
            }while(randomInt==2);
            id = getResources().getIdentifier(babyimage[randomInt], "drawable", getPackageName());
            ib=findViewById(R.id.baby);
            ib.setImageResource(id);
            if(randomInt==3)
            {
                SharedPreferences.Editor editor = pref.edit();
                editor.putLong("Time",System.currentTimeMillis());
                //Log.d("PrefTimeafterfeed", ((Long)Math.abs(pref.getLong("Time",0))).toString());
                editor.commit();
            }

        }
    }
    public void feed(View view)
    {
        id = getResources().getIdentifier(babyimage[3], "drawable", getPackageName());
        ib.setImageResource(id);
        SharedPreferences.Editor editor = pref.edit();
        //Log.d("Now", ((Long)System.currentTimeMillis()).toString());
        editor.putLong("Time",System.currentTimeMillis());
        editor.commit();
        //Log.d("PrefTimeafterfeed", ((Long)Math.abs(pref.getLong("Time",0))).toString());
    }
    public void sleep(View view)
    {
        id = getResources().getIdentifier(babyimage[1], "drawable", getPackageName());
        ib.setImageResource(id);
    }
    public void play(View view)
    {
        id = getResources().getIdentifier(babyimage[4], "drawable", getPackageName());
        ib.setImageResource(id);
    }
    public void cuddle(View view)
    {
        id = getResources().getIdentifier(babyimage[0], "drawable", getPackageName());
        ib.setImageResource(id);
    }
    public void slap(View view)
    {
        id = getResources().getIdentifier(babyimage[2], "drawable", getPackageName());
        ib.setImageResource(id);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
