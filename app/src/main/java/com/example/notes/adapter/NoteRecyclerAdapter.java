package com.example.notes.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notes.R;
import com.example.notes.data.Note;

import java.util.ArrayList;
import java.util.List;

public class NoteRecyclerAdapter extends RecyclerView.Adapter<NoteRecyclerAdapter.ViewHolder> {

    private List<Note> mNotes;
    private Context mContext;

    public NoteRecyclerAdapter(List<Note> notes, Context context) {
        this.mNotes = notes;
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_note_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(mNotes.get(position).getTitle());
        holder.timestamp.setText(mNotes.get(position).getTimestamp());

    }

    @Override
    public int getItemCount() {
        return (mNotes == null) ? 0 : mNotes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView timestamp;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.note_title);
            timestamp = itemView.findViewById(R.id.note_timestamp);
        }
    }
}
