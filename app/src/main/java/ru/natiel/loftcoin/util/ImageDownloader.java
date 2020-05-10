package ru.natiel.loftcoin.util;

import com.squareup.picasso.Picasso;
import ru.natiel.loftcoin.BuildConfig;
import ru.natiel.loftcoin.databinding.LiRateBinding;

public class ImageDownloader {
    public static void load(int id, LiRateBinding binding) {
        Picasso.get()
                .load(BuildConfig.IMG_ENDPOINT + id + ".png")
                .into(binding.logo);
    }
}
