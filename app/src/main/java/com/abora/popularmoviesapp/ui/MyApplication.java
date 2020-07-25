package com.abora.popularmoviesapp.ui;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.multidex.MultiDex;

import com.abora.popularmoviesapp.util.LocaleHelper;


public class MyApplication extends Application {

    private static Application application;

    public static Context getContext() {
        return application.getApplicationContext();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleHelper.onAttach(base, "en"));
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
//        OneSignal.startInit(this)
//                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
//                .unsubscribeWhenNotificationsAreDisabled(true)
//                .setNotificationOpenedHandler(new ExampleNotificationOpenedHandler())
//                .init();
//
//        OneSignal.idsAvailable(new OneSignal.IdsAvailableHandler() {
//            @Override
//            public void idsAvailable(String userId, String registrationId) {
//                Log.d("debug", "User:" + userId);
//                if (registrationId != null)
//                    Log.d("debug", "registrationId:" + registrationId);
//
//            }
//        });
    }
}
