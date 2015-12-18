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
    boolean decToBin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDecToBin = (Button)findViewById(R.id.btnDecToBin);
        mBinToDec = (Button)findViewById(R.id.btnBinToDec);

        mDecToBin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decToBin = true;
                nyIntent();
            }
        });

        mBinToDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decToBin = false;
                nyIntent();
            }
        });
    }

    public void nyIntent(){
        Intent intent = new Intent(this, Converter.class);
        intent.putExtra("bool", decToBin);
        startActivity(intent);
    }
}
