package com.nelsito.kotlindojo9

/**
 * Created by npuglisi on 12/12/17.
 */
class Lugar(name: String, val km: Int) {
    fun distancia(destino: Lugar): Int {
        return Math.abs(destino.km - this.km)
    }
}