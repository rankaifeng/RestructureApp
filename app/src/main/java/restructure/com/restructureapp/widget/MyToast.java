package restructure.com.restructureapp.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import restructure.com.restructureapp.R;

/**
 * Created by rankaifeng on 2017/9/27.
 */

public class MyToast {
    private Toast mToast;
    private static final int DURATION = Toast.LENGTH_LONG;

    private MyToast(Context context, CharSequence text, int duration) {
        View v = LayoutInflater.from(context).inflate(R.layout.my_toast, null);
        TextView textView = (TextView) v.findViewById(R.id.tv_tost);
        textView.setText(text);
        mToast = new Toast(context);
        mToast.setDuration(duration);
        mToast.setView(v);
    }

    public static MyToast makeText(Context context, CharSequence text) {
        return new MyToast(context, text, DURATION);
    }

    public void show() {
        if (mToast != null) {
            mToast.show();
        }
    }

    public void setGravity(int gravity, int xOffset, int yOffset) {
        if (mToast != null) {
            mToast.setGravity(gravity, xOffset, yOffset);
        }
    }
}
