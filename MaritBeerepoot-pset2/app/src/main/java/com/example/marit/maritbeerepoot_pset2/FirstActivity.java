package com.example.marit.maritbeerepoot_pset2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.IOException;
import java.util.stream.Stream;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }

    public void goToChoose(View view) {
        Intent intent = new Intent(this, ChooseStory.class);
        startActivity(intent);

    }

    public void readData(Context context) throws IOException {
        Stream stream = (Stream) context.getResources().getAssets().open(("madlib1_tarzan.text"));
    }



}
