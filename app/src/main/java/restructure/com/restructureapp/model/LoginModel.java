package restructure.com.restructureapp.model;

import android.app.Activity;

import restructure.com.restructureapp.bean.UserIn;
import restructure.com.restructureapp.bean.UserOut;

/**
 * Created by rankaifeng on 2017/9/26.
 */

public interface LoginModel {
    void login(UserIn userIn, Activity activity,LoginSuessListener loginSuessListener);

    interface LoginSuessListener{
        void suess(UserOut userOut);
    }
}
