package restructure.com.restructureapp.activity;


import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import restructure.com.restructureapp.R;
import restructure.com.restructureapp.adapter.BiddingAdapter;
import restructure.com.restructureapp.base.BaseActivity;
import restructure.com.restructureapp.base.BaseLayzFragment;
import restructure.com.restructureapp.presenter.LoginPresenter;
import restructure.com.restructureapp.view.LoginView;

public class MainActivity extends BaseActivity<LoginView, LoginPresenter> {
    ViewPager mViewPager;
    List<Fragment> mFragmentList;
    MyViewPagerAdapter myViewPagerAdapter;

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        mViewPager = findViewById(R.id.view_pager);
        if (mFragmentList == null) {
            mFragmentList = new ArrayList<>();
        }
        mFragmentList.add(BaseLayzFragment.newInstance(1, "我是第一个fragment"));
        mFragmentList.add(BaseLayzFragment.newInstance(2, "我是第二个fragment"));
        mFragmentList.add(BaseLayzFragment.newInstance(3, "我是第三个framgent"));
        myViewPagerAdapter = new MyViewPagerAdapter(getSupportFragmentManager(), mFragmentList);
        mViewPager.setAdapter(myViewPagerAdapter);
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
}
