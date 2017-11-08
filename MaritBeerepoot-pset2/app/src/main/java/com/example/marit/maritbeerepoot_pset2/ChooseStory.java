package com.example.marit.maritbeerepoot_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Random;

public class ChooseStory extends AppCompatActivity {

    String madlib;
    String[] choose = {"madlib0_simple.txt", "madlib1_tarzan.txt", "madlib2_university.txt", "madlib3_clothes.txt", "madlib4_dance.txt"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_story);

        findViewById(R.id.simple).setOnClickListener(new Checkboxes());
        findViewById(R.id.tarzan).setOnClickListener(new Checkboxes());
        findViewById(R.id.university).setOnClickListener(new Checkboxes());
        findViewById(R.id.clothes).setOnClickListener(new Checkboxes());
        findViewById(R.id.dance).setOnClickListener(new Checkboxes());
        findViewById(R.id.random).setOnClickListener(new Checkboxes());
    }

    public class Checkboxes implements View.OnClickListener {

        @Override
        public void Click(View view) {
            switch (view.getId()) {
                case R.id.simple:
                    madlib = "madlib0_simple.txt";
                    goToSecond();
                    break;
                case R.id.tarzan:
                    madlib = "madlib1_tarzan.txt";
                    goToSecond();
                    break;
                case R.id.university:
                    madlib = "madlib2_universiry.txt";
                    goToSecond();
                    break;
                case R.id.clothes:
                    madlib = "madlib3_clothes.txt";
                    goToSecond();
                    break;
                case R.id.dance:
                    madlib = "madlib4_dance.txt";
                    goToSecond();
                    break;
                case R.id.random:
                    madlib = choose[new Random().nextInt(choose.length)];
                    goToSecond();
                    break;
            }
        }
    }

    public void goToSecond(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);

    }
}
