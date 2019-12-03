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
import android.widget.Toast;

public class EditActivity extends AppCompatActivity {

    EditText editText1, editText2, editText3;
    SQLiteDatabase bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bd = openOrCreateDatabase("meubd", MODE_PRIVATE, null);

        editText1 = findViewById(R.id.txt_id);
        editText2 = findViewById(R.id.txt_titulo);
        editText3 = findViewById(R.id.txt_texto);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                String txt1 = editText1.getText().toString();
                String txt2 = editText2.getText().toString();
                String txt3 = editText3.getText().toString();

                if (txt1.equalsIgnoreCase("")){

                    Toast.makeText(EditActivity.this, "Preencha os dados",Toast.LENGTH_LONG);

                }else{

                    ContentValues contentValues = new ContentValues();
                    contentValues.put("titulo", txt2);
                    contentValues.put("texto", txt3);

                    bd.update("notas", contentValues, "id = " + txt1, null);

                    txt2 = null;
                    txt3 = null;

                    finish();

                }

            }
        });
    }

}
