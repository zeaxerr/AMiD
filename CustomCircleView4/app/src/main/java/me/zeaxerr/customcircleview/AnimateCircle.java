package me.zeaxerr.customcircleview;

import android.animation.ObjectAnimator;

public class AnimateCircle {

    public void animateCircle() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(this, "radius", 200f, 400f);
        animator.setDuration(1000);
        animator.start();
    }
}
