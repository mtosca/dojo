package com.mercadolibre.dojos;

public class Lugar {
    private final int km;

    public Lugar(String name, int km) {
        this.km = km;
    }

    public int distancia(Lugar destino) {
        return Math.abs(destino.km - this.km);
    }
}
