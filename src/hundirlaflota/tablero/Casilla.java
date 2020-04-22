/*
 * Copyright (C) 2020 Javier Tejedor
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package hundirlaflota.tablero;

import hundirlaflota.tablero.tipocasilla.Destructor;
import hundirlaflota.tablero.tipocasilla.Escolta;
import hundirlaflota.tablero.tipocasilla.Portaaviones;
import hundirlaflota.tablero.tipocasilla.TipoCasilla;
import java.awt.Color;

/**
 *
 * @author Javier Tejedor
 */
public class Casilla implements Comparable<Casilla> {

    public static final Color COLOR_IMPACTADA = new Color(255, 0, 0);
    public static final Color COLOR_BARCO3 = new Color(0, 0, 0);
    public static final Color COLOR_BARCO1 = new Color(26, 26, 26);
    public static final Color COLOR_VACIA = new Color(102, 207, 255);
    public static final Color COLOR_ATACADA = new Color(253, 191, 70);
    public static final Color COLOR_BARCO2 = new Color(140, 140, 140);
    public static int FILA_MAX = 7;
    public static int FILA_MIN = 0;
    public static int COLUMNA_MAX = 7;
    public static int COLUMNA_MIN = 0;

    private int fila;
    private int columna;
    private TipoCasilla tipo;

    public Casilla(int fila, int columna, TipoCasilla tipo) {
        this.fila = fila;
        this.columna = columna;
        this.tipo = tipo;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(char columna) {
        this.columna = columna;
    }

    public TipoCasilla getTipo() {
        return tipo;
    }

    public void setTipo(TipoCasilla tipo) {
        this.tipo = tipo;
    }

    public boolean tieneBarco() {
        return this.tipo instanceof Escolta || this.tipo instanceof Destructor || this.tipo instanceof Portaaviones;

    }

    public boolean esValida(Tablero t) {
        for (int i = fila - 1 < FILA_MIN ? FILA_MIN : fila - 1; i <= (fila + 1 >= FILA_MAX ? fila : fila + 1); i++) {
            for (int j = columna - 1 < COLUMNA_MIN ? COLUMNA_MIN : columna - 1; j <= (columna + 1 >= COLUMNA_MAX ? columna : columna + 1); j++) {
                if (t.get(new Index(new int[]{i, j})).tieneBarco()) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public int compareTo(Casilla t) {
        return this.columna == t.columna && this.fila == t.fila ? 0 : 1;
    }

}
