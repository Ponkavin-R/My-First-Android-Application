package com.example.bookbazaar;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Fragment {

    private EditText name, password;
    private Button submit;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        name = view.findViewById(R.id.username);
        password = view.findViewById(R.id.password);
        submit = view.findViewById(R.id.loginButton);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = name.getText().toString();
                String pass = password.getText().toString();

                Bundle bundle = new Bundle();
                bundle.putString("KEY_USERNAME", username);
                bundle.putString("KEY_PASSWORD", pass);

                if (getActivity() != null) {
                    Intent intent = new Intent(getActivity(), Home.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }

                Toast.makeText(getActivity(), "Welcome you : " + username, Toast.LENGTH_LONG).show();
            }

        });

        return view;
    }
}
