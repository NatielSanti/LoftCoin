package ru.natiel.loftcoin.ui.rates;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import lombok.NonNull;
import ru.natiel.loftcoin.data.CmcCoinsRepo;
import ru.natiel.loftcoin.data.Coin;
import ru.natiel.loftcoin.data.CoinsRepo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RatesViewModel extends ViewModel {
    private final MutableLiveData<List<Coin>> coins = new MutableLiveData<>();
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    private CoinsRepo repo;
    private Future<?> future;

    public RatesViewModel(){
        repo = new CmcCoinsRepo();
        refresh();
    }

    @NonNull
    public LiveData<List<Coin>> coins(){
        return coins;
    }

    final void refresh() {
        future = executor.submit(() -> {
            try {
                this.coins.postValue(new ArrayList<>(repo.listings("USD")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    protected void onCleared() {
        if(future != null){
            future.cancel(true);
        }
    }
}
