package steinpetter.com.binaryconverter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by SteinPetter on 19.01.2016.
 */
public class BinToDec  extends Fragment{

    TextView mResult;
    EditText mNum;
    Button mConvert;
    String bin;
    int value = 0;

    public static BinToDec newInstance(){
        BinToDec fragment = new BinToDec();
        return fragment;
    }

    public BinToDec() {
    }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.bin_to_dec_fragment, container, false);

            mResult = (TextView) rootView.findViewById(R.id.txtResult);
            mNum = (EditText) rootView.findViewById(R.id.editNum);
            mConvert = (Button) rootView.findViewById(R.id.btnConvert);


        mConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bin = mNum.getText().toString();
                char[] binChar = bin.toCharArray();
                for (int j = 0; j < binChar.length; j++) {//validates input
                    /*if (binChar[j] != '1' && binChar[j] != '0') {
                        isAllowed = false;
                        Toast.makeText(this, R.getString(R.string.bin_error_toast), Toast.LENGTH_LONG).show();
                        break;
                    }*/
                }
                //if (isAllowed) {//only allowed input gets through
                    for (int i = 0; i < binChar.length; i++) {
                        if (binChar[i] == '1') {
                            value += (Math.pow(2, (binChar.length + (-i - 1))));
                        } else {
                            value += 1 * 0;
                        }
                    }
                    mResult.setText(value + "");
                    value = 0;
                //}
            }
        });

        return rootView;
    }
}
