package restructure.com.restructureapp.activity;


import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import restructure.com.restructureapp.R;
import restructure.com.restructureapp.adapter.BiddingAdapter;
import restructure.com.restructureapp.base.BaseActivity;
import restructure.com.restructureapp.base.BaseLayzFragment;
import restructure.com.restructureapp.presenter.LoginPresenter;
import restructure.com.restructureapp.view.LoginView;
import restructure.com.restructureapp.widget.TabItemView;
import restructure.com.restructureapp.widget.TabSlectChange;

public class MainActivity extends BaseActivity<LoginView, LoginPresenter> {
    ViewPager mViewPager;
    List<Fragment> mFragmentList;
    MyViewPagerAdapter myViewPagerAdapter;
    TabLayout mTabLayout;
    private String tabIcon[] = new String[]{"首页", "消息", "我的"};

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        mViewPager = findViewById(R.id.view_pager);
        mTabLayout = findViewById(R.id.tab_layout);
        if (mFragmentList == null) {
            mFragmentList = new ArrayList<>();
        }
        mFragmentList.add(BaseLayzFragment.newInstance(1, "首页"));
        mFragmentList.add(BaseLayzFragment.newInstance(2, "消息"));
        mFragmentList.add(BaseLayzFragment.newInstance(3, "我的"));
        TabPagerAdapter mTabPagerAdapter = new TabPagerAdapter(getSupportFragmentManager());

        mViewPager = findViewById(R.id.view_pager);
        mViewPager.setAdapter(mTabPagerAdapter);

        initTabLayout();
//        myViewPagerAdapter = new MyViewPagerAdapter(getSupportFragmentManager(), mFragmentList);
//        mViewPager.setAdapter(myViewPagerAdapter);
    }

    @Override
    protected LoginPresenter createPresenter() {
        return null;
    }

    protected void showData() {
        RecyclerView recyclerView;
        List<String> stringList = new ArrayList<>();
        recyclerView = findViewById(R.id.recy_main);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        for (int i = 0; i < 20; i++) {
            stringList.add("测试数据" + i);
        }
        BiddingAdapter biddingAdapter = new BiddingAdapter(this, R.layout.bidding, stringList);
        recyclerView.setAdapter(biddingAdapter);
    }

    private class TabPagerAdapter extends FragmentPagerAdapter {

        private TabPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
//            //构造插件 Fragment
//            Fragment fragment = Small.createObject("fragment-v4", sUris[position], MainActivity.this);
//            if (fragment == null) {
//                fragment = PlaceHolderFragment.newInstance(position);
//            }
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return tabIcon.length;
        }
    }

    /**
     * 初始化 TabLayout
     */
    private void initTabLayout() {

        //设置 TabLayout 初始图像和字样
        TabItemView homeTab = new TabItemView(this).setText("首页").setImageRes(R.drawable.home);
        TabItemView messageTab = new TabItemView(this).setText("消息").setImageRes(R.drawable.msg);
        TabItemView mineTab = new TabItemView(this).setText("我的").setImageRes(R.drawable.my);
        mTabLayout.addTab(mTabLayout.newTab().setCustomView(homeTab));
        mTabLayout.addTab(mTabLayout.newTab().setCustomView(messageTab));
        mTabLayout.addTab(mTabLayout.newTab().setCustomView(mineTab));

        //自定义 View 的时候无法使用 setupWithViewPager() 方法
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));
        mTabLayout.setSelectedTabIndicatorColor(Color.BLUE);
        mTabLayout.setOnTabSelectedListener(new TabSlectChange() {
            @Override
            public void selectTab(TabLayout.Tab tab) {
                selectTablayout(tab, "select");
            }

            @Override
            public void unSelectTab(TabLayout.Tab tab) {
                selectTablayout(tab, "unselect");
            }
        });
    }


    /**
     * 改变tablayout的文字选中颜色
     *
     * @param tab
     * @param type
     */
    private void selectTablayout(TabLayout.Tab tab, String type) {
        TextView te = tab.getCustomView().findViewById(R.id.tv_tab);
        if (type.equals("select")) {
            te.setTextColor(Color.BLUE);
        } else {
            te.setTextColor(Color.WHITE);
        }
    }
}
