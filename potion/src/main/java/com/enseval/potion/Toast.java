package com.enseval.potion;

import android.app.Activity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import static com.enseval.potion.PotionTools.DANGER_ALERT_TEXT;
import static com.enseval.potion.PotionTools.DANGER_CLASS;
import static com.enseval.potion.PotionTools.DANGER_COLOR_SOFT;
import static com.enseval.potion.PotionTools.DARK_ALERT_TEXT;
import static com.enseval.potion.PotionTools.DARK_CLASS;
import static com.enseval.potion.PotionTools.DARK_COLOR_SOFT;
import static com.enseval.potion.PotionTools.INFO_ALERT_TEXT;
import static com.enseval.potion.PotionTools.INFO_CLASS;
import static com.enseval.potion.PotionTools.INFO_COLOR_SOFT;
import static com.enseval.potion.PotionTools.LIGHT_ALERT_TEXT;
import static com.enseval.potion.PotionTools.LIGHT_CLASS;
import static com.enseval.potion.PotionTools.LIGHT_COLOR_SOFT;
import static com.enseval.potion.PotionTools.PRIMARY_ALERT_TEXT;
import static com.enseval.potion.PotionTools.PRIMARY_COLOR_SOFT;
import static com.enseval.potion.PotionTools.SECONDARY_ALERT_TEXT;
import static com.enseval.potion.PotionTools.SECONDARY_CLASS;
import static com.enseval.potion.PotionTools.SECONDARY_COLOR_SOFT;
import static com.enseval.potion.PotionTools.SUCCESS_ALERT_TEXT;
import static com.enseval.potion.PotionTools.SUCCESS_CLASS;
import static com.enseval.potion.PotionTools.SUCCESS_COLOR_SOFT;
import static com.enseval.potion.PotionTools.WARNING_ALERT_TEXT;
import static com.enseval.potion.PotionTools.WARNING_CLASS;
import static com.enseval.potion.PotionTools.WARNING_COLOR_SOFT;

public class Toast extends android.widget.Toast {

    private static final int X_OFFSET = 0;
    private static final int Y_OFFSET = 100;

    private static Toast toast;

    private Container background;
    private TextView tvText;

    public Toast(Activity activity, CharSequence text, int duration) {
        super(activity);

        LayoutInflater inflater = activity.getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast, (ViewGroup) activity.findViewById(R.id.custom_toast_view_root));
        background = layout.findViewById(R.id.toast_background);
        background.setFillColor(PRIMARY_COLOR_SOFT);
        tvText = layout.findViewById(R.id.toast_text);
        tvText.setText(text);
        tvText.setTextColor(PRIMARY_ALERT_TEXT);
        this.setGravity(Gravity.BOTTOM, X_OFFSET, Y_OFFSET);
        this.setDuration(duration);
        this.setView(layout);
    }

    public static Toast makeText(Activity activity, CharSequence text, int duration) {
        toast = new Toast(activity, text, duration);
        return toast;
    }

    public android.widget.Toast setType(int type) {
        int backgroundColor;
        int textColor;
        switch (type) {
            case SECONDARY_CLASS:
                backgroundColor = SECONDARY_COLOR_SOFT;
                textColor = SECONDARY_ALERT_TEXT;
                break;
            case SUCCESS_CLASS:
                backgroundColor = SUCCESS_COLOR_SOFT;
                textColor = SUCCESS_ALERT_TEXT;
                break;
            case DANGER_CLASS:
                backgroundColor = DANGER_COLOR_SOFT;
                textColor = DANGER_ALERT_TEXT;
                break;
            case WARNING_CLASS:
                backgroundColor = WARNING_COLOR_SOFT;
                textColor = WARNING_ALERT_TEXT;
                break;
            case INFO_CLASS:
                backgroundColor = INFO_COLOR_SOFT;
                textColor = INFO_ALERT_TEXT;
                break;
            case LIGHT_CLASS:
                backgroundColor = LIGHT_COLOR_SOFT;
                textColor = LIGHT_ALERT_TEXT;
                break;
            case DARK_CLASS:
                backgroundColor = DARK_COLOR_SOFT;
                textColor = DARK_ALERT_TEXT;
                break;
            default:
                backgroundColor = PRIMARY_COLOR_SOFT;
                textColor = PRIMARY_ALERT_TEXT;
                break;
        }

        background.setFillColor(backgroundColor);
        tvText.setTextColor(textColor);
        return toast;
    }
}
