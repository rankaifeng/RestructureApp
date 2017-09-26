package restructure.com.restructureapp.model.imp;

import android.app.Activity;

import io.reactivex.Observable;
import restructure.com.restructureapp.api.CarAppApi;
import restructure.com.restructureapp.api.RetrofitSP;
import restructure.com.restructureapp.base.BaseObserver;
import restructure.com.restructureapp.bean.UserIn;
import restructure.com.restructureapp.bean.UserOut;
import restructure.com.restructureapp.model.LoginModel;
import retrofit2.Retrofit;

/**
 * Created by rankaifeng on 2017/9/26.
 */

public class LoginModelImp implements LoginModel {
    RetrofitSP retrofitSP = RetrofitSP.getInstanse();
    @Override
    public void login(UserIn userIn, Activity activity, final LoginSuessListener loginSuessListener) {
        Retrofit retrofit = retrofitSP.getRetrofit(UserOut.class);
        CarAppApi carAppApi = retrofit.create(CarAppApi.class);
        Observable<UserOut> login = carAppApi.login(userIn);
        retrofitSP.toSubscribe(activity, login, new BaseObserver<UserOut>(activity) {
            @Override
            public void success(UserOut obj) {
                loginSuessListener.suess(obj);
            }
        });
    }
}
