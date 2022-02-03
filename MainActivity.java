package com.example.bmscalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    int wt = 50;
    int age = 20;
    int ht = 120;
    boolean m = true;
    boolean f = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("BMI Calculator");
        FloatingActionButton weightDown = findViewById(R.id.weightDown);
        FloatingActionButton weightUp = findViewById(R.id.weightUp);
        FloatingActionButton ageDown = findViewById(R.id.ageDown);
        FloatingActionButton ageUp = findViewById(R.id.ageUp);
        Button male = findViewById(R.id.male);
        Button female = findViewById(R.id.female);
        TextView weight = findViewById(R.id.weight);
        TextView Age = findViewById(R.id.age);
        TextView height = findViewById(R.id.height);
        SeekBar seekBar=(SeekBar)findViewById(R.id.seekBar);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                height.setText((ht+progress)+" cm");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //
                ht=120;
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
               //
                ht+=seekBar.getProgress();
            }
        });
        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(m) {
                    male.setTextColor(Color.RED);
                    female.setTextColor(Color.WHITE);
                    m=false;
                    f=true;
                }

            }
        });

        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(f){
                    female.setTextColor(Color.RED);
                    male.setTextColor(Color.WHITE);
                    f=false;
                    m=true;
                }
            }
        });

        weightDown.setOnClickListener(new View.OnClickListener (){
            public void onClick(View v){
                wt--;
                weight.setText(wt+" kg");
            }
        });
        weightUp.setOnClickListener(new View.OnClickListener (){
            public void onClick(View v){
                wt++;
                weight.setText(wt+" kg");
            }
        });
        ageDown.setOnClickListener(new View.OnClickListener (){
            public void onClick(View v){
                age--;
                Age.setText(age+" yr");
            }
        });
        ageUp.setOnClickListener(new View.OnClickListener (){
            public void onClick(View v){
                age++;
                Age.setText(age+" yr");
            }
        });

        Button calculate = findViewById(R.id.calculate);

        // Add_button add clicklistener
        calculate.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v)
            {

                // Intents are objects of the android.content.Intent type. Your code can send them
                // to the Android system defining the components you are targeting.
                // Intent to start an activity called SecondActivity with the following code:

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);

                Bundle bundle = new Bundle();
                System.out.println(ht+" "+wt);
                bundle.putInt("Height",ht);
                bundle.putInt("Weight",wt);
                intent.putExtras(bundle);

                // start the activity connect to the specified class
                startActivity(intent);
            }
        });

    }
}