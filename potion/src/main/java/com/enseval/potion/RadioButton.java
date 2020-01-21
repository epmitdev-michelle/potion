package com.enseval.potion;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatRadioButton;

import static com.enseval.potion.PotionTools.getRadioButtonDrawable;

public class RadioButton extends AppCompatRadioButton {

    public RadioButton(Context context) {
        super(context);
        init();
    }

    public RadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        PotionTools u = new PotionTools(getContext());
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/didact_gothic_regular.ttf");
        this.setTypeface(tf);
        this.setButtonDrawable(getRadioButtonDrawable());
    }
}
