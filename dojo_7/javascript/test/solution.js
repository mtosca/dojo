const chai = require('chai');
const Order = require('../Order.js');
const AccountMoney = require('../AccountMoney.js');
const CreditCard = require('../CreditCard.js');
const Installment = require('../Installment.js');
const CustomShipment = require('../CustomShipment.js');
const GiftCard = require('../GiftCard.js');

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

        it("should pay an order first with account money and then with credit card", () => {

            let order = new Order(1000, new CustomShipment(350));

            order.payWith(new AccountMoney(100 /* account balance */));
            order.payWith(new CreditCard(new Installment(2)));

            chai.assert.equal(order.printPaymentMessage(), 'Dinero en cuenta: $100 - Tarjeta de crédito: 2 x $625');
        });

        it("should pay an order first with account money and then with credit card as an array", () => {

            let order = new Order(1000, new CustomShipment(350));

            order.payWithList([new AccountMoney(100 /* account balance */), new CreditCard(new Installment(2))]);

            chai.assert.equal(order.printPaymentMessage(), 'Dinero en cuenta: $100 - Tarjeta de crédito: 2 x $625');
        });

        it("should pay an order first with credit card and then with account money", () => {

            let order = new Order(1000, new CustomShipment(350));

            order.payWith(new CreditCard(new Installment(2)));
            order.payWith(new AccountMoney(100 /* account balance */));

            chai.assert.equal(order.printPaymentMessage(), 'Dinero en cuenta: $100 - Tarjeta de crédito: 2 x $625');
        });

        it("should pay an order with a gift card", () => {

            let order = new Order(1000, new CustomShipment(350));

            order.payWith(new GiftCard(1350 /* gift card balance */));

            chai.assert.equal(order.printPaymentMessage(), 'Gift Card: $1350');
        });

        it("should pay an order with account money and using a gift card", () => {

            let order = new Order(1000, new CustomShipment(350));

            order.payWith(new AccountMoney(100 /* gift card balance */));
            order.payWith(new GiftCard(1350 /* gift card balance */));

            chai.assert.equal(order.printPaymentMessage(), 'Dinero en cuenta: $100 - Gift Card: $1250');
        });

        it("should pay an order with account money exceeding the cost with the balance and using a gift card", () => {

            let order = new Order(1000, new CustomShipment(350));

            order.payWith(new AccountMoney(2000 /* gift card balance */));
            order.payWith(new GiftCard(350 /* gift card balance */));

            chai.assert.equal(order.printPaymentMessage(), 'Dinero en cuenta: $1350');
        });
    });
});
