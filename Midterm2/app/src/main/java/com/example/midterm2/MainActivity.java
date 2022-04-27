package com.example.midterm2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imgView;
    Button btn_watermelon;
    Button btn_peach;
    Button btn_reset;
    CheckBox check_watermelon;
    CheckBox check_peach;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgView = findViewById(R.id.imgView);
        btn_watermelon = findViewById(R.id.btn_watermelon);
        btn_peach = findViewById(R.id.btn_peach);
        btn_reset = findViewById(R.id.btn_reset);
        check_watermelon = findViewById(R.id.check_watermelon);
        check_peach = findViewById(R.id.check_peach);

        btn_watermelon.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                check_watermelon.setChecked(true);
            }

        });
        btn_peach.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                check_peach.setChecked(true);

            }
        });
        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                check_watermelon.setChecked(false);
                check_peach.setChecked(false);

            }
        });

        imgView.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });


    }
}