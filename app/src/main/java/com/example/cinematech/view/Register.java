package com.example.cinematech.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cinematech.R;
import com.example.cinematech.data.utilities.RegisterApiClient;

public class Register extends AppCompatActivity {

    View registerback;
    Button registeruser;
    EditText usernameinput, emailinput, passwordinput, retypepassword;
    CheckBox registeragreement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        usernameinput = findViewById(R.id.username_input);
        emailinput = findViewById(R.id.email_input);
        passwordinput = findViewById(R.id.password_input);
        registerback = findViewById(R.id.register_back);
        retypepassword = findViewById(R.id.retype_password);
        registeragreement = findViewById(R.id.register_agreement);
        registerback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        registeruser = findViewById(R.id.register_user);
        registeruser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = String.valueOf(usernameinput.getText());
                String email = String.valueOf(emailinput.getText());
                String password = String.valueOf(passwordinput.getText());
                String repassword = String.valueOf(retypepassword.getText());

                if(!username.isEmpty() && !email.isEmpty() && !password.isEmpty() && !repassword.isEmpty() && registeragreement.isChecked())
                {

                    if(password.equals(repassword))
                    {
                        RegisterApiClient registerApiClient = new RegisterApiClient();
                        registerApiClient.registerUser(username, email, password);



                        Intent loginpage = new Intent(Register.this, Login.class);
                        startActivity(loginpage);
                        Toast.makeText(getApplicationContext(), "Successfully Registerd!", Toast.LENGTH_LONG).show();
//                        usernameinput.setText("");
//                        emailinput.setText("");
//                        passwordinput.setText("");
//                        retypepassword.setText("");
//                        registeragreement.setChecked(false);
                    }
                    else
                    {
                        passwordinput.setText("");
                        retypepassword.setText("");
                        Toast.makeText(getApplicationContext(), "Password is not same!", Toast.LENGTH_LONG).show();
                    }

                }
                else {
                    Toast.makeText(getApplicationContext(), "Registration form is not filled!", Toast.LENGTH_LONG).show();

                }


            }
        });
    }
}