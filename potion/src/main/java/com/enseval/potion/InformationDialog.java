package com.enseval.potion;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class InformationDialog extends Dialog {

    private static InformationDialog dialog;

    private TextView tvTitle;
    private TextView tvMessage;
    private ImageView ivDrawable;
    private static Button buttonPositive;
    private static Button buttonNegative;

    public InformationDialog(@NonNull Context context) {
        super(context);
        init();
    }

    public InformationDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        init();
    }

    protected InformationDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        init();
    }

    private void init() {
        this.setContentView(R.layout.dialog_information);
        this.setCancelable(true);
        this.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        tvTitle = this.findViewById(R.id.tv_title);
        tvMessage = this.findViewById(R.id.tv_message);
        ivDrawable = this.findViewById(R.id.iv_drawable);
        buttonNegative = this.findViewById(R.id.btn_negative);
        buttonPositive = this.findViewById(R.id.btn_positive);

        buttonPositive.setText(getContext().getResources().getString(R.string.default_text_ok));
        buttonPositive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }

    public static InformationDialog makeDialog(@NonNull Context context){
        dialog = new InformationDialog(context);
        return dialog;
    }

    public InformationDialog setTitle(String text){
        tvTitle.setText(text);
        return dialog;
    }

    public InformationDialog setMessage(String text){
        tvMessage.setText(text);
        return dialog;
    }

    public InformationDialog setDrawable(Drawable drawable){
        ivDrawable.setImageDrawable(drawable);
        ivDrawable.setVisibility(View.VISIBLE);
        return dialog;
    }

    public InformationDialog setPositiveButton(String text, View.OnClickListener listener){
        buttonPositive.setText(text);
        buttonPositive.setOnClickListener(listener);
        return dialog;
    }

    public InformationDialog setNegativeButton(String text, View.OnClickListener listener){
        buttonNegative.setVisibility(View.VISIBLE);
        buttonNegative.setText(text);
        buttonNegative.setOnClickListener(listener);
        return dialog;
    }

    public static InformationDialog getDialog(){
        return dialog;
    }

    public static void dismissDialog(){
        try {
            dialog.dismiss();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
