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
        Button actionButton = (Button) findViewById(R.id.welcome_action);
        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DogscreenActivity.class));
            }
        });

        //Set up app info
        TextView buildNumber = (TextView) findViewById(R.id.info_build);
        String buildNumberText = getResources().getString(R.string.main_info_text_build) + " " + BuildConfig.VERSION_CODE;
        buildNumber.setText(buildNumberText);

        TextView buildVersion = (TextView) findViewById(R.id.info_version);
        String buildVersionText = getResources().getString(R.string.main_info_text_build) + " " + BuildConfig.VERSION_NAME;
        buildVersion.setText(buildVersionText);

        TextView buildFlavor = (TextView) findViewById(R.id.info_flavor);
        String buildFlavorText = getResources().getString(R.string.main_info_text_flavor) + " " + BuildConfig.FLAVOR;
        buildFlavor.setText(buildFlavorText);

        TextView buildDebug = (TextView) findViewById(R.id.info_debug);
        String buildDebugText = getResources().getString(R.string.main_info_text_debug) + " " + BuildConfig.DEBUG;
        buildDebug.setText(buildDebugText);
    }
}
