package com.nelsito.kotlindojo9

/**
 * Created by npuglisi on 12/12/17.
 */
abstract class Transporte(val precioPorKM: Precio) {
    fun precio(origen: Lugar, destino: Lugar): Precio {
        return precioPorKM.multiply(origen.distancia(destino))
    }
}