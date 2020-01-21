package com.enseval.potion;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatCheckBox;

import static com.enseval.potion.PotionTools.getCheckboxDrawable;

public class CheckBox extends AppCompatCheckBox {

    public CheckBox(Context context) {
        super(context);
        init();
    }

    public CheckBox(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CheckBox(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();

    }

    private void init(){
        PotionTools u = new PotionTools(getContext());
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/didact_gothic_regular.ttf");
        this.setTypeface(tf);
        this.setButtonDrawable(getCheckboxDrawable());
    }
}
