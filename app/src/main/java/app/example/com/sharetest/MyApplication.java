package app.example.com.sharetest;

import android.app.Application;
import android.content.Context;

/**
 * Created by Dudaizhong on 2016/7/11.
 */
public class MyApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }

}
