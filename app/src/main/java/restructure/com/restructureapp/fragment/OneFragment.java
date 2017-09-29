package restructure.com.restructureapp.fragment;

import android.util.Log;

import restructure.com.restructureapp.base.BaseLayzFragment;

/**
 * Created by rankaifeng on 2017/9/29.
 */

public class OneFragment extends BaseLayzFragment {
    private static final String TAG = OneFragment.class.getSimpleName();



    @Override
    public void loadDatas() {
        Log.e(TAG, "我是第一个fragment加载。。。。");
    }
}
