package com.example.databaselab;

import android.os.AsyncTask;

public class AddPersonAsync extends AsyncTask<Person, Void, Void> {
    private LabDatabase database;

    public AddPersonAsync(LabDatabase database){
        this.database = database;
    }

    @Override
    protected Void doInBackground(Person... people) {

        database.personDao().insertPerson(people[0]);
        return null;

    }

}
