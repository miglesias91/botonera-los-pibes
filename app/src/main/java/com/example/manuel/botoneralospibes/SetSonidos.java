package com.example.manuel.botoneralospibes;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Manuel on 20/03/2016.
 */
public class SetSonidos {

    private ArrayList<SoundPool> sound_pools;
    private SoundPool sound_pool_activo;
    private int idx_sound_pool_activo = 0;
    private int num_sound_pools = 2;

    private HashMap<Integer, Integer> mapa_sonidos;
    int priority = 1;
    int no_loop = 0;
    private int volume;
    float normal_playback_rate = 1.0f;

    private Context context;

    private static int ultimo_id_reproducido = 0;
    private static int id_play = 0;

    public static final int SONIDO_FRANCO_DESPERTATE_HDP = 1;
    public static final int SONIDO_FRANCO_HE_GUACHO = 2;
    public static final int SONIDO_FRANCO_MADRID_PAPA = 3;
    public static final int SONIDO_FRANCO_RE_VA = 4;
    public static final int SONIDO_FRANCO_REZARPADO_RELOCO = 5;
    public static final int SONIDO_JM_GOING_CRAZY = 6;
    public static final int SONIDO_JM_JOJOJO = 7;
    public static final int SONIDO_JM_OSITO_DORMILION = 8;

    private static int MAX_SONIDOS = 8;

    private static SetSonidos instancia = new SetSonidos();

    public static SetSonidos getInstance() {
        return instancia;
    }

    private SetSonidos() {
    }

    public void init( Context context ) {
        this.context = context;

        sound_pools = new ArrayList<SoundPool>(num_sound_pools);

        Log.i( "SetSonidos", "Numero de SoundPools = " + num_sound_pools );
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {

            AudioAttributes audio_atrib = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_GAME)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();

            //for ( SoundPool s : sound_pools ) {
            //    s = new SoundPool.Builder().setAudioAttributes(audio_atrib).build();
            //}
            for ( int i = 0 ; i < num_sound_pools ; i++ ) {
                sound_pools.add( new SoundPool.Builder().setAudioAttributes(audio_atrib).build() );
            }
            //sound_pool = new SoundPool.Builder().setAudioAttributes(audio_atrib).build();
            Log.i( "SetSonidos", "Iniciado con API >= 21" );
        }
        else {
            //for ( SoundPool s : sound_pools ) {
            //    s = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
            //}
            for ( int i = 0 ; i < num_sound_pools ; i++ ) {
                sound_pools.add( new SoundPool(10, AudioManager.STREAM_MUSIC, 0) );
            }
            //sound_pool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
            Log.i( "SetSonidos", "Iniciado con API < 21" );
        }

        mapa_sonidos = new HashMap<Integer, Integer>();

        for ( SoundPool s : sound_pools ) {
            // audios franco
            mapa_sonidos.put(SONIDO_FRANCO_DESPERTATE_HDP, s.load(context, R.raw.franco_despertate_hdp, 1));
            mapa_sonidos.put(SONIDO_FRANCO_HE_GUACHO, s.load(context, R.raw.franco_he_guacho, 1));
            mapa_sonidos.put(SONIDO_FRANCO_MADRID_PAPA, s.load(context, R.raw.franco_madrid_papa, 1));
            mapa_sonidos.put(SONIDO_FRANCO_RE_VA, s.load(context, R.raw.franco_re_va, 1));
            mapa_sonidos.put(SONIDO_FRANCO_REZARPADO_RELOCO, s.load(context, R.raw.franco_rezarpado_reloco, 1));

            // audios jm
            mapa_sonidos.put(SONIDO_JM_GOING_CRAZY, s.load(context, R.raw.jm_going_crazy, 1));
            mapa_sonidos.put(SONIDO_JM_JOJOJO, s.load(context, R.raw.jm_jojojo, 1));
            mapa_sonidos.put(SONIDO_JM_OSITO_DORMILION, s.load(context, R.raw.jm_osito_dormilon, 1));
        }

        AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        volume = audioManager.getStreamVolume(AudioManager.STREAM_SYSTEM);

        sound_pool_activo = sound_pools.get( idx_sound_pool_activo );
    }

    public void reproducir(int id_sonido_a_reproducir) {

        if ( ultimo_id_reproducido == id_sonido_a_reproducir ) {
            //this.cambiarSoundPool();
            //this.sound_pool_activo.pause(this.id_play);
            //this.sound_pool_activo.resume(this.id_play);
            //Log.i("SetSonidos", "Reproduciendo sonido: " + id_sonido_a_reproducir);
            //Log.i("SetSonidos", "id_play: " + this.id_play);
            //return;
        }

        ultimo_id_reproducido = id_sonido_a_reproducir;
        this.sound_pool_activo.stop(this.id_play);
        this.id_play = this.sound_pool_activo.play(mapa_sonidos.get(id_sonido_a_reproducir), volume, volume, priority, no_loop, normal_playback_rate);
        Log.i("SetSonidos", "Reproduciendo sonido: " + id_sonido_a_reproducir);
        Log.i("SetSonidos", "id_play: " + this.id_play);
    }

    public void cambiarSoundPool() {
        // paro el soundpool q se esta reproduciendo.
        this.id_play = this.sound_pool_activo.play(mapa_sonidos.get(ultimo_id_reproducido--), volume, volume, priority, no_loop, normal_playback_rate);
        this.sound_pool_activo.stop(this.id_play);

        if ( 0 == this.idx_sound_pool_activo ) {
            this.idx_sound_pool_activo = 1;
        } else {
            this.idx_sound_pool_activo = 0;
        }
        // cambio de soundpool
        //this.sound_pool_activo = this.sound_pools.get( this.idx_sound_pool_activo );

        Log.i("SetSonidos", "Idx SoundPool activo: " + this.idx_sound_pool_activo);
        Log.i("SetSonidos", "id_play: " + this.id_play);
    }
}
