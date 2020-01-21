package com.enseval.potion;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import static com.enseval.potion.PotionTools.EDIT_TEXT_COLOR;
import static com.enseval.potion.PotionTools.FILL_OUTLINE;
import static com.enseval.potion.PotionTools.TYPE_ROUNDED;
import static com.enseval.potion.PotionTools.WHITE_COLOR;
import static com.enseval.potion.PotionTools.createContainerBackground;

public class Container extends RelativeLayout {

    private int type;
    private int fill;
    private int fillColor;
    private int outlineColor;

    public Container(Context context) {
        super(context);
        init();
    }

    public Container(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
        obtainStyledAttributes(context, attrs, 0);
    }

    public Container(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
        obtainStyledAttributes(context, attrs, defStyleAttr);
    }

    private void init() {
        PotionTools u = new PotionTools(getContext());
    }

    private void obtainStyledAttributes(Context context, AttributeSet attrs, int defStyleAttr) {
        if (attrs != null) {
            TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.Container, defStyleAttr, 0);
            fill = typedArray.getInteger(R.styleable.Container_fill, FILL_OUTLINE);
            type = typedArray.getInteger(R.styleable.Container_type, TYPE_ROUNDED);
            fillColor = typedArray.getColor(R.styleable.Container_fillColor, WHITE_COLOR );
            outlineColor = typedArray.getColor(R.styleable.Container_outlineColor, EDIT_TEXT_COLOR);
        }

        renderContainer();
    }

    private void renderContainer() {
        this.setBackground(createContainerBackground(type, fill, fillColor, outlineColor));
    }

    public void setFillColor(int color){
        fillColor = color;
        renderContainer();
    }

    public void setOutlineColor(int color){
        outlineColor = color;
        renderContainer();
    }
}
