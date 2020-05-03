package ru.natiel.loftcoin.ui.main;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import ru.natiel.loftcoin.R;
import ru.natiel.loftcoin.databinding.ActivityMainBinding;
import ru.natiel.loftcoin.databinding.ActivityWelcomeBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setSupportActionBar(binding.toolbar);
        setContentView(binding.getRoot());

        final NavController navController = Navigation.findNavController(this, R.id.main_host);
        NavigationUI.setupWithNavController(binding.bottomNav, navController);
        NavigationUI.setupWithNavController(binding.toolbar, navController,
                new AppBarConfiguration.Builder(binding.bottomNav.getMenu()).build());
    }

}
