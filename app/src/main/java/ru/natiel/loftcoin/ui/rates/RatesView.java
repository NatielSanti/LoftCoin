package ru.natiel.loftcoin.ui.rates;

import lombok.NonNull;
import ru.natiel.loftcoin.data.Coin;

import java.util.List;

public interface RatesView {

    void showCoins(@NonNull List<? extends Coin> coins);

    void showError(@NonNull String error);
}
