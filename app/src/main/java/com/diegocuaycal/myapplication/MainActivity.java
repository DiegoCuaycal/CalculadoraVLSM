package com.diegocuaycal.myapplication;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.InputType;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Referencias a los elementos
    EditText editTextNetwork, editTextPrefix, editTextNumSubredes;
    Button btnCambiar, btnCalcular;
    LinearLayout layoutSubredes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Enlazar vistas
        editTextNetwork = findViewById(R.id.editTextNetwork);
        editTextPrefix = findViewById(R.id.editTextPrefix);
        editTextNumSubredes = findViewById(R.id.editTextNumSubredes);
        btnCambiar = findViewById(R.id.btnCambiar);
        btnCalcular = findViewById(R.id.buttonCalcular);
        layoutSubredes = findViewById(R.id.layoutSubredes);

        // Botón "Cambiar" para generar dinámicamente subredes
        btnCambiar.setOnClickListener(view -> {
            layoutSubredes.removeAllViews();
            String valor = editTextNumSubredes.getText().toString().trim();
            if (!valor.isEmpty()) {
                int cantidad = Integer.parseInt(valor);
                for (int i = 1; i <= cantidad; i++) {
                    TextView label = new TextView(MainActivity.this);
                    label.setText("Subred " + i);
                    label.setTypeface(null, Typeface.BOLD);
                    label.setPadding(0, 24, 0, 8);

                    EditText campoNombre = new EditText(MainActivity.this);
                    campoNombre.setHint("Nombre de subred " + i);
                    campoNombre.setInputType(InputType.TYPE_CLASS_TEXT);

                    EditText campoHost = new EditText(MainActivity.this);
                    campoHost.setHint("Tamaño host " + i);
                    campoHost.setInputType(InputType.TYPE_CLASS_NUMBER);

                    layoutSubredes.addView(label);
                    layoutSubredes.addView(campoNombre);
                    layoutSubredes.addView(campoHost);
                }
            } else {
                Toast.makeText(this, "Ingrese un número válido", Toast.LENGTH_SHORT).show();
            }
        });

        btnCalcular.setOnClickListener(view -> {
            try {
                String ip = editTextNetwork.getText().toString().trim();
                String prefijoStr = editTextPrefix.getText().toString().trim();

                if (!isValidIPv4(ip)) {
                    Toast.makeText(this, "La IP ingresada no es válida", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (prefijoStr.isEmpty()) {
                    Toast.makeText(this, "Ingresa un prefijo", Toast.LENGTH_SHORT).show();
                    return;
                }

                int prefijo = Integer.parseInt(prefijoStr);
                if (prefijo < 1 || prefijo > 32) {
                    Toast.makeText(this, "El prefijo debe estar entre 1 y 32", Toast.LENGTH_SHORT).show();
                    return;
                }

                ArrayList<String> nombres = new ArrayList<>();
                ArrayList<Integer> tamanios = new ArrayList<>();

                int childCount = layoutSubredes.getChildCount();
                for (int i = 0; i < childCount; i += 3) {
                    // i es TextView, i+1 es nombre, i+2 es tamaño

                    EditText campoNombre = (EditText) layoutSubredes.getChildAt(i + 1);
                    EditText campoTamanio = (EditText) layoutSubredes.getChildAt(i + 2);

                    String nombre = campoNombre.getText().toString().trim();
                    String tamanioStr = campoTamanio.getText().toString().trim();

                    if (nombre.isEmpty()) {
                        Toast.makeText(this, "Falta el nombre en subred " + (i / 3 + 1), Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if (tamanioStr.isEmpty()) {
                        Toast.makeText(this, "Falta el tamaño en subred " + (i / 3 + 1), Toast.LENGTH_SHORT).show();
                        return;
                    }

                    try {
                        int tamanio = Integer.parseInt(tamanioStr);
                        if (tamanio <= 0) {
                            Toast.makeText(this, "Tamaño inválido en subred " + (i / 3 + 1), Toast.LENGTH_SHORT).show();
                            return;
                        }

                        nombres.add(nombre);
                        tamanios.add(tamanio);

                    } catch (NumberFormatException e) {
                        Toast.makeText(this, "Tamaño no válido en subred " + (i / 3 + 1), Toast.LENGTH_SHORT).show();
                        return;
                    }
                }

                // Verificación de tamaños
                if (nombres.size() != tamanios.size()) {
                    Toast.makeText(this, "Error: tamaños de datos desiguales", Toast.LENGTH_LONG).show();
                    return;
                }

                // Lanzar nueva actividad
                Intent intent = new Intent(MainActivity.this, ResultadosActivity.class);
                intent.putExtra("ip", ip);
                intent.putExtra("prefijo", prefijo);
                intent.putStringArrayListExtra("nombres", nombres);
                intent.putIntegerArrayListExtra("tamanios", tamanios);
                startActivity(intent);

            } catch (Exception e) {
                Toast.makeText(this, "⚠️ Error en el cálculo: " + e.getMessage(), Toast.LENGTH_LONG).show();
                e.printStackTrace(); // También aparecerá en el Logcat
            }
        });


    }

    private boolean isValidIPv4(String ip) {
        String regex = "^((25[0-5]|2[0-4]\\d|[01]?\\d\\d?)\\.){3}(25[0-5]|2[0-4]\\d|[01]?\\d\\d?)$";
        return ip.matches(regex);
    }
}
