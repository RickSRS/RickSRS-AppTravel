package com.richardsoares.apptravel.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

public class ResourceUtil {

    public static final String DRAWABLE_STR = "drawable";

    public static Drawable devolveDrawable(Context context, String drawableEmTexto) {
        Resources resources = context.getResources();
        int idDrawable = resources.getIdentifier(drawableEmTexto,
                DRAWABLE_STR, context.getPackageName());
        Drawable drawableImagemPacote = resources.getDrawable(idDrawable);
        return drawableImagemPacote;
    }
}
