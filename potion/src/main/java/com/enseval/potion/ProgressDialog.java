package com.enseval.potion;

import android.app.Dialog;
import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ProgressDialog extends Dialog {

    private static ProgressDialog dialog;

    private TextView tvMessage;

    public ProgressDialog(@NonNull Context context) {
        super(context);
        init();
    }

    public ProgressDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        init();
    }

    protected ProgressDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        init();
    }

    private void init() {
        this.setContentView(R.layout.dialog_progress);
        this.setCancelable(false);
        this.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        tvMessage = this.findViewById(R.id.progress_bar_message);
        tvMessage.setText(getContext().getResources().getString(R.string.default_progress_message));
    }

    public ProgressDialog setLoadingMessage(String message){
        tvMessage.setText(message);
        tvMessage.setVisibility(View.VISIBLE);
        return dialog;
    }

    public static ProgressDialog makeDialog(@NonNull Context context){
        dialog = new ProgressDialog(context);
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
