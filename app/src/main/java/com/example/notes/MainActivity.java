package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.notes.adapter.NoteRecyclerAdapter;
import com.example.notes.data.Note;
import com.example.notes.util.VerticalSpacingItemDecorator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NoteRecyclerAdapter.OnNoteListener {

    private RecyclerView mNotesRecycler;
    private List<Note> mNotesList = new ArrayList<>();
    private NoteRecyclerAdapter mNoteRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewsById();
        initRecyclerView();
        insertFakeNotes();

        setSupportActionBar(findViewById(R.id.notes_toolbar));
    }

    private void insertFakeNotes() {
        for (int i = 0; i < 20; i++) {
            Note note = new Note();
            note.setTitle("Title # " + i);
            note.setContent("Content note # " + i);
            note.setTimestamp("Feb 2024");
            mNotesList.add(note);
        }
        mNoteRecyclerAdapter.notifyDataSetChanged();
    }

    private void findViewsById() {
        mNotesRecycler = findViewById(R.id.notes_recycler);
    }

    private void initRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        mNotesRecycler.setLayoutManager(linearLayoutManager);
        VerticalSpacingItemDecorator itemDecorator = new VerticalSpacingItemDecorator(10);
        mNotesRecycler.addItemDecoration(itemDecorator);
        mNoteRecyclerAdapter = new NoteRecyclerAdapter(mNotesList, MainActivity.this, this);
        mNotesRecycler.setAdapter(mNoteRecyclerAdapter);
    }

    @Override
    public void onNoteClick(int position) {

    }
}