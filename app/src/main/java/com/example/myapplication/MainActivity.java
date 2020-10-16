package com.example.myapplication.



import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity{
    private TextView output;
    private EditText input;
    private EditText input2;
    private TextView output2;
    private Button tombol;

    private SharedPreferences preferences;

    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input =findViewById(R.id.email);
        input2 =findViewById(R.id.sandi);
        output =findViewById (R.id.output);
        output2 =findViewById (R.id.pass);
        tombol =findViewById(R.id.btn);
        preferences = getSharedPreferences("apaandah_SharedPreferences" , Context.MODE_PRIVATE);

        tombol.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                getData();
                Toast.makeText(getApplicationContext(),"Data Tersimpan",
                        Toast.LENGTH_SHORT).show();
                getpass();
                Toast.makeText(getApplicationContext(),"Data Tersimpan",
                        Toast.LENGTH_SHORT).show();

            }
        } );
    }
    private void getData(){
        String getKonten = input.getText().toString();
        editor = preferences.edit();
        editor.putString("data_saya", getKonten);
        editor.apply();
        output.setText("Output Email : "+preferences.getString("data_saya", null));
