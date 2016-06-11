package com.mstc.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * TODO: document your custom view class.
 */
public class MyScrollView extends ScrollView {

    private ScrollViewListener scrollViewListener = null;

    public MyScrollView(Context context) {
        super(context);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setOnScrollViewListener(ScrollViewListener scrollViewListener){
        this.scrollViewListener = scrollViewListener;
    }

    @Override
    protected void onScrollChanged(int x,int y,int oldx,int oldy){
        super.onScrollChanged(x, y, oldx, oldy);
        if(scrollViewListener != null){
            scrollViewListener.onScrollChanged(this,x,y,oldx,oldy);
        }
    }
}
