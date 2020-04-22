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
package hundirlaflota.tablero.tipocasilla;

/**
 *
 * @author Javier Tejedor
 */
public class TipoCasilla {

    private int partesRestantes;
    private boolean tocado;
    private int tipoIndex;

    public TipoCasilla() {
        tocado = false;
        setTipoIndex();
    }

    public void setPartesRestantes(int partesRestantes) {
        this.partesRestantes = partesRestantes;
    }

    public int getPartesRestantes() {
        return partesRestantes;
    }

    public void setTipoIndex() {
        if (this instanceof Escolta) {
            tipoIndex = 1;
        } else if (this instanceof Destructor) {
            tipoIndex = 2;
        } else if (this instanceof Portaaviones) {
            tipoIndex = 3;
        } else {
            tipoIndex = 0;
        }
    }

    public int getTipoIndex() {

        return tipoIndex;
    }

    public void restarParte() {

        this.partesRestantes--;
    }

    public boolean isTocado() {
        return tocado;
    }

    public void setTocado(boolean tocado) {
        this.tocado = tocado;
    }

}
