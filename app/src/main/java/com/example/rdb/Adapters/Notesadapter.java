package com.example.rdb.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rdb.DataBase.NoteEntiity;
import com.example.rdb.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Notesadapter extends RecyclerView.Adapter<Notesadapter.ViewHolder>{

    public List<NoteEntiity> mnotes;
    public final Context context;

    public Notesadapter(List<NoteEntiity> mnotes, Context context) {
        this.mnotes = mnotes;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.note_list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Notesadapter.ViewHolder holder, int position) {
        holder.note=mnotes.get(position);
     holder.tv.setText(mnotes.get(position).getText());

    }

    @Override
    public int getItemCount() {
        return mnotes.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder {
        NoteEntiity note;
        View parentView;
        TextView tv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parentView=itemView;

            tv = itemView.findViewById(R.id.textView);
        }
    }
}
