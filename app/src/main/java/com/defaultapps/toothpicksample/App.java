package com.defaultapps.toothpicksample;

import android.app.Application;

import toothpick.Scope;
import toothpick.Toothpick;
import toothpick.configuration.Configuration;
import toothpick.registries.FactoryRegistryLocator;
import toothpick.registries.MemberInjectorRegistryLocator;
import toothpick.smoothie.module.SmoothieApplicationModule;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Toothpick.setConfiguration(Configuration.forProduction().disableReflection()); // Production
        FactoryRegistryLocator.setRootRegistry(new com.defaultapps.toothpicksample.FactoryRegistry());
        MemberInjectorRegistryLocator.setRootRegistry(new com.defaultapps.toothpicksample.MemberInjectorRegistry());

        Scope appScope = Toothpick.openScope(this);
        initToothpick(appScope);
    }

    public void initToothpick(Scope appScope) {
        appScope.installModules(new SmoothieApplicationModule(this), new AppModule(this));
    }
}
