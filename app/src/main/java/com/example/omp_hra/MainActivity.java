package com.example.omp_hra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import static com.example.omp_hra.R.layout.activity_game;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
private static TextView tittle;
private static Button btn;
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
    }

    @Override
    public void onClick(View v) {
        Intent myIntent = new Intent(v.getContext(), Game.class);
        startActivityForResult(myIntent, 0);
    }
}