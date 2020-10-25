package com.example.Android_3_home.data.local;

import androidx.room.Database;
import androidx.room.Entity;
import androidx.room.RoomDatabase;

import com.example.Android_3_home.data.models.FilmsGhibli;

@Database(entities = {FilmsGhibli.class}, version = 1)

public abstract class FilmDataBase extends RoomDatabase {
 public abstract FilmDao filmDao();
}
