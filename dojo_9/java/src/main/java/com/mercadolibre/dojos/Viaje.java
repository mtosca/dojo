package com.mercadolibre.dojos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Viaje {
    private List<Tramo> tramos = new ArrayList();

    public Viaje(Tramo... tramos) {
        this.tramos = Arrays.asList(tramos);
    }

    public Precio precio() {
        Precio precio = this.tramos
                .stream()
                .map(tramo -> tramo.precio())
                .reduce(
                    new Precio(0), (precio1, precio2) -> {
                        return precio1.plus(precio2);
                    });

        return precio;
    }
}
