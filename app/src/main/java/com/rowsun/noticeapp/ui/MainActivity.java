package com.rowsun.noticeapp.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rowsun.noticeapp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.content, new NoticeFragment()).commit();
    }
}
