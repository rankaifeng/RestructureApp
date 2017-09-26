package restructure.com.restructureapp.activity;


import restructure.com.restructureapp.R;
import restructure.com.restructureapp.base.BaseActivity;
import restructure.com.restructureapp.presenter.LoginPresenter;
import restructure.com.restructureapp.view.LoginView;

public class MainActivity extends BaseActivity<LoginView, LoginPresenter> {

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        setTitle("主界面");
    }

    @Override
    protected LoginPresenter createPresenter() {
        return null;
    }
}
