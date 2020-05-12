package ru.natiel.loftcoin;

import android.app.Application;
import android.content.Context;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
abstract class AppModule {

    @Singleton
    @Provides
    static Context context(Application app) {
        return app.getApplicationContext();
    }

}
