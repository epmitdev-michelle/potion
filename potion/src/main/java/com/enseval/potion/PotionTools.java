package com.enseval.potion;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.StateSet;

import androidx.core.graphics.drawable.DrawableCompat;

public class PotionTools {

    public static final float DARK_COLOR_FACTOR = 0.8f;

    public static final int PRIMARY_CLASS = 0;
    public static final int SECONDARY_CLASS = 1;
    public static final int SUCCESS_CLASS = 2;
    public static final int DANGER_CLASS = 3;
    public static final int WARNING_CLASS = 4;
    public static final int INFO_CLASS = 5;
    public static final int LIGHT_CLASS = 6;
    public static final int DARK_CLASS = 7;
    public static final int LINK_CLASS = 8;

    public static int PRIMARY_COLOR;
    public static int SECONDARY_COLOR;
    public static int SUCCESS_COLOR;
    public static int DANGER_COLOR;
    public static int WARNING_COLOR;
    public static int INFO_COLOR;
    public static int LIGHT_COLOR;
    public static int DARK_COLOR;
    public static int DEFAULT_COLOR;
    public static int DISABLE_COLOR;

    public static int PRIMARY_COLOR_SOFT;
    public static int SECONDARY_COLOR_SOFT;
    public static int SUCCESS_COLOR_SOFT;
    public static int DANGER_COLOR_SOFT;
    public static int WARNING_COLOR_SOFT;
    public static int INFO_COLOR_SOFT;
    public static int LIGHT_COLOR_SOFT;
    public static int DARK_COLOR_SOFT;

    public static int PRIMARY_ALERT_TEXT;
    public static int SECONDARY_ALERT_TEXT;
    public static int SUCCESS_ALERT_TEXT;
    public static int DANGER_ALERT_TEXT;
    public static int WARNING_ALERT_TEXT;
    public static int INFO_ALERT_TEXT;
    public static int LIGHT_ALERT_TEXT;
    public static int DARK_ALERT_TEXT;

    public static int BLACK_COLOR;
    public static int WHITE_COLOR;
    public static int TEXT_COLOR;
    public static int EDIT_TEXT_COLOR;
    public static int HINT_EDIT_TEXT_COLOR;
    public static int TRANSPARENT_COLOR;

    public static int TYPE_ROUNDED = 0;
    public static int TYPE_PILL = 1;
    public static int TYPE_SQUARE = 2;
    public static int FILL_SOLID = 0;
    public static int FILL_OUTLINE = 1;
    public static int BUTTON_ELEVATED = 0;
    public static int BUTTON_FLAT = 1;

    public static float BUTTON_ROUNDED_CORNER_RADIUS;
    public static float BUTTON_PILL_CORNER_RADIUS;
    public static float DEFAULT_TEXT_SIZE;
    public static float DEFAULT_SPINNER_VERTICAL_OFFSET;
    public static float DEFAULT_SPINNER_MIN_HEIGHT;
    public static int BUTTON_STROKE_WEIGHT;

    public static Drawable CHECKBOX_TRUE;
    public static Drawable CHECKBOX_FALSE;
    public static Drawable RADIO_BUTTON_TRUE;
    public static Drawable RADIO_BUTTON_FALSE;
    public static Drawable TOGGLE_TRUE;
    public static Drawable TOGGLE_FALSE;

    public static final int TEXT_H1 = 0;
    public static final int TEXT_H2 = 1;
    public static final int TEXT_H3 = 2;
    public static final int TEXT_H4 = 3;
    public static final int TEXT_H5 = 4;
    public static final int TEXT_H6 = 5;
    public static final int TEXT_SUBTITLE1 = 6;
    public static final int TEXT_SUBTITLE2 = 7;
    public static final int TEXT_BODY1 = 8;
    public static final int TEXT_BODY2 = 9;
    public static final int TEXT_CAPTION = 10;

    public static final int DEFAULT_NONE = -1;
    public static final int PASSWORD_MODE = 0;
    public static final int CLEAR_TEXT_MODE = 1;

    /* DEFAULT VALUE */
    public static final int DEFAULT_DIDACT = 0;
    public static final int INPUT_TEXT = 0x00000001;
    public static final int GRAVITY_LEFT = 0x03;
    public static final int GRAVITY_CENTER_VERTICAL = 0x10;
    public static final float WRAP_CONTENT = -2;

    Context context;

