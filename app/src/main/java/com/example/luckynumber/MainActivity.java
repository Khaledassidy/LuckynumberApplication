package com.example.luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView display;
    Button btn;
    EditText input;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display=findViewById(R.id.welcome);
        btn=findViewById(R.id.Btn);
        input=findViewById(R.id.name);
        img=findViewById(R.id.imageView);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data=input.getText().toString();
                if(data.isEmpty()){
                    Toast.makeText(getApplicationContext(), "please enter your name", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                    intent.putExtra("name",data);
                    startActivity(intent);
                }
            }
        });

    }
}