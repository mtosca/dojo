import PasoDeCheckout from './PasoDeCheckout';

import SeleccionDeMedioDePago from '../pasos/SeleccionDeMedioDePago';
import MapaDeSucursales from '../pasos/MapaDeSucursales';
import Review from './Review';

class SeleccionDeEnvio extends PasoDeCheckout {
    constructor(editMode) {
        super(editMode);
    }

    envioADomicilio() {
        if (!this.editMode) {
            return new SeleccionDeMedioDePago();
        } else {
            return new Review();
        }
    }

    retiroEnCorreo() {
        return new MapaDeSucursales();
    }
}

export default SeleccionDeEnvio;