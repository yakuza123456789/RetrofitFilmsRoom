package com.example.Android_3_home.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.Android_3_home.App;
import com.example.Android_3_home.R;
import com.example.Android_3_home.data.Interface.OnClickListeners;
import com.example.Android_3_home.data.adapters.LocalAdapter;
import com.example.Android_3_home.data.models.FilmsGhibli;

import java.util.ArrayList;

public class LocalFilmActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LocalAdapter localAdapter;
    ArrayList<FilmsGhibli> localfilmsGhiblis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_film);
        init();
        getFilms();
        onCLick();
    }

    private void onCLick() {
        localAdapter.setOnClickListenersLocal(new OnClickListeners() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(LocalFilmActivity.this, InfoActivity.class);
                intent.putExtra("savedFilm", localfilmsGhiblis.get(position).getId());
                startActivity(intent);
            }
        });

    }

    private void getFilms() {
        localfilmsGhiblis = (ArrayList<FilmsGhibli>) App.filmDataBase.filmDao().getFIlm();
        localAdapter.setLocalfilms(localfilmsGhiblis);
    }

    private void init() {
        recyclerView = findViewById(R.id.local_recycler);
        localAdapter = new LocalAdapter();
        recyclerView.setAdapter(localAdapter);
    }
}