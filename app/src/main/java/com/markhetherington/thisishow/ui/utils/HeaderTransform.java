package com.markhetherington.thisishow.ui.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.ColorInt;
import android.support.v4.graphics.ColorUtils;
import android.support.v7.graphics.Palette;

import com.squareup.picasso.Transformation;

/**
 * Created by markhetherington on 2015-11-22.
 */
public class HeaderTransform implements Transformation {

    private final Context mContext;

    public Palette mPalette;

    public HeaderTransform(Context context) {
        this.mContext = context;
    }

    @Override
    public Bitmap transform(Bitmap source) {
        mPalette = Palette.from(source).maximumColorCount(64).generate();
        int start = ColorUtils.setAlphaComponent(mPalette.getLightVibrantColor(Color.TRANSPARENT), 130);
        int end = mPalette.getDarkVibrantColor(Color.parseColor("#FF000000"));
        Bitmap secondBitmap = addGradient(source, start, end);
        source.recycle();
        return secondBitmap;
    }

    @Override
    public String key() {
        return "HeaderTransform";
    }

    public Palette getPalette() {
        return mPalette;
    }

    private static Bitmap addGradient(Bitmap src, @ColorInt int start, @ColorInt int end) {
        int w = src.getWidth();
        int h = src.getHeight();
        Bitmap overlay = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(overlay);

        canvas.drawBitmap(src, 0, 0, null);

        Paint paint = new Paint();
        LinearGradient shader = new LinearGradient(0, 0, 0, h, start, end, Shader.TileMode.CLAMP);
        paint.setShader(shader);
        paint.setStyle(Paint.Style.FILL);
        paint.setAlpha(230);
        canvas.drawRect(0, 0, w, h, paint);

        return overlay;
    }
}

