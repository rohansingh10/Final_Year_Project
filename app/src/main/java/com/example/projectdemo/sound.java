package com.example.projectdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class sound extends AppCompatActivity
{

    private Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);
        b1 = (Button) findViewById(R.id.next2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                openactivity2();
            }
        });

    }

    public void openactivity2() {
        Intent intent = new Intent(this, activity2.class);
        startActivity(intent);
    }
}
