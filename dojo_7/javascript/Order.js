const AgreeWithSeller = require('./AgreeWithSeller.js');

function Order(_amount, _shipment) {

    this.amount = _amount;
    this.paidAmount = 0;
    this.paymentList = [];
    this.shipment = _shipment || new AgreeWithSeller();

}

Order.prototype.printPaymentMessage = function () {
    let payment = this.paymentList[0];
    //return payment.name() + ': ' + payment.paidAmount();
    return payment.printNameAndAmount();
}

Order.prototype.payWith = function (payment) {
    let totalCost = this.amount + this.shipment.cost;

    // esto genera que los objetos sean stateful,
    // se puede evitar y que el payment solamente resuelva el mensaje sin mantener el monto.
    payment.contributesWith(totalCost);
    this.paymentList.push(payment);
};

/*Order.prototype.isPaid = function () {
    return this.amount - this.paidAmount == 0;
};*/

module.exports = Order;