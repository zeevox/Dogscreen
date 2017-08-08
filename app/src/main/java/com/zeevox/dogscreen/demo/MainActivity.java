package com.zeevox.dogscreen.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Define the button "DEFAULT" on the main screen, which will launch the DogscreenActivity
        Button actionButton = findViewById(R.id.welcome_action_default);

        //Add the onClickListener to launch DogscreenActivity
        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DogscreenActivity.class));
            }
        });

        //Define the button "FAB" on the main screen, which will launch the DogscreenFabActivity
        Button actionButtonFab = findViewById(R.id.welcome_action_fab);

        //Add the onClickListener to launch DogscreenFabActivity
        actionButtonFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DogscreenFabActivity.class));
            }
        });

        //App specific code
        //This code sets up the card below the welcome card and populates with app info

        //build number
        TextView buildNumber = findViewById(R.id.info_build);
        String buildNumberText = getResources().getString(R.string.main_info_text_build) + " " + BuildConfig.VERSION_CODE;
        buildNumber.setText(buildNumberText);

        //build version
        TextView buildVersion = findViewById(R.id.info_version);
        String buildVersionText = getResources().getString(R.string.main_info_text_build) + " " + BuildConfig.VERSION_NAME;
        buildVersion.setText(buildVersionText);

        //build type
        TextView buildFlavor = findViewById(R.id.info_flavor);
        String buildFlavorText = getResources().getString(R.string.main_info_text_flavor) + " " + BuildConfig.BUILD_TYPE;
        buildFlavor.setText(buildFlavorText);

        //build debug (true/false)
        TextView buildDebug = findViewById(R.id.info_debug);
        String buildDebugText = getResources().getString(R.string.main_info_text_debug) + " " + BuildConfig.DEBUG;
        buildDebug.setText(buildDebugText);
    }
}
