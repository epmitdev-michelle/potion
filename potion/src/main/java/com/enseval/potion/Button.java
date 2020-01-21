package com.enseval.potion;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Gravity;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

import static android.view.ViewOutlineProvider.BOUNDS;
import static com.enseval.potion.PotionTools.BLACK_COLOR;
import static com.enseval.potion.PotionTools.BUTTON_ELEVATED;
import static com.enseval.potion.PotionTools.BUTTON_FLAT;
import static com.enseval.potion.PotionTools.DANGER_CLASS;
import static com.enseval.potion.PotionTools.DANGER_COLOR;
import static com.enseval.potion.PotionTools.DARK_CLASS;
import static com.enseval.potion.PotionTools.DARK_COLOR;
import static com.enseval.potion.PotionTools.DEFAULT_DIDACT;
import static com.enseval.potion.PotionTools.FILL_OUTLINE;
import static com.enseval.potion.PotionTools.FILL_SOLID;
import static com.enseval.potion.PotionTools.INFO_CLASS;
import static com.enseval.potion.PotionTools.INFO_COLOR;
import static com.enseval.potion.PotionTools.LIGHT_CLASS;
import static com.enseval.potion.PotionTools.LIGHT_COLOR;
import static com.enseval.potion.PotionTools.LINK_CLASS;
import static com.enseval.potion.PotionTools.PRIMARY_CLASS;
import static com.enseval.potion.PotionTools.PRIMARY_COLOR;
import static com.enseval.potion.PotionTools.SECONDARY_CLASS;
import static com.enseval.potion.PotionTools.SECONDARY_COLOR;
import static com.enseval.potion.PotionTools.SUCCESS_CLASS;
import static com.enseval.potion.PotionTools.SUCCESS_COLOR;
import static com.enseval.potion.PotionTools.TYPE_ROUNDED;
import static com.enseval.potion.PotionTools.WARNING_CLASS;
import static com.enseval.potion.PotionTools.WARNING_COLOR;
import static com.enseval.potion.PotionTools.WHITE_COLOR;
import static com.enseval.potion.PotionTools.getDrawable;

public class Button extends AppCompatTextView {

    private int buttonClass;
    private int buttonType;
    private int buttonFill;
    private int buttonShadow;
    private int backgroundColor;
    private int fontFamily;
    private int textColor;

    private int defaultColor;
    private int defaultTextColor;

    public Button(Context context) {
        super(context);
    }

    public Button(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
        obtainStyledAttributes(context, attrs, 0);
    }

    public Button(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
        obtainStyledAttributes(context, attrs, defStyleAttr);
    }

    private void init() {
        PotionTools u = new PotionTools(getContext());
    }

    private void obtainStyledAttributes(Context context, AttributeSet attrs, int defStyleAttr) {
        if (attrs != null) {
            TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.Button, defStyleAttr, 0);
            buttonClass = typedArray.getInteger(R.styleable.Button_buttonClass, PRIMARY_CLASS);
            buttonFill = typedArray.getInteger(R.styleable.Button_buttonFill, FILL_SOLID);
            getDefaultColor();
            fontFamily = typedArray.getInteger(R.styleable.Button_buttonFont, DEFAULT_DIDACT);
            buttonType = typedArray.getInteger(R.styleable.Button_buttonType, TYPE_ROUNDED);
            buttonShadow = typedArray.getInteger(R.styleable.Button_buttonShadow, BUTTON_FLAT);
            backgroundColor = typedArray.getColor(R.styleable.Button_backgroundColor, defaultColor);
            textColor = typedArray.getColor(R.styleable.Button_textColor, defaultTextColor);
        }

