package com.radiohora.android;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView texto = new TextView(this);
        texto.setText("RADIO HORA\nBienvenido a nuestra radio");
        texto.setTextSize(26);
        texto.setTextColor(Color.WHITE);
        texto.setBackgroundColor(Color.rgb(15, 25, 45));
        texto.setGravity(Gravity.CENTER);

        setContentView(texto);
    }
}
