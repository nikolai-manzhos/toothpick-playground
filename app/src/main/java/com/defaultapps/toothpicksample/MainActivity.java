package com.defaultapps.toothpicksample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.defaultapps.core.CoreDep1;
import com.defaultapps.utils.UtilClass1;
import com.defaultapps.utils.UtilClass2;

import javax.inject.Inject;

import toothpick.Scope;
import toothpick.Toothpick;
import toothpick.smoothie.module.SmoothieActivityModule;

public class MainActivity extends AppCompatActivity {

    @Inject
    UtilClass1 utilClass1;

    @Inject
    UtilClass2 utilClass2;

    @Inject
    CoreDep1 coreDep1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Scope scope = Toothpick.openScopes(getApplication(), this);
        scope.installModules(new SmoothieActivityModule(this));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toothpick.inject(this, scope);

        checkNotNull(utilClass1);
        checkNotNull(utilClass2);
        checkNotNull(coreDep1);
    }

    @Override
    protected void onDestroy() {
        Toothpick.closeScope(this);
        super.onDestroy();
    }

    private <T> void checkNotNull(T t) {
        if (t == null) throw new RuntimeException("NULL");
    }
}
