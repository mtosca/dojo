import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import payments.MasterCard0002;
import payments.Visa0001;
import steps.*;

/**
 * Created by R. Bevilacqua
 */
public class DojoTest {
	
	@Before
	public void setup() {

	}

	@Test
	public void cuando_EligeEnvioADomicilio_nextStepIs_SeleccionDeMedioDePago() {
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
        SeleccionDeEnvio seleccionDeEnvio = new SeleccionDeEnvio();

        CheckoutStep nextStep = seleccionDeEnvio.envioADomicilio();

        // Zeplin: https://zpl.io/br1Km7L
        Assert.assertEquals(SeleccionDeMedioDePago.class, nextStep.getClass());
	}

    @Test
    public void cuando_modificaEnvioDesdeReview_EligeEnvioADomicilio_nextStepIs_Review() {
	    // Zeplin: https://zpl.io/be48RDa
        Review review = new Review();

        SeleccionDeEnvio seleccionDeEnvio = review.modificarEnvio();

        CheckoutStep nextStep = seleccionDeEnvio.envioADomicilio();

        Assert.assertEquals(Review.class, nextStep.getClass());
    }

    @Test
    public void cuando_modificaEnvioDesdeReview_EligeEnvioASucursal_nextStepIs_SucursalDeCorreo() {
        // Zeplin: https://zpl.io/be48RDa
        Review review = new Review();

        SeleccionDeEnvio seleccionDeEnvio = review.modificarEnvio();

        // Zeplin: https://zpl.io/V10Ye52
        CheckoutStep nextStep = seleccionDeEnvio.retiroEnCorreo();

        Assert.assertEquals(MapaDeSucursales.class, nextStep.getClass());
    }
/*
    @Test
    public void cuandoSeleccionoRetiroEnCorreo_tieneQueSeleccionarAgenciaDeCorreo() {
	    SeleccionDeEnvio seleccionDeEnvio = new SeleccionDeEnvio();

	    SeleccionarAgenciaDeCorreo seleccionarAgenciaDeCorreo = (SeleccionarAgenciaDeCorreo) seleccionDeEnvio.retiroEnCorreo();

	    MapaDeSucursales mapaDeSucursales = seleccionarAgenciaDeCorreo.correoArgentino();

	    SeleccionDeMedioDePago seleccionDeMedioDePago = mapaDeSucursales.sucursalCentro();

	    Review review = seleccionDeMedioDePago.dineroEnCuenta();

	    Assert.assertEquals(Review.class, review.getClass());
    }
*/
    @Test
    public void modificoMedioDePagoDesdeReview_tarjetaPrecargada_gatewaySolicitaSecCode_VuelveReview() {
        Review review = new Review();

        SeleccionDeMedioDePago seleccionDeMedioDePago = review.modificarMedioDePago();

        SecCode secCode = (SecCode) seleccionDeMedioDePago
                .tarjetaPrecargada(new Visa0001(), new GatewayApiRequiredSecCode());

        Review review1 = secCode.acceptSecCode();

        Assert.assertEquals(Review.class, review1.getClass());
    }

    @Test
    public void modificoMedioDePagoDesdeReview_tarjetaPrecargada_gatewayVuelveReview() {
        Review review = new Review();

        SeleccionDeMedioDePago seleccionDeMedioDePago = review.modificarMedioDePago();

        MasterCard0002 masterCard0002 = new MasterCard0002();

        CheckoutStep nuevaReview = seleccionDeMedioDePago
                .tarjetaPrecargada(masterCard0002, new GatewayApiNotRequiredSecCode());

        Assert.assertEquals(Review.class, nuevaReview.getClass());
    }

    @Test
    public void modificoMedioDePagoDesdeReview_altaDeTarjeta_pideSecCode_vuelveReview() {
        Review review = new Review();

        SeleccionDeMedioDePago seleccionDeMedioDePago = review.modificarMedioDePago();

        AltaDeTarjeta altaDeTarjeta = seleccionDeMedioDePago.altaDeTarjeta();

        SecCode secCode = altaDeTarjeta.nuevaTarjeta();

        Review nuevaReview = secCode.acceptSecCode();

        Assert.assertEquals(Review.class, nuevaReview.getClass());
    }

    @Test
    public void modificoMedioDePagoDesdeReview_altaDeTarjetaConFoto_pideSecCode_vuelveReview() {
        Review review = new Review();

        SeleccionDeMedioDePago seleccionDeMedioDePago = review.modificarMedioDePago();

        AltaDeTarjeta altaDeTarjeta = seleccionDeMedioDePago.altaDeTarjeta();

        LectorQR lectorQR = altaDeTarjeta.escanearQR();

        SecCode secCode = lectorQR.nuevaTarjeta();

        Review nuevaReview = secCode.acceptSecCode();

        Assert.assertEquals(Review.class, nuevaReview.getClass());
    }

    //Selecciona un envio con costo
    //Selecciona un medio off con limite de monto
    //Review modifica envio
    //Selecciona un medio de envio con costo mayor al limite
    //Despliega inconsistencia de medio de pago
    //Vuelve a seleccion de medio de envio
}