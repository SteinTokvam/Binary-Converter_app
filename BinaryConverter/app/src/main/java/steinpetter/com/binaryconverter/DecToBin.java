package steinpetter.com.binaryconverter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by SteinPetter on 19.01.2016.
 */
public class DecToBin  extends Fragment{

    TextView mResult;
    EditText mNum;
    Button mConvert;
    String decimalString;
    int currDeci;
    String result;

    public static DecToBin newInstance(){
        DecToBin fragment = new DecToBin();
        return fragment;
    }

    public DecToBin() {
    }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.dec_to_bin_fragment, container, false);
            mResult = (TextView) rootView.findViewById(R.id.txtResult);
            mNum = (EditText) rootView.findViewById(R.id.editNum);
            mConvert = (Button) rootView.findViewById(R.id.btnConvert);

            mConvert.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
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
            });

            return rootView;
        }
}
