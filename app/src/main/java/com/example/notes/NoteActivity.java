package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.example.notes.data.Note;

public class NoteActivity extends AppCompatActivity {

    private static final String TAG = "NoteActivity";

    private LineEditText mLinedEditText;
    private EditText mEditTitle;
    private TextView mViewTitle;

    private boolean mIsNewNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        findViews();

        Intent intent = getIntent();
        if (intent == null && getIncomingNote()) {
            // This is brand new note, go edit mode
        } else {
            // this is not new note, go view mode
        }
    }

    private void findViews() {
        mLinedEditText = findViewById(R.id.note_text);
        mViewTitle = findViewById(R.id.note_edit_title);
        mViewTitle = findViewById(R.id.note_text_title);
    }

    private boolean getIncomingNote() {
        if(getIntent().hasExtra("selected_note")) {
            Note inComingNote = getIntent().getParcelableExtra("selected_note");
            Log.d(TAG, "getIncomingNote: " + inComingNote.toString());
            mIsNewNote = false;
            return false;
        }
        return true;
    }
}