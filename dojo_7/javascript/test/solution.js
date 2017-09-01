const chai = require('chai');
const Order = require('../Order.js');
const AccountMoney = require('../AccountMoney.js');
const CreditCard = require('../CreditCard.js');
const Installment = require('../Installment.js');
const CustomShipment = require('../CustomShipment.js');

describe("checkout", () => {

    describe("dummy", function() {

        it("should print payment with account money for an order", () => {

            let order = new Order(1350);

            let accountMoney = new AccountMoney(4000);

            order.payWith(accountMoney);

            chai.assert.equal(order.printPaymentMessage(), 'Dinero en cuenta: $1350');
        });

        it("should print payment with credit card and one installment for an order", () => {

            let order = new Order(1350);

            let creditCard = new CreditCard();

            order.payWith(creditCard);

            chai.assert.equal(order.printPaymentMessage(), 'Tarjeta de crédito: 1 x $1350');
        });

        it("should print payment with credit card and two installments for an order", () => {

            let order = new Order(1350);

            let creditCard = new CreditCard(new Installment(2));

            order.payWith(creditCard);

            chai.assert.equal(order.printPaymentMessage(), 'Tarjeta de crédito: 2 x $675');
        });

        it("should print payment with credit card and two installments for an order with custom shipment", () => {

            let order = new Order(1000, new CustomShipment(350));

            let creditCard = new CreditCard(new Installment(2));

            order.payWith(creditCard);

            chai.assert.equal(order.printPaymentMessage(), 'Tarjeta de crédito: 2 x $675');
        });

        /*it("should pay an order with credit card and account money", () => {

            Order order = new Order(1000);

            order.addPayment(new CreditCardPayment(900));
            order.addPayment(new AccountMoney(100));

            chai.assert.equal(order.isPaid(), true);
        });*/
    });
});
