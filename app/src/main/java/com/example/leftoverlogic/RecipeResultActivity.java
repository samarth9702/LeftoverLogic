package com.example.leftoverlogic;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Collections;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecipeResultActivity extends AppCompatActivity {

    private TextView recipeName;
    private Button shareButton;
    private ProgressBar progressBar;
    private ScrollView scrollView;
    private ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_result);

        recipeName = findViewById(R.id.recipe_name);
        shareButton = findViewById(R.id.share_button);
        progressBar = findViewById(R.id.progress_bar);
        scrollView = findViewById(R.id.scrollView);
        logo = findViewById(R.id.logo);

        // Get the prompt from the Intent
        Intent intent = getIntent();
        String prompt = intent.getStringExtra("prompt");

        // Load recipe data from the API
        loadRecipeData(prompt);

        shareButton.setOnClickListener(v -> shareRecipe());
    }

    private void loadRecipeData(String prompt) {
        // Show the progress bar and hide the content
        progressBar.setVisibility(View.VISIBLE);
        scrollView.setVisibility(View.GONE);

        // Create the request object
        ChatRequest chatRequest = new ChatRequest(prompt, Collections.emptyList());

        // Get the Retrofit client and create the service
        ApiService apiService = RetrofitClient.getClient().create(ApiService.class);

        // Make the API call
        apiService.getChatResponse(chatRequest).enqueue(new Callback<ChatResponse>() {
            @Override
            public void onResponse(Call<ChatResponse> call, Response<ChatResponse> response) {
                // Hide the progress bar and show the content
                progressBar.setVisibility(View.GONE);
                scrollView.setVisibility(View.VISIBLE);

                if (response.isSuccessful() && response.body() != null) {
                    recipeName.setText(response.body().getMessage());
                } else {
                    Toast.makeText(RecipeResultActivity.this, "Error retrieving recipe", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ChatResponse> call, Throwable t) {
                // Hide the progress bar
                progressBar.setVisibility(View.GONE);
                scrollView.setVisibility(View.VISIBLE);

                Toast.makeText(RecipeResultActivity.this, "API call failed: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("RecipeResultActivity", "API call failed", t);
            }
        });
    }

    private void shareRecipe() {
        String recipeText = recipeName.getText().toString();

        // Convert the drawable resource to a bitmap
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.logo);

        // Save the bitmap to a file
        File cachePath = new File(getCacheDir(), "images");
        cachePath.mkdirs(); // Make sure the directory exists
        File file = new File(cachePath, "logo.png");
        try (FileOutputStream stream = new FileOutputStream(file)) {
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Error saving image", Toast.LENGTH_SHORT).show();
            return;
        }

        // Get the URI of the saved file
        Uri imageUri = FileProvider.getUriForFile(this, getPackageName() + ".fileprovider", file);

        // Create the share intent
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_TEXT, recipeText);
        shareIntent.putExtra(Intent.EXTRA_STREAM, imageUri);
        shareIntent.setType("image/png");
        shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

        // Start the share intent
        startActivity(Intent.createChooser(shareIntent, "Share recipe via"));
    }
}
