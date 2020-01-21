package com.enseval.potion;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.TypedValue;

import androidx.appcompat.widget.AppCompatTextView;

import static com.enseval.potion.PotionTools.DEFAULT_DIDACT;
import static com.enseval.potion.PotionTools.TEXT_BODY1;
import static com.enseval.potion.PotionTools.TEXT_BODY2;
import static com.enseval.potion.PotionTools.TEXT_CAPTION;
import static com.enseval.potion.PotionTools.TEXT_COLOR;
import static com.enseval.potion.PotionTools.TEXT_H1;
import static com.enseval.potion.PotionTools.TEXT_H2;
import static com.enseval.potion.PotionTools.TEXT_H3;
import static com.enseval.potion.PotionTools.TEXT_H4;
import static com.enseval.potion.PotionTools.TEXT_H5;
import static com.enseval.potion.PotionTools.TEXT_H6;
import static com.enseval.potion.PotionTools.TEXT_SUBTITLE1;
import static com.enseval.potion.PotionTools.TEXT_SUBTITLE2;

public class TextView extends AppCompatTextView {

    private int textClass;
    private int textColor;
    private int textStyle;
    private int fontFamily;
    private float textSize;

    private int defaultTextColor;
    private int defaultTextStyle;
    private float defaultTextSize;

    public TextView(Context context) {
        super(context);
    }

    public TextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
        obtainStyledAttributes(context, attrs, 0);
    }

    public TextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
        obtainStyledAttributes(context, attrs, defStyleAttr);
    }

    private void init() {
        PotionTools u = new PotionTools(getContext());
    }

    private void obtainStyledAttributes(Context context, AttributeSet attrs, int defStyleAttr) {
        if (attrs != null) {
            TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.TextView, defStyleAttr, 0);
            textClass = typedArray.getInteger(R.styleable.TextView_textClass, TEXT_BODY2);
            getDefaultValue();
            fontFamily = typedArray.getInteger(R.styleable.TextView_textFont, DEFAULT_DIDACT);
            textColor = typedArray.getInteger(R.styleable.TextView_textColor, defaultTextColor);
            textStyle = typedArray.getInteger(R.styleable.TextView_textStyle, defaultTextStyle);
            textSize = typedArray.getDimension(R.styleable.TextView_textSize, defaultTextSize);
        }

        renderTextView();
    }

    private void getDefaultValue() {
        defaultTextColor = TEXT_COLOR;
        defaultTextStyle = Typeface.NORMAL;
        switch (textClass) {
            case TEXT_H1:
                defaultTextSize = getResources().getDimension(R.dimen.text_size_h1);
                break;
            case TEXT_H2:
                defaultTextSize = getResources().getDimension(R.dimen.text_size_h2);
                break;
            case TEXT_H3:
                defaultTextSize = getResources().getDimension(R.dimen.text_size_h3);
                break;
            case TEXT_H4:
                defaultTextSize = getResources().getDimension(R.dimen.text_size_h4);
                break;
            case TEXT_H5:
                defaultTextSize = getResources().getDimension(R.dimen.text_size_h5);
                break;
            case TEXT_H6:
                defaultTextSize = getResources().getDimension(R.dimen.text_size_h6);
                defaultTextStyle = Typeface.BOLD;
                break;
            case TEXT_SUBTITLE1:
                defaultTextSize = getResources().getDimension(R.dimen.text_size_subtitle1);
                break;
            case TEXT_SUBTITLE2:
                defaultTextSize = getResources().getDimension(R.dimen.text_size_subtitle2);
                defaultTextStyle = Typeface.BOLD;
                break;
            case TEXT_BODY1:
                defaultTextSize = getResources().getDimension(R.dimen.text_size_body1);
                break;
            case TEXT_BODY2:
                defaultTextSize = getResources().getDimension(R.dimen.text_size_body2);
                break;
            case TEXT_CAPTION:
                defaultTextSize = getResources().getDimension(R.dimen.text_size_caption);
                break;
            default:
                defaultTextSize = getResources().getDimension(R.dimen.text_size_default);
                break;
        }
    }

    private void renderTextView() {
        /* Set Text Font */
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), fontFamily == DEFAULT_DIDACT ? "fonts/didact_gothic_regular.ttf" : "fonts/montserrat_regular.ttf");
        this.setTypeface(tf);

        /* Set Text Size */
        this.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);

        /* Set Text Style */
        this.setTypeface(getTypeface(), textStyle);

        /* Set Text Color */
        this.setTextColor(textColor);
    }
}
