package com.example.leftoverlogic;

import java.util.List;

public class ChatRequest {
    private String userMessage;
    private List<String> chatHistory;

    // Constructor
    public ChatRequest(String userMessage, List<String> chatHistory) {
        this.userMessage = userMessage;
        this.chatHistory = chatHistory;
    }

    // Getters and Setters
    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }

    public List<String> getChatHistory() {
        return chatHistory;
    }

    public void setChatHistory(List<String> chatHistory) {
        this.chatHistory = chatHistory;
    }
}
