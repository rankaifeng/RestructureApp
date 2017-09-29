package restructure.com.restructureapp.fragment;

import android.util.Log;

import restructure.com.restructureapp.base.BaseLayzFragment;

/**
 * Created by rankaifeng on 2017/9/29.
 */

public class ThreeFragment extends BaseLayzFragment {
    private static final String TAG = ThreeFragment.class.getSimpleName();

    @Override
    public void loadDatas() {
        Log.e(TAG, "我是第三个fragment加载。。。。");
    }
}
