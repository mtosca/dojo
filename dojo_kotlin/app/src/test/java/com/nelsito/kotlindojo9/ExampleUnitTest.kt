package com.nelsito.kotlindojo9

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun unViaje_desdeBsAS_hastaMDQ_enMicro_vale865() {
        val tramo = Tramo(
                Lugar("BsAs", 0),
                Lugar("MDQ", 400),
                Micro())
        val viaje = Viaje(tramo)

        assertEquals(Precio(865.0), viaje.precio())
    }

    @Test
    fun unViaje_desdeBsAS_hastaMDQ_enTren_vale465() {
        val tramo = Tramo(
                Lugar("BsAs", 0),
                Lugar("MDQ", 400),
                Tren())
        val viaje = Viaje(tramo)

        assertEquals(Precio(465.0), viaje.precio())
    }

    @Test
    fun unViaje_desdeTrelew_hastaBsAs_enMicro_vale3027() {
        val tramo = Tramo(
                Lugar("Trelew", 1400),
                Lugar("BsAs", 0),
                Micro())
        val viaje = Viaje(tramo)

        assertEquals(Precio(3027.5), viaje.precio())
    }


    @Test
    fun unViaje_desdeTrelew_hastaBsAs_pasandoPorBahiaBlanca_enMicro_vale4000() {
        val tramo1 = Tramo(
                Lugar("Trelew", 1400),
                Lugar("BahiaBlanca", 770),
                Micro())
        val tramo2 = Tramo(
                Lugar("BahiaBlanca", 770),
                Lugar("BsAs", 0),
                Micro())
        val viaje = Viaje(tramo1, tramo2)

        assertEquals(Precio(3027.5), viaje.precio())
    }

    @Test
    fun unViaje_desdeTrelew_hastaBsAs_pasandoPorBahiaBlanca_enMicrosDeDistintosPrecios_vale4000() {
        val tramo1 = Tramo(
                Lugar("Trelew", 1400),
                Lugar("BahiaBlanca", 770),
                Micro())
        val tramo2 = Tramo(
                Lugar("BahiaBlanca", 770),
                Lugar("BsAs", 0),
                Micro(Precio(8.0)))
        val viaje = Viaje(tramo1, tramo2)

        assertEquals(Precio(7522.375), viaje.precio())
    }
}
