package com.example.luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    TextView dis,welcome;
    Button Btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        welcome=findViewById(R.id.textView);
        dis=findViewById(R.id.dispay);
        Btn=findViewById(R.id.share);



        int r=randomnumber();
        dis.setText(""+r);

        Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=getIntent();
                String username=intent.getStringExtra("name");
                share(username,r);

            }
        });

    }
    public int randomnumber(){
        Random rand = new Random();
        int max=1000;
        int r=rand.nextInt(max);
        return r;
    }
    public void share(String subject,int text){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT,subject+" got lucky number");
        intent.putExtra(Intent.EXTRA_TEXT,"his lucky number is "+text);
        startActivity(Intent.createChooser(intent,"choose a platform"));


    }

}