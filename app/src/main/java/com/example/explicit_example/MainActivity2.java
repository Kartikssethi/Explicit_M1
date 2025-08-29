package com.example.explicit_example;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    private TextView Added_sum;
    private Button Send_Result;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Added_sum = findViewById(R.id.Added_sum);
        Send_Result = findViewById(R.id.Send_Result);
        String N1=getIntent().getStringExtra("Num1");
        String N2=getIntent().getStringExtra("Num2");
        Double Number1=Double.parseDouble(N1);
        Double Number2=Double.parseDouble(N2);
        Double sum = Number1+Number2;
        Added_sum.setText(String.valueOf(sum));
        Send_Result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this,MainActivity.class);
                intent.putExtra("sum",sum);
                startActivity(intent);
            }

        });








    }
}