package com.enseval.potion;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import static com.enseval.potion.PotionTools.CLEAR_TEXT_MODE;
import static com.enseval.potion.PotionTools.DANGER_COLOR;
import static com.enseval.potion.PotionTools.DEFAULT_NONE;
import static com.enseval.potion.PotionTools.DEFAULT_TEXT_SIZE;
import static com.enseval.potion.PotionTools.DISABLE_COLOR;
import static com.enseval.potion.PotionTools.EDIT_TEXT_COLOR;
import static com.enseval.potion.PotionTools.FILL_OUTLINE;
import static com.enseval.potion.PotionTools.GRAVITY_CENTER_VERTICAL;
import static com.enseval.potion.PotionTools.GRAVITY_LEFT;
import static com.enseval.potion.PotionTools.HINT_EDIT_TEXT_COLOR;
import static com.enseval.potion.PotionTools.INPUT_TEXT;
import static com.enseval.potion.PotionTools.PASSWORD_MODE;
import static com.enseval.potion.PotionTools.TEXT_COLOR;
import static com.enseval.potion.PotionTools.TRANSPARENT_COLOR;
import static com.enseval.potion.PotionTools.TYPE_ROUNDED;
import static com.enseval.potion.PotionTools.WRAP_CONTENT;
import static com.enseval.potion.PotionTools.getDarkerColor;
import static com.enseval.potion.PotionTools.getDrawable;
import static com.enseval.potion.PotionTools.recolorIcon;

public class EditText extends LinearLayout {

    private TextView tvPrefix;
    private TextView tvSuffix;
    private TextView tvLabel;
    private TextView tvError;
    private android.widget.EditText editText;
    private ImageView ivDrawableLeft;
    private ImageView ivDrawableRight;
    private RelativeLayout layout;

    private Drawable drawableLeft;
    private Drawable drawableRight;
    private int textColor;
    private float textSize;
    private int prefixTextColor;
    private int suffixTextColor;
    private int layoutColor;
    private int layoutOutlineFillColor;
    private int inputType;
    private int layoutType;
    private int layoutFill;
    private int endIconMode;
    private int drawableLeftColor;
    private int drawableRightColor;
    private int gravity;
    private int labelColor;
    private int textHintColor;
    private boolean singleLine;
    private boolean enabled;
    private float height;
    private float labelSize;
    private String prefix;
    private String suffix;
    private String text;
    private String hint;
    private String label;

    public EditText(Context context) {
        super(context);
    }

    public EditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
        obtainStyledAttributes(context, attrs, 0);
    }

    public EditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
        obtainStyledAttributes(context, attrs, defStyleAttr);
    }

    private void init() {
        PotionTools u = new PotionTools(getContext());
        inflate(getContext(), R.layout.edit_text, this);
        layout = findViewById(R.id.edit_text_layout);
        ivDrawableLeft = findViewById(R.id.drawable_left);
        ivDrawableRight = findViewById(R.id.drawable_right);
        tvPrefix = findViewById(R.id.text_prefix);
        tvSuffix = findViewById(R.id.text_suffix);
        editText = findViewById(R.id.edit_text);
        tvLabel = findViewById(R.id.label);
        tvError = findViewById(R.id.error);
    }

    private void obtainStyledAttributes(Context context, AttributeSet attrs, int defStyleAttr) {
        if (attrs != null) {
            TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.EditText, defStyleAttr, 0);
            drawableLeft = typedArray.getDrawable(R.styleable.EditText_drawableLeft);
            prefix = typedArray.getString(R.styleable.EditText_prefix);
            suffix = typedArray.getString(R.styleable.EditText_suffix);
            label = typedArray.getString(R.styleable.EditText_label);
            text = typedArray.getString(R.styleable.EditText_text);
            hint = typedArray.getString(R.styleable.EditText_hint);
            textSize = typedArray.getDimension(R.styleable.EditText_textSize, DEFAULT_TEXT_SIZE);
            labelSize = typedArray.getDimension(R.styleable.EditText_labelSize, DEFAULT_TEXT_SIZE);
            labelColor = typedArray.getInteger(R.styleable.EditText_labelColor, EDIT_TEXT_COLOR);
            textColor = typedArray.getInteger(R.styleable.EditText_textColor, TEXT_COLOR);
            textHintColor = typedArray.getInteger(R.styleable.EditText_hintTextColor, HINT_EDIT_TEXT_COLOR);
            layoutColor = typedArray.getInteger(R.styleable.EditText_layoutColor, EDIT_TEXT_COLOR);
            layoutOutlineFillColor = typedArray.getInteger(R.styleable.EditText_layoutOutlineFillColor, TRANSPARENT_COLOR);
            prefixTextColor = typedArray.getInteger(R.styleable.EditText_prefixTextColor, HINT_EDIT_TEXT_COLOR);
            suffixTextColor = typedArray.getInteger(R.styleable.EditText_suffixTextColor, HINT_EDIT_TEXT_COLOR);
            inputType = typedArray.getInteger(R.styleable.EditText_inputType, INPUT_TEXT);
            singleLine = typedArray.getBoolean(R.styleable.EditText_singleLine, false);
            enabled = typedArray.getBoolean(R.styleable.EditText_enabled, true);
            layoutType = typedArray.getInteger(R.styleable.EditText_layoutType, TYPE_ROUNDED);
            layoutFill = typedArray.getInteger(R.styleable.EditText_layoutFill, FILL_OUTLINE);
            endIconMode = typedArray.getInteger(R.styleable.EditText_endIconMode, DEFAULT_NONE);
            drawableLeftColor = typedArray.getInteger(R.styleable.EditText_drawableLeftColor, layoutColor);
            drawableRightColor = typedArray.getInteger(R.styleable.EditText_drawableRightColor, layoutColor);
            gravity = typedArray.getInteger(R.styleable.EditText_gravity, GRAVITY_LEFT | GRAVITY_CENTER_VERTICAL);
            height = typedArray.getDimension(R.styleable.EditText_layoutHeight, WRAP_CONTENT);
        }

        renderEditText();
    }

    private void renderEditText() {
        /* Set Text Font */
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/didact_gothic_regular.ttf");
        editText.setTypeface(tf);

        /* Set Edit Text Height */
        setMinHeight((int) height);

        /* Set & Display Drawable Left */
        setDrawableLeft(drawableLeft);

        /* Set & Display Prefix */
        setPrefix(prefix);
        setPrefixTextColor(prefixTextColor);

        /* Set & Display Suffix */
        setSuffix(suffix);
        setSuffixTextColor(suffixTextColor);

        /* Set Hint Value */
        setHintText(hint);

        /* Set Text Value */
        setText(text);

        /* Set Text Size */
        setTextSize(textSize);

        /* Set Text Color */
        setTextColor(textColor);

        /* Set Text Hint Color */
        setHintTextColor(textHintColor);

        /* Set Input Type */
        setInputType(inputType);

        /* Set layout */
        layout.setBackground(getDrawable(layoutType, layoutFill, layoutColor, layoutOutlineFillColor));

        /* Set End Icon */
        if (endIconMode != DEFAULT_NONE) {
            setEndIcon();
        }

        /* Set Gravity */
        setLayoutGravity(gravity);

        /* Set Input Type */
        setInputType(inputType);

        /* Set Label */
        if (label != null) {
            setLabel(label);
            setLabelSize(labelSize);
            setLabelColor(labelColor);
            setLabelVisibility(VISIBLE);
        }

        /* Set SingleLine */
        setSingleLine(singleLine);

        /* Set Enabled */
        setEnabled(enabled);
    }

    private void setEndIcon() {
        OnClickListener clickListener = null;
        switch (endIconMode) {
            case PASSWORD_MODE:
                drawableRight = getResources().getDrawable(R.drawable.fa_regular_eye);
                editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                clickListener = new OnClickListener() {
                    boolean show = false;

                    @Override
                    public void onClick(View view) {
                        if (!enabled) {
                            ivDrawableRight.setImageDrawable(recolorIcon(drawableRight, getDarkerColor(DISABLE_COLOR)));
                            return;
                        }
                        drawableRight = show ? getResources().getDrawable(R.drawable.fa_regular_eye_slash) : getResources().getDrawable(R.drawable.fa_regular_eye);
                        ivDrawableRight.setImageDrawable(recolorIcon(drawableRight, drawableRightColor));
                        editText.setTransformationMethod(show ? HideReturnsTransformationMethod.getInstance() : PasswordTransformationMethod.getInstance());
                        editText.setSelection(editText.getText().length());
                        show = !show;
                    }
                };
                ivDrawableRight.setVisibility(VISIBLE);
                break;
            case CLEAR_TEXT_MODE:
                drawableRight = getResources().getDrawable(R.drawable.fa_regular_times_circle);
                ivDrawableRight.setVisibility(GONE);
                editText.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void afterTextChanged(Editable editable) {
                        ivDrawableRight.setVisibility(editable.toString().isEmpty() ? GONE : VISIBLE);
                    }
                });
                clickListener = new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        editText.setText("");
                    }
                };
                break;
            default:
                ivDrawableRight.setVisibility(GONE);
                break;
        }
        ivDrawableRight.setImageDrawable(recolorIcon(drawableRight, drawableRightColor));
        ivDrawableRight.setOnClickListener(clickListener);
    }

    public void setError(String message) {
        if (message != null) {
            layout.setBackground(getDrawable(layoutType, layoutFill, DANGER_COLOR, layoutOutlineFillColor));
            tvError.setText(message);
            tvError.setVisibility(VISIBLE);
        } else {
            layout.setBackground(getDrawable(layoutType, layoutFill, layoutColor, layoutOutlineFillColor));
            tvError.setText("");
            tvError.setVisibility(GONE);
        }

    }

    public void addTextChangedListener(TextWatcher watcher) {
        editText.addTextChangedListener(watcher);
    }

    public void setDrawableLeft(Drawable drawableLeft) {
        if (drawableLeft != null) {
            ivDrawableLeft.setImageDrawable(recolorIcon(drawableLeft, drawableLeftColor));
            ivDrawableLeft.setVisibility(VISIBLE);
        }
    }

    public void setLayoutType(int layoutType) {
        layout.setBackground(getDrawable(layoutType, layoutFill, layoutColor, layoutOutlineFillColor));
    }

    public void setLayoutFill(int layoutFill) {
        layout.setBackground(getDrawable(layoutType, layoutFill, layoutColor, layoutOutlineFillColor));
    }

    public void setLayoutColor(int layoutColor) {
        layout.setBackground(getDrawable(layoutType, layoutFill, layoutColor, layoutOutlineFillColor));
    }

    public void setLayoutOutlineFillColor(int layoutOutlineFillColor) {
        layout.setBackground(getDrawable(layoutType, layoutFill, layoutColor, layoutOutlineFillColor));
    }

    public void setLayoutGravity(int gravity) {
        editText.setGravity(gravity);
    }

    public void setEndIconMode(int endIconMode) {
        this.endIconMode = endIconMode;
        setEndIcon();
    }

    public void setSingleLine(boolean singleLine) {
        editText.setSingleLine(singleLine);
    }

    public void setEnabled(boolean enabled) {
        if (!enabled) {
            setError(null);
            editText.setInputType(InputType.TYPE_NULL);
            editText.setFocusable(false);
            layout.setBackground(getDrawable(layoutType, layoutFill, DISABLE_COLOR));
            if (drawableLeft != null) {
                ivDrawableLeft.setImageDrawable(recolorIcon(drawableLeft, getDarkerColor(DISABLE_COLOR)));
                ivDrawableLeft.setVisibility(VISIBLE);
            }
            ivDrawableRight.setVisibility(GONE);
            tvLabel.setTextColor(DISABLE_COLOR);
            editText.setTextColor(getDarkerColor(DISABLE_COLOR));
        }
    }

    public void setFocusable(boolean focusable) {
        editText.setFocusable(focusable);
    }

    public void setSelection(int index) {
        editText.setSelection(index);
    }

    public void setSelection(int start, int stop) {
        editText.setSelection(start, stop);
    }

    public void setInputType(int type) {
        editText.setInputType(type);
    }

    public void setTextColor(int color) {
        editText.setTextColor(color);
    }

    public void setText(String text) {
        editText.setText(text);
    }

    public void setHintText(String hint) {
        editText.setHint(hint);
    }

    public void setHintTextColor(int color) {
        editText.setHintTextColor(color);
    }

    public void setLabel(String label) {
        tvLabel.setText(label);
    }

    public void setLabelColor(int color) {
        tvLabel.setTextColor(color);
    }

    public void setLabelVisibility(int visibility) {
        tvLabel.setVisibility(visibility);
    }

    public void setLabelSize(float labelSize) {
        tvLabel.setTextSize(TypedValue.COMPLEX_UNIT_PX, labelSize);
    }

    public void setTextSize(float textSize) {
        editText.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
    }

    public void setPrefix(String prefix) {
        tvPrefix.setText(prefix);
        tvPrefix.setVisibility(VISIBLE);
    }

    public void setSuffix(String suffix) {
        tvSuffix.setText(suffix);
        tvSuffix.setVisibility(VISIBLE);
    }

    public void setPrefixTextColor(int color) {
        tvPrefix.setTextColor(color);
    }

    public void setSuffixTextColor(int color) {
        tvSuffix.setTextColor(color);
    }

    public void setMinHeight(int minHeight) {
        editText.setMinimumHeight((int) (minHeight * getResources().getDisplayMetrics().density));
        editText.setMinHeight((int) (minHeight * getResources().getDisplayMetrics().density));
    }
}
