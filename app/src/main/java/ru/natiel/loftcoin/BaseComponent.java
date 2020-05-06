package ru.natiel.loftcoin;

import android.content.Context;
import ru.natiel.loftcoin.data.CoinsRepo;
import ru.natiel.loftcoin.data.CurrencyRepo;

public interface BaseComponent {
    Context context();
    CoinsRepo coinsRepo();
    CurrencyRepo currencyRepo();
}
