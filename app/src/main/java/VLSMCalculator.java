package com.diegocuaycal.myapplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import com.diegocuaycal.myapplication.Subred;


public class VLSMCalculator {

    private int redPrincipal;
    private int prefijo;
    public ArrayList<Subred> subredes;

    public VLSMCalculator(String redPrincipal, int prefijo) {
        this.redPrincipal = ipToInt(redPrincipal);
        this.prefijo = prefijo;
        this.subredes = new ArrayList<>();
    }

    public static ArrayList<Subred> calcularSubredes(String ipBase, int prefijoBase, ArrayList<String> nombres, ArrayList<Integer> tamanios) {
        ArrayList<Subred> resultado = new ArrayList<>();

        // Ordenar de mayor a menor tamaño
        ArrayList<SubredTemp> subredesTemp = new ArrayList<>();
        for (int i = 0; i < nombres.size(); i++) {
            subredesTemp.add(new SubredTemp(nombres.get(i), tamanios.get(i)));
        }

        Collections.sort(subredesTemp, (a, b) -> b.hosts - a.hosts);

        int redBase = ipToInt(ipBase);

        for (SubredTemp temp : subredesTemp) {
            int bits = (int) Math.ceil(Math.log(temp.hosts + 2) / Math.log(2));
            int prefijo = 32 - bits;

            if (prefijo < prefijoBase) break;

            int mascara = (int) (0xFFFFFFFF << (32 - prefijo));
            int direccionRed = redBase & mascara;
            int direccionPrimera = direccionRed + 1;
            int direccionUltima = direccionRed + (int) Math.pow(2, bits) - 2;
            int broadcast = direccionUltima + 1;

            String rango = intToIp(direccionPrimera) + " - " + intToIp(direccionUltima);

            Subred subred = new Subred(
                    temp.nombre,
                    temp.hosts,
                    intToIp(direccionRed),
                    intToIp(mascara),
                    prefijo,
                    rango,
                    intToIp(broadcast)
            );

            resultado.add(subred);

            // Avanzar a la siguiente red
            redBase = direccionRed + (int) Math.pow(2, bits);
        }

        return resultado;
    }

    private static int ipToInt(String ip) {
        String[] partes = ip.split("\\.");
        return (Integer.parseInt(partes[0]) << 24) |
                (Integer.parseInt(partes[1]) << 16) |
                (Integer.parseInt(partes[2]) << 8) |
                Integer.parseInt(partes[3]);
    }

    private static String intToIp(int num) {
        return ((num >> 24) & 255) + "." +
                ((num >> 16) & 255) + "." +
                ((num >> 8) & 255) + "." +
                (num & 255);
    }

    private static class SubredTemp {
        String nombre;
        int hosts;

        SubredTemp(String nombre, int hosts) {
            this.nombre = nombre;
            this.hosts = hosts;
        }
    }
}
