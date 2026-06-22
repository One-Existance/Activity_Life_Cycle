package com.example.activitylifecycle;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button btnGoBack = findViewById(R.id.btnGoBack);
        btnGoBack.setOnClickListener(v -> finish());

        Toast.makeText(this, getString(R.string.toast_second_opened), Toast.LENGTH_LONG).show();
    }
}
