package com.example.bmicalculator;

public class BmiResult {
    private String title;
    private String explanation;

    public BmiResult(String title, String explanation) {
        this.title = title;
        this.explanation = explanation;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }
}
