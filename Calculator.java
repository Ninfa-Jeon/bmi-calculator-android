package com.example.bmscalculator;

public class Calculator {
    Calculator(int wt,int ht){
        weight = wt;
        height = ht;
        bmi = (weight / (height*height))*10000;
    }
    int weight;
    double height;
    double bmi;

    String calculatebmi(){
        return String.format("%.2f",bmi);
    }

    String getResult(){
        if (bmi >= 25)
            return "Overweight";
        else if(bmi>=18.5)
            return "Normal";
        else
            return "Underweight";
    }

    String getInterpretation(){
        if (bmi>=25.0)
            return "You have higher than normal body weight. Try to exercise more.";
        else if(bmi>=18.5)
            return "You have a normal body weight. Good job!";
        else
            return "You have lesser than normal body weight. Try to eat more.";
    }



}

