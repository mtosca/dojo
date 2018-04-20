import SeleccionDeEnvio from './SeleccionDeEnvio';
import PasoDeCheckout from './PasoDeCheckout';

class Review extends PasoDeCheckout {
    constructor() {
        super();
    }

    modificarEnvio() {
        return new SeleccionDeEnvio(true);
    }
}

export default Review;