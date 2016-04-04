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
        wa_intent.putExtra(Intent.EXTRA_STREAM, Uri.parse("android.resource://com.example.manuel.botoneralospibes/" + R.raw.jm_jojojo_wa));
        wa_intent.setType("audio/*");
        view.getContext().startActivity(Intent.createChooser(wa_intent, "Share Sound File"));
    }
}
