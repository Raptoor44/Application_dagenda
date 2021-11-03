package com.example.myapplication.tools;

import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;

public class Animation_ {





    public static RotateAnimation RotateAnimation() {
        RotateAnimation anim = new RotateAnimation(0f, 350f, 15f, 15f);
        anim.setInterpolator(new LinearInterpolator());
        anim.setRepeatCount(android.view.animation.Animation.INFINITE);
        anim.setDuration(700);

        return anim;
    }

}
