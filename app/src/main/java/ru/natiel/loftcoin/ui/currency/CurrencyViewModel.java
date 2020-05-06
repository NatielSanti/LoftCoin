package ru.natiel.loftcoin.ui.currency;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import ru.natiel.loftcoin.data.Currency;
import ru.natiel.loftcoin.data.CurrencyRepo;

import javax.inject.Inject;
import java.util.List;

class CurrencyViewModel extends ViewModel {

    private final CurrencyRepo currencyRepo;

    @Inject
    CurrencyViewModel(CurrencyRepo currencyRepo) {
        this.currencyRepo = currencyRepo;
    }

    @NonNull
    LiveData<List<Currency>> allCurrencies() {
        return currencyRepo.availableCurrencies();
    }

    void updateCurrency(@NonNull Currency currency) {
        currencyRepo.updateCurrency(currency);
    }

}
