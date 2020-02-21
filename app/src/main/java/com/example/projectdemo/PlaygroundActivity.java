package com.example.projectdemo;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PlaygroundActivity extends AppCompatActivity {
    private String[] kid={"kidhi","kidcry","kidangry","kidlaugh","kidthink"};
    private String[] activity={"Share"};
    int id;
    ImageButton ib;
    ImageButton ib1;
    ImageButton ib2;
    SharedPreferences pref;
    Context context;
    int randomInt;
    TextView kiddisplay;
    // private int hunger,tiredness;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playground);
        context =this;
        pref = context.getSharedPreferences(GameActivity.REGEX_STORE, Context.MODE_PRIVATE);
        ib=findViewById(R.id.kid);
        kiddisplay=findViewById(R.id.playgrounddisplay);
        double randomDouble = Math.random();
        ib1=findViewById(R.id.activity1);
        ib2=findViewById(R.id.activity2);
        randomDouble = randomDouble * kid.length;
        randomInt = (int) randomDouble;
        if(randomInt==0)
        {
            kiddisplay.setText("                       Rahul Gave You A Chocolate");
            ib1.setImageResource(R.drawable.share);
            ib2.setImageResource(R.drawable.keep);
        }
            id = getResources().getIdentifier(kid[randomInt], "drawable", getPackageName());
            ib=findViewById(R.id.kid);
            ib.setImageResource(id);

        }

    public void share(View view) {

    }
    public void keep(View view) {
        id = getResources().getIdentifier(kid[2], "drawable", getPackageName());
        ib=findViewById(R.id.kid);
        ib.setImageResource(id);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Magic here
                id = getResources().getIdentifier(kid[1], "drawable", getPackageName());
                ib=findViewById(R.id.kid);
                ib.setImageResource(id);
            }
        }, 2000);
    }
}


