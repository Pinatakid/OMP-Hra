package com.example.omp_hra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

import static com.example.omp_hra.R.layout.activity_game;

public class MainMenu extends AppCompatActivity implements View.OnClickListener {
    private static TextView tittle;
    private static Button btn;
    static ArrayList<String> questions = new ArrayList<>();
    static ArrayList<String> answers0= new ArrayList<>();
    static ArrayList<String> answers1 = new ArrayList<>();
    static ArrayList<String> answers2 = new ArrayList<>();
    static ArrayList<String> answers3 = new ArrayList<>();
    static ArrayList<String> answers4 = new ArrayList<>();
    static ArrayList<String> answers5 = new ArrayList<>();
    static ArrayList<String> answers6 = new ArrayList<>();
    static ArrayList<String> answers7 = new ArrayList<>();
    static ArrayList<String> answers8 = new ArrayList<>();
    static ArrayList<String> answers9 = new ArrayList<>();
    static ArrayList<String> answers10 = new ArrayList<>();
    static ArrayList<String> answers11 = new ArrayList<>();
    static ArrayList<String> answers12 = new ArrayList<>();
    static ArrayList<String> answers13 = new ArrayList<>();
    static ArrayList<String> answers14 = new ArrayList<>();
    static ArrayList<String> answers15 = new ArrayList<>();
    static ArrayList<String> answers16 = new ArrayList<>();
    static ArrayList<String> answers17 = new ArrayList<>();
    static ArrayList<String> answers18 = new ArrayList<>();
    static ArrayList<String> answers19 = new ArrayList<>();
    static ArrayList<String> answers20 = new ArrayList<>();
    static String correct0, correct1, correct2, correct3, correct4, correct5;
    static String correct6,  correct7, correct8, correct9, correct10;
    static String correct11, correct12, correct13, correct14, correct15;
    static String correct16, correct17, correct18, correct19, correct20;
@Override
  protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       requestWindowFeature(Window.FEATURE_ACTION_BAR);
       getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
              WindowManager.LayoutParams.FLAG_FULLSCREEN);
       setContentView(R.layout.activity_main);
       tittle = findViewById(R.id.tittle);
      btn = findViewById(R.id.btn);
      btn.setOnClickListener(this);
      questions.add("1+1?");
      questions.add("5+5?");
      questions.add("Hlavní město Velké Británie je:");
      questions.add("V jakém století žil Wolfgang A. Mozart?");
      questions.add("9/3?");
      questions.add("5*5?");
        questions.add("9*6?");
        questions.add("9*9?");
        questions.add("6*12?");
        questions.add("2*8?");
        questions.add("4*7?");
        questions.add("3*11?");
        questions.add("9*11?");
        questions.add("100/4?");
        questions.add("150/10?");
        questions.add("160/8?");
        questions.add("18/6?");
        questions.add("42/6?");
        questions.add("81/9?");
        questions.add("95/5?");
        questions.add("54/6?");

        answers0.add("3");
        answers0.add("5");
        answers0.add("4");
        correct0 = "2";
        answers0.add(correct0);

        answers1.add("6");
        answers1.add("8");
        answers1.add("4");
        correct1 = "10";
        answers1.add(correct1);

        answers2.add("Moskva");
        answers2.add("Paříš");
        answers2.add("Berlín");
        correct2 = "Londýn";
        answers2.add(correct2);

        answers3.add("16. století");
        answers3.add("17. století");
        answers3.add("19. století");
        correct3 = "18. století";
        answers3.add(correct3);

        answers4.add("6");
        answers4.add("8");
        answers4.add("7");
        correct4 = "3";
        answers4.add(correct4);

        answers5.add("20");
        answers5.add("30");
        answers5.add("35");
        correct5 = "25";
        answers5.add(correct5);

        answers6.add("36");
        answers6.add("42");
        answers6.add("63");
        correct6 = "54";
        answers6.add(correct6);

        answers7.add("49");
        answers7.add("68");
        answers7.add("27");
        correct7 = "81";
        answers7.add(correct7);

        answers8.add("78");
        answers8.add("60");
        answers8.add("46");
        correct8 = "72";
        answers8.add(correct8);

        answers9.add("6");
        answers9.add("12");
        answers9.add("8");
        correct9 = "16";
        answers9.add(correct9);

        answers10.add("35");
        answers10.add("48");
        answers10.add("24");
        correct10 = "28";
        answers10.add(correct10);

        answers11.add("30");
        answers11.add("28");
        answers11.add("25");
        correct11 = "33";
        answers11.add(correct11);

        answers12.add("69");
        answers12.add("77");
        answers12.add("85");
        correct12 = "99";
        answers12.add(correct12);

        answers13.add("27");
        answers13.add("30");
        answers13.add("36");
        correct13 = "25";
        answers13.add(correct13);

        answers14.add("20");
        answers14.add("18");
        answers14.add("4");
        correct14 = "15";
        answers14.add(correct14);

        answers15.add("30");
        answers15.add("27");
        answers15.add("35");
        correct15 = "20";
        answers15.add(correct15);

        answers16.add("4");
        answers16.add("2");
        answers16.add("5");
        correct16 = "3";
        answers16.add(correct16);

        answers17.add("9");
        answers17.add("6");
        answers17.add("5");
        correct17 = "7";
        answers17.add(correct17);

        answers18.add("6");
        answers18.add("8");
        answers18.add("4");
        correct18 = "9";
        answers18.add(correct18);

        answers19.add("13");
        answers19.add("15");
        answers19.add("17");
        correct19 = "19";
        answers19.add(correct19);

        answers20.add("5");
        answers20.add("8");
        answers20.add("7");
        correct20 = "9";
        answers20.add(correct20);

        Collections.shuffle(answers1);
        Collections.shuffle(answers2);
        Collections.shuffle(answers3);
        Collections.shuffle(answers4);
        Collections.shuffle(answers5);
        Collections.shuffle(answers6);
        Collections.shuffle(answers7);
        Collections.shuffle(answers8);
        Collections.shuffle(answers9);
        Collections.shuffle(answers10);
        Collections.shuffle(answers11);
        Collections.shuffle(answers12);
        Collections.shuffle(answers13);
        Collections.shuffle(answers14);
        Collections.shuffle(answers15);
        Collections.shuffle(answers16);
        Collections.shuffle(answers17);
        Collections.shuffle(answers18);
        Collections.shuffle(answers19);
        Collections.shuffle(answers20);
}

    @Override
    public void onClick(View v) {
        Intent myIntent = new Intent(v.getContext(), Game.class);
        startActivityForResult(myIntent, 0);
//        finishActivity(R.layout.activity_main);
    }
}