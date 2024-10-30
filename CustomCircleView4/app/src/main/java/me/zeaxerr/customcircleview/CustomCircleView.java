package me.zeaxerr.customcircleview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.animation.ObjectAnimator;
import java.util.Random;

public class CustomCircleView extends View {

    private float radius = 200f;
    private float circleX;
    private float circleY;
    private Paint paint;
    private int color = Color.BLUE;

    public CustomCircleView(Context context) {
        super(context);
        init();
    }

    public CustomCircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(color);
        paint.setStyle(Paint.Style.FILL);

        Random random = new Random();
        int maxWidth = getResources().getDisplayMetrics().widthPixels;
        int maxHeight = getResources().getDisplayMetrics().heightPixels;
        circleX = random.nextInt(maxWidth - (int) radius * 2) + radius;
        circleY = random.nextInt(maxHeight - (int) radius * 2) + radius;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(circleX, circleY, radius, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            color = new Random().nextInt(0xFFFFFF) | 0xFF000000;
            paint.setColor(color);
            invalidate();

            float targetX = event.getX();
            float targetY = event.getY();
            animateCirclePosition(targetX, targetY);

            return true;
        }
        return super.onTouchEvent(event);
    }

    public void animateCircleSize(float newSize) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(this, "radius", this.radius, newSize);
        animator.setDuration(1000);
        animator.start();
    }

    public void animateCirclePosition(float newX, float newY) {
        ObjectAnimator animatorX = ObjectAnimator.ofFloat(this, "circleX", this.circleX, newX);
        ObjectAnimator animatorY = ObjectAnimator.ofFloat(this, "circleY", this.circleY, newY);
        animatorX.setDuration(1000);
        animatorY.setDuration(1000);
        animatorX.start();
        animatorY.start();
    }

    public void setRadius(float radius) {
        this.radius = radius;
        invalidate();
    }

    public void setCircleX(float x) {
        this.circleX = x;
        invalidate();
    }

    public void setCircleY(float y) {
        this.circleY = y;
        invalidate();
    }
}
