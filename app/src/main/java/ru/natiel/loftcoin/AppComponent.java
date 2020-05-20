package ru.natiel.loftcoin;

import android.app.Application;
import android.content.Context;
import ru.natiel.loftcoin.data.DataModule;
import dagger.BindsInstance;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(
    modules = {
        AppModule.class,
        DataModule.class
    }
)
abstract class AppComponent implements BaseComponent {

    @Component.Builder
    static abstract class Builder {
        @BindsInstance
        abstract Builder application(Application app);
        abstract AppComponent build();
    }

}
