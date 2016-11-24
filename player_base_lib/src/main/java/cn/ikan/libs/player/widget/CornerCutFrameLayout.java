package cn.ikan.libs.player.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.FrameLayout;

/**
 * Created by Taurus on 2016/10/17.
 */

public class CornerCutFrameLayout extends FrameLayout {

    private String TAG = "_CornerCut";
    private int mWidth,mHeight;
    private int mCornerBgColor = Color.TRANSPARENT;
    private int mCornerRadius = 0;
    private Paint mPaint;

    private PointF start, end, control;

    public CornerCutFrameLayout(Context context) {
        super(context);
        init(context);
    }

    public CornerCutFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CornerCutFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        setBackgroundColor(Color.TRANSPARENT);
        mPaint = new Paint();
        mPaint.setColor(mCornerBgColor);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);

        start = new PointF(0,0);
        end = new PointF(0,0);
        control = new PointF(0,0);
    }

    public void setCornerBgColor(int cornerBgColor){
        this.mCornerBgColor = cornerBgColor;
        mPaint.setColor(mCornerBgColor);
        invalidate();
    }

    public void setCornerRadius(int cornerRadius){
        this.mCornerRadius = cornerRadius;
        invalidate();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
        Log.d(TAG,"mWidth = " + mWidth + " mHeight = " + mHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(mCornerRadius<=0)
            return;
        drawLeftTop(canvas);
        drawLeftBottom(canvas);
        drawRightTop(canvas);
        drawRightBottom(canvas);
    }

    private void drawLeftTop(Canvas canvas) {

        // 初始化数据点和控制点的位置
        start.x = mCornerRadius;
        start.y = 0;
        end.x = 0;
        end.y = mCornerRadius;
        control.x = 0;
        control.y = 0;

        Path leftTop = new Path();
        leftTop.lineTo(mCornerRadius,0);
        leftTop.quadTo(control.x,control.y,end.x,end.y);
        leftTop.lineTo(0,0);
        canvas.drawPath(leftTop,mPaint);
    }

    private void drawLeftBottom(Canvas canvas) {

        // 初始化数据点和控制点的位置
        start.x = 0;
        start.y = mHeight - mCornerRadius;
        end.x = mCornerRadius;
        end.y = mHeight;
        control.x = 0;
        control.y = mHeight;

        Path leftBottom = new Path();
        leftBottom.moveTo(0,mHeight);
        leftBottom.lineTo(0,mHeight - mCornerRadius);
        leftBottom.quadTo(control.x,control.y,end.x,end.y);
        leftBottom.lineTo(0,mHeight);
        canvas.drawPath(leftBottom,mPaint);
    }

    private void drawRightTop(Canvas canvas) {

        // 初始化数据点和控制点的位置
        start.x = mWidth - mCornerRadius;
        start.y = 0;
        end.x = mWidth;
        end.y = mCornerRadius;
        control.x = mWidth;
        control.y = 0;

        Path rightTop = new Path();
        rightTop.moveTo(mWidth,0);
        rightTop.lineTo(mWidth - mCornerRadius,0);
        rightTop.quadTo(control.x,control.y,end.x,end.y);
        rightTop.lineTo(mWidth,0);
        canvas.drawPath(rightTop,mPaint);
    }

    private void drawRightBottom(Canvas canvas) {

        // 初始化数据点和控制点的位置
        start.x = mWidth;
        start.y = mHeight - mCornerRadius;
        end.x = mWidth - mCornerRadius;
        end.y = mHeight;
        control.x = mWidth;
        control.y = mHeight;

        Path rightBottom = new Path();
        rightBottom.moveTo(mWidth,mHeight);
        rightBottom.lineTo(mWidth,mHeight - mCornerRadius);
        rightBottom.quadTo(control.x,control.y,end.x,end.y);
        rightBottom.lineTo(mWidth,mHeight);
        canvas.drawPath(rightBottom,mPaint);
    }
}
