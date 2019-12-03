package br.ifsc.edu.nostasql;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.EditText;

public class CreateActivity extends AppCompatActivity {

    SQLiteDatabase bd = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setTitle("Adicionar");

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bd = openOrCreateDatabase("meubd",MODE_PRIVATE,null);
                bd.execSQL("CREATE TABLE IF NOT EXISTS notas (" +
                        "id integer primary key autoincrement," +
                        "titulo varchar not null," +
                        "texto varchar not null  )");

                EditText txt1 = findViewById(R.id.txt_titulo);
                EditText txt2 = findViewById(R.id.txt_texto);

                String t1 = txt1.getText().toString();
                String t2 = txt2.getText().toString();

                ContentValues contentValues = new ContentValues();
                contentValues.put("titulo",t1);
                contentValues.put("texto",t2);

                bd.insert("notas", null, contentValues);

                finish();

            }
        });
    }

}
