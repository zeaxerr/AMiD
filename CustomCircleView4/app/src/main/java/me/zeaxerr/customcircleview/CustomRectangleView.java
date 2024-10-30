package me.zeaxerr.customcircleview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.animation.ObjectAnimator;
import android.animation.ArgbEvaluator;

public class CustomRectangleView extends View {

    private float rectWidth = 300f;
    private float rectHeight = 200f;
    private Paint paint;
    private int color = Color.RED;

    public CustomRectangleView(Context context) {
        super(context);
        init();
    }

    public CustomRectangleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(color);
        paint.setStyle(Paint.Style.FILL);
    }

    public void setRectWidth(float width) {
        this.rectWidth = width;
        invalidate();
    }

    public float getRectWidth() {
        return rectWidth;
    }

    public void setRectHeight(float height) {
        this.rectHeight = height;
        invalidate();
    }

    public float getRectHeight() {
        return rectHeight;
    }

    public void setColor(int color) {
        this.color = color;
        paint.setColor(color);
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(100, 100, 100 + rectWidth, 100 + rectHeight, paint);
    }

    public void animateRectangleSize(float newWidth, float newHeight) {
        ObjectAnimator widthAnimator = ObjectAnimator.ofFloat(this, "rectWidth", this.rectWidth, newWidth);
        ObjectAnimator heightAnimator = ObjectAnimator.ofFloat(this, "rectHeight", this.rectHeight, newHeight);
        widthAnimator.setDuration(1000);
        heightAnimator.setDuration(1000);
        widthAnimator.start();
        heightAnimator.start();
    }

    public void animateRectangleColor() {
        ObjectAnimator colorAnimator = ObjectAnimator.ofObject(this, "color", new ArgbEvaluator(), color, color == Color.RED ? Color.YELLOW : Color.RED);
        colorAnimator.setDuration(1000);
        colorAnimator.start();
    }
}
