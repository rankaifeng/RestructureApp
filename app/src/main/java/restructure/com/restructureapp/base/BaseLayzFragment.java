package restructure.com.restructureapp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import restructure.com.restructureapp.R;
import restructure.com.restructureapp.fragment.OneFragment;
import restructure.com.restructureapp.fragment.ThreeFragment;
import restructure.com.restructureapp.fragment.TwoFragment;

/**
 * Created by rankaifeng on 2017/9/29.
 */

public abstract class BaseLayzFragment extends Fragment {
    private boolean isLazyLoaded;

    private boolean isPrepared;

    public static Fragment newInstance(int type, String str) {
        Bundle args = new Bundle();
        args.putString("str", str);
        switch (type) {
            case 1:
                OneFragment oneFragment = new OneFragment();
                oneFragment.setArguments(args);
                return oneFragment;
            case 2:
                TwoFragment twoFragment = new TwoFragment();
                twoFragment.setArguments(args);
                return twoFragment;
            case 3:
                ThreeFragment threeFragment = new ThreeFragment();
                threeFragment.setArguments(args);
                return threeFragment;
            default:
                return null;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment, container, false);
        TextView tvFragment = rootView.findViewById(R.id.tv_fragment);
        Bundle arguments = getArguments();
        String str = arguments.getString("str");
        tvFragment.setText(str);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        isPrepared = true;
        lazyLoad();
    }

    /**
     * 调用懒加载
     */

    private void lazyLoad() {
        if (getUserVisibleHint() && isPrepared && !isLazyLoaded) {
            loadDatas();
            isLazyLoaded = true;
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        lazyLoad();
    }

    public abstract void loadDatas();
}
