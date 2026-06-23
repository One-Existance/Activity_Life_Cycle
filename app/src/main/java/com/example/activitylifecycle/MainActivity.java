package com.example.activitylifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView tvLog;
    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvLog = findViewById(R.id.tvLog);
        scrollView = findViewById(R.id.scrollView);

        Button btnOpenSecond = findViewById(R.id.btnOpenSecond);
        Button btnFinish = findViewById(R.id.btnFinish);
        Button btnClearLog = findViewById(R.id.btnClearLog);

        btnOpenSecond.setOnClickListener(v ->
                startActivity(new Intent(this, SecondActivity.class)));

        btnFinish.setOnClickListener(v -> finish());

        btnClearLog.setOnClickListener(v ->
                tvLog.setText("(log cleared)\n"));

        log("onCreate", "Activity is being created");
        Toast.makeText(this, "onCreate: Activity created", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        log("onStart", "Activity is becoming visible");
        Toast.makeText(this, "onStart: Activity visible", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        log("onResume", "Returning to the app — activity is interactive again");
        Toast.makeText(this, "onResume: Back to foreground", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        log("onPause", "Briefly leaving the app — activity loses focus");
        Toast.makeText(this, "onPause: Briefly leaving the app", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        log("onStop", "Activity is no longer visible");
        Toast.makeText(this, "onStop: Activity not visible", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        log("onRestart", "Activity is restarting after being stopped");
        Toast.makeText(this, "onRestart: Activity restarting", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        log("onDestroy", "Activity is being destroyed and removed from memory");
        Toast.makeText(this, "onDestroy: Activity destroyed", Toast.LENGTH_SHORT).show();
    }

    private void log(String method, String description) {
        String entry = "[" + method + "]\n  → " + description + "\n\n";
        tvLog.append(entry);
        scrollView.post(() -> scrollView.fullScroll(ScrollView.FOCUS_DOWN));
    }
}
