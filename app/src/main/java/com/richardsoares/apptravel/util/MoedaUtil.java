package com.richardsoares.apptravel.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class MoedaUtil {

    public static final String PORTUGUES = "pt";
    public static final String BRASIL = "br";
    public static final String FORMATADO_PADRAO = "R$";
    public static final String FORMATO_COM_ESPACO = "R$ ";

    public static String formataMoedaParaBrasileiro(BigDecimal preco) {
        NumberFormat formatoBrasileiro = DecimalFormat.getCurrencyInstance(new Locale(PORTUGUES, BRASIL));
        String precoFormatado = formatoBrasileiro
                .format(preco)
                .replace(FORMATADO_PADRAO, FORMATO_COM_ESPACO);
        return precoFormatado;
    }

}
