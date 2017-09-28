package restructure.com.restructureapp.activity;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import restructure.com.restructureapp.R;
import restructure.com.restructureapp.adapter.BiddingAdapter;
import restructure.com.restructureapp.base.BaseActivity;
import restructure.com.restructureapp.presenter.LoginPresenter;
import restructure.com.restructureapp.view.LoginView;

public class MainActivity extends BaseActivity<LoginView, LoginPresenter> {
    //    @BindView(R.id.recy_main)
    RecyclerView recyclerView;
    List<String> stringList = new ArrayList<>();

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        recyclerView = findViewById(R.id.recy_main);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        for (int i = 0; i < 20; i++) {
            stringList.add("测试数据" + i);
        }
        BiddingAdapter biddingAdapter = new BiddingAdapter(this, R.layout.bidding, stringList);
        recyclerView.setAdapter(biddingAdapter);
    }

    @Override
    protected LoginPresenter createPresenter() {
        return null;
    }
}
