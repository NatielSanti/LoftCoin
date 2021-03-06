package ru.natiel.loftcoin.ui.rates;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import ru.natiel.loftcoin.data.Coin;
import ru.natiel.loftcoin.data.CoinsRepo;
import ru.natiel.loftcoin.data.CurrencyRepo;
import ru.natiel.loftcoin.data.SortBy;

import javax.inject.Inject;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class RatesViewModel extends ViewModel {

    private final MutableLiveData<Boolean> isRefreshing = new MutableLiveData<>();

    private final MutableLiveData<AtomicBoolean> forceRefresh = new MutableLiveData<>(new AtomicBoolean(true));

    private final MutableLiveData<SortBy> sortBy = new MutableLiveData<>(SortBy.RANK);

    private final LiveData<List<Coin>> coins;

    private int sortingIndex = 1;
    @Inject
    public RatesViewModel(CoinsRepo coinsRepo, CurrencyRepo currencyRepo) {
        final LiveData<CoinsRepo.Query> query = Transformations.switchMap(forceRefresh, (r) -> {
            return Transformations.switchMap(currencyRepo.currency(), (c) -> {
                r.set(true);
                isRefreshing.postValue(true);
                return Transformations.map(sortBy, (s) -> {
                    return CoinsRepo.Query.builder()
                        .currency(c.code())
                        .forceUpdate(r.getAndSet(false))
                        .sortBy(s)
                        .build();
                });
            });
        });
        final LiveData<List<Coin>> coins = Transformations.switchMap(query, coinsRepo::listings);
        this.coins = Transformations.map(coins, (c) -> {
            isRefreshing.postValue(false);
            return c;
        });
    }

    @NonNull
    LiveData<List<Coin>> coins() {
        return coins;
    }

    @NonNull
    LiveData<Boolean> isRefreshing() {
        return isRefreshing;
    }

    final void refresh() {
        forceRefresh.postValue(new AtomicBoolean(true));
    }

    void switchSortingOrder() {
        sortBy.postValue(SortBy.values()[sortingIndex++ % SortBy.values().length]);
    }

}
