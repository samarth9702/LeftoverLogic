package com.example.leftoverlogic;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button recipeSuggesterButton;
    private Button askMeAnythingButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recipeSuggesterButton = findViewById(R.id.recipe_suggester_button);
        askMeAnythingButton = findViewById(R.id.ask_me_anything_button);

        recipeSuggesterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle recipe suggester button click
                Intent intent = new Intent(MainActivity.this, RecipeSuggesterActivity.class);
                startActivity(intent);
            }
        });

        askMeAnythingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle ask me anything button click
                Intent intent = new Intent(MainActivity.this, ChatGPT.class);
                startActivity(intent);
            }
        });
    }
}