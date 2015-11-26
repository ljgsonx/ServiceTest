package com.example.ljgsonx.viewtest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;

/**
 * Created by ljgsonx on 2015/11/15.
 */
public class DrawableView extends View {
    BitmapDrawable bitmapDrawable;
    public DrawableView(Context context) {
        super(context);
        //也可以从xml获取,转换成viewgroup对象
        bitmapDrawable = (BitmapDrawable) getResources().getDrawable(R.drawable.cc);
        bitmapDrawable.setBounds(10, 10, 135, 160);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        bitmapDrawable.draw(canvas);
    }
}
