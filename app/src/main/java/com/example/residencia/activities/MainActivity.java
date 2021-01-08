package com.example.residencia.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.residencia.R;

public class MainActivity extends AppCompatActivity {
Button btnUsers;
Button btnDocentes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

btnUsers=findViewById(R.id.btnUsers);
btnDocentes=findViewById(R.id.btnDocente);

btnDocentes.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(MainActivity.this,LoginActivity.class));
   finish();
    }
});

btnUsers.setOnClickListener(new View.OnClickListener(){
    public void onClick(View v){
        startActivity(new Intent(MainActivity.this,UserActivity.class));
    }
});
    }
}