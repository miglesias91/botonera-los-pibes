package com.example.manuel.botoneralospibes;

import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    // botones audio
    private ImageButton boton_franco_despertate_hdp;
    private ImageButton boton_franco_he_guacho;
    private ImageButton boton_franco_madrid_papa;
    private ImageButton boton_franco_re_va;
    private ImageButton boton_franco_rezarpado_reloco;
    private ImageButton boton_jm_going_crazy;
    private ImageButton boton_jm_jojojo;
    private ImageButton boton_jm_osito_dormilon;

    // botones whatsapp
    private ImageButton boton_franco_despertate_hdp_compartir;
    private ImageButton boton_franco_he_guacho_compartir;
    private ImageButton boton_franco_madrid_papa_compartir;
    private ImageButton boton_franco_re_va_compartir;
    private ImageButton boton_franco_rezarpado_reloco_compartir;
    private ImageButton boton_jm_going_crazy_compartir;
    private ImageButton boton_jm_jojojo_compartir;
    private ImageButton boton_jm_osito_dormilon_compartir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SetSonidos.getInstance().init(this);
        CompartirAudioEnWhatsAppListener.init();

        boton_franco_despertate_hdp = (ImageButton) findViewById( R.id.boton_franco_despertate_hdp );
        boton_franco_despertate_hdp.setOnClickListener(new ReproducirBotonListener(1));

        boton_franco_despertate_hdp_compartir = (ImageButton) findViewById( R.id.boton_franco_despertate_hdp_compartir );
        boton_franco_despertate_hdp_compartir.setOnClickListener(new CompartirAudioEnWhatsAppListener(this, 1));

        boton_franco_he_guacho = (ImageButton) findViewById( R.id.boton_franco_he_guacho );
        boton_franco_he_guacho.setOnClickListener(new ReproducirBotonListener(2));

        boton_franco_he_guacho_compartir = (ImageButton) findViewById( R.id.boton_franco_he_guacho_compartir );
        boton_franco_he_guacho_compartir.setOnClickListener(new CompartirAudioEnWhatsAppListener(this, 2));

        boton_franco_madrid_papa = (ImageButton) findViewById( R.id.boton_franco_madrid_papa );
        boton_franco_madrid_papa.setOnClickListener(new ReproducirBotonListener(3));

        boton_franco_madrid_papa_compartir = (ImageButton) findViewById( R.id.boton_franco_madrid_papa_compartir );
        boton_franco_madrid_papa_compartir.setOnClickListener(new CompartirAudioEnWhatsAppListener(this, 3));

        boton_franco_re_va = (ImageButton) findViewById( R.id.boton_franco_re_va );
        boton_franco_re_va.setOnClickListener(new ReproducirBotonListener(4));

        boton_franco_re_va_compartir = (ImageButton) findViewById( R.id.boton_franco_re_va_compartir );
        boton_franco_re_va_compartir.setOnClickListener(new CompartirAudioEnWhatsAppListener(this, 4));

        boton_franco_rezarpado_reloco = (ImageButton) findViewById( R.id.boton_franco_rezarpado_reloco );
        boton_franco_rezarpado_reloco.setOnClickListener(new ReproducirBotonListener(5));

        boton_franco_rezarpado_reloco_compartir = (ImageButton) findViewById( R.id.boton_franco_rezarpado_reloco_compartir );
        boton_franco_rezarpado_reloco_compartir.setOnClickListener(new CompartirAudioEnWhatsAppListener(this, 5));

        boton_jm_going_crazy = (ImageButton) findViewById( R.id.boton_jm_going_crazy );
        boton_jm_going_crazy.setOnClickListener(new ReproducirBotonListener(6));

        boton_jm_going_crazy_compartir = (ImageButton) findViewById( R.id.boton_jm_going_crazy_compartir );
        boton_jm_going_crazy_compartir.setOnClickListener(new CompartirAudioEnWhatsAppListener(this, 6));

        boton_jm_jojojo = (ImageButton) findViewById( R.id.boton_jm_jojojo );
        boton_jm_jojojo.setOnClickListener(new ReproducirBotonListener(7));

        boton_jm_jojojo_compartir = (ImageButton) findViewById( R.id.boton_jm_jojojo_compartir );
        boton_jm_jojojo_compartir.setOnClickListener(new CompartirAudioEnWhatsAppListener(this, 7));

        boton_jm_osito_dormilon = (ImageButton) findViewById( R.id.boton_jm_osito_dormilon );
        boton_jm_osito_dormilon.setOnClickListener(new ReproducirBotonListener(8));

        boton_jm_osito_dormilon_compartir = (ImageButton) findViewById( R.id.boton_jm_osito_dormilon_compartir );
        boton_jm_osito_dormilon_compartir.setOnClickListener(new CompartirAudioEnWhatsAppListener(this, 8));
    }
}
