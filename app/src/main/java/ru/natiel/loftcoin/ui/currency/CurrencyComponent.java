package ru.natiel.loftcoin.ui.currency;

import androidx.lifecycle.ViewModelProvider;
import ru.natiel.loftcoin.BaseComponent;
import ru.natiel.loftcoin.util.ViewModelModule;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {
    CurrencyModule.class,
    ViewModelModule.class
}, dependencies = {
    BaseComponent.class
})
abstract class CurrencyComponent {

    abstract ViewModelProvider.Factory viewModelFactory();

}
