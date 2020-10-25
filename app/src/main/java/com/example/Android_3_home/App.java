package com.example.Android_3_home;

import android.app.Application;

import androidx.room.Room;

import com.example.Android_3_home.data.local.FilmDataBase;
import com.example.Android_3_home.data.network.GhibliService;

public class App extends Application {

   public static GhibliService ghibliService;
   public static  FilmDataBase filmDataBase;

    @Override
    public void onCreate() {
        super.onCreate();
        filmDataBase = Room.databaseBuilder(this, FilmDataBase.class, "filmDataBase").allowMainThreadQueries().build();

        ghibliService = new GhibliService();
    }
}
