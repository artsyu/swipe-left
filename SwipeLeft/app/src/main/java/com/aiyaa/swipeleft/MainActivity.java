package com.aiyaa.swipeleft;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button subtractButton = findViewById(R.id.subtract);
        subtractButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView swipes = findViewById(R.id.swipeCounter);
                String currentCounter = swipes.getText().toString();
                int count = Integer.parseInt(currentCounter);

                if(count > 0)
                    swipes.setText("" + --count);
                else
                    Toast.makeText(getApplicationContext(), "You don't have any swipes left already!!!", Toast.LENGTH_SHORT).show();
            }
        });

        Button addButton = findViewById(R.id.add);
        addButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView swipes = findViewById(R.id.swipeCounter);
                String currentCounter = swipes.getText().toString();
                int count = Integer.parseInt(currentCounter);

                swipes.setText("" + ++count);
                Toast.makeText(getApplicationContext(), "wHY DId u aDd A sWIpE", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

