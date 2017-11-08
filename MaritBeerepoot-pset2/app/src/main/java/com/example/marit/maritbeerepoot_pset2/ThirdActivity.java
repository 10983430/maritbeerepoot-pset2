package com.example.marit.maritbeerepoot_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    String finalstory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        // Get the picked story from the intent
        Intent intent = getIntent();
        finalstory = (String) intent.getSerializableExtra("finalstory");

        // Put the story in the view
        TextView textView = findViewById(R.id.outputField);
        textView.setText(finalstory);
    }

    public void goToFirst(View view){
        Intent intent = new Intent(this, FirstActivity.class);
        startActivity(intent);
    }
}
