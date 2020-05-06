package ru.natiel.loftcoin.ui.rates;

import android.os.Handler;
import android.os.Looper;
import lombok.NonNull;
import ru.natiel.loftcoin.data.CmcCoinsRepo;
import ru.natiel.loftcoin.data.Coin;
import ru.natiel.loftcoin.data.CoinsRepo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RatesPresenter {

    private final Handler handler = new Handler(Looper.getMainLooper());
    private List<? extends Coin> coins = new ArrayList<>();

    private CoinsRepo repo;
    private ExecutorService executor;
    private RatesView view;

    public RatesPresenter() {
        this.executor = Executors.newSingleThreadExecutor();
        this.repo = new CmcCoinsRepo();
        refresh();
    }

    void attach(@NonNull RatesView view) {
        this.view = view;
        if (!coins.isEmpty()) {
            view.showCoins(coins);
        }
    }

    void detach(@NonNull RatesView view) {
        this.view = null;
    }

    private void onSuccess(List<? extends Coin> coins) {
        this.coins = coins;
        if (view != null) {
            view.showCoins(coins);
        }
    }

    private void onError(IOException e) {

    }

    void refresh() {
        executor.submit(() -> {
            try {
                final List<? extends Coin> coins = repo.listings("USD");
                handler.post(() -> onSuccess(coins));
            } catch (IOException e) {
                handler.post(() -> onError(e));
            }
        });
    }
}
