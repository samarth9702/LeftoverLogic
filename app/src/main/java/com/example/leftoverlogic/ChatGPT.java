package com.example.leftoverlogic;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ChatGPT extends AppCompatActivity {

    private EditText userMessageEditText;
    private RecyclerView chatRecyclerView;
    private ChatAdapter chatAdapter;
    private List<ChatMessage> chatMessages;
    private ApiService chatService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_gpt);

        userMessageEditText = findViewById(R.id.userMessage);
        chatRecyclerView = findViewById(R.id.chatRecyclerView);
        Button sendButton = findViewById(R.id.sendButton);

        chatMessages = new ArrayList<>();
        chatAdapter = new ChatAdapter(chatMessages);
        chatRecyclerView.setAdapter(chatAdapter);
        chatRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://model82-production-2a9d.up.railway.app/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        chatService = retrofit.create(ApiService.class);

        // Add greeting message
        chatMessages.add(new ChatMessage("Welcome to LeftoverLogicGPT! How can I assist you today?", true));
        chatAdapter.notifyItemInserted(chatMessages.size() - 1);
        chatRecyclerView.scrollToPosition(chatMessages.size() - 1);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userMessage = userMessageEditText.getText().toString();
                chatMessages.add(new ChatMessage(userMessage, false));  // Add user message to chat
                chatAdapter.notifyItemInserted(chatMessages.size() - 1);
                chatRecyclerView.scrollToPosition(chatMessages.size() - 1);

                // Clear the EditText after sending the message
                userMessageEditText.setText("");

                ChatRequest chatRequest = new ChatRequest(userMessage, Collections.emptyList());
                sendMessage(chatRequest);
            }
        });
    }

    private void sendMessage(ChatRequest chatRequest) {
        Call<ChatResponse> call = chatService.getChatResponse(chatRequest);
        call.enqueue(new Callback<ChatResponse>() {
            @Override
            public void onResponse(Call<ChatResponse> call, Response<ChatResponse> response) {
                if (response.isSuccessful()) {
                    ChatResponse chatResponse = response.body();
                    if (chatResponse != null) {
                        chatMessages.add(new ChatMessage(chatResponse.getMessage(), true));  // Add response message to chat
                        chatAdapter.notifyItemInserted(chatMessages.size() - 1);
                        chatRecyclerView.scrollToPosition(chatMessages.size() - 1);
                    } else {
                        chatMessages.add(new ChatMessage("Response was null", true));
                        chatAdapter.notifyItemInserted(chatMessages.size() - 1);
                        chatRecyclerView.scrollToPosition(chatMessages.size() - 1);
                    }
                } else {
                    chatMessages.add(new ChatMessage("Request failed: " + response.code(), true));
                    chatAdapter.notifyItemInserted(chatMessages.size() - 1);
                    chatRecyclerView.scrollToPosition(chatMessages.size() - 1);
                }
            }

            @Override
            public void onFailure(Call<ChatResponse> call, Throwable t) {
                chatMessages.add(new ChatMessage("Error: " + t.getMessage(), true));
                chatAdapter.notifyItemInserted(chatMessages.size() - 1);
                chatRecyclerView.scrollToPosition(chatMessages.size() - 1);
            }
        });
    }
}
