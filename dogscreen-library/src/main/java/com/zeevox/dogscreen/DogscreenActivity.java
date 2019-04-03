package com.zeevox.dogscreen;

import android.os.Build;
import android.os.Bundle;
import androidx.annotation.RequiresApi;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DogscreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // If the user passed a parameter through Dogscreen.setFullscreen(), display accordingly.
        // Default to false if no value is passed
        // This must be called before setContentView()
        if (getIntent().getBooleanExtra("fullscreen", false)) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                setFullscreen();
            } else {
                Log.e("Dogscreen", "Cannot setFullscreen() on application with minSdk below 16.");
            }
        }
        // If no parameter was passed, set the default dogscreen value type
        int type = getIntent().getIntExtra("type", Dogscreen.DOGSCREEN_DEFAULT);
        switch (type) {
            // If the user passed a parameter through Dogscreen.setType(), display the appropriate
            // dogscreen.
            case Dogscreen.DOGSCREEN_DEFAULT:
                setContentView(R.layout.activity_dogscreen_default);
                break;
            case Dogscreen.DOGSCREEN_FAB:
                setContentView(R.layout.activity_dogscreen_fab);
                break;
            // If an unknown parameter was passed, display the default dogscreen.
            default:
                setContentView(R.layout.activity_dogscreen_default);
                break;
        }
        // Once the view is set, set an onClickListener for the confirmation button.
        setConfirmationListener(type);
        // Get the user settings
        CharSequence title = getIntent().getCharSequenceExtra("title");
        CharSequence content = getIntent().getCharSequenceExtra("content");
        // If the user passed a parameter through Dogscreen.setTitle(), display the custom title.
        TextView titleText = findViewById(R.id.dogscreen_title);
        if (title != null && !title.toString().isEmpty()) {
            try {
                titleText.setText(title);
            } catch (NullPointerException npe) {
                npe.printStackTrace();
                Toast.makeText(
                        this,
                        "An error occurred. Please report this to the developer: Error code DA40",
                        Toast.LENGTH_LONG)
                        .show();
            }
        }
        // If the user passed a parameter through Dogscreen.setContent(), display the custom title.
        TextView contentText = findViewById(R.id.dogscreen_content);
        if (content != null && !content.toString().isEmpty()) {
            try {
                contentText.setText(content);
            } catch (NullPointerException npe) {
                npe.printStackTrace();
                Toast.makeText(
                        this,
                        "An error occurred. Please report this to the developer: Error code DA50",
                        Toast.LENGTH_SHORT)
                        .show();
            }
        }
    }

    private void setConfirmationListener(int layoutType) {
        // Close the activity when accepted
        switch (layoutType) {
            case Dogscreen.DOGSCREEN_FAB:
                FloatingActionButton dogscreenConfirmationFAB =
                        findViewById(R.id.dogscreen_confirmation_fab);
                dogscreenConfirmationFAB.setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                finish();
                            }
                        });
                break;
            default:
                Button dogscreenConfirmationButton = findViewById(R.id.dogscreen_confirmation_button);
                dogscreenConfirmationButton.setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                finish();
                            }
                        });
                break;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void setFullscreen() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        View mDecorView = getWindow().getDecorView();
        mDecorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }
}
