package restructure.com.restructureapp.api;

import android.app.Activity;

import java.io.IOException;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import restructure.com.restructureapp.util.Config;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * Created by rankaifeng on 2017/9/25.
 */

public class RetrofitSP {
    private static RetrofitSP instanse;

    public static RetrofitSP getInstanse() {
        if (instanse == null) {
            instanse = new RetrofitSP();
        }
        return instanse;
    }

    public <T> void toSubscribe(Activity activity, Observable<T> observable, Observer<T> observer) {
        observable.subscribeOn(Schedulers.io())    // 指定subscribe()发生在IO线程
                .observeOn(AndroidSchedulers.mainThread())  // 指定Subscriber的回调发生在io线程
                .subscribe(observer);   //订阅
    }

    public Retrofit getRetrofit(Class type) {
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request newRequest = chain.request().newBuilder()
                        .addHeader("OuYeellAuthorization", "android<>A227F7DE402348129E3C1D3F15FF9B4F<>2.3.2.4_beta<>0.0<>0.0")
                        .addHeader("DeviceInfo", "0")
                        .addHeader("Content-Type", "application/json;charset=UTF-8").build();
                return chain.proceed(newRequest);
            }
        }).build();


        Retrofit retrofit = new Retrofit.Builder().baseUrl(Config.TEST_URL)
                .addConverterFactory(new JsonConverterFactory(type))
//                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();

        return retrofit;
    }
}
