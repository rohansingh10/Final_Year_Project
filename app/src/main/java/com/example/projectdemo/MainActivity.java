package com.example.projectdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public ImageButton start;
    Context context;
    SharedPreferences pref;
    long time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context=this;
        TextView coin=findViewById(R.id.coins);
        pref = context.getSharedPreferences(GameActivity.REGEX_STORE, Context.MODE_PRIVATE);
        Log.d("Difference", "Value: " + "Coins: "+ pref.getInt("Coins",0));
        start=findViewById(R.id.start);
        coin.setText(Integer.toString(pref.getInt("Coins",0)));
        SharedPreferences.Editor editor = pref.edit();
        editor.putLong("Time",System.currentTimeMillis());
        editor.commit();
    }

    public void gameStart(View view) {
        Intent intent=new Intent(this,GameActivity.class);
        startActivity(intent);
    }

    public void gameStart2(View view) {
        if(pref.getInt("Coins",0)>=55)
        {
            Intent intent=new Intent(this,GameActivity6.class);
            startActivity(intent);
        }
    }
    public void goToSocial(View view)
    {
        Intent intent=new Intent(this,BabyActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        time=System.currentTimeMillis();
        SharedPreferences.Editor editor = pref.edit();
        editor.putLong("Time",time);
        editor.commit();
    }

    public void goToPlayground(View view) {
        Intent intent=new Intent(this,PlaygroundActivity.class);
        startActivity(intent);
    }
}
