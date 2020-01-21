package com.enseval.potion;

import android.content.Context;
import android.graphics.drawable.Animatable2;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;

import androidx.core.content.ContextCompat;

public class ProgressBar extends android.widget.ProgressBar {

    private PotionTools u;

    public ProgressBar(Context context) {
        super(context);
        init();
    }

    public ProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        u = new PotionTools(getContext());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            this.setIndeterminateDrawable(ContextCompat.getDrawable(getContext(), R.drawable.enseval_loading));
            ((Animatable2) this.getIndeterminateDrawable()).registerAnimationCallback(new Animatable2.AnimationCallback() {
                @Override
                public void onAnimationEnd(Drawable drawable) {
                    super.onAnimationEnd(drawable);
                    ((Animatable2) drawable).start();
                }
            });
        } else {
            this.setIndeterminateDrawable(getResources().getDrawable(R.drawable.anim));
            ((AnimationDrawable) this.getIndeterminateDrawable()).start();
        }
    }
}
