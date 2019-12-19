package com.example.examen2dsa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        SharedPreferences sharedPref =  LoginActivity.this.getPreferences(Context.MODE_PRIVATE);

        String user = sharedPref.getString("user","incorrecto");
        String password = sharedPref.getString("dsamola","incorrecto");
        if(user.equals("user")&&password.equals("dsamola"))
        {
            Intent intent = new Intent(LoginActivity.this, ListActivity.class);
            startActivity(intent);
        }
    }

    public void Login(final View view) {
        EditText user =  findViewById(R.id.editText2);
        EditText password =  findViewById(R.id.editText);

        String usuario=user.getText().toString();
                String contrasena=password.getText().toString();
if ( usuario.equals("user") && contrasena.equals("dsamola")) {

   /* Context context = getActivity();
    SharedPreferences sharedPref = context.getSharedPreferences(
            getString(R.string.preference_file_key), Context.MODE_PRIVATE);

    */SharedPreferences sharedPref = LoginActivity.this.getPreferences(Context.MODE_PRIVATE);
    SharedPreferences.Editor editor = sharedPref.edit();
    editor.putString(user.getText().toString(),user.getText().toString());
    editor.putString(password.getText().toString(),password.getText().toString());
    editor.commit();
    Intent intent = new Intent(view.getContext(), ListActivity.class);




    startActivity(intent);
}


    }
}
