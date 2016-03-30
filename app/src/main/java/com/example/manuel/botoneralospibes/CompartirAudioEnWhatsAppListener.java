package com.example.manuel.botoneralospibes;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;

/**
 * Created by Manuel on 30/03/2016.
 */
public class CompartirAudioEnWhatsAppListener implements View.OnClickListener {

    Context context;

    public CompartirAudioEnWhatsAppListener(Context context) {
        this.context = context;
    }

    public void onClick( View view ) {
        Intent wa_intent = new Intent();
        wa_intent.setAction(Intent.ACTION_SEND);
        wa_intent.putExtra(Intent.EXTRA_STREAM, Uri.parse("android.resource://com.example.manuel.botoneralospibes/" + R.raw.jm_jojojo) );
        wa_intent.setType("audio/wav");
        wa_intent.setPackage("com.whatsapp");
        view.getContext().startActivity(wa_intent);
    }
}
