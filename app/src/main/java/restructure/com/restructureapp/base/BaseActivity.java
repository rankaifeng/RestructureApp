package restructure.com.restructureapp.base;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.ButterKnife;
import restructure.com.restructureapp.R;
import restructure.com.restructureapp.util.ViewUtil;
import restructure.com.restructureapp.widget.MyDiglog;
import restructure.com.restructureapp.widget.MyToast;

/**
 * Created by rankaifeng on 2017/9/25.
 */

public abstract class BaseActivity<V, T extends BasePresenter<V>> extends FragmentActivity {
    protected T mPrster;
    Dialog progressDlg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewUtil.initSystemBar(this, R.color.system_bar_bg);
        setContentView(getLayout());
        ButterKnife.bind(this);
        if (createPresenter() != null) {
                 /*创建center*/
            mPrster = createPresenter();
        /*关联view*/
            mPrster.attachView((V) this);
        }
        initView();
    }

    /**
     * 设置Activity标题
     */
    public void setTitle(String resId) {
        LinearLayout layout = (LinearLayout) findViewById(R.id.layout_top);
        TextView textView = (TextView) layout.findViewById(R.id.tv_activity_title);
        textView.setText(resId);
    }

    public abstract int getLayout();

    public abstract void initView();

    protected abstract T createPresenter();


    /**
     * 显示加载进度框
     *
     * @param msg
     */
    public void showProgress(String msg) {
        progressDlg = MyDiglog.createLoadingDialog(BaseActivity.this, msg, true);
    }

    /**
     * 隐藏进度框
     */
    public void hideProgress() {
        if (progressDlg != null && progressDlg.isShowing()) {
            progressDlg.dismiss();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        /*解除关联*/
        if (mPrster != null) {
            mPrster.detachView();
        }
    }

    /**
     * 显示tost
     *
     * @param msg
     */
    public void showTost(String msg) {
        MyToast myToast = MyToast.makeText(BaseActivity.this, msg);
        myToast.setGravity(Gravity.CENTER, 0, 0);
        myToast.show();
    }
}
