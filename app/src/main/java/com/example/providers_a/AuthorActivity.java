package com.example.providers_a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class AuthorActivity extends AppCompatActivity {

    EditText et_idauthor, et_name, et_address, et_email;
    Button bt_save, bt_select, bt_exit, bt_update, bt_delete;
    GridView gv_display;
    ArrayList<Author> list_author;
    static final String uri = "content://com.example.providers_a";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author);

        et_idauthor = (EditText)findViewById(R.id.edittext_idauthor);
        et_name = (EditText)findViewById(R.id.edittext_name);
        et_address = (EditText)findViewById(R.id.edittext_address);
        et_email = (EditText)findViewById(R.id.edittext_email);
        gv_display = (GridView) findViewById(R.id.gridview_display);

        bt_save = (Button)findViewById(R.id.button_save);
        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues content = new ContentValues();
                content.put("id_author", Integer.parseInt(et_idauthor.getText().toString()));
                content.put("name", et_name.getText().toString());
                content.put("address", et_address.getText().toString());
                content.put("email", et_email.getText().toString());
                Uri uripro = Uri.parse(uri);
                Uri insert_uri = getContentResolver().insert(uripro, content);
                if(insert_uri != null)
                    Toast.makeText(getApplicationContext(),"Save successfully!", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getApplicationContext(),"Save error!", Toast.LENGTH_LONG).show();
            }
        });

        bt_select = (Button)findViewById(R.id.button_select);
        bt_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> string_list = new ArrayList<>();
                Uri author = Uri.parse(uri);
                Cursor cursor = getContentResolver().query(author, null,
                        null, null, "name");
                if(cursor != null) {
                    cursor.moveToFirst();
                    do {
                        string_list.add(cursor.getInt(0) + "");
                        string_list.add(cursor.getString(1));
                        string_list.add(cursor.getString(2));
                        string_list.add(cursor.getString(3));
                    } while (cursor.moveToNext());
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(AuthorActivity.this,
                            android.R.layout.simple_list_item_1, string_list);
                    gv_display.setAdapter(adapter);
                } else
                    Toast.makeText(getApplicationContext(), "Select error!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}