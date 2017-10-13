package com.mercadolibre.dojos;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests for the dojo.
 */
public class DojoTest {

	@Before
	public void setup() {
	}

	@Test
	public void pagoUnaOrden_ConDineroEnCuenta_ObtengoMetodoPagoYTotal() {
		Order order = new Order(new Amount(1350f));

		order.payWith(new AccountMoney(new Amount(1350f)));

		assertEquals("Dinero en Cuenta: $ 1350", order.printPaymentDetails());
	}

	@Test
	public void pagoUnaOrden_ConDineroEnCuentaConBalanceQueExcede_ObtengoMetodoPagoYTotal() {
		Order order = new Order(new Amount(2000f));

		order.payWith(new AccountMoney(new Amount(1350f)));

		assertEquals("Dinero en Cuenta: $ 1350", order.printPaymentDetails());
	}

	@Test
	public void pagoUnaOrden_ConTarjetaDeCredito_ConUnaCuota_ObtengoMetodoPagoYTotal() {
		Order order = new Order(new Amount(1350f));

		order.payWith(new CreditCard());

		assertEquals("Tarjeta de Credito (1 cuota): $ 1350", order.printPaymentDetails());
	}

	@Test
	public void pagoUnaOrden_ConTarjetaDeCredito_ConDosCuotas_ObtengoMetodoPagoYTotal() {
		Order order = new Order(new Amount(1350f));

		order.payWith(new CreditCard(new Installments(2)));

		assertEquals("Tarjeta de Credito (2 cuotas): $ 675", order.printPaymentDetails());
	}

	@Test
	public void pagoUnaOrden_ConEnvioADomicilio_ConTarjetaDeCredito_ConDosCuotas_ObtengoMetodoPagoYTotal() {
		Order order = new Order(new Amount(1350f));

		order.shipWith(new MercadoEnvio(new Amount(150f)));

		order.payWith(new CreditCard(new Installments(2)));

		assertEquals("Tarjeta de Credito (2 cuotas): $ 750", order.printPaymentDetails());
	}

	@Test
	public void pagoUnaOrden_ConTarjetaDeCredito_ConDosCuotasConInteres_ObtengoMetodoPagoYTotal() {
		Order order = new Order(new Amount(1350f));

		order.payWith(new CreditCard(new InstallmentsWithInterest(2, 0.1)));

		assertEquals("Tarjeta de Credito (2 cuotas): $ 743", order.printPaymentDetails());
	}

	@Test
	public void pagoUnaOrden_ConDineroEnCuenta_CombinadoConTarjetaDeCredito_ConDosCuotas_ObtengoMetodoPagoYTotal() {
		Order order = new Order(new Amount(1350f));
		order.payWith(new AccountMoney(new Amount(800f)));
		order.payWith(new CreditCard(new Installments(2)));

		assertEquals("Dinero en Cuenta: $ 800 - Tarjeta de Credito (2 cuotas): $ 275", order.printPaymentDetails());
	}

	@Test
	public void pagoUnaOrden_ConDineroEnCuenta_CombinadoConTarjetaDeCreditoConLimite_ConDosCuotas_ObtengoMetodoPagoYTotal() {
		Order order = new Order(new Amount(1350f));
		order.payWith(new AccountMoney(new Amount(625f)));
		order.payWith(new CreditCardWithLimit(new CreditCard(new Installments(2)), new Amount(500f)));
		order.payWith(new CreditCard(new Installments(3)));

		assertEquals("Dinero en Cuenta: $ 625 - Tarjeta de Credito (2 cuotas): $ 250 - Tarjeta de Credito (3 cuotas): $ 75", order.printPaymentDetails());
	}

	@Test
	public void pagoUnaOrden_ConDineroEnCuenta_CombinadoConTarjetaDeCredito_ConDosCuotas_CambioElEnvio_ObtengoMetodoPagoYNuevoTotal() {
		Order order = new Order(new Amount(1350f));
		order.payWith(new AccountMoney(new Amount(800f)));
		order.payWith(new CreditCard(new Installments(2)));

		assertEquals("Dinero en Cuenta: $ 800 - Tarjeta de Credito (2 cuotas): $ 275", order.printPaymentDetails());

		order.shipWith(new MercadoEnvio(new Amount(150f)));

		assertEquals("Dinero en Cuenta: $ 800 - Tarjeta de Credito (2 cuotas): $ 350", order.printPaymentDetails());
	}

	@Test
	public void pagoUnaOrden_ConTarjetaDeCredito_ConDosCuotas_CombinadoConDineroEnCuenta_ObtengoMetodoPagoYTotal() {
		Order order = new Order(new Amount(1350f));
		order.payWith(new CreditCard(new Installments(2)));
		order.payWith(new AccountMoney(new Amount(800f)));

		assertEquals("Dinero en Cuenta: $ 800 - Tarjeta de Credito (2 cuotas): $ 275", order.printPaymentDetails());
	}

	@Test
	public void pagoUnaOrden_ConTarjetaDeCredito_ConDosCuotas_CombinadoConDineroEnCuentaYGiftcard_ObtengoMetodoPagoYTotal() {
		Order order = new Order(new Amount(1350f));
		order.payWith(new CreditCard(new Installments(2)));
		order.payWith(new AccountMoney(new Amount(800f)));
		order.payWith(new GiftCard(new Amount(100f)));

		assertEquals("Dinero en Cuenta: $ 800 - Giftcard: $100 - Tarjeta de Credito (2 cuotas): $ 225", order.printPaymentDetails());
	}
}
