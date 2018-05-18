package com.nelsito.kotlindojo9

/**
 * Created by npuglisi on 12/12/17.
 */
class Precio(var monto: Double) {
    fun plus(precio: Precio): Precio {
        this.monto = this.monto.plus(precio.monto)
        return this
    }
    fun multiply(factor: Int): Precio {
        this.monto = monto.times(factor)
        return this
    }

    override fun toString(): String {
        return monto.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (other === this) return true
        if (other?.javaClass != javaClass) return false
        other as Precio
        return other.monto.toInt().equals(this.monto.toInt())
    }
}