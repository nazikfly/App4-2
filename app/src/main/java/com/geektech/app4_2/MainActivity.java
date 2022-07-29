package com.geektech.app4_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String obshiyParol = "admin";
    String proverka = "false";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.banner);
        TextView textView = findViewById(R.id.регистрация);
        TextView vhod = findViewById(R.id.tv_vhod);
        TextView zabyli_parol = findViewById(R.id.zabyli_parol);
        EditText email = findViewById(R.id.email);
        EditText password = findViewById(R.id.password);
        proverkaET(email, password, button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (proverka.equals("true")) {
                    button.setVisibility(View.GONE);
                    textView.setVisibility(View.GONE);
                    vhod.setVisibility(View.GONE);
                    email.setVisibility(View.GONE);
                    password.setVisibility(View.GONE);
                    Toast.makeText(MainActivity.this, "Вы успешно зарегистрировались", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Неправильный логин и пароль", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    private void proverkaET(EditText password, EditText email, Button button) {
        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (email.getText().toString().equals(obshiyParol) && password.getText().toString().equals(obshiyParol)) {
                    button.setBackground(ContextCompat.getDrawable(MainActivity.this, R.color.orange));
                    proverka = "true";
                }

            }
        });
    }
}