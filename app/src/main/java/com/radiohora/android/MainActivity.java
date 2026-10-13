
package com.radiohora.android;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Button;
import android.media.MediaPlayer;
import android.media.AudioManager;

public class MainActivity extends Activity {

    private MediaPlayer radio;
    private TextView estado;

    // Aqui colocaremos el enlace de tu radio
    private final String RADIO_URL = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout pantalla = new LinearLayout(this);
        pantalla.setOrientation(LinearLayout.VERTICAL);
        pantalla.setGravity(Gravity.CENTER);
        pantalla.setPadding(30, 30, 30, 30);
        pantalla.setBackgroundColor(Color.rgb(15, 25, 45));

        TextView titulo = new TextView(this);
        titulo.setText("RADIO HORA");
        titulo.setTextSize(34);
        titulo.setTextColor(Color.WHITE);
        titulo.setGravity(Gravity.CENTER);
        pantalla.addView(titulo);

        TextView mensaje = new TextView(this);
        mensaje.setText("Tu radio, tu mejor compañía");
        mensaje.setTextSize(19);
        mensaje.setTextColor(Color.WHITE);
        mensaje.setGravity(Gravity.CENTER);
        mensaje.setPadding(0, 25, 0, 45);
        pantalla.addView(mensaje);

        Button reproducir = new Button(this);
        reproducir.setText("▶ REPRODUCIR RADIO");
        pantalla.addView(reproducir);

        Button detener = new Button(this);
        detener.setText("■ DETENER RADIO");
        pantalla.addView(detener);

        estado = new TextView(this);
        estado.setText("Radio lista");
        estado.setTextSize(18);
        estado.setTextColor(Color.WHITE);
        estado.setGravity(Gravity.CENTER);
        estado.setPadding(0, 35, 0, 0);
        pantalla.addView(estado);

        setContentView(pantalla);

        reproducir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciarRadio();
            }
        });

        detener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                detenerRadio();
                estado.setText("Radio detenida");
            }
        });
    }

    private void iniciarRadio() {
        if (RADIO_URL.isEmpty()) {
            estado.setText("Falta configurar el enlace de la radio");
            return;
        }

        detenerRadio();

        try {
            radio = new MediaPlayer();
            radio.setAudioStreamType(AudioManager.STREAM_MUSIC);
            radio.setDataSource(RADIO_URL);

            estado.setText("Conectando...");

            radio.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.start();
                    estado.setText("RADIO HORA EN VIVO");
                }
            });

            radio.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                @Override
                public boolean onError(MediaPlayer mp, int what, int extra) {
                    estado.setText("Error de reproducción");
                    return true;
                }
            });

            radio.prepareAsync();

        } catch (Exception e) {
            detenerRadio();
            estado.setText("Error al conectar la radio");
        }
    }

    private void detenerRadio() {
        if (radio != null) {
            radio.release();
            radio = null;
        }
    }

    @Override
    protected void onDestroy() {
        detenerRadio();
        super.onDestroy();
    }
}
