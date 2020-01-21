package com.enseval.potion;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatToggleButton;

import static com.enseval.potion.PotionTools.TRANSPARENT_COLOR;
import static com.enseval.potion.PotionTools.getToggleButtonDrawable;

public class ToggleButton extends AppCompatToggleButton {

    private static PotionTools u;

    public ToggleButton(Context context) {
        super(context);
        init();
    }

    public ToggleButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ToggleButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        u = new PotionTools(getContext());
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/didact_gothic_regular.ttf");
        this.setTypeface(tf);
        this.setBackgroundColor(TRANSPARENT_COLOR);
        this.setButtonDrawable(getToggleButtonDrawable());
    }
}
