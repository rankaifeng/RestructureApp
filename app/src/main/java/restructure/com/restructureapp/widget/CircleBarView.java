package restructure.com.restructureapp.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by rankaifeng on 2017/10/16.
 */

public class CircleBarView extends View {
    private Paint rPaint;//绘制矩形的画笔
    private Paint progressPaint;//绘制圆弧的画笔

    public CircleBarView(Context context) {
        super(context);
    }

    public CircleBarView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public CircleBarView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        rPaint = new Paint();
        rPaint.setStyle(Paint.Style.STROKE);//只描边不填充
        rPaint.setColor(Color.RED);
        progressPaint = new Paint();
        progressPaint.setStyle(Paint.Style.STROKE);//只描边，不填充
        progressPaint.setColor(Color.BLUE);
        progressPaint.setAntiAlias(true);//设置抗锯齿
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float x = 50;
        float y = 50;
        RectF rectF = new RectF(x, y, x + 300, y + 300);//建一个大小为300 * 300的正方形区域
        canvas.drawArc(rectF, 0, 270, false, progressPaint);//这里角度0对应的是三点钟方向，顺时针方向递增
        canvas.drawRect(rectF, rPaint);
    }
}
