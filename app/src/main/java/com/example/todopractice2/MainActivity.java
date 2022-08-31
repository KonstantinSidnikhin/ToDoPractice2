package com.example.todopractice2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
 private LinearLayout linearLayout;
 private FloatingActionButton buttonAddNote;
private DataBase dataBase = DataBase.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        Random random = new Random();

        showNotes();
        buttonAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = AddNoteActivity.newIntent(MainActivity.this);
                startActivity(intent);

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        showNotes();
    }

    public void initViews(){
        linearLayout = findViewById(R.id.linearLayout);
        buttonAddNote = findViewById(R.id.buttonAddNote);
    }

    private void showNotes(){
        linearLayout.removeAllViews();
        for(Note note : dataBase.getNotes()){
            View view = getLayoutInflater().inflate(R.layout.note_item,linearLayout,false);
            String text = note.getText().toString();
            TextView textViewNote = view.findViewById(R.id.textViewNoteItem);
            textViewNote.setText(text);
            int colorResId;
            switch(note.getPriority()){
                case 0:
                    colorResId = android.R.color.holo_green_light;
                    break;
                case 1:
                    colorResId = android.R.color.holo_orange_light;
                    break;
                default:
                    colorResId = android.R.color.holo_red_light;
            }
            int  color = ContextCompat.getColor(this,colorResId);
            textViewNote.setBackgroundColor(color);

            linearLayout.addView(view);

        }
    }
}