package com.example.pisces;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity {
    private final static int TARGETACTIVITY_RESULTCODE = 100;

    Button bt_StartActivityFromActivity;
    TextView tv_callBack;
    FragmentManager fragmentManager = getSupportFragmentManager();
    TestFragment testFragment = new TestFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        fragmentManager.beginTransaction().replace(R.id.FragmentContent, testFragment).commit();

        bt_StartActivityFromActivity = (Button) findViewById(R.id.Bt_StartActivityFromActivity);
        tv_callBack = (TextView) findViewById(R.id.TV_callBack);
        bt_StartActivityFromActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TargetActivity.class);
                startActivityForResult(intent, TARGETACTIVITY_RESULTCODE);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //将返回数据传递下去
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TARGETACTIVITY_RESULTCODE) {
            tv_callBack.setText(getDate()+"  response result for MainActivity \n"+"resultCode is "+ resultCode);
        }
    }

    public static String getDate() {
        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String date = sDateFormat.format(new java.util.Date());
        return date;
    }
}
