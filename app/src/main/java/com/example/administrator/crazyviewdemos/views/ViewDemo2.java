package com.example.administrator.crazyviewdemos.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.administrator.crazyviewdemos.R;

/**
 * Created by YinZeTong on 2017/11/8.
 */

public class ViewDemo2 extends View{
    public ViewDemo2(Context context) {
        super(context);
    }

    public ViewDemo2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        linearGradientDemo(canvas);
//        radialGradientDemo(canvas);
//        sweepGradientDemo(canvas);
//        bitmapShaderDemo(canvas);
//        ComposeShaderDemo(canvas);
    }

    private void ComposeShaderDemo(Canvas canvas) {
        /**
         * 注意：上面这段代码中我使用了两个 BitmapShader 来作为
         * ComposeShader() 的参数，而 ComposeShader() 在硬件加速
         * 下是不支持两个相同类型的 Shader 的，所以这里也需要关闭
         * 硬件加速才能看到效果
         */
        Paint paint = new Paint();
        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.icon_logo);
        Shader shader1 = new BitmapShader(bitmap1,Shader.TileMode.REPEAT,Shader.TileMode.REPEAT);

        Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(),R.drawable.ic_launcher);
        Shader shader2 = new BitmapShader(bitmap2,Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);

        Shader shader = new ComposeShader(shader1,shader2, PorterDuff.Mode.SRC_OVER);
        paint.setShader(shader);

        canvas.drawCircle(300,300,200,paint);
    }

    private void bitmapShaderDemo(Canvas canvas) {
        Paint paint = new Paint();
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
        Shader shader = new BitmapShader(bitmap,Shader.TileMode.REPEAT,Shader.TileMode.REPEAT);
        paint.setShader(shader);
        canvas.drawCircle(300,300,300,paint);
    }

    private void sweepGradientDemo(Canvas canvas) {
        Paint paint = new Paint();
        //color0:扫描起始的颜色
        //color1:扫描终止的颜色
        Shader shader = new SweepGradient(300,300, Color.parseColor("#E91e63"),
                Color.parseColor("#2196F3"));
        paint.setShader(shader);
        canvas.drawCircle(300,300,200,paint);
    }

    private void radialGradientDemo(Canvas canvas) {
        Paint paint = new Paint();
        Shader shader = new RadialGradient(300, 300, 200,
                Color.parseColor("#E91e63"),
                Color.parseColor("#2196F3"),
                Shader.TileMode.CLAMP);
        paint.setShader(shader);
        canvas.drawCircle(300, 300, 200, paint);
    }

    private void linearGradientDemo(Canvas canvas) {
        Shader shader = new LinearGradient(100,100,500,500, Color.parseColor("#E91E63"),Color.parseColor("#2196f3"),Shader.TileMode.CLAMP);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(shader);

        canvas.drawCircle(300,300,200,paint);
    }
}
