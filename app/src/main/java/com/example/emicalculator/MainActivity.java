package com.example.emicalculator;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText et1,et2,et3;
    TextView emiresult;
    Button bmicalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.loan);
        et2  = findViewById(R.id.rate);
        et3 = findViewById(R.id.timeinstallment);
        bmicalculate =findViewById(R.id.bmicalculate);
        emiresult =findViewById(R.id.emiresult);

        bmicalculate.setOnClickListener (this);
    }


    @Override
    public void onClick(View v) {

        String st1 = et1.getText().toString();
        String st2 = et2.getText().toString();
        String st3 = et3.getText().toString();

        if (TextUtils.isEmpty(st1)) {
            et1.setError("Enter loan Amount");
            et1.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(st2)) {
            et2.setError("Enter Interest Rate");
            et2.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(st3)) {
            et3.setError("Enter months");
            et3.requestFocus();
            return;
        }
        float loan = Float.parseFloat(et1.getText().toString ());
        float rate = Float.parseFloat(et2.getText().toString ());
        float timeinstallment = Float.parseFloat(et3.getText().toString ());
        float   emi =  emical(loan,rate,timeinstallment);
        emiresult.setText(String.format("%.2f",emi));

    }
    // Calcuating EMI
    static float emical(float p, float r, float t){
        float  r1 = r / (12 * 100);
        float t1 = t * 12;
        float em = (p * r1 * (float)Math.pow(1 + r1, t1)) / (float)(Math.pow(1 + r1, t1) - 1);

        return (em);  // Returning emi value


    }
}