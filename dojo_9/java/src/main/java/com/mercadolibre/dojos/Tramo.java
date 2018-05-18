package com.mercadolibre.dojos;

public class Tramo {
    private final Transporte transporte;
    private final Lugar destino;
    private final Lugar origen;

    public Tramo(Lugar origen, Lugar destino, Transporte transporte) {
        this.transporte = transporte;
        this.origen = origen;
        this.destino = destino;
    }

    public Precio precio() {
        return transporte.precio(origen, destino);
    }
}
