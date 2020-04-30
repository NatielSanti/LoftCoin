package ru.natiel.loftcoin.ui.welcome;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import ru.natiel.loftcoin.R;
import ru.natiel.loftcoin.databinding.ActivityWelcomeBinding;
import ru.natiel.loftcoin.ui.main.MainActivity;

public class WelcomeActivity extends AppCompatActivity {

    public static final String KEY_SHOW_WELCOME = "show_welcome";

    private ActivityWelcomeBinding binding;
    private SnapHelper helper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWelcomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.pager.setLayoutManager(
                new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        binding.pager.setAdapter(new WelcomePageAdapter());
        helper = new PagerSnapHelper();
        helper.attachToRecyclerView(binding.pager);
        binding.btnStart.setOnClickListener((v) -> {
            SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE);
            sharedPreferences.edit()
                    .putBoolean(KEY_SHOW_WELCOME, true).apply();
            startActivity(new Intent(this, MainActivity.class));
            finish();
        });
    }

    @Override
    protected void onDestroy() {
        helper.attachToRecyclerView(null);
        binding.pager.setAdapter(null);
        super.onDestroy();
    }
}
