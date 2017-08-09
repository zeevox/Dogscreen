package com.zeevox.dogscreen.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.zeevox.dogscreen.Dogscreen;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set the toolbar title to "Dogscreen demo"
        try {
            getSupportActionBar().setTitle(R.string.main_activity_title);
        } catch (NullPointerException npe) {
            Toast.makeText(this, "An error occurred. Please report this to the developer: Error code MA19", Toast.LENGTH_LONG).show();
            npe.printStackTrace();
        }

        //Define the button "DEFAULT" on the main screen, which will launch the Dogscreen
        Button actionButton = findViewById(R.id.welcome_action_default);

        //Add the onClickListener to launch the Dogscreen
        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(MainActivity.this, DogscreenActivity.class));
                Dogscreen dogscreen = new Dogscreen(getApplicationContext());
                dogscreen.setTitle(R.string.dogscreen_warning);
                dogscreen.setContent(R.string.dogscreen_desc);
                dogscreen.setType(Dogscreen.DOGSCREEN_DEFAULT);
                dogscreen.show();
            }
        });

        //Define the button "FAB" on the main screen, which will launch the Dogscreen with a FAB instead
        Button actionButtonFab = findViewById(R.id.welcome_action_fab);

        //Add the onClickListener to launch the Dogscreen
        actionButtonFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(MainActivity.this, DogscreenFabActivity.class));
                Dogscreen dogscreen = new Dogscreen(getApplicationContext());
                dogscreen.setTitle(R.string.dogscreen_warning);
                dogscreen.setContent(R.string.dogscreen_desc);
                dogscreen.setType(Dogscreen.DOGSCREEN_FAB);
                dogscreen.show();
            }
        });
    }
}
