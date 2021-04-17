package com.example.tempconvert;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText inputView;
    TextView resultView;
    RadioButton ftoCButton;
    RadioButton ctoFButton;
    RadioGroup radioGroup;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputView = findViewById(R.id.input);
        resultView = findViewById(R.id.result);
        ftoCButton = findViewById(R.id.ftoc);
        ctoFButton = findViewById(R.id.ctof);
        radioGroup = findViewById(R.id.radio_group);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                updateResult();
            }
        });

        inputView.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                updateResult();
            }
        });
    }

    private float cToF(float c) {
        float result = c * 9 / 5 + 32;
        return c != 0 ? result : 0;
    }

    private float fToC(float f) {
        float result = (f - 32) * 5 / 9;
        return f != 0 ? result : 0;
    }


    private void updateResult() {
        String current = inputView.getText().toString();
        float input = current.isEmpty() ? 0 : Float.parseFloat(current);
        boolean isCtoF = ctoFButton.isChecked();
        boolean isFtoC = ftoCButton.isChecked();
        String result = "Please choose type to convert!";
        if (isCtoF) {
            result = Float.toString(cToF(input));
        }
        if (isFtoC) {
            result = Float.toString(fToC(input));
        }
        resultView.setText(result);
    }
}