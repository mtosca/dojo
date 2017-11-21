const AgreeWithSeller = require('./AgreeWithSeller.js');

function Order(_amount, _shipment) {

    this.amount = _amount;
    this.paymentList = [];
    this.shipment = _shipment || new AgreeWithSeller();

}

Order.prototype.printPaymentMessage = function () {

    return this.paymentList.map(function(payment) {
        return payment.printNameAndAmount();
    }).join(' - ');
};

Order.prototype.payWith = function (payment) {

    let that = this;
    this.paymentList.push(payment);

    this.paymentList.sort(function (a, b) {
        return a.compare(b);
    });

    this.paymentList.forEach( function (p) {
        p.contributesWith(that.remaining());
    });
};

Order.prototype.payWithList = function (paymentList) {

    paymentList.forEach(p => this.payWith(p));
};

Order.prototype.totalCost = function () {
    return this.amount + this.shipment.cost;
};

Order.prototype.remaining = function () {
    return this.totalCost() - this.paid();
};

Order.prototype.paid = function () {
    let sum = 0;
    this.paymentList.forEach(function (payment) {
        sum += payment.contributesWith();
    });
    return sum;
};

module.exports = Order;