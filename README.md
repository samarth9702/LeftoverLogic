# LeftoverLogic

LeftoverLogic is an Android application that helps users make the most out of their leftover food ingredients by suggesting recipes based on the ingredients they have. The app also features a chat interface where users can interact with a bot (powered by your custom API) to get personalized recipe suggestions.

## Features

- **Login and Signup**: Users can sign up or log in using their credentials.
- **Ingredient-Based Recipe Suggestions**: Users can input their available ingredients to get recipe suggestions.
- **Chat Interface**: Users can interact with a bot to get personalized recipe suggestions.
- **Share Recipes**: Users can share their favorite recipes with friends.

## Screenshots

*Include some screenshots of your app here*

## Installation

### Prerequisites

- Android Studio
- An Android device or emulator

### Steps

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/leftoverlogic.git
   ```

2. Open the project in Android Studio.

3. Build the project:
   - Ensure that all the dependencies are resolved.
   - Sync the project with Gradle files if prompted.

4. Set up your API URL in the `RetrofitClient` class:
   ```java
   private static final String BASE_URL = "https://model82-production-2a9d.up.railway.app";
   ```

5. Run the project on your Android device or emulator.

## Usage

### Login and Signup

- Open the app and either log in with your existing credentials or sign up for a new account.

### Recipe Suggestion

- Navigate to the recipe suggestion screen.
- Enter your available ingredients, dietary restrictions, cuisine type, meal type, and any allergen information.
- Tap on "Suggest Recipe" to get a recipe based on your inputs.

### Chat Interface

- Open the chat interface from the menu.
- Type your message to interact with the bot and get personalized recipe suggestions.

### Sharing Recipes

- View a recipe and tap the "Share" button to share it with your friends via other apps.

## API

The app uses a custom API to get recipe suggestions. The API endpoint is configured in the `RetrofitClient` class.

### Request Example

```json
{
    "userMessage": "I have some leftover food ingredients and I'd like to create a delicious meal out of them. Can you suggest a recipe using the following ingredients? Please include step-by-step instructions. Ingredients: Cabbage, carrot, potato. Preference: Veg",
    "chatHistory": []
}
```

### Response Example

```json
{
    "message": "Here's a simple and tasty recipe for a Cabbage, Carrot, and Potato Stir-Fry: ..."
}
```

## Contributing

Contributions are welcome! Please open an issue or submit a pull request with your changes.

1. Fork the repository.
2. Create your feature branch:
   ```bash
   git checkout -b feature/your-feature-name
   ```
3. Commit your changes:
   ```bash
   git commit -m 'Add some feature'
   ```
4. Push to the branch:
   ```bash
   git push origin feature/your-feature-name
   ```
5. Open a pull request.

## License

This project is licensed under the MIT License
