package com.example.Android_3_home.data.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.Android_3_home.data.models.FilmsGhibli;

import java.util.List;

@Dao
public interface FilmDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void saveFilm (FilmsGhibli filmsGhibli);

    @Query("SELECT * FROM FilmsGhibli")
    List<FilmsGhibli> getFIlm();

}
