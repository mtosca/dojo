package com.mercadolibre.dojos;

public class Micro extends Transporte {

    public Micro() {
        super(new Precio(2.1625));
    }

    public Micro(Precio precio) {
        super(precio);
    }
}
