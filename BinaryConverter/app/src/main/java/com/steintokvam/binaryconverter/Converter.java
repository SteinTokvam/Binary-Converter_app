package com.steintokvam.binaryconverter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Converter extends AppCompatActivity {

    TextView mResult;
    EditText mNum;
    Button mConvert;
    String tekst = "";
    String decimalString;
    String bin;
    int value = 0;
    int currDeci;
    String result;
    boolean isAllowed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);

        mResult = (TextView) findViewById(R.id.txtResult);
        mNum = (EditText) findViewById(R.id.editNum);
        mConvert = (Button) findViewById(R.id.btnConvert);

        Intent intent = getIntent();
        tekst = intent.getStringExtra("isBin");

        mConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (value != 0) { // reset value for more converting
                    value = 0;
                }
                if (tekst.equals("1")) {//BinToDec
                    BinToDec();
                    isAllowed = true; //reset bool
                } else {
                    DecToBin();
                }
            }
        });
    }

    private void DecToBin() {
        result = "";
        decimalString = mNum.getText().toString();
        currDeci=Integer.parseInt(decimalString);
        if(decimalString.equals("0")){
            mResult.setText("0");
        }

        while(currDeci!=0){
            if(currDeci%2==0){
                currDeci=currDeci/2;
                result+="0";
            }
            else{
                result +="1";
                currDeci= currDeci/2;
            }
        }
        char[] turn = result.toCharArray();
        for (int i = 0; i < turn.length / 2; i++) {
            char temp = turn[i];
            turn[i] = turn[turn.length - 1 - i];
            turn[turn.length - 1 - i] = temp;
        }
        result = "";
        for(int j = 0; j<turn.length;j++){
            result+=turn[j];
        }
        System.out.println(result);
        mResult.setText(result);
    }

    private void BinToDec() {
        bin = mNum.getText().toString();
        char[] binChar = bin.toCharArray();
        for (int j = 0; j < binChar.length; j++) {//validates input
            if (binChar[j] != '1' && binChar[j] != '0') {
                isAllowed = false;
                Toast.makeText(this, R.string.error_not_bin, Toast.LENGTH_LONG).show();
                break;
            }
        }
        if (isAllowed) {//only allowed input gets through
            for (int i = 0; i < binChar.length; i++) {
                if (binChar[i] == '1') {
                    value += (Math.pow(2, (binChar.length + (-i - 1))));
                } else {
                    value += 1 * 0;
                }
            }
            mResult.setText(value + "");
        }
    }
}
