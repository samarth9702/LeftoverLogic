# LeftoverLogic

LeftoverLogic is an Android application that helps users make the most out of their leftover food ingredients by suggesting recipes based on the ingredients they have. The app also features a chat interface where users can interact with a bot (powered by your custom API) to get personalized recipe suggestions.

## Features

- **Login and Signup**: Users can sign up or log in using their credentials.
- **Ingredient-Based Recipe Suggestions**: Users can input their available ingredients to get recipe suggestions.
- **Chat Interface**: Users can interact with a bot to get personalized recipe suggestions.
- **Share Recipes**: Users can share their favorite recipes with friends.

## Screenshots

![LoginScreen](https://github.com/samarth9702/LeftoverLogic/assets/138648292/542deaca-530a-4d6a-9bac-618ede9c1120 =200x400) 
![Main Screen](https://github.com/samarth9702/LeftoverLogic/assets/138648292/822b4598-ba4d-46c1-a096-ed1910effe66)
![Recipe Suggestor](https://github.com/samarth9702/LeftoverLogic/assets/138648292/977d96cd-8b7c-4910-8971-1c7ed33bbeee)
![Result](https://github.com/samarth9702/LeftoverLogic/assets/138648292/1823be4b-edfb-47c5-a87a-5ad5e10d84a9)
![LeftoverLogicGPT Screen](https://github.com/samarth9702/LeftoverLogic/assets/138648292/63fd5d23-7e1b-4b2e-a12c-5a4b8cddb395)


## Installation

### Prerequisites

- Android Studio
- An Android device or emulator

### Steps

1. Clone the repository:
   ```bash
   git clone https://github.com/samarth9702/LeftoverLogic.git
   ```

2. Open the project in Android Studio.

3. Build the project:
   - Ensure that all the dependencies are resolved.
   - Sync the project with Gradle files if prompted.

4. Set up your API URL in the `RetrofitClient` class:
   ```java
   private static final String BASE_URL = "YOUR_MODEL_URL";
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
