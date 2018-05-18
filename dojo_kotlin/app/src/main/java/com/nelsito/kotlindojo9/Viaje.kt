package com.nelsito.kotlindojo9

class Viaje(vararg val tramo: Tramo) {
    fun precio(): Precio {
        return tramo
            .map { t -> t.precio() }
            .reduce {
                precio1, precio2 -> precio1.plus(precio2)
            }
    }
}