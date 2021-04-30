package com.example.databaselab;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PersonDao {

    @Insert
    void insertPerson(Person person);

    @Query("SELECT * FROM Person")
    List<Person> getAllPersons();

}
