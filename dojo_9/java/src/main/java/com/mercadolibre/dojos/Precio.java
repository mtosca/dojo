package com.mercadolibre.dojos;

public class Precio {
    private Double monto;

    public Precio(double monto) {
        this.monto = monto;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass().equals(this.getClass())) {
            return this.monto.intValue() == ((Precio) obj).monto.intValue();
        } else {
            return false;
        }
    }

    public Precio plus(Precio precio) {
        this.monto += precio.monto;
        return this;
    }

    public Precio multiply(double factor) {
        this.monto *= factor;
        return this;
    }

    @Override
    public String toString() {
        return String.valueOf(monto.intValue());
    }
}
