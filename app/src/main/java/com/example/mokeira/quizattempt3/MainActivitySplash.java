package com.example.mokeira.quizattempt3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivitySplash extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_page);
    }

    public void onStartButtonClick(View view)
    {
        Intent intent;
        intent = new Intent(this, MainActivityQuiz.class);
        startActivity(intent);
        finish();
    }
}
