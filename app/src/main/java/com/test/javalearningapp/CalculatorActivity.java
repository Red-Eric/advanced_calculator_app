package com.test.javalearningapp;

import android.graphics.Paint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;


public class CalculatorActivity extends AppCompatActivity {

    private String selectedMode;
    private TextView sequence;
    private TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculator);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView[] textViewsType = new TextView[]{
                findViewById(R.id.hexText),
                findViewById(R.id.decText),
                findViewById(R.id.octText),
                findViewById(R.id.binText),
        };
        textViewsType[0].setPaintFlags(textViewsType[0].getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        selectedMode = getResources().getResourceEntryName(textViewsType[0].getId()); // hexText
        sequence = findViewById(R.id.sequence);
        result = findViewById(R.id.result);

//        Log.d("ID", "ID : "+ selectedMode);

        // Handle change Mode



        Button[] allbtn = new Button[]{
                findViewById(R.id.Button00),
                findViewById(R.id.Button0),
                findViewById(R.id.Button1),
                findViewById(R.id.Button2),
                findViewById(R.id.Button3),
                findViewById(R.id.Button4),
                findViewById(R.id.Button5),
                findViewById(R.id.Button6),
                findViewById(R.id.Button7),
                findViewById(R.id.Button8),
                findViewById(R.id.Button9),
                findViewById(R.id.ButtonPlus),
                findViewById(R.id.ButtonMinus),
                findViewById(R.id.ButtonPlusMinus),
                findViewById(R.id.ButtonSquare),
                findViewById(R.id.ButtonA),
                findViewById(R.id.ButtonB),
                findViewById(R.id.ButtonC),
                findViewById(R.id.ButtonD),
                findViewById(R.id.ButtonE),
                findViewById(R.id.ButtonF),
                findViewById(R.id.ButtonEqual),
                findViewById(R.id.ButtonDiv),
                findViewById(R.id.ButtonMul),
                findViewById(R.id.ButtonModulo),
                findViewById(R.id.ButtonPright),
                findViewById(R.id.ButtonPLeft),
                findViewById(R.id.ButtonReset),
                //findViewById(R.id.ButtonVirg),
                findViewById(R.id.ButtonDel)
        };

        Button[] decBtns = new Button[]{
                findViewById(R.id.Button00),
                findViewById(R.id.Button0),
                findViewById(R.id.Button1),
                findViewById(R.id.Button2),
                findViewById(R.id.Button3),
                findViewById(R.id.Button4),
                findViewById(R.id.Button5),
                findViewById(R.id.Button6),
                findViewById(R.id.Button7),
                findViewById(R.id.Button8),
                findViewById(R.id.Button9),
                findViewById(R.id.ButtonPlus),
                findViewById(R.id.ButtonMinus),
                findViewById(R.id.ButtonPlusMinus),
                findViewById(R.id.ButtonSquare),
                findViewById(R.id.ButtonEqual),
                findViewById(R.id.ButtonDiv),
                findViewById(R.id.ButtonMul),
                findViewById(R.id.ButtonModulo),
                findViewById(R.id.ButtonPright),
                findViewById(R.id.ButtonPLeft),
                findViewById(R.id.ButtonReset),
                findViewById(R.id.ButtonDel)
        };

        Button[] octBtns = new Button[]{
                findViewById(R.id.Button00),
                findViewById(R.id.Button0),
                findViewById(R.id.Button1),
                findViewById(R.id.Button2),
                findViewById(R.id.Button3),
                findViewById(R.id.Button4),
                findViewById(R.id.Button5),
                findViewById(R.id.Button6),
                findViewById(R.id.Button7),
                findViewById(R.id.ButtonPlus),
                findViewById(R.id.ButtonMinus),
                findViewById(R.id.ButtonPlusMinus),
                findViewById(R.id.ButtonSquare),
                findViewById(R.id.ButtonEqual),
                findViewById(R.id.ButtonDiv),
                findViewById(R.id.ButtonMul),
                findViewById(R.id.ButtonModulo),
                findViewById(R.id.ButtonPright),
                findViewById(R.id.ButtonPLeft),
                findViewById(R.id.ButtonReset),
                findViewById(R.id.ButtonDel)
        };

        Button[] binBtns = new Button[]{
                findViewById(R.id.Button00),
                findViewById(R.id.Button0),
                findViewById(R.id.Button1),
                findViewById(R.id.ButtonPlus),
                findViewById(R.id.ButtonMinus),
                findViewById(R.id.ButtonPlusMinus),
                findViewById(R.id.ButtonSquare),
                findViewById(R.id.ButtonEqual),
                findViewById(R.id.ButtonDiv),
                findViewById(R.id.ButtonMul),
                findViewById(R.id.ButtonModulo),
                findViewById(R.id.ButtonPright),
                findViewById(R.id.ButtonPLeft),
                findViewById(R.id.ButtonReset),
                findViewById(R.id.ButtonDel)
        };

        // Set Button event click
        for(Button btn : allbtn){
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("TAG", "onClick: "+ btn.getText().toString() );
                    if(btn.getText().toString().equals("Del")){
                        //                            substring(0, a.length() - 1);
                        if(!sequence.getText().toString().isEmpty()){

                            String res = sequence.getText().toString().substring(0, sequence.getText().toString().length() - 1);
                            sequence.setText(res);
                        }

                    }
                    else if(btn.getText().toString().equals("CE")){
                        sequence.setText("");
                        result.setText("0");
                    }
                    else{
                        String tmp = sequence.getText().toString() + btn.getText().toString();
                        sequence.setText(tmp);
                    }
                }
            });
        }

        // Change Mode
        for (TextView mode:
                textViewsType) {
            mode.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    for (TextView mode_:
                            textViewsType) {
                        if( mode == mode_){
                            mode.setPaintFlags(mode.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
                            selectedMode = getResources().getResourceEntryName(mode_.getId());
//                            Log.d("Selected Mode", selectedMode);
                            for (Button btn:
                                 allbtn) {
                                if(selectedMode.equals("hexText")){
                                    btn.setEnabled(true);
                                }
                                if(selectedMode.equals("decText")){
                                    btn.setEnabled(Arrays.asList(decBtns).contains(btn));
                                }
                                if(selectedMode.equals("octText")){
                                    btn.setEnabled(Arrays.asList(octBtns).contains(btn));
                                }
                                if(selectedMode.equals("binText")){
                                    btn.setEnabled(Arrays.asList(binBtns).contains(btn));
                                }
                            }

                        }
                        else{
                            mode_.setPaintFlags(mode_.getPaintFlags() & (~Paint.UNDERLINE_TEXT_FLAG));
                        }
                    }
                }
            });
        }


    }
}