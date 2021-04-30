package com.example.databaselab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final String DATABASE_NAME = "database_name";
    EditText editText;
    Button submit;
    Button displayNames;
    LabDatabase labDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        submit = findViewById(R.id.submit);
        displayNames = findViewById(R.id.display_names);

        labDB = Room.databaseBuilder(this, LabDatabase.class, DATABASE_NAME)
                .build();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                final AddPersonAsync addPersonAsync = new AddPersonAsync(labDB);

                Person person = new Person();
                person.setName(editText.getText().toString());
                addPersonAsync.execute(person);

                editText.setText("");

            }
        });

        displayNames.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                final GetAllPersonsAsync getAllPersonsAsync = new GetAllPersonsAsync(labDB,getApplicationContext());
                getAllPersonsAsync.execute();

            }
        });
    }
}