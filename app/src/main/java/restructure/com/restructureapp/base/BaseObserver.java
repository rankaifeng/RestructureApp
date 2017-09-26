package restructure.com.restructureapp.base;


import android.accounts.NetworkErrorException;
import android.app.Activity;
import android.net.ParseException;
import android.util.Log;

import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;

import org.json.JSONException;

import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import restructure.com.restructureapp.activity.LoginActivity;

/**
 * Created by rankaifeng on 2017/9/25.
 */

public abstract class BaseObserver<T> implements Observer<T> {
    private Activity activity;

    public BaseObserver(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {
        if (activity != null) {
            if (activity instanceof LoginActivity) {
                ((BaseActivity) activity).showProgress("登陆中......");
            } else {
                ((BaseActivity) activity).showProgress("请求中,请稍后......");
            }
        }
    }

    @Override
    public void onNext(@NonNull T t) {
        if (activity != null) {
            ((BaseActivity) activity).hideProgress();
        }
        if (null != t) {
            success(t);
        }
    }

    @Override
    public void onError(@NonNull Throwable t) {
        if (activity != null) {
            ((BaseActivity) activity).hideProgress();
        }
        StringBuffer sb = new StringBuffer();
        sb.append("请求失败：");
        if (t instanceof NetworkErrorException || t instanceof UnknownHostException || t instanceof ConnectException) {
            sb.append("网络异常");
        } else if (t instanceof SocketTimeoutException || t instanceof InterruptedIOException || t instanceof TimeoutException) {
            sb.append("请求超时");
        } else if (t instanceof JsonSyntaxException) {
            sb.append("请求不合法");
        } else if (t instanceof JsonParseException
                || t instanceof JSONException
                || t instanceof ParseException) {   //  解析错误
            sb.append("解析错误");
        } else {
            Log.e("error", t.getMessage());
            return;
        }
        Log.e("error", sb.toString());
    }

    @Override
    public void onComplete() {

    }

    public abstract void success(T obj);
}
