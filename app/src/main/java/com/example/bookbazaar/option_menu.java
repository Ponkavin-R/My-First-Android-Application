package com.example.bookbazaar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class option_menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_menu);

        // Set up the action bar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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
