package com.example.pisces;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class TargetActivity extends AppCompatActivity {
    TextView tv_random;
    Button bt_return;
    int randomCode = new Random().nextInt();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tv_random = (TextView) findViewById(R.id.TV_random);
        bt_return = (Button) findViewById(R.id.Bt_return);
        tv_random.setText(String.valueOf(randomCode));

        bt_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnBackData();
            }
        });
    }
    private void returnBackData(){
        Intent data = new Intent();
        setResult(randomCode, data);
        finish();
    }
    @Override
    public void onBackPressed() {
        returnBackData();
    }
}
