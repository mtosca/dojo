import { expect } from 'chai';

import SeleccionDeEnvio from '../src/pasos/SeleccionDeEnvio';
import SeleccionDeMedioDePago from '../src/pasos/SeleccionDeMedioDePago';
import MapaDeSucursales from '../src/pasos/MapaDeSucursales';
import Review from '../src/pasos/Review';


describe("Dojo 11", () => {
    it('cuando se selecciona envio a domicilio el proximo paso debería ser seleccion de medio de pago', () => {
        // Con Precargadas y Dinero En Cuenta o Tarjeta Precargada
        // Paso 1 -> Selecciona Express a Domicilio
        // Paso 2 -> ¿Como quieres pagar? -> Dinero en Cuenta
        // Paso 3 -> Review -> Modificar Envio
        // Paso 4 -> Selecciona Retiro en Sucursal
        // Paso 5 -> Selecciona Sucursal
        // Paso 6 -> Review

        // Paso 1 -> ¿Como queres recibir el producto? 00_01 -> Enviar a mi ubicacion actual
        // Paso 2 -> Envio a Villa Urquiza 01_01
        // Zeplin: https://zpl.io/25zKgWV
        const seleccionDeEnvio = new SeleccionDeEnvio(false);
        const proximoPaso = seleccionDeEnvio.envioADomicilio();

        // Zeplin: https://zpl.io/br1Km7L
        expect(proximoPaso instanceof SeleccionDeMedioDePago).to.be.true;
    });

    it('cuando se selecciona envio a domicilio desde la review el proximo paso debería ser review', () => {
        const review = new Review();

        const seleccionDeEnvio = review.modificarEnvio();

        const proximoPaso = seleccionDeEnvio.envioADomicilio();

        expect(proximoPaso instanceof Review).to.be.true;
    });

    it('cuando se selecciona envio a sucursal desde la review el proximo paso debería ser SucursalDeCorreo', () => {
        // Zeplin: https://zpl.io/be48RDa
        const review = new Review();

        const seleccionDeEnvio = review.modificarEnvio();

        // Zeplin: https://zpl.io/V10Ye52
        const proximoPaso = seleccionDeEnvio.retiroEnCorreo();

        expect(proximoPaso instanceof MapaDeSucursales).to.be.true;
    });
});


