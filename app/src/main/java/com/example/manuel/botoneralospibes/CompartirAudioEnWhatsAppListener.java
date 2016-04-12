package com.example.manuel.botoneralospibes;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;

/**
 * Created by Manuel on 30/03/2016.
 */
public class CompartirAudioEnWhatsAppListener implements View.OnClickListener {

    Context context;
    Integer id_raw;

    private static final int SONIDO_FRANCO_DESPERTATE_HDP = 1;
    private static final int SONIDO_FRANCO_HE_GUACHO = 2;
    private static final int SONIDO_FRANCO_MADRID_PAPA = 3;
    private static final int SONIDO_FRANCO_RE_VA = 4;
    private static final int SONIDO_FRANCO_REZARPADO_RELOCO = 5;
    private static final int SONIDO_JM_GOING_CRAZY = 6;
    private static final int SONIDO_JM_JOJOJO = 7;
    private static final int SONIDO_JM_OSITO_DORMILION = 8;

    private static HashMap<Integer, Integer> mapa_nombres = new HashMap<Integer, Integer>();

    public CompartirAudioEnWhatsAppListener(Context context, Integer id_raw) {
        this.context = context;
        this.id_raw = id_raw;
    }

    public static void init() {
        mapa_nombres.put(SONIDO_FRANCO_DESPERTATE_HDP,  R.raw.franco_despertate_hdp_wa);
        mapa_nombres.put(SONIDO_FRANCO_HE_GUACHO,  R.raw.franco_he_guacho_wa);
        mapa_nombres.put(SONIDO_FRANCO_MADRID_PAPA,  R.raw.franco_madrid_papa_wa);
        mapa_nombres.put(SONIDO_FRANCO_RE_VA,  R.raw.franco_re_va_wa);
        mapa_nombres.put(SONIDO_FRANCO_REZARPADO_RELOCO,  R.raw.franco_rezarpado_reloco_wa);
        mapa_nombres.put(SONIDO_JM_GOING_CRAZY,  R.raw.jm_going_crazy_wa);
        mapa_nombres.put(SONIDO_JM_JOJOJO,  R.raw.jm_jojojo_wa);
        mapa_nombres.put(SONIDO_JM_OSITO_DORMILION,  R.raw.jm_osito_dormilon_wa);
    }

    public void onClick( View view ) {
        Intent wa_intent = new Intent();
        wa_intent.setAction(Intent.ACTION_SEND);
        wa_intent.putExtra(Intent.EXTRA_STREAM, Uri.parse("android.resource://com.example.manuel.botoneralospibes/" + mapa_nombres.get(this.id_raw)));
        wa_intent.setType("audio/*");
        wa_intent.setPackage("com.whatsapp");
        view.getContext().startActivity(wa_intent);
    }
}
