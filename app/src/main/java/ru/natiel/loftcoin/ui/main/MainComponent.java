package ru.natiel.loftcoin.ui.main;

import ru.natiel.loftcoin.BaseComponent;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {
    MainModule.class
}, dependencies = {
    BaseComponent.class
})
public abstract class MainComponent {

    abstract void inject(MainActivity activity);

}
