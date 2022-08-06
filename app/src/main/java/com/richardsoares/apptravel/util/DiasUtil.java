package com.richardsoares.apptravel.util;

public class DiasUtil {

    public static final String PLURAL = " dias";
    public static final String SINGULAR = " dia";

    public static String formataEmTexto(int dias) {
        if (dias > 1) {
            return dias + PLURAL;
        }
        return dias + SINGULAR;
    }

}
