package ru.natiel.loftcoin.data;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;

import java.io.IOException;
import java.util.List;

public interface CoinsRepo {

    @NonNull
    @WorkerThread
    List<? extends ru.natiel.loftcoin.data.Coin> listings(@NonNull String currency) throws IOException;

}
