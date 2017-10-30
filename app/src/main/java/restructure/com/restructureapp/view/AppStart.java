package restructure.com.restructureapp.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import restructure.com.restructureapp.util.ChangeActivityUtil;

/**
 * Created by rankaifeng on 2017/9/25.
 */

public class AppStart extends Activity {
    private static final String TAG = AppStart.class.getSimpleName();
    ChangeActivityUtil activityUtil = new ChangeActivityUtil();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

    @Override
    protected void onStart() {
        super.onStart();
        getWindow().getDecorView().postDelayed(new Runnable() {
            @Override
            public void run() {
                activityUtil.intentLoginActivity(AppStart.this);
                finish();
            }
        }, 3000);
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }
}
