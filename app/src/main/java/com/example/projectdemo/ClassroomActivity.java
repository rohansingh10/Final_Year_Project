package com.example.projectdemo;


import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class ClassroomActivity extends AppCompatActivity {
    private TextToSpeech mTTs;
    MediaPlayer sing;
    MediaPlayer sing1;
    private String[] kidm={"classexcited","classcry","classhappy","classsad","classangry"};
    //private String[] kidf={"girlhappy","girlsmile","girlangry","girlcry","girlplay"};
    int id,idf;
    ImageButton boyandteach;
    ImageButton ib1;
    ImageButton ib2;
    ImageButton ib3;
    ImageButton girl;int flag=0,cry=0;
    SharedPreferences pref;
    Context context;
    public static final String REGEX_STORE = "RegexStore";
    int friendship=100;
    final Locale locale=new Locale("hi_IN");
    int randomInt,randomIntf;double randomDoublef;
    TextView classdisplay;
    // private int hunger,tiredness;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    protected void onCreate(Bundle savedInstanceState) {
        context =this;
        /*pref = context.getSharedPreferences(GameActivity.REGEX_STORE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt("Friendship",pref.getInt("Friendship",0));
        editor.commit();*/
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classroom);
        pref = context.getSharedPreferences(GameActivity.REGEX_STORE, Context.MODE_PRIVATE);
        boyandteach=findViewById(R.id.kid);
        classdisplay=findViewById(R.id.classroomdisplay);
        double randomDouble = Math.random();
        ib1=findViewById(R.id.activity1);
        ib2=findViewById(R.id.activity2);
        ib3=findViewById(R.id.activity3);

        ib1.setEnabled(false);
        ib2.setEnabled(false);
        ib3.setEnabled(false);
        randomDouble = randomDouble * (kidm.length+1);
        randomInt = (int) randomDouble;
        if(randomInt==5) {
            boyandteach = findViewById(R.id.classkidandteacher);
            boyandteach.setImageResource(R.drawable.teachernormal);
        }
        else {
            id = getResources().getIdentifier(kidm[randomInt], "drawable", getPackageName());
            boyandteach = findViewById(R.id.classkidandteacher);
            boyandteach.setImageResource(id);
        }

    }


    public void share(View view) {

    }
    public void keep(View view) {

    }

    @Override
    public void onBackPressed() {
        if(cry==1)
            sing.stop();
        super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        if (mTTs != null) {
            mTTs.stop();
            mTTs.shutdown();
        }

        super.onDestroy();
    }

    public void special(View view) {
        Toast.makeText(
                context,
                "Sometimes not meddling is the right way to go",
                Toast.LENGTH_SHORT
        ).show();
    }
}



