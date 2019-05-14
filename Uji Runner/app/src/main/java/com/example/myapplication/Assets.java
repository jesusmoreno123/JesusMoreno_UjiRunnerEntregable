package com.example.myapplication;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Assets {
    public static Bitmap[] bgLayers;
    public static void createAssets(Context context, int playerWidth, int stageHeight,
                                    int parallaxWidth) {
        Resources resources = context.getResources();
        if (bgLayers != null)
            for (Bitmap bitmap: bgLayers)
                bitmap.recycle();
        int[] bgLayersResources = {
                R.drawable.bg1,
                R.drawable.bg2,
                R.drawable.bg3,
                R.drawable.bg4
        };
        bgLayers = new Bitmap[bgLayersResources.length];
        for (int i = 0; i < bgLayers.length; i++) {
            bgLayers[i] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(
                    resources, bgLayersResources[i]), parallaxWidth, stageHeight, true);
        }
    }
}
