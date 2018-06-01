package com.mercadolibre.dojos;


import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;

/**
 * Tests for the dojo.
 */
public class DojoTest {

    @Test
    public void unViaje_desdeBsAS_hastaMDQ_enMicro_vale865() {
        Tramo tramo = new Tramo(
                new Lugar("BsAs", 0),
                new Lugar("MDQ", 400),
                new Micro());
        Viaje viaje = new Viaje(tramo);

        Assert.assertEquals(new Precio(865), viaje.precio());
    }

    @Test
    public void unViaje_desdeBsAS_hastaMDQ_enTren_vale465() {
        Tramo tramo = new Tramo(
                new Lugar("BsAs", 0),
                new Lugar("MDQ", 400),
                new Tren());
        Viaje viaje = new Viaje(tramo);

        Assert.assertEquals(new Precio(465), viaje.precio());
    }

    @Test
    public void unViaje_desdeTrelew_hastaBsAs_enMicro_vale2000() {
        Tramo tramo = new Tramo(
                new Lugar("Trelew", 1400),
                new Lugar("BsAs", 0),
                new Micro());
        Viaje viaje = new Viaje(tramo);

        Assert.assertEquals(new Precio(3027), viaje.precio());
    }

    @Test
    public void unViaje_desdeTrelew_hastaBsAs_pasandoPorBahiaBlanca_enMicro_vale4000() {
        Tramo tramo1 = new Tramo(
                new Lugar("Trelew", 1400),
                new Lugar("BahiaBlanca", 770),
                new Micro());
        Tramo tramo2 = new Tramo(
                new Lugar("BahiaBlanca", 770),
                new Lugar("BsAs", 0),
                new Micro());
        Viaje viaje = new Viaje(tramo1, tramo2);

        Assert.assertEquals(new Precio(3027), viaje.precio());
    }

    //nuevos casos

    @Test
    public void unViaje_desdeTrelew_hastaBsAs_pasandoPorBahiaBlanca_enMicrosDeDistintosPrecios_vale4000() {
        Tramo tramo1 = new Tramo(
                new Lugar("Trelew", 1400),
                new Lugar("BahiaBlanca", 770),
                new Micro());
        Tramo tramo2 = new Tramo(
                new Lugar("BahiaBlanca", 770),
                new Lugar("BsAs", 0),
                new Micro(new Precio(8)));
        Viaje viaje = new Viaje(tramo1, tramo2);

        Assert.assertEquals(new Precio(7522), viaje.precio());
    }
}