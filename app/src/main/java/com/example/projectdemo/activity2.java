package com.example.projectdemo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class activity2 extends AppCompatActivity
{


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity3);



        final TextView t=(TextView) findViewById(R.id.textView);



        ImageButton click2=(ImageButton)findViewById(R.id.imageButton2);
        ImageButton click1=(ImageButton)findViewById(R.id.imageButton);
        ImageButton click3=(ImageButton)findViewById(R.id.imageButton3);
        ImageButton click4=(ImageButton)findViewById(R.id.imageButton4);
        ImageButton click5=(ImageButton)findViewById(R.id.imageButton6);

        final MediaPlayer mp1=MediaPlayer.create(getApplicationContext(), R.raw.nh);
        final MediaPlayer mp3=MediaPlayer.create(getApplicationContext(), R.raw.nb);
        final MediaPlayer mp5=MediaPlayer.create(getApplicationContext(), R.raw.g);
        final MediaPlayer mp4=MediaPlayer.create(getApplicationContext(), R.raw.ch);
        final MediaPlayer mp2=MediaPlayer.create(getApplicationContext(), R.raw.whl);


        View.OnClickListener elem = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                switch (v.getId()) {

                    case R.id.imageButton2:
                        mp2.start();
                        t.setText("IT'S A BLUE-WHALE!! ");
                        break;
                    case R.id.imageButton:
                        mp1.start();
                        t.setText("IT'S A BROWN-HORSE!!");
                        break;
                    case R.id.imageButton3:
                        mp3.start();
                        t.setText("IT'S A KINGFISHER-BIRD!!");
                        break;
                    case R.id.imageButton4:
                        mp4.start();
                        t.setText("IT'S A GROUP OF HEN!!");
                        break;
                    case R.id.imageButton6:
                        mp5.start();
                        t.setText("IT'S A WHITE-GOAT!!");
                        break;

                }
            }
        };
        click1.setOnClickListener(elem);
        click2.setOnClickListener(elem);
        click3.setOnClickListener(elem);
        click4.setOnClickListener(elem);
        click5.setOnClickListener(elem);




    }


}
