package ru.natiel.loftcoin.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.loftschool.loftcoin19.BaseComponent;
import com.loftschool.loftcoin19.R;
import com.loftschool.loftcoin19.prefs.Settings;
import com.loftschool.loftcoin19.ui.main.MainActivity;
import com.loftschool.loftcoin19.ui.welcome.WelcomeActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        final Settings settings = BaseComponent.get(this).settings();
        new Handler().postDelayed(() -> {
            if (settings.shouldShowWelcomeScreen()) {
                startActivity(new Intent(this, WelcomeActivity.class));
            } else {
                startActivity(new Intent(this, MainActivity.class));
            }
        }, 1000);
    }

}