    public PotionTools(Context context) {
        this.context = context;
        PRIMARY_COLOR = context.getResources().getColor(R.color.colorEpmPrimary);
        SECONDARY_COLOR = context.getResources().getColor(R.color.colorEpmSecondary);
        SUCCESS_COLOR = context.getResources().getColor(R.color.colorEpmSuccess);
        DANGER_COLOR = context.getResources().getColor(R.color.colorEpmDanger);
        WARNING_COLOR = context.getResources().getColor(R.color.colorEpmWarning);
        INFO_COLOR = context.getResources().getColor(R.color.colorEpmInfo);
        LIGHT_COLOR = context.getResources().getColor(R.color.colorEpmLight);
        DARK_COLOR = context.getResources().getColor(R.color.colorEpmDark);
        DEFAULT_COLOR = context.getResources().getColor(R.color.colorPrimary);
        DISABLE_COLOR = context.getResources().getColor(R.color.colorEpmDisable);

        PRIMARY_COLOR_SOFT = context.getResources().getColor(R.color.colorEpmPrimarySoft);
        SECONDARY_COLOR_SOFT = context.getResources().getColor(R.color.colorEpmSecondarySoft);
        SUCCESS_COLOR_SOFT = context.getResources().getColor(R.color.colorEpmSuccessSoft);
        DANGER_COLOR_SOFT = context.getResources().getColor(R.color.colorEpmDangerSoft);
        WARNING_COLOR_SOFT = context.getResources().getColor(R.color.colorEpmWarningSoft);
        INFO_COLOR_SOFT = context.getResources().getColor(R.color.colorEpmInfoSoft);
        LIGHT_COLOR_SOFT = context.getResources().getColor(R.color.colorEpmLightSoft);
        DARK_COLOR_SOFT = context.getResources().getColor(R.color.colorEpmDarkSoft);

        PRIMARY_ALERT_TEXT = context.getResources().getColor(R.color.colorEpmPrimaryAlertText);
        SECONDARY_ALERT_TEXT = context.getResources().getColor(R.color.colorEpmSecondaryAlertText);
        SUCCESS_ALERT_TEXT = context.getResources().getColor(R.color.colorEpmSuccessAlertText);
        DANGER_ALERT_TEXT = context.getResources().getColor(R.color.colorEpmDangerAlertText);
        WARNING_ALERT_TEXT = context.getResources().getColor(R.color.colorEpmWarningAlertText);
        INFO_ALERT_TEXT = context.getResources().getColor(R.color.colorEpmInfoAlertText);
        LIGHT_ALERT_TEXT = context.getResources().getColor(R.color.colorEpmLightAlertText);
        DARK_ALERT_TEXT = context.getResources().getColor(R.color.colorEpmDarkAlertText);

        BLACK_COLOR = context.getResources().getColor(R.color.colorBlack);
        WHITE_COLOR = context.getResources().getColor(R.color.colorWhite);
        TEXT_COLOR = context.getResources().getColor(R.color.colorText);
        EDIT_TEXT_COLOR = context.getResources().getColor(R.color.colorEditText);
        HINT_EDIT_TEXT_COLOR = context.getResources().getColor(R.color.colorHintEditText);
        TRANSPARENT_COLOR = context.getResources().getColor(android.R.color.transparent);

        BUTTON_ROUNDED_CORNER_RADIUS = context.getResources().getDimension(R.dimen.btn_rounded_corner_radius);
        BUTTON_PILL_CORNER_RADIUS = context.getResources().getDimension(R.dimen.btn_pill_corner_radius);
        BUTTON_STROKE_WEIGHT = (int) context.getResources().getDimension(R.dimen.btn_stroke_weight);
        DEFAULT_TEXT_SIZE = context.getResources().getDimension(R.dimen.text_size_default);
        DEFAULT_SPINNER_VERTICAL_OFFSET = context.getResources().getDimension(R.dimen.spinner_vertical_offset);
        DEFAULT_SPINNER_MIN_HEIGHT = context.getResources().getDimension(R.dimen.spinner_min_height);

        CHECKBOX_TRUE = context.getResources().getDrawable(R.drawable.ic_checkbox_true);
        CHECKBOX_FALSE = context.getResources().getDrawable(R.drawable.ic_checkbox_false);
        RADIO_BUTTON_TRUE = context.getResources().getDrawable(R.drawable.ic_radio_true);
        RADIO_BUTTON_FALSE = context.getResources().getDrawable(R.drawable.ic_radio_false);
        TOGGLE_TRUE = context.getResources().getDrawable(R.drawable.ic_switches_true);
        TOGGLE_FALSE = context.getResources().getDrawable(R.drawable.ic_switches_disable);
    }

    static Drawable getDrawable(int type, int fill, int color) {
        return getStateDrawable(type, fill, color, WHITE_COLOR);
    }

