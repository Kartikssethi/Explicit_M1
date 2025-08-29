package com.example.explicit_example;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import javax.xml.transform.Result;

public class MainActivity extends AppCompatActivity {
    private EditText Number1,Number2;
    private TextView OddEven;
    private Button Send_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Number1 = findViewById(R.id.Number1);
        Number2= findViewById(R.id.Number2);
        Send_number = findViewById(R.id.Send_number);
        OddEven =findViewById(R.id.OddEven);

        Double sum = getIntent().getDoubleExtra("sum",0.0);
        if(sum%2==0)
        {
            OddEven.setText("Even");
        }
        else
        {
            OddEven.setText("Odd");
        }




        Send_number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Number1_string = Number1.getText().toString();
                String Number2_string = Number2.getText().toString();
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("Num1",Number1_string);
                intent.putExtra("Num2",Number2_string);
                startActivity(intent);
            }



        });



    }
}