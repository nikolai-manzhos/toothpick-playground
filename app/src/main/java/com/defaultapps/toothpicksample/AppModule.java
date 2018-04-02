package com.defaultapps.toothpicksample;

import android.app.Application;
import android.content.Context;

import toothpick.config.Module;

class AppModule extends Module {

    AppModule(Application application) {
        bind(Context.class).toInstance(application);
    }
}
