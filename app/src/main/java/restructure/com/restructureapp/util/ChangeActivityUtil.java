package restructure.com.restructureapp.util;

import android.app.Activity;
import android.content.Intent;

import restructure.com.restructureapp.activity.LoginActivity;
import restructure.com.restructureapp.activity.MainActivity;

/**
 * Created by rankaifeng on 2017/9/25.
 */

public class ChangeActivityUtil {
    /**
     * 跳转到登陆界面
     *
     * @param activity
     */
    public static void intentLoginActivity(Activity activity) {
        Intent intent = new Intent(activity, LoginActivity.class);
        activity.startActivity(intent);
    }

    /**
     * 跳转到主界面
     *
     * @param activity
     */
    public static void intenMainActivity(Activity activity) {
        Intent intent = new Intent(activity, MainActivity.class);
        activity.startActivity(intent);
    }
}
