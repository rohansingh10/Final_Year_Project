package com.example.projectdemo;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class PlaygroundActivity extends AppCompatActivity {
    private TextToSpeech mTTs;
    MediaPlayer sing;
    MediaPlayer sing1;
    private String[] kidm={"kidhi","kidcry","kidlaugh","kidthink","kidangry"};
    private String[] kidf={"girlhappy","girlsmile","girlangry","girlcry","girlplay"};
    int id,idf;
    ImageButton boy;
    ImageButton ib1;
    ImageButton ib2;
    ImageButton girl;int flag=0,cry=0;
    SharedPreferences pref;
    Context context;
    final Locale locale=new Locale("hi_IN");
    int randomInt,randomIntf;double randomDoublef;
    TextView kiddisplay;
    // private int hunger,tiredness;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playground);
        context =this;
        pref = context.getSharedPreferences(GameActivity.REGEX_STORE, Context.MODE_PRIVATE);
        boy=findViewById(R.id.kid);
        kiddisplay=findViewById(R.id.playgrounddisplay);
        double randomDouble = Math.random();
        ib1=findViewById(R.id.activity1);
        ib2=findViewById(R.id.activity2);
        ib1.setEnabled(false);
        ib2.setEnabled(false);
        girl=findViewById(R.id.kidf);
        randomDouble = randomDouble * (kidm.length-1);
        randomInt = (int) randomDouble;
        randomDoublef = Math.random();
        randomDoublef = randomDoublef * (kidf.length);
        randomIntf = (int) randomDoublef;
        Log.d("ADebugTag", Integer.toString(randomIntf));

        if(randomInt==0&&randomIntf!=4)
        {
            String text="Rahul Gave You A Chocolate";
            kiddisplay.setText(text);
            ib1.setEnabled(true);
            ib2.setEnabled(true);
            ib1.setImageResource(R.drawable.share);
            ib2.setImageResource(R.drawable.keep);
            mTTs = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
                @Override
                public void onInit(int status) {
                    if (status == TextToSpeech.SUCCESS) {
                        int result = mTTs.setLanguage(locale);

                        if (result == TextToSpeech.LANG_MISSING_DATA
                                || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                            Log.e("TTS", "Language not supported");

                        }mTTs.speak("Rahul Gave You A Chocolate",TextToSpeech.QUEUE_ADD,null,null);
                    } else {
                        Log.e("TTS", "Initialization failed");
                    }
                }
            });

        }
        else if(randomIntf==4&&randomInt!=0)
        {
            kiddisplay.setText("Sneha Wants to Play With You");
            flag=1;
            ib1.setEnabled(true);
            ib2.setEnabled(true);
            ib1.setImageResource(R.drawable.playwithboth);
            ib2.setImageResource(R.drawable.playwithrahul);
            mTTs = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
                @Override
                public void onInit(int status) {
                    if (status == TextToSpeech.SUCCESS) {
                        int result = mTTs.setLanguage(locale);

                        if (result == TextToSpeech.LANG_MISSING_DATA
                                || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                            Log.e("TTS", "Language not supported");

                        }mTTs.speak("Sneha Wants to Play With You",TextToSpeech.QUEUE_ADD,null,null);
                    } else {
                        Log.e("TTS", "Initialization failed");
                    }
                }
            });
        }
            id = getResources().getIdentifier(kidm[randomInt], "drawable", getPackageName());
            boy=findViewById(R.id.kid);
            boy.setImageResource(id);
            idf = getResources().getIdentifier(kidf[randomIntf], "drawable", getPackageName());
            girl.setImageResource(idf);
        }


    public void share(View view) {
        if(cry==1)
            sing.stop();
        cry=0;
        sing= MediaPlayer.create(context,R.raw.kidhappysound);
        sing.start();
        if(flag==1)
        {
            girl.setImageResource(R.drawable.girlhappy);
            id = getResources().getIdentifier(kidm[2], "drawable", getPackageName());
            Log.d("ADebugTag", "here");
            boy.setImageResource(R.drawable.kidlaugh);
            cry=0;
            return;
        }
        id = getResources().getIdentifier(kidm[2], "drawable", getPackageName());
        boy=findViewById(R.id.kid);
        boy.setImageResource(id);
        girl.setImageResource(R.drawable.girlhappy);
    }
    public void keep(View view) {
        cry=1;
        if (flag == 1) {
            boy.setImageResource(R.drawable.kidlaugh);
            girl.setImageResource(R.drawable.girlangry);
            new CountDownTimer(1500, 1000) {
                public void onFinish() {
                    // When timer is finished
                    // Execute your code here
                    if(cry==1)
                    {
                        girl.setImageResource(R.drawable.girlcry);
                        sing= MediaPlayer.create(context,R.raw.girlcrysound);
                        sing.start();
                    }

                }
                @Override
                public void onTick(long l) {

                }
            }.start();
            return;
        }
        boy.setImageResource(R.drawable.kidangry);
        girl.setImageResource(R.drawable.girlangry);
        new CountDownTimer(1500, 1000) {
            public void onFinish() {
                // When timer is finished
                // Execute your code here
                if(cry==1)
                {
                    boy.setImageResource(R.drawable.kidcry);
                    girl.setImageResource(R.drawable.girlcry);
                    sing= MediaPlayer.create(context,R.raw.girlcrysound);
                    sing.start();
                }

            }

            @Override
            public void onTick(long l) {

            }
        }.start();
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
}


