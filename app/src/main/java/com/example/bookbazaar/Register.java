package com.example.bookbazaar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class Register extends AppCompatActivity {
    Button log, reg;
    FrameLayout framelayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        log = findViewById(R.id.login);
        reg = findViewById(R.id.register);

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm1 = getSupportFragmentManager();
                fm1.beginTransaction().replace(R.id.fragmentContainerView, Login.class, null).setReorderingAllowed(true).addToBackStack("name").commit();
            }
        });
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm2 = getSupportFragmentManager();
                fm2.beginTransaction().replace(R.id.fragmentContainerView, Regist.class, null).setReorderingAllowed(true).addToBackStack("name").commit();
            }
        });
    }
}
