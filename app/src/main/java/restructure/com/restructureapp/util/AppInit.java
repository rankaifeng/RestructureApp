package restructure.com.restructureapp.util;

import android.app.Application;

/**
 * Created by rankaifeng on 2017/9/25.
 */

public class AppInit extends Application {
    private static AppInit mInstanse;

    public static AppInit getmInstanse() {
        if (mInstanse == null) {
            mInstanse = new AppInit();
        }
        return mInstanse;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
