package com.example.projectdemo;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SocialStory extends AppCompatActivity {
String [] title={"anger","hygiene","classroombehaviour","puberty","personalspace"};
int i=0;int id=0;
Context context;
    TextView tv;
ImageButton titleview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=this;
        setContentView(R.layout.activity_socialstory);
        id = getResources().getIdentifier(title[i], "drawable", getPackageName());
        titleview=findViewById(R.id.image);
        tv=findViewById(R.id.title);
        tv.setText(title[0]);
        titleview.setImageResource(id);
    }
    public void prev(View view)
    {
        if(i==0)
        {
            id = getResources().getIdentifier(title[0], "drawable", getPackageName());
        titleview=findViewById(R.id.image);
        titleview.setImageResource(id);
        tv.setText(title[0]);
        }
        else
        {
            id = getResources().getIdentifier(title[--i], "drawable", getPackageName());
            titleview=findViewById(R.id.image);
            titleview.setImageResource(id);
            tv.setText(title[i]);
        }
    }
    public void next(View view)
    {
        if(i==4)
        {
            id = getResources().getIdentifier(title[4], "drawable", getPackageName());
            titleview=findViewById(R.id.image);
            titleview.setImageResource(id);
            tv.setText(title[4]);
        }
        else
        {
            id = getResources().getIdentifier(title[++i], "drawable", getPackageName());
            titleview=findViewById(R.id.image);
            titleview.setImageResource(id);
            tv.setText(title[i]);
        }
    }
}