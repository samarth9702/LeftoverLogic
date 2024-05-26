package com.example.leftoverlogic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RecipeSuggesterActivity extends AppCompatActivity {

    private EditText ingredients;
    private EditText dietaryRestrictions;
    private EditText cuisineType;
    private EditText mealType;
    private EditText allergenInfo;
    private Button showRecipeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_suggester);

        ingredients = findViewById(R.id.ingredients);
        dietaryRestrictions = findViewById(R.id.dietary_restrictions);
        cuisineType = findViewById(R.id.cuisine_type);
        mealType = findViewById(R.id.meal_type);
        allergenInfo = findViewById(R.id.allergen_info);
        showRecipeButton = findViewById(R.id.show_recipe_button);

        showRecipeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ingredientsText = ingredients.getText().toString();
                String dietaryRestrictionsText = dietaryRestrictions.getText().toString();
                String cuisineTypeText = cuisineType.getText().toString();
                String mealTypeText = mealType.getText().toString();
                String allergenInfoText = allergenInfo.getText().toString();

                String prompt = "I have some leftover food ingredients and I'd like to create a delicious meal out of them. Can you suggest a recipe using the following ingredients? " +
                        "Ingredients: " + ingredientsText +
                        ". Dietary Restrictions: " + dietaryRestrictionsText +
                        ". Cuisine Type: " + cuisineTypeText +
                        ". Meal Type: " + mealTypeText +
                        ". Allergen Information: " + allergenInfoText + ". Note: Do not use bold style. Display the preparation time at the beginning and the nutritional facts at the end. This is not a challenge. Do not ask if there are any questions. All responses should be given by LeftoverLogic and dont write LeftoverLogic here. Display name of the dish at top and strictly follow the ingredients as I don't have any other ingredients at home. at the end write enjoy with some good words and  meal_name";
                Intent intent = new Intent(RecipeSuggesterActivity.this, RecipeResultActivity.class);
                intent.putExtra("prompt", prompt);
                startActivity(intent);
            }
        });
    }
}
