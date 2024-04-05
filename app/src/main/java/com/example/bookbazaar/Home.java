package com.example.bookbazaar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends AppCompatActivity {
    TextView name,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        name = findViewById(R.id.textViewname);
        password = findViewById(R.id.textViewpassword);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button atomic = findViewById(R.id.atomic);
        atomic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte=new Intent(Home.this, AtomicBook.class);
                startActivity(inte);
            }
        });

        Button b2 = findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Home.this, PaymentActivity.class);
                startActivity(in);
            }
        });

        Button pay1 = findViewById(R.id.pay1);
        pay1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Home.this, PaymentProcess.class);
                startActivity(i);
            }
        });

        Button thriller = findViewById(R.id.thriller);
        AlertDialog.Builder builder = new AlertDialog.Builder(Home.this);
        thriller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.setMessage("Do you want to view thriller books").setTitle("Thriller Books..").setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(Home.this, Thriller.class);
                                startActivity(intent);
                            }
                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getApplicationContext(), "You choose no action for alertbox", Toast.LENGTH_LONG).show();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.setTitle("Thriller Books");
                alert.show();
            }
        });

        Intent intent = getIntent();
        if (intent != null) {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                String receivename = bundle.getString("KEY_USERNAME");
                String receivepassword = bundle.getString("KEY_PASSWORD");
                if (receivename != null && receivepassword != null) {
                    name.setText(receivename);
                    password.setText(receivepassword);
                }
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        createMenu(menu);
        return true;
    }

    private void createMenu(Menu menu) {
        MenuItem mnu1 = menu.add(0, 0, 0, "Profile");
        mnu1.setAlphabeticShortcut('a');

        MenuItem mnu2 = menu.add(0, 1, 1, "Setting");
        mnu2.setAlphabeticShortcut('b');

        MenuItem mnu3 = menu.add(0, 2, 2, "About");
        mnu3.setAlphabeticShortcut('c');
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 0:
                // Handle item 1 click
                Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(getApplicationContext(), Profile.class);
                startActivity(i);
                return true;
            case 1:
                // Handle item 2 click
                Toast.makeText(this, "Item 2 clicked", Toast.LENGTH_SHORT).show();
                return true;
            case 2:
                // Handle item 3 click
                Toast.makeText(this, "Item 3 clicked", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
