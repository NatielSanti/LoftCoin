package ru.natiel.loftcoin.ui.rates;

import androidx.lifecycle.ViewModelProvider;
import ru.natiel.loftcoin.BaseComponent;
import ru.natiel.loftcoin.util.ViewModelModule;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {
    RatesModule.class,
    ViewModelModule.class
}, dependencies = {
    BaseComponent.class
})
abstract class RatesComponent {

    abstract ViewModelProvider.Factory viewModelFactory();

}
