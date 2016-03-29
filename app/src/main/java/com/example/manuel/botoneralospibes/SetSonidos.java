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

    private SoundPool sound_pool;

    private HashMap<Integer, Integer> mapa_sonidos;
    int priority = 1;
    int no_loop = 0;
    private int volume;
    float normal_playback_rate = 1.0f;

    private Context context;

    private static int ultimo_id_reproducido = -1;
    private static Integer id_play;

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

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {

            AudioAttributes audio_atrib = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_GAME)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();

            sound_pool = new SoundPool.Builder().setAudioAttributes(audio_atrib).build();
            Log.i( "SetSonidos", "Iniciado con API >= 21" );
        }
        else {
            sound_pool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
            Log.i( "SetSonidos", "Iniciado con API < 21" );
        }

        mapa_sonidos = new HashMap<Integer, Integer>();

        // audios franco
        mapa_sonidos.put(SONIDO_FRANCO_DESPERTATE_HDP, sound_pool.load(context, R.raw.franco_despertate_hdp, 1));
        mapa_sonidos.put(SONIDO_FRANCO_HE_GUACHO, sound_pool.load(context, R.raw.franco_he_guacho, 1));
        mapa_sonidos.put(SONIDO_FRANCO_MADRID_PAPA, sound_pool.load(context, R.raw.franco_madrid_papa, 1));
        mapa_sonidos.put(SONIDO_FRANCO_RE_VA, sound_pool.load(context, R.raw.franco_re_va, 1));
        mapa_sonidos.put(SONIDO_FRANCO_REZARPADO_RELOCO, sound_pool.load(context, R.raw.franco_rezarpado_reloco, 1));

        // audios jm
        mapa_sonidos.put(SONIDO_JM_GOING_CRAZY, sound_pool.load(context, R.raw.jm_going_crazy, 1));
        mapa_sonidos.put(SONIDO_JM_JOJOJO, sound_pool.load(context, R.raw.jm_jojojo, 1));
        mapa_sonidos.put(SONIDO_JM_OSITO_DORMILION, sound_pool.load(context, R.raw.jm_osito_dormilon, 1));

        AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        volume = audioManager.getStreamVolume(AudioManager.STREAM_SYSTEM);
    }

    public void reproducir(int id_sonido_a_reproducir) {

        if ( this.ultimo_id_reproducido == id_sonido_a_reproducir ) {
            int aux = id_sonido_a_reproducir - 1;
            if ( aux == 0 ) {
                aux += 3;
            }
            this.id_play = this.sound_pool.play(mapa_sonidos.get(aux), volume, volume, priority, no_loop, normal_playback_rate);
            this.sound_pool.stop(this.id_play);
        }

        this.ultimo_id_reproducido = id_sonido_a_reproducir;
        this.id_play = this.sound_pool.play(mapa_sonidos.get(id_sonido_a_reproducir), volume, volume, priority, no_loop, normal_playback_rate);
        Log.i("SetSonidos", "Reproduciendo sonido: " + id_sonido_a_reproducir);
        Log.i("SetSonidos", "id_play: " + this.id_play);
    }
}
