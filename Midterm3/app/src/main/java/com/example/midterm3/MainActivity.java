package com.example.midterm3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_hello, btn_thank, btn_add, btn_sub, btn_mul, btn_calculation;
    EditText editText_num1, editText_num2, editText_result;
    Integer result;
    View view_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_hello = findViewById(R.id.btn_hello);
        btn_thank = findViewById(R.id.btn_thank);
        btn_add = findViewById(R.id.btn_add);
        btn_sub = findViewById(R.id.btn_sub);
        btn_mul = findViewById(R.id.btn_mul);
        btn_calculation = findViewById(R.id.btn_calculation);
        editText_num1 = findViewById(R.id.editText_num1);
        editText_num2 = findViewById(R.id.editText_num2);
        editText_result = findViewById(R.id.editText_result);
        view_main = findViewById(R.id.view_main);

        final InputMethodManager manager = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE) ;

        btn_hello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"안녕하세요", Toast.LENGTH_SHORT).show();
            }
        });
        btn_thank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"고맙습니다", Toast.LENGTH_LONG).show();
            }
        });

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String num1 = editText_num1.getText().toString();
                    String num2 = editText_num2.getText().toString();
                    result = Integer.parseInt(num1) + Integer.parseInt(num2);
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "수를 입력 하세요", Toast.LENGTH_SHORT).show();
                }

            }

        });

        btn_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String num1 = editText_num1.getText().toString();
                    String num2 = editText_num2.getText().toString();
                    result = Integer.parseInt(num1) - Integer.parseInt(num2);
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "수를 입력 하세요", Toast.LENGTH_SHORT).show();
                }
            }

        });
        btn_mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String num1 = editText_num1.getText().toString();
                    String num2 = editText_num2.getText().toString();
                    result = Integer.parseInt(num1) * Integer.parseInt(num2);
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "수를 입력 하세요", Toast.LENGTH_SHORT).show();
                }


            }
        });
        btn_calculation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    editText_result.setText(result.toString());
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "수나 연산자를 입력 하세요", Toast.LENGTH_SHORT).show();
                }
            }
        });
        view_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                manager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            }
        });
    }

}