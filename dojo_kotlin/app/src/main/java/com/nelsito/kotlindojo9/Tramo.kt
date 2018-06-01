package com.nelsito.kotlindojo9

/**
 * Created by npuglisi on 12/12/17.
 */
class Tramo(val origen: Lugar, val destino: Lugar, val transporte: Transporte) {
    fun precio(): Precio {
        return transporte.precio(origen, destino)
    }
}