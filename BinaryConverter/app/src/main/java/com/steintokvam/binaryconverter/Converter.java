package com.steintokvam.binaryconverter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Converter extends AppCompatActivity {

    TextView mTest;
    String tekst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);

        boolean standard;
        standard = false;

        Intent intent = getIntent();
        tekst = intent.getBooleanExtra("bool", standard);
        if(tekst.equals("true")){
            tekst = "1";
        }
        else {
            tekst = "2";
        }

        mTest = (TextView)findViewById(R.id.textView);
        mTest.setText(tekst);
    }
}
