package com.zeevox.dogscreen.demo;

import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.zeevox.dogscreen.Dogscreen;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set the toolbar title to "Dogscreen demo"
        try {
            // noinspection ConstantConditions
            getSupportActionBar().setTitle(R.string.main_activity_title);
        } catch (NullPointerException npe) {
            Toast.makeText(
                    this,
                    "An error occurred. Please report this to the developer: Error code MA19",
                    Toast.LENGTH_LONG)
                    .show();
            npe.printStackTrace();
        }

        // Define the button "DEFAULT" on the main screen, which will launch the Dogscreen
        Button actionButton = findViewById(R.id.example_default_button);

        // Add the onClickListener to launch the Dogscreen
        actionButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // startActivity(new Intent(MainActivity.this, DogscreenActivity.class));
                        new Dogscreen(getApplicationContext()).show();
                    }
                });

        // Define the button "CUSTOM TEXT" on the main screen, which will launch the Dogscreen with custom text instead
        Button actionButtonCustomText = findViewById(R.id.example_custom_text_button);

        // Add the onClickListener to launch the Dogscreen
        actionButtonCustomText.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Dogscreen dogscreen = new Dogscreen(getApplicationContext());
                dogscreen.setTitle("Hello world!");
                dogscreen.setContent("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed nec dapibus turpis. Proin aliquet laoreet convallis. Phasellus at leo porttitor, blandit mauris at, interdum turpis.");
                dogscreen.show();
            }
        });

        // Define the button "FAB" on the main screen, which will launch the Dogscreen with a FAB
        // instead
        Button actionButtonFab = findViewById(R.id.example_fab_button);

        // Add the onClickListener to launch the Dogscreen
        actionButtonFab.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // startActivity(new Intent(MainActivity.this, DogscreenFabActivity.class));
                        new Dogscreen(getApplicationContext()).setType(Dogscreen.DOGSCREEN_FAB).show();
                    }
                });

        // Define the "fullscreen" example button
        Button actionButtonFullscreen = findViewById(R.id.example_fullscreen_button);
        // Check the device API Level
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            // Disable the button if less than API 19
            actionButtonFullscreen.setEnabled(false);
            actionButtonFullscreen.setAllCaps(false);
            actionButtonFullscreen.setText(R.string.example_fullscreen_text_disabled);
        } else {
            // Else, Attach an onClickListener
            actionButtonFullscreen.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Dogscreen dogscreen = new Dogscreen(getApplicationContext());
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                                dogscreen.setFullscreen(true).show();
                            }
                        }
                    });
        }
    }
}
