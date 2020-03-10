package com.example.demoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class ChapterActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private String[] chapterName;
    private String[] chapterDes;
    adapter_class adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter);
        recyclerView = findViewById(R.id.recyclerViewId);
        chapterName = getResources().getStringArray(R.array.chapter_name);
        chapterDes = getResources().getStringArray(R.array.chapter_des);
        adapter = new adapter_class(this,chapterName);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(ChapterActivity.this));

        adapter.setOnItemClickListener(new adapter_class.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {

                //Toast.makeText(getApplicationContext(),"position : "+position,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ChapterActivity.this,Details_chapter.class);
                intent.putExtra("title",chapterName[position]);
                intent.putExtra("des",chapterDes[position]);
                startActivity(intent);
            }
        });

    }
}
