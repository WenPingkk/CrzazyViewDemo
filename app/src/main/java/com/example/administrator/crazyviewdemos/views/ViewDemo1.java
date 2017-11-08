package com.example.administrator.crazyviewdemos.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import com.example.administrator.crazyviewdemos.R;

/**
 * Created by YinZeTong on 2017/11/8.
 */

public class ViewDemo1 extends View {
    public ViewDemo1(Context context) {
        super(context);
    }

    public ViewDemo1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        drawPoints(canvas);
//        drawOval(canvas);
//        drawLine(canvas);
//        drawlines(canvas);
//        drawRounRect(canvas);
//        drawArc(canvas);
//        drawPath1(canvas);
//        drawPathCircle(canvas);
//        drawPathLineToxx(canvas);
//        drawBeisaier(canvas);
//        drawBeiSaier2(canvas);
//        drawPathMoveTo(canvas);
//        drawPathArcTo();
//        drawPathClose();
//        drawPathStyle();
//        drawBitmap(canvas);
//        drawText(canvas);


    }

    private void drawText(Canvas canvas) {
        /**
         * drawText(String text, float x, float y, Paint paint) 绘制文字
         界面里所有的显示内容，都是绘制出来的，包括文字。 drawText()
         这个方法就是用来绘制文字的。参数 text 是用来绘制的字符串，x 和 y 是绘制的起点坐标。
         */

        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        String text = "wenping coder";
        paint.setTextSize(18);
        canvas.drawText(text, 100, 25, paint);
        paint.setTextSize(36);
        canvas.drawText(text, 100, 70, paint);
        paint.setTextSize(60);
        canvas.drawText(text, 100, 145, paint);
        paint.setTextSize(84);
        canvas.drawText(text, 100, 240, paint);
    }

    private void drawBitmap(Canvas canvas) {
        /**
         * drawBitmap(Bitmap bitmap, float left, float top, Paint paint) 画 Bitmap
         绘制 Bitmap 对象，也就是把这个 Bitmap 中的像素内容贴过来。其中 left 和 top
         是要把 bitmap 绘制到的位置坐标。它的使用非常简单。
         */
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
//        Bitmap bitmap = BitmapFactory.decodeResource(R.mipmap.ic_launcher,null);
//        canvas.drawBitmap(bitmap,200,100,paint);
    }

    private void drawPathStyle() {
        /**
         * 「子图形」：官方文档里叫做 contour 。
         * 但由于在这个场景下我找不到这个词合适的中文翻译（直译的话叫做「轮廓」），
         * 所以我换了个便于中国人理解的词：「子图形」。前面说到，第一组方法是「添加子图形」，所谓「子图形」，指的就是一次不间断的连线。一个 Path 可以包含多个子图形。当使用第一组方法，即 addCircle() addRect() 等方法的时候，每一次方法调用都是新增了一个独立的子图形；而如果使用第二组方法，即 lineTo() arcTo() 等方法的时候，则是每一次断线（即每一次「抬笔」），都标志着一个子图形的结束，以及一个新的子图形的开始。
         另外，不是所有的子图形都需要使用 close() 来封闭。
         当需要填充图形时（即 Paint.Style 为 FILL 或 FILL_AND_STROKE），
         Path 会自动封闭子图形!!
         */
        Paint paint = new Paint();
        Path path = new Path();
        paint.setStyle(Paint.Style.FILL);
        path.moveTo(100, 100);
        path.lineTo(200, 100);
        path.lineTo(150, 150);
        //这里只是绘制了两条边,但是Style是Fill,所以绘制时会自动封口
    }

    private void drawPathClose() {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        Path path = new Path();

        path.moveTo(100, 100);
        path.lineTo(200, 100);
        path.lineTo(150, 150);
        path.close();//适用close(),封闭图形,等价:path.lineTo(100,100)
        //close()和lineTo(起点坐标)是完全等价的
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void drawPathArcTo() {
    /*
     * 第二组还有两个特殊的方法： arcTo() 和 addArc()。它们也是用来画线的，但并不使用当前位置作为弧线的起点。
     arcTo(RectF oval, float startAngle, float sweepAngle, boolean forceMoveTo) / arcTo(float left, float top, float right, float bottom, float startAngle, float sweepAngle, boolean forceMoveTo) / arcTo(RectF oval, float startAngle, float sweepAngle) 画弧形
     这个方法和 Canvas.drawArc() 比起来，少了一个参数 useCenter，而多了一个参数 forceMoveTo 。
     少了 useCenter ，是因为 arcTo() 只用来画弧形而不画扇形，所以不再需要 useCenter 参数；而多出来的这个
     forceMoveTo 参数的意思是，绘制是要「抬一下笔移动过去」，还是「直接拖着笔过去」，区别在于是否留下移动的痕迹。
     */

        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        Path path = new Path();
        path.lineTo(100, 100);
        //画出强制移动到弧线起点[不显示从上一位置移动到当前起点的移动痕迹]
        path.arcTo(100, 100, 300, 300, -90, 90, true);
        ;

        path.lineTo(100, 100);
        //画出从上一位置到当前弧线起点的移动痕迹
        path.arcTo(100, 100, 300, 300, -90, 90, false); // 直接连线连到弧形起点（有痕迹）

//        addArc(float left, float top, float right, float bottom, float startAngle, float sweepAngle) / addArc(RectF oval, float startAngle, float sweepAngle)
//        又是一个弧形的方法。一个叫 arcTo ，一个叫 addArc()，都是弧形，
// 区别在哪里？其实很简单： addArc() 只是一个直接使用了 forceMoveTo = true 的简化版 arcTo() 。
        path.lineTo(100, 100);
        path.addArc(100, 100, 300, 300, -90, 90);
    }

    private void drawPathMoveTo(Canvas canvas) {
        //moveTo(float x, float y) /
        // rMoveTo(float x, float y) 移动到目标位置
        //moveTo(x, y) 虽然不添加图形，但它会设置图形的起点，
        // 所以它是非常重要的一个辅助方法!
        /**
         * 不论是直线还是贝塞尔曲线，都是以当前位置作为起点，
         * 而不能指定起点。但你可以通过 moveTo(x, y) 或 rMoveTo()
         * 来改变当前位置，从而间接地设置这些方法的起点。
         */

        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        Path path = new Path();
        path.lineTo(100, 100);//画斜线
        path.moveTo(200, 100);//移动
        path.lineTo(200, 0);//画竖线

        canvas.drawPath(path, paint);
    }

    private void drawBeiSaier2(Canvas canvas) {
        //cubicTo(float x1, float y1, float x2, float y2, float x3, float y3)/
        // rCubicTo(float x1, float y1, float x2, float y2, float x3, float y3)
        // 画三次贝塞尔曲
        Paint paint = new Paint();
        Path path = new Path();
        //以下数字为随机,未验证
        path.cubicTo(200, 200, 300, 300, 400, 400);

        path.rCubicTo(200, 200, 300, 300, 400, 400);
        canvas.drawPath(path, paint);
    }

    private void drawBeisaier(Canvas canvas) {
        Paint paint = new Paint();
        Path path = new Path();

        /**
         * quadTo(float x1, float y1, float x2, float y2) /
         * rQuadTo(float dx1, float dy1, float dx2, float dy2) 画二次贝塞尔曲线
         * 这条二次贝塞尔曲线的起点就是当前位置，
         * 而参数中的 x1, y1 和 x2, y2 则分别是控制点和终点的坐标。
         * 和 rLineTo(x, y) 同理，rQuadTo(dx1, dy1, dx2, dy2) 的参数
         * 也是相对坐标
         */
//        path.quadTo(200,200,300,300);
        path.rQuadTo(200, 200, 300, 300);

        canvas.drawPath(path, paint);
    }

    private void drawPathLineToxx(Canvas canvas) {
        Paint paint = new Paint();
        Path path = new Path();
        //path.lineTo 绝对坐标
//        path.lineTo(200,200);
        //path.rLineTo 相对坐标 rLineTo(x, y) 的参数是相对当前位置的相对坐标 （前缀 r 指的就是 relatively 「相对地」)
        //当前位置：所谓当前位置，即最后一次调用画 Path 的方法的终点位置。初始值为原点 (0, 0)。
//        path.rLineTo(200,200);
        //*******************************
        path.lineTo(100, 100); // 由当前位置 (0, 0) 向 (100, 100) 画一条直线
        path.rLineTo(100, 0); // 由当前位置 (100, 100) 向正右方 100 像素的位置画一条直线
        //********************************
        canvas.drawPath(path, paint);
    }

    private void drawPathCircle(Canvas canvas) {
        //第一类,直接描述路径>>1,添加子图形
        /**
         * 画组合的图形适用drawPath;简单的不需要
         */
        Paint paint = new Paint();
        Path path = new Path();
        //Path.Direction.CCW:逆时针
        //Path.Direction.CW:顺时针

        /**
         * EVEN_ODD 简单粗暴的理解:交叉填充
         * WINDING[默认值] 全填充
         * INVERSE_EVENT_ODD
         * INVERSE_WINDING
         *
         */

        path.addCircle(200, 200, 100, Path.Direction.CCW);
//        path.setFillType(Path.FillType.EVEN_ODD);//外圆
        path.addCircle(300, 300, 200, Path.Direction.CW);
        canvas.drawPath(path, paint);

        //************************EVEN_ODD和WINDING的原理*************************************

        /**
         * 即 even-odd rule （奇偶原则）：对于平面中的任意一点，
         * 向任意方向射出一条射线，这条射线和图形相交的次数
         * （相交才算，相切不算哦）如果是奇数，则这个点被认为在
         * 图形内部，是要被涂色的区域；如果是偶数，则这个点被认为
         * 在图形外部，是不被涂色的区域。
         */

        /**
         * 然后，同样是从平面中的点向任意方向射出一条射线，
         * 但计算规则不一样：以 0 为初始值，对于射线和图形的所有交点，
         * 遇到每个顺时针的交点（图形从射线的左边向右穿过）把结果加
         * 1，遇到每个逆时针的交点（图形从射线的右边向左穿过）
         * 把结果减 1，最终把所有的交点都算上，得到的结果如果不是 0，
         * 则认为这个点在图形内部，是要被涂色的区域；如果是 0，则认为
         * 这个点在图形外部，是不被涂色的区域。
         */
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void drawPath1(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        //path 是 graphic类的
        Path path = new Path();
        // 使用 path 对图形进行描述（这段描述代码不必看懂）
        path.addArc(200, 200, 400, 400, -225, 225);
        path.arcTo(400, 200, 600, 400, -180, 225, false);
        path.lineTo(400, 542);
        //绘出心形
        canvas.drawPath(path, paint);
    }

    /**
     * drawArc() 是使用一个椭圆来描述弧形的。left, top, right, bottom 描述的是这个弧形所在的椭圆；startAngle 是弧形的起始角度（x 轴的正向，即正右的方向，是 0 度的位置；顺时针为正角度，逆时针为负角度），
     * sweepAngle 是弧形划过的角度；useCenter 表示是否连接到圆心，如果不连接到圆心，就是弧形，如果连接到圆心，就是扇形
     *
     * @param canvas
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void drawArc(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
        //userCenter 是否链接中心
        canvas.drawArc(200, 100, 800, 500, -110, 100, true, paint);
        canvas.drawArc(200, 100, 800, 500, 20, 140, false, paint);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(200, 100, 800, 500, 180, 60, false, paint);
    }

    //圆角矩形
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void drawRounRect(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawRoundRect(100, 100, 500, 300, 50, 50, paint);
    }

    private void drawlines(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        float[] points = {
                20, 20,
                120, 20,
                70, 20,
                70, 120,
                20, 120,
                120, 120,
                150, 20,
                250, 20,
                150, 20,
                150, 120,
                250, 20,
                250, 120,
                150, 120,
                250, 120};
        canvas.drawLines(points, paint);
    }

    private void drawLine(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        //因为,直线不是封闭图形,所以setStyle对直线无影响
        canvas.drawLine(200, 200, 400, 500, paint);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void drawOval(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawOval(50, 50, 350, 200, paint);
    }

    private void drawPoints(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        float[] points = {0, 0, 50, 50, 50, 100, 100, 50, 100, 100, 150, 50, 150, 100};
        canvas.drawPoints(points, 2, 8, paint);
    }
}
