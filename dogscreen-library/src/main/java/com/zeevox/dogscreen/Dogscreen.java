package com.zeevox.dogscreen;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.annotation.StringRes;

@SuppressWarnings({"SameParameterValue", "CanBeFinal", "unused"})
public class Dogscreen {

    public static final int DOGSCREEN_DEFAULT = 1;
    public static final int DOGSCREEN_FAB = 2;
    private Context userContext;
    private CharSequence displayTitle;
    private CharSequence displayContent;
    private int displayType;
    private boolean displayFullscreen;

    public Dogscreen(Context context) {
        userContext = context;
    }

    public void show() {
        Intent intent = new Intent(userContext, DogscreenActivity.class)
                .putExtra("title", displayTitle)
                .putExtra("content", displayContent)
                .putExtra("type", displayType)
                .putExtra("fullscreen", displayFullscreen);
        userContext.startActivity(intent);
    }

    public CharSequence setTitle(@NonNull CharSequence title) {
        displayTitle = title;
        return title;
    }

    public CharSequence setTitle(@StringRes int titleID) {
        displayTitle = userContext.getResources().getString(titleID);
        return userContext.getResources().getString(titleID);
    }

    public CharSequence setContent(@NonNull CharSequence content) {
        displayContent = content;
        return content;
    }

    public CharSequence setContent(@StringRes int contentID) {
        displayContent = userContext.getResources().getString(contentID);
        return userContext.getResources().getString(contentID);
    }

    public Dogscreen setType(int dogscreenType) {
        displayType = dogscreenType;
        return this;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public Dogscreen setFullscreen(boolean fullscreen) {
        displayFullscreen = fullscreen;
        return this;
    }
}
