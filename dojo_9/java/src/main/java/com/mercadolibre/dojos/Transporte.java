package com.mercadolibre.dojos;

public abstract class Transporte {
    private final Precio precioPorKM;

    public Transporte(Precio precioPorKM) {
        this.precioPorKM = precioPorKM;
    }

    public Precio precio(Lugar origen, Lugar destino) {
        return precioPorKM.multiply(origen.distancia(destino));
    }
}
