package com.markhetherington.thisishow.ui.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.ColorInt;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.markhetherington.thisishow.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class BigStartTextView extends FrameLayout {

    @Bind(R.id.start_character)
    TextView mStartCharacter;
    @Bind(R.id.topright_text)
    TextView mTopRight;
    @Bind(R.id.bottom_text)
    TextView mBottomText;

    public BigStartTextView(Context context) {
        super(context);
        init(null, 0);
    }

    public BigStartTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public BigStartTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        // Load attributes
        final TypedArray a = getContext().obtainStyledAttributes(
                attrs, R.styleable.BigStartTextView, defStyle, 0);
        a.recycle();

        LayoutInflater.from(getContext()).inflate(R.layout.big_start_text_view, this, true);
        ButterKnife.bind(this);
    }

    public void setStartColor(@ColorInt int color) {
        mStartCharacter.setTextColor(color);
    }

    public void setText(String inputText) {

        String firstCharacter = null;
        inputText = inputText.trim();
        if (!TextUtils.isEmpty(inputText)) {
            firstCharacter = inputText.substring(0, 1);
            inputText = inputText.substring(1);
            inputText = inputText.trim();
        }
        mStartCharacter.setText(firstCharacter);
        mTopRight.setText(inputText);

        final String finalText = inputText;
        post(() -> {
            String text = finalText;
            String extraText = null;
            int totalTextOfTopRight = mTopRight.getLayout().getLineEnd(1);

            if (!TextUtils.isEmpty(text)) {
                text = text.substring(totalTextOfTopRight);
                text.trim();
                extraText = text;
            }
            mBottomText.setText(extraText);
        });

    }


}
