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

        Intent intent = getIntent();
        tekst = intent.getStringExtra("isBin");
        if(tekst.equals("1")){
            tekst = "BinToDec";
        }
        else {
            tekst = "DecToBin";
        }

        mTest = (TextView)findViewById(R.id.textView);
        mTest.setText(tekst);
    }
}
