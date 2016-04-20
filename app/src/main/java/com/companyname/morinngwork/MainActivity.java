package com.companyname.morinngwork;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int DEFAULT_TEXT_SIZE = 15;
    private static final int DEFAULT_COLOR = Color.BLACK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        TextView textOne = (TextView) findViewById(R.id.text_one);
        TextView textTwo = (TextView) findViewById(R.id.text_two);

        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("secretKey", Context.MODE_PRIVATE);
        int textViewOneSize = sharedPreferences.getInt("textViewOneSize", DEFAULT_TEXT_SIZE);
        int textViewTwoSize = sharedPreferences.getInt("textViewTwoSize", DEFAULT_TEXT_SIZE);
        int textViewOneColor = sharedPreferences.getInt("textViewOneColor", DEFAULT_COLOR);
        int textViewTwoColor = sharedPreferences.getInt("textViewTwoColor", DEFAULT_COLOR);

        textOne.setTextSize(textViewOneSize);
        textTwo.setTextSize(textViewTwoSize);
        textOne.setTextColor(textViewOneColor);
        textTwo.setTextColor(textViewTwoColor);
    }

    public void clickedNextActivity(View view) {
        Intent intent = new Intent(MainActivity.this, Settings.class);
        startActivity(intent);
    }
}
