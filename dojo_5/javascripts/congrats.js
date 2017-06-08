
var Header = require('./header');
var Order = require('./order');

function Congrats(orderFromApi) {
    this.orderFromApi = orderFromApi;
}

Congrats.prototype.asJSON = function() {
    var order = new Order(this.orderFromApi);
    return new Header().asJSON(order.getCurrentPayment());
};

module.exports = Congrats;