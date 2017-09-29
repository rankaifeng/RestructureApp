package restructure.com.restructureapp.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by rankaifeng on 2017/9/29.
 */

class MyViewPagerAdapter extends FragmentPagerAdapter {
    List<Fragment> fragmentList;

    public MyViewPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragmentList = fragments;
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }


    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }
}
