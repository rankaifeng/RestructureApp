package restructure.com.restructureapp.fragment;

import android.util.Log;

import restructure.com.restructureapp.base.BaseLayzFragment;

/**
 * Created by rankaifeng on 2017/9/29.
 */

public class TwoFragment extends BaseLayzFragment {
    private static final String TAG = TwoFragment.class.getSimpleName();



    @Override
    public void loadDatas() {
        Log.e(TAG, "我是第二个fragment加载。。。。");
    }
}
