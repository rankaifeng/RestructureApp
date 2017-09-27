package restructure.com.restructureapp.api;


import io.reactivex.Observable;
import restructure.com.restructureapp.bean.UserIn;
import restructure.com.restructureapp.bean.UserOut;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by rankaifeng on 2017/9/25.
 */

public interface CarAppApi {
    /*登陆*/
    @POST("")
    Observable<UserOut> login(@Body UserIn userIn);
}
