package com.example.todopractice2;

import java.util.ArrayList;
import java.util.Random;

public class DataBase {
    private static DataBase instanse = null;
    public static DataBase getInstance(){
        if(instanse == null){
            instanse = new DataBase();
        }
        return instanse;
    }
    private ArrayList<Note> notes = new ArrayList<>();
    public DataBase(){
        Random random =new Random();
        for (int i = 0; i<20; i++){

            Note note = new Note(i,"Note "+i, random.nextInt(3));
            notes.add(note);
        }

    }
    public void addNote(Note note){
        notes.add(note);
    }

    public void removeNote(int id){
        for(Note note : notes)
        {
        if (note.getId()==id)
        {
            notes.remove(id);
        }
        }
    }
    public ArrayList<Note> getNotes(){
        return new ArrayList<>(notes);
    }
}

