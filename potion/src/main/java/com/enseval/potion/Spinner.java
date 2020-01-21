package com.enseval.potion;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.util.AttributeSet;
import android.widget.ArrayAdapter;

import androidx.appcompat.widget.AppCompatSpinner;

import java.util.List;

import static com.enseval.potion.PotionTools.DEFAULT_SPINNER_MIN_HEIGHT;
import static com.enseval.potion.PotionTools.DEFAULT_SPINNER_VERTICAL_OFFSET;
import static com.enseval.potion.PotionTools.EDIT_TEXT_COLOR;

public class Spinner extends AppCompatSpinner {

    int dropdownColor;

    public Spinner(Context context) {
        super(context);
        init();
    }

    public Spinner(Context context, int mode) {
        super(context, mode);
        init();
    }

    public Spinner(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
        obtainStyledAttributes(context, attrs, 0);
    }

    public Spinner(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
        obtainStyledAttributes(context, attrs, defStyleAttr);
    }

    public Spinner(Context context, AttributeSet attrs, int defStyleAttr, int mode) {
        super(context, attrs, defStyleAttr, mode);
        init();
        obtainStyledAttributes(context, attrs, defStyleAttr);
    }

    public Spinner(Context context, AttributeSet attrs, int defStyleAttr, int mode, Resources.Theme popupTheme) {
        super(context, attrs, defStyleAttr, mode, popupTheme);
        init();
        obtainStyledAttributes(context, attrs, defStyleAttr);
    }

    private void init() {
        PotionTools u = new PotionTools(getContext());
        this.setDropDownVerticalOffset((int) DEFAULT_SPINNER_VERTICAL_OFFSET);
        this.setMinimumHeight((int) DEFAULT_SPINNER_MIN_HEIGHT);
    }

    private void obtainStyledAttributes(Context context, AttributeSet attrs, int defStyleAttr) {
        if (attrs != null) {
            TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.Spinner, defStyleAttr, 0);
            dropdownColor = typedArray.getColor(R.styleable.Spinner_dropdownColor, EDIT_TEXT_COLOR);
        }
        blankBackground();
    }

    public void setSpinnerData(String[] data){
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), R.layout.spinner_item, data);
        adapter.setDropDownViewResource(R.layout.spinner_item_dropdown);
        this.setAdapter(adapter);
    }

    public void setSpinnerData(List<String> data){
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), R.layout.spinner_item, data);
        adapter.setDropDownViewResource(R.layout.spinner_item_dropdown);
        this.setAdapter(adapter);
    }
    public void blankBackground(){
        this.getBackground().setColorFilter(new PorterDuffColorFilter(dropdownColor,  PorterDuff.Mode.SRC_ATOP));
    }
}
