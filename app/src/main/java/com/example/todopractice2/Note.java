package com.example.todopractice2;

public class Note {

    public Note(int id, String text, int priority) {
        this.id = id;
        this.text = text;
        this.priority = priority;
    }

    private int id;
    private String text;
    private int priority;

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public int getPriority() {
        return priority;
    }

}
