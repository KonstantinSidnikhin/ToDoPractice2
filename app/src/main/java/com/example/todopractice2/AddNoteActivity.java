package com.example.todopractice2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class AddNoteActivity extends AppCompatActivity {
    private EditText editTextAddNote;
    private RadioGroup radioGroup;
    private RadioButton radioLow;
    private RadioButton radioMedium;
    private RadioButton radioHigh;
    private Button buttonAdd;
    private DataBase dataBase = DataBase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        initViews();
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editTextAddNote.getText().toString().trim();
                int id = dataBase.getNotes().size();
                int priority = getPriority();
                Note note = new Note(id,text,priority);
                dataBase.addNote(note);
                finish();

            }
        });

    }
    public int getPriority(){
        if(radioLow.isChecked()){
            return 0;
        }else if (radioMedium.isChecked()){
            return 1;
        }else{
            return 2;
        }
    }
    public static Intent newIntent(Context context){
        Intent intent = new Intent(context,AddNoteActivity.class);
        return  intent;
    }
    private void initViews(){
        editTextAddNote = findViewById(R.id.editTextAddNote);
        radioGroup = findViewById(R.id.radioGroup);
        radioLow = findViewById(R.id.radioLow);
        radioMedium = findViewById(R.id.radioMedium);
        radioHigh = findViewById(R.id.radioHigh);
        buttonAdd = findViewById(R.id.buttonAddNoteOne);
    }

}