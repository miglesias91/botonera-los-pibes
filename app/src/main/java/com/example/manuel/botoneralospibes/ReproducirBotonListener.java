package com.example.manuel.botoneralospibes;

import android.view.View;

/**
 * Created by Manuel on 20/03/2016.
 */
public class ReproducirBotonListener implements View.OnClickListener {

    private int id_a_reproducir = -1;

    public ReproducirBotonListener( int id_a_reproducir ) {
        this.id_a_reproducir = id_a_reproducir;
    }

    public void onClick( View view ) {
        SetSonidos.getInstance().reproducir( id_a_reproducir );
    }

}
