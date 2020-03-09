package com.example.demoapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class adapter_class extends RecyclerView.Adapter<adapter_class.MyViewHolder>{

    //DATA PART
    Context context;
    String[] chapter_name;
    private static ClickListener clickListener;

    public adapter_class(Context context, String[] chapter_name) {
        this.context = context;
        this.chapter_name = chapter_name;
    }

    //VIEW HOLDER PART

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.chapter_name_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.ChapterName.setText(chapter_name[position]);
    }

    @Override
    public int getItemCount() {
        return chapter_name.length;
    }

    //VIEW HOLDER PART

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView ChapterName;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ChapterName = itemView.findViewById(R.id.ChapterNameForSingleViewId);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            clickListener.onItemClick(getAdapterPosition(),v);
        }
    }


    //click listener
    public  interface ClickListener{
        void onItemClick(int position,View v);
    }
    public void setOnItemClickListener(ClickListener clickListener){
        adapter_class.clickListener = clickListener;
    }
}
