package com.gzk.sample.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Scroller;

/**
 * Created by gzhenk on 16-1-29.
 */
public class ScrollViewLinearLayout extends LinearLayout implements View.OnTouchListener {

    private LinearLayout top;
    //private LinearLayout.LayoutParams top_lp ;
    private ScrollView sv;
    private boolean isFrist = true;
    private float y1, y2;
    private int hight = 60;
    private Scroller mScroller;

    public ScrollViewLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

        setClickable(true);
        setLongClickable(true);
        mScroller = new Scroller(context);

    }

    protected void smoothScrollBy(int dx, int dy) {
        //设置mScroller的滚动偏移量
        mScroller.startScroll(0, mScroller.getFinalY(), 0, dy);
        //这里必须调用invalidate()才能保证computeScroll()会被调用，否则不一定会刷新界面，看不到滚动效果
        invalidate();
    }

    protected void smoothScrollTo(int fx, int fy) {
        int dx = fx - mScroller.getFinalX();
        int dy = fy - mScroller.getFinalY();
        smoothScrollBy(0, dy);
    }


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        //只需实例化一次
        if (changed && isFrist) {
            //该自定义布局写入xml文件时，其子布局的第一个必须是ScrollView时，这里才能getChildAt(0），实例化ScrollView
            sv = (ScrollView) getChildAt(0);
            //去掉ScrollView 滑动到底部或顶部 继续滑动时会出现渐变的蓝色颜色快
            sv.setOverScrollMode(View.OVER_SCROLL_NEVER);
            sv.setOnTouchListener(this);
            isFrist = false;

        }

    }

    @Override
    public void computeScroll() {
        //判断mScroller滚动是否完成
        if (mScroller.computeScrollOffset()) {
            scrollTo(mScroller.getCurrX(), mScroller.getCurrY());//这里调用View的scrollTo()完成实际的滚动
            postInvalidate();
        }
        super.computeScroll();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                y1 = event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                y2 = event.getY();
                int scrollY = v.getScrollY();
                int height = v.getHeight();
                int scrollViewMeasuredHeight = sv.getChildAt(0).getMeasuredHeight();
                //头部回弹效果
                if (y2 - y1 > 0 && v.getScrollY() <= 0) {
                    smoothScrollTo(0, -(int) ((y2 - y1) / 2));
                    System.out.println("topMargin=" + ((int) ((y2 - y1) / 2)));
                    return false;
                }

                //底部回弹效果
                if (y2 - y1 < 0 && (scrollY + height) == scrollViewMeasuredHeight) {
                    smoothScrollTo(0, -(int) ((y2 - y1) / 2));
                    return false;
                }

                break;
            case MotionEvent.ACTION_UP:
                //松开手指，自动回滚
                smoothScrollTo(0, 0);
                break;
            default:
                break;
        }
        return false;
    }
}
