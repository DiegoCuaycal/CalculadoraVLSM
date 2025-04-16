package com.diegocuaycal.myapplication;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.diegocuaycal.myapplication.Subred;
import com.diegocuaycal.myapplication.VLSMCalculator;


import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import androidx.cardview.widget.CardView;
import android.graphics.Color;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;
import android.content.Intent;



public class ResultadosActivity extends AppCompatActivity {

    LinearLayout layoutResultados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        layoutResultados = findViewById(R.id.layoutResultados);

        // Obtener datos del Intent
        String ip = getIntent().getStringExtra("ip");
        int prefijo = getIntent().getIntExtra("prefijo", 24);
        ArrayList<String> nombres = getIntent().getStringArrayListExtra("nombres");
        ArrayList<Integer> tamanios = getIntent().getIntegerArrayListExtra("tamanios");

        if (ip != null && nombres != null && tamanios != null && nombres.size() == tamanios.size()) {

            // Combinar nombres y tamaños en objetos Subred (temporal para ordenar)
            ArrayList<Subred> datos = new ArrayList<>();
            for (int i = 0; i < nombres.size(); i++) {
                datos.add(new Subred(nombres.get(i), tamanios.get(i), "", "", 0, "", ""));
            }

            // Ordenar de mayor a menor por tamaño de host
            Collections.sort(datos, new Comparator<Subred>() {
                @Override
                public int compare(Subred s1, Subred s2) {
                    return Integer.compare(s2.hosts, s1.hosts);
                }
            });

            // Extraer solo tamaños ordenados
            ArrayList<Integer> tamaniosOrdenados = new ArrayList<>();
            for (Subred s : datos) {
                tamaniosOrdenados.add(s.hosts);
            }

            // Calcular subredes usando la clase VLSMCalculator
            VLSMCalculator calc = new VLSMCalculator(ip, prefijo);
            ArrayList<Subred> subredesCalculadas = VLSMCalculator.calcularSubredes(ip, prefijo, nombres, tamanios);


            // Asignar nombre y mostrar resultados
            for (int i = 0; i < datos.size(); i++) {
                Subred resultado = subredesCalculadas.get(i);
                resultado.nombre = datos.get(i).nombre;  // Asignar nombre original

                CardView card = new CardView(this);
                card.setCardElevation(8);
                card.setRadius(20);
                card.setUseCompatPadding(true);

                LinearLayout cardContent = new LinearLayout(this);
                cardContent.setOrientation(LinearLayout.VERTICAL);
                cardContent.setPadding(32, 24, 32, 24);

                TextView texto = new TextView(this);
                texto.setText("Nombre: " + resultado.nombre + "\n" +
                        "Host Requeridos: " + resultado.hosts + "\n" +
                        "Dirección de Subred: " + resultado.direccionRed + "\n" +
                        "Máscara de Subred: " + resultado.mascara + "\n" +
                        "Prefijo: /" + resultado.prefijo + "\n" +
                        "Rango asignable: " + resultado.rangoAsignable + "\n" +
                        "Broadcast: " + resultado.broadcast);
                texto.setTextSize(15f);
                texto.setTextColor(Color.BLACK);

                cardContent.addView(texto);
                card.addView(cardContent);

                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
                params.setMargins(0, 16, 0, 16);
                card.setLayoutParams(params);

                layoutResultados.addView(card);

            }
            // Acción para el botón "Nuevo Cálculo"
            findViewById(R.id.btnNuevoCalculo).setOnClickListener(view -> {
                // Ir de vuelta a la actividad principal
                Intent intent = new Intent(ResultadosActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish(); // Opcional: cierra esta pantalla para evitar volver con el botón atrás
            });

        }
    }
}



