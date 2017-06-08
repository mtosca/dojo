var PaymentFactory = require('./payment_factory');

function Order(orderFromApi) {

    this.orderFromApi = orderFromApi
}

Order.prototype.getCurrentPayment = function() {
    return new PaymentFactory().createPayment(this.orderFromApi.payments[0])
};

module.exports = Order;