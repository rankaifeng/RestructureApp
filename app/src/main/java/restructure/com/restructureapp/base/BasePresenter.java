package restructure.com.restructureapp.base;

import java.lang.ref.WeakReference;

/**
 * Created by rankaifeng on 2017/9/19.
 */

public abstract class BasePresenter<T> {
    protected WeakReference<T> mTWeakReference;

    public void attachView(T view) {
        mTWeakReference = new WeakReference<T>(view);
    }

    public void detachView() {
        if (mTWeakReference != null) {
            mTWeakReference.clear();
            mTWeakReference = null;
        }
    }

    protected T getView() {
        return mTWeakReference.get();
    }
}
