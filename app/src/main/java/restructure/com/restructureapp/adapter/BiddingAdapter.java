package restructure.com.restructureapp.adapter;

import android.content.Context;

import java.util.List;

import restructure.com.library.adapter.BaseViewHolder;
import restructure.com.library.adapter.PublicAdapter;
import restructure.com.restructureapp.R;

/**
 * Created by rankaifeng on 2017/9/28.
 */

public class BiddingAdapter extends PublicAdapter<String> {
    private List<String> stringList;

    public BiddingAdapter(Context context, int layoutId, List datas) {
        super(context, layoutId, datas);
        this.stringList = datas;
    }

    @Override
    public void convert(BaseViewHolder holder, int position) {
        holder.setText(R.id.tv_str, stringList.get(position));
    }
}