    static Drawable getDrawable(int type, int fill, int color, int color2) {
        return getStateDrawable(type, fill, color, color2);
    }

    private static Drawable getStateDrawable(int type, int fill, int color, int colorFill) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, createBackground(type, fill, getDarkerColor(color), colorFill, true));
        stateListDrawable.addState(new int[]{-android.R.attr.state_enabled}, createBackground(type, fill, DISABLE_COLOR, colorFill, false));
        stateListDrawable.addState(StateSet.WILD_CARD, createBackground(type, fill, color, colorFill, false));
        return stateListDrawable;
    }

    private static Drawable createBackground(int type, int fill, int color, int color2, boolean pressed) {
        GradientDrawable background = new GradientDrawable();
        background.setShape(GradientDrawable.RECTANGLE);

        if (type == TYPE_ROUNDED) {
            background.setCornerRadius(BUTTON_ROUNDED_CORNER_RADIUS);
        } else if (type == TYPE_PILL) {
            background.setCornerRadius(BUTTON_PILL_CORNER_RADIUS);
        } else if (type == TYPE_SQUARE) {
            background.setCornerRadius(0);
        } else {
            background.setCornerRadius(BUTTON_ROUNDED_CORNER_RADIUS);
        }

        if (fill == FILL_SOLID) {
            background.setColor(color);
        } else if (fill == FILL_OUTLINE) {
            background.setColor(pressed ? getDarkerColor(color2) : color2);
            background.setStroke(BUTTON_STROKE_WEIGHT, color);
        } else {
            background.setColor(color);
        }

        return background;
    }

    public static Drawable createContainerBackground(int type, int fill, int color, int color2) {
        GradientDrawable background = new GradientDrawable();
        background.setShape(GradientDrawable.RECTANGLE);

        if (type == TYPE_ROUNDED) {
            background.setCornerRadius(BUTTON_ROUNDED_CORNER_RADIUS);
        } else if (type == TYPE_PILL) {
            background.setCornerRadius(BUTTON_PILL_CORNER_RADIUS);
        } else if (type == TYPE_SQUARE) {
            background.setCornerRadius(0);
        } else {
            background.setCornerRadius(BUTTON_ROUNDED_CORNER_RADIUS);
        }

        if (fill == FILL_SOLID) {
            background.setColor(color);
        } else if (fill == FILL_OUTLINE) {
            background.setColor(color);
            background.setStroke(BUTTON_STROKE_WEIGHT, color2);
        } else {
            background.setColor(color);
        }

        return background;
    }

    public static Drawable getCheckboxDrawable() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_checked}, CHECKBOX_TRUE);
        stateListDrawable.addState(new int[]{-android.R.attr.state_checked}, CHECKBOX_FALSE);
        stateListDrawable.addState(new int[]{-android.R.attr.state_enabled}, CHECKBOX_FALSE);
        stateListDrawable.addState(StateSet.WILD_CARD, CHECKBOX_FALSE);
        return stateListDrawable;
    }

    public static Drawable getToggleButtonDrawable() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_checked}, TOGGLE_TRUE);
        stateListDrawable.addState(new int[]{-android.R.attr.state_checked}, TOGGLE_FALSE);
        stateListDrawable.addState(new int[]{-android.R.attr.state_enabled}, TOGGLE_FALSE);
        stateListDrawable.addState(StateSet.WILD_CARD, TOGGLE_FALSE);
        return stateListDrawable;
    }

    public static Drawable getRadioButtonDrawable() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_checked},  RADIO_BUTTON_TRUE);
        stateListDrawable.addState(new int[]{-android.R.attr.state_checked}, RADIO_BUTTON_FALSE);
        stateListDrawable.addState(new int[]{-android.R.attr.state_enabled}, RADIO_BUTTON_FALSE);
        stateListDrawable.addState(StateSet.WILD_CARD, RADIO_BUTTON_FALSE);
        return stateListDrawable;
    }

    static int getDarkerColor(int color) {
        int a = Color.alpha(color);
        int r = Math.round(Color.red(color) * DARK_COLOR_FACTOR);
        int g = Math.round(Color.green(color) * DARK_COLOR_FACTOR);
        int b = Math.round(Color.blue(color) * DARK_COLOR_FACTOR);
        return Color.argb(a,
                Math.min(r, 255),
                Math.min(g, 255),
                Math.min(b, 255));
    }

    static Drawable recolorIcon(Drawable icon, int color) {
        DrawableCompat.setTint(
                DrawableCompat.wrap(icon),
                color
        );
        return icon;
    }
}
