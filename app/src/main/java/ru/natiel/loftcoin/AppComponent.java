package ru.natiel.loftcoin;

import android.app.Application;
import ru.natiel.loftcoin.data.DataModule;
import dagger.BindsInstance;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(
    modules = {
        ru.natiel.loftcoin.AppModule.class,
        DataModule.class
    }
)
abstract class AppComponent implements BaseComponent {

    @Component.Builder
    static abstract class Builder {
        @BindsInstance
        abstract Builder application(Application app);

        abstract ru.natiel.loftcoin.AppComponent build();
    }

}
