package com.example.providers_a;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mnAuthor: {
                Intent intent1 = new Intent(MainActivity.this, AuthorActivity.class);
                startActivity(intent1);
                return true;
            }

//            case R.id.mnBook: {
//                Intent intent2 = new Intent(MainActivity.this, BookActivity.class);
//                startActivity(intent2);
//                return true;
//            }

            default: return super.onOptionsItemSelected(item);
        }
    }
}

                    // example about the using SQLiteOpenHelper
// khi dùng databse trên local thì tao một database trên application, chỉ có app đó mới tạo ra cơ sở dữ liệu thì dùng SQLiteOpentHelper
// SQLiteOpenHelper chỉ dùng trên local của application có database

                    // example about the using ContentProviders
// một app quản lý database and app khác nằm ở debate khác, một app khác muốn kết nối và share dữ liệu trên database thì mình dùng content Providers
// example có 2 app, app thứ nhất có