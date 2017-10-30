package restructure.com.restructureapp.widget;

import android.support.design.widget.TabLayout;

/**
 * Created by rankaifeng on 2017/10/17.
 */

public abstract class TabSlectChange implements TabLayout.OnTabSelectedListener {
    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        selectTab(tab);
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
        unSelectTab(tab);
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    public abstract void selectTab(TabLayout.Tab tab);

    public abstract void unSelectTab(TabLayout.Tab tab);
}
