package com.example.marit.maritbeerepoot_pset2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.util.stream.Stream;

public class SecondActivity extends AppCompatActivity {

    Story madlib;
    String replacement;
    String finalstory;
    int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Get the picked story from the intent
        Intent intent = getIntent();
        madlib = (Story) intent.getSerializableExtra("madlibstory");

        //Set the placeholder
        EditText placeholder = (EditText) findViewById(R.id.placeholder);
        replacement = madlib.getNextPlaceholder();
        placeholder.setHint(replacement);

        // Set the remaing words
        TextView remainder = (TextView) findViewById(R.id.numberwords);
        number = madlib.getPlaceholderRemainingCount();
        remainder.setText(number + " word(s) left");

        // Set the text placeholder
        TextView placetext = (TextView) findViewById(R.id.placeholdertext);
        placetext.setText("This word should be a/an " + replacement);

        findViewById(R.id.placeholder).setOnClickListener(new Listen());
        findViewById(R.id.ok).setOnClickListener(new Click());
    }

    public class Listen implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            storymaker();
        }
    }

    public void storymaker() {
        EditText placeholder = (EditText) findViewById(R.id.placeholder);
        String input = placeholder.getText().toString();

        if(input.length() != 0){
            placeholder.setText("");
            madlib.fillInPlaceholder(input);

            //Set the placeholder
            EditText placeholder2 = (EditText) findViewById(R.id.placeholder);
            replacement = madlib.getNextPlaceholder();
            placeholder2.setHint(replacement);

            // Set the remaing words
            TextView remainder = (TextView) findViewById(R.id.numberwords);
            number = madlib.getPlaceholderRemainingCount();
            remainder.setText(number + " word(s) left");

            // Set the text placeholder
            TextView placetext = (TextView) findViewById(R.id.placeholdertext);
            placetext.setText("This word should be a/an " + replacement);


            if (madlib.isFilledIn() == true) {
                finalstory = madlib.toString();
                goToThird();
            }
        }
    }

    public class Click implements View.OnClickListener {
        public void onClick(View view) {
            EditText placeholder = (EditText) findViewById(R.id.placeholder);
            String input = placeholder.getText().toString();

            if(input.length() != 0){
                placeholder.setText("");
                madlib.fillInPlaceholder(input);

                //Set the placeholder
                EditText placeholder2 = (EditText) findViewById(R.id.placeholder);
                replacement = madlib.getNextPlaceholder();
                placeholder2.setHint(replacement);

                // Set the remaing words
                TextView remainder = (TextView) findViewById(R.id.numberwords);
                number = madlib.getPlaceholderRemainingCount();
                remainder.setText(number + " word(s) left");

                // Set the text placeholder
                TextView placetext = (TextView) findViewById(R.id.placeholdertext);
                placetext.setText("This word should be a/an " + replacement);


                if (madlib.isFilledIn() == true) {
                    finalstory = madlib.toString();
                    goToThird();
                }
            }
        }
    }

    public void goToThird() {
        Intent intent = new Intent(this, ThirdActivity.class);
        intent.putExtra("finalstory",finalstory);
        startActivity(intent);
        finish();
    }

}
