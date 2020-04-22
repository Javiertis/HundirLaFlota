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
package hundirlaflota.jugador;

import hundirlaflota.tablero.Casilla;
import hundirlaflota.tablero.Index;
import hundirlaflota.tablero.Tablero;

/**
 * Clase principal Jugador
 *
 * @author Javier Tejedor
 */
public class Jugador {

    private Tablero tableroPropio;
    private Tablero tableroDeJuego;

    private int barcosRestantes;

    /**
     * Numero de barcos inicales
     */
    public static final int BARCOS_INICIALES = 3;

    /**
     * Constructor especificando una instancia de la clase de objeto Tablero.
     *
     * @param tableroPropio Tablero con tus barcos.
     */
    public Jugador(Tablero tableroPropio) {
        this.tableroPropio = tableroPropio;
        this.barcosRestantes = BARCOS_INICIALES;
    }

    /**
     * Constructor sin tablero.
     */
    public Jugador() {
        this.tableroPropio = new Tablero();
        this.barcosRestantes = BARCOS_INICIALES;
    }

    /**
     * Devuelve el tablero de juego.
     *
     * @return Tablero de juego.
     */
    public Tablero getTableroDeJuego() {
        return tableroDeJuego;
    }

    /**
     * Configura el tablero de juego.
     *
     * @param tableroDeJuego
     */
    public void setTableroDeJuego(Tablero tableroDeJuego) {
        this.tableroDeJuego = tableroDeJuego;
    }

    /**
     * Devuelve el tablero propio.
     *
     * @return Tablero propio.
     */
    public Tablero getTableroPropio() {
        return tableroPropio;
    }

    /**
     * Configura el tablero propio.
     *
     * @param tableroPropio
     */
    public void setTableroPropio(Tablero tableroPropio) {
        this.tableroPropio = tableroPropio;
    }

    /**
     *
     * @return Los barcos restantes del jugador.
     */
    public int getBarcosRestantes() {
        return barcosRestantes;
    }

    /**
     * Configura los barcos restantes del jugador.
     *
     * @param barcosRestantes
     */
    public void setBarcosRestantes(int barcosRestantes) {
        this.barcosRestantes = barcosRestantes;
    }

    /**
     * Cambia el estado de una casilla y resta una parte a aquellas casillas
     * cuyo tipo sea igual.
     *
     * @param pos Posición de la casilla.
     */
    public void cambiarEstadoCasilla(int[] pos) {
        this.tableroDeJuego.get(new Index(pos)).getTipo().setTocado(true);
        for (Casilla casilla : this.tableroPropio.values()) {
            if (casilla.getTipo().getTipoIndex() == this.tableroDeJuego.get(new Index(pos)).getTipo().getTipoIndex()) {
                this.tableroDeJuego.get(new Index(pos)).getTipo().restarParte();
            }
        }
    }

}
