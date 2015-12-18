package com.steintokvam.binaryconverter;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button mDecToBin;
    Button mBinToDec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDecToBin = (Button)findViewById(R.id.btnDecToBin);
        mBinToDec = (Button)findViewById((R.id.btnBinToDec);

        mDecToBin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(this, activity2.class);
                intent.putExtra("DecToBin", 1);
                startActivity(intent);
            }
        });

        mBinToDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(this, activity2.class);
                intent.putExtra("BinToDec", 2);
                startActivity(intent);
            }
        });
    }
}
