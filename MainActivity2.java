package com.example.bmscalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        TextView result,bmi,inter;
        int height=bundle.getInt("Height",150);
        int weight=bundle.getInt("Weight",54);
        String res,val,interpretation;
        setContentView(R.layout.activity_main2);
        result = findViewById(R.id.result);
        bmi = findViewById(R.id.bmi);
        inter = findViewById(R.id.interpretation);
        Button reCalculate = findViewById(R.id.reCalculate);

        Calculator c = new Calculator(weight,height);
        res = c.getResult();
        val = c.calculatebmi();
        interpretation = c.getInterpretation();

        result.setText(res);
        bmi.setText(val);
        inter.setText(interpretation);

        reCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}