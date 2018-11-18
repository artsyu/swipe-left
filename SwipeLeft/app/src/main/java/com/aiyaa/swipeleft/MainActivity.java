package com.aiyaa.swipeleft;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private MorphAnimation morphAnimationSetting;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        turnOnSubtractButton();
        turnOnAddButton();
        turnOnSettingButton();
        turnOnSaveButton();

        Spinner planDropdown = findViewById(R.id.planDropdown);
        planDropdown.setOnItemSelectedListener(new CustomOnItemSelectedListener());

    }

    public void turnOnSubtractButton(){
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
    }

    public void turnOffSubtractButton() {
        Button subtractButton = findViewById(R.id.subtract);
        subtractButton.setOnClickListener(null);
    }

    public void turnOnAddButton() {
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

    public void turnOffAddButton() {
        Button addButton = findViewById(R.id.add);
        addButton.setOnClickListener(null);
    }

    public void turnOnSettingButton(){
        View loginContainer = findViewById(R.id.form_btn);
        final Button settingButton =  findViewById(R.id.setting_button);
        ViewGroup loginViews = findViewById(R.id.setting_views);

        final FrameLayout rootView = findViewById(R.id.setting_view);

        morphAnimationSetting = new MorphAnimation(loginContainer, rootView, loginViews);

        settingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!morphAnimationSetting.isPressed()) {
                    morphAnimationSetting.morphIntoForm();
                    turnOffSettingButton();
                    turnOffAddButton();
                    turnOffSubtractButton();
                } else {
                    morphAnimationSetting.morphIntoButton();
                }
            }
        });
    }

    public void turnOffSettingButton(){
        final Button settingButton =  findViewById(R.id.setting_button);
        settingButton.setOnClickListener(null);
    }

    public void turnOnSaveButton() {
        View loginContainer = findViewById(R.id.form_btn);
        final Button settingButton =  findViewById(R.id.setting_button);
        final Button saveButton = findViewById(R.id.saveButton);
        ViewGroup loginViews = findViewById(R.id.setting_views);

        final FrameLayout rootView = findViewById(R.id.setting_view);

        morphAnimationSetting = new MorphAnimation(loginContainer, rootView, loginViews);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                morphAnimationSetting.morphIntoButton();
                turnOnSettingButton();
                turnOnAddButton();
                turnOnSubtractButton();
            }
        });
    }

    public void turnOffSaveButton() {
        final Button saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(null);
    }
}