        renderButton();
    }


    private void getDefaultColor() {
        switch (buttonClass) {
            case PRIMARY_CLASS:
                defaultColor = PRIMARY_COLOR;
                defaultTextColor = buttonFill == FILL_OUTLINE ? PRIMARY_COLOR : WHITE_COLOR;
                break;
            case SECONDARY_CLASS:
                defaultColor = SECONDARY_COLOR;
                defaultTextColor = buttonFill == FILL_OUTLINE ? SECONDARY_COLOR : WHITE_COLOR;
                break;
            case SUCCESS_CLASS:
                defaultColor = SUCCESS_COLOR;
                defaultTextColor = buttonFill == FILL_OUTLINE ? SUCCESS_COLOR : WHITE_COLOR;
                break;
            case DANGER_CLASS:
                defaultColor = DANGER_COLOR;
                defaultTextColor = buttonFill == FILL_OUTLINE ? DANGER_COLOR : WHITE_COLOR;
                break;
            case WARNING_CLASS:
                defaultColor = WARNING_COLOR;
                defaultTextColor = buttonFill == FILL_OUTLINE ? WARNING_COLOR : WHITE_COLOR;
                break;
            case INFO_CLASS:
                defaultColor = INFO_COLOR;
                defaultTextColor = buttonFill == FILL_OUTLINE ? INFO_COLOR : WHITE_COLOR;
                break;
            case LIGHT_CLASS:
                defaultColor = LIGHT_COLOR;
                defaultTextColor = BLACK_COLOR;
                break;
            case DARK_CLASS:
                defaultColor = DARK_COLOR;
                defaultTextColor = buttonFill == FILL_OUTLINE ? DARK_COLOR : WHITE_COLOR;
                break;
            case LINK_CLASS:
                defaultColor = WHITE_COLOR;
                defaultTextColor = PRIMARY_COLOR;
                break;
            default:
                defaultColor = getResources().getColor(R.color.colorPrimary);
                defaultTextColor = buttonFill == FILL_OUTLINE ? getResources().getColor(R.color.colorPrimary) : WHITE_COLOR;
                break;
        }
    }

    private void renderButton() {
        /* Set Padding */
        this.setPadding(getResources().getDimensionPixelSize(R.dimen.btn_padding_lr),
                getResources().getDimensionPixelSize(R.dimen.btn_padding_tb),
                getResources().getDimensionPixelSize(R.dimen.btn_padding_lr),
                getResources().getDimensionPixelSize(R.dimen.btn_padding_tb));

        /* Set Gravity */
        this.setGravity(Gravity.CENTER);

        /* Set Clickable */
        this.setClickable(true);

        /* Set Text Not All Caps */
        this.setAllCaps(false);

        /* Set Text Font */
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(),  fontFamily == DEFAULT_DIDACT ? "fonts/didact_gothic_regular.ttf" : "fonts/montserrat_regular.ttf");
        this.setTypeface(tf);

        /* Create Background */
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            this.setBackground(getDrawable(buttonType, buttonFill, backgroundColor));
        } else {
            this.setBackgroundDrawable(getDrawable(buttonType, buttonFill, backgroundColor));
        }

        /* Set Text Color */
        this.setTextColor(textColor);

        /* Set Drawable Color */
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            this.setCompoundDrawableTintList(ColorStateList.valueOf(textColor));
        }

        /* Set Elevation for API > 21 */
        if (buttonShadow == BUTTON_ELEVATED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                this.setOutlineProvider(BOUNDS);
                this.setElevation(getResources().getDimension(R.dimen.btn_elevation));
                this.setTranslationZ(getResources().getDimension(R.dimen.btn_elevation));
                this.setStateListAnimator(null);
            }
        }
    }

    public void setButtonClass(int buttonClass) {
        this.buttonClass = buttonClass;
        getDefaultColor();
        this.setBackground(getDrawable(buttonType, buttonFill, backgroundColor));
    }

    public void setButtonFill(int buttonFill) {
        this.setBackground(getDrawable(buttonType, buttonFill, backgroundColor));
    }

    public void setButtonShadow(int buttonShadow) {
        if (buttonShadow == BUTTON_ELEVATED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                this.setOutlineProvider(BOUNDS);
                this.setElevation(getResources().getDimension(R.dimen.btn_elevation));
                this.setTranslationZ(getResources().getDimension(R.dimen.btn_elevation));
                this.setStateListAnimator(null);
            }
        }
    }

    public void setButtonType(int buttonType) {
        this.setBackground(getDrawable(buttonType, buttonFill, backgroundColor));
    }
}
