package restructure.com.restructureapp.activity;

import android.util.Log;
import android.view.View;
import android.widget.Button;

import restructure.com.restructureapp.R;
import restructure.com.restructureapp.base.BaseActivity;
import restructure.com.restructureapp.bean.UserIn;
import restructure.com.restructureapp.bean.UserOut;
import restructure.com.restructureapp.presenter.LoginPresenter;
import restructure.com.restructureapp.util.ChangeActivityUtil;
import restructure.com.restructureapp.util.Config;
import restructure.com.restructureapp.view.LoginView;

/**
 * Created by rankaifeng on 2017/9/26.
 */

public class LoginActivity extends BaseActivity<LoginView, LoginPresenter> implements LoginView {
    private static String TAG = LoginActivity.class.getSimpleName();
    private LoginPresenter loginPresenter;
    Button btnLogin;

    @Override
    public int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {
        setTitle("登陆");
        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserIn userIn1 = new UserIn("13811111555", "E10ADC3949BA59ABBE56E057F20F883E", Config.PLAT_ID);
                loginPresenter = new LoginPresenter(LoginActivity.this);
                loginPresenter.login(userIn1, LoginActivity.this);
//                ChangeActivityUtil.intenMainActivity(LoginActivity.this);
            }
        });
    }

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter(this);
    }

    @Override
    public void loginSuess(UserOut userOut) {
        ChangeActivityUtil.intenMainActivity(LoginActivity.this);
        Log.e(TAG, "请求成功");
    }
}
