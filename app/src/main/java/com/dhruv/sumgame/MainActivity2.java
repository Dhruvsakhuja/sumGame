package com.dhruv.sumgame;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity2 extends AppCompatActivity {


    final ArrayList<Integer> answers = new ArrayList<Integer>();
    int locationOfCorrectAnswer;
    int score=0;
    int chance=0;
    TextView scr;
    TextView timer;
    Button playAgain;

    Button button0,button1,button2,button3;
    TextView sumText,resultTextView;

    public void generateQuestion(){
        answers.clear();
        Random rand = new Random();

        int a=rand.nextInt(21);
        int b=rand.nextInt(21);

        sumText.setText(Integer.toString(a)+ "+" +Integer.toString(b));
        locationOfCorrectAnswer = rand.nextInt(4);

        int incorrectAnswer;

        for(int i=0;i<4;i++)
        {
            if(i==locationOfCorrectAnswer){
                answers.add(a+b);}
            else {
                incorrectAnswer=rand.nextInt(41);

                while(incorrectAnswer==a+b){
                    incorrectAnswer=rand.nextInt(41);
                }

                answers.add(incorrectAnswer);
            }
        }
        button0.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));

    }

    public void playAgain(View view){
        score=0;
        chance=0;
        scr.setText("0/0");
        timer.setText("30s");
        new CountDownTimer(30100,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                button0.setVisibility(View.VISIBLE);
                button1.setVisibility(View.VISIBLE);
                button2.setVisibility(View.VISIBLE);
                button3.setVisibility(View.VISIBLE);
                scr.setVisibility(View.VISIBLE);
                timer.setVisibility(View.VISIBLE);
                sumText.setVisibility(View.VISIBLE);
                timer.setText(String.valueOf(millisUntilFinished/1000)+"s");
            }

            @Override
            public void onFinish() {
                resultTextView.setVisibility(View.VISIBLE);
                playAgain.setVisibility(View.VISIBLE);
                button0.setVisibility(View.INVISIBLE);
                button1.setVisibility(View.INVISIBLE);
                button2.setVisibility(View.INVISIBLE);
                button3.setVisibility(View.INVISIBLE);
                scr.setVisibility(View.INVISIBLE);
                timer.setVisibility(View.INVISIBLE);
                sumText.setVisibility(View.INVISIBLE);
            }
        }.start();

        playAgain.setVisibility(View.INVISIBLE);
        resultTextView.setVisibility(View.INVISIBLE);

    }

    public void chooseAnswer(View view){

        if(view.getTag().toString().equals(Integer.toString(locationOfCorrectAnswer))){
            score++;
            Toast.makeText(this,"Correct",Toast.LENGTH_SHORT).show();
        } else{
            Toast.makeText(this,"Wrong!",Toast.LENGTH_SHORT).show();
        }
        chance++;
        scr.setText(Integer.toString(score) + "/" + Integer.toString(chance));
        generateQuestion();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        new CountDownTimer(30100,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                button0.setVisibility(View.VISIBLE);
                button1.setVisibility(View.VISIBLE);
                button2.setVisibility(View.VISIBLE);
                button3.setVisibility(View.VISIBLE);
                scr.setVisibility(View.VISIBLE);
                timer.setVisibility(View.VISIBLE);
                sumText.setVisibility(View.VISIBLE);
                timer.setText(String.valueOf(millisUntilFinished/1000)+"s");
            }

            @Override
            public void onFinish() {
                button0.setVisibility(View.INVISIBLE);
                button1.setVisibility(View.INVISIBLE);
                button2.setVisibility(View.INVISIBLE);
                button3.setVisibility(View.INVISIBLE);
                scr.setVisibility(View.INVISIBLE);
                timer.setVisibility(View.INVISIBLE);
                sumText.setVisibility(View.INVISIBLE);
                resultTextView.setVisibility(View.VISIBLE);
                playAgain.setVisibility(View.VISIBLE);
            }
        }.start();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        sumText = (TextView)findViewById(R.id.sumOf);
        button0 = (Button)findViewById(R.id.button0);
        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        scr = (TextView)findViewById(R.id.score);
        timer = (TextView)findViewById(R.id.timer);
        resultTextView = (TextView)findViewById(R.id.resultTextView);
        playAgain = (Button)findViewById(R.id.playAgain);

        generateQuestion();


    }
}
