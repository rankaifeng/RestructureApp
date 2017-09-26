package restructure.com.restructureapp.presenter;

import android.app.Activity;

import restructure.com.restructureapp.base.BasePresenter;
import restructure.com.restructureapp.bean.UserIn;
import restructure.com.restructureapp.bean.UserOut;
import restructure.com.restructureapp.model.LoginModel;
import restructure.com.restructureapp.model.imp.LoginModelImp;
import restructure.com.restructureapp.view.LoginView;

/**
 * Created by rankaifeng on 2017/9/26.
 */

public class LoginPresenter extends BasePresenter<LoginView>{
    private LoginView loginView;
    private LoginModel loginModel;

    public LoginPresenter(LoginView loginView) {
        this.loginView = loginView;
        this.loginModel = new LoginModelImp();
    }

    public void login(UserIn userIn, Activity activity) {
        loginModel.login(userIn, activity, new LoginModel.LoginSuessListener() {
            @Override
            public void suess(UserOut userOut) {
                loginView.loginSuess(userOut);
            }
        });
    }
}
