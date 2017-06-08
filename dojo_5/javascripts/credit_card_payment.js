var CreditCardHeading = require('./credit_card_title');
var CreditCardTitle = require('./credit_card_title');

function CreditCardPayment() {

}

CreditCardPayment.prototype.getHeading = function() {
    return new CreditCardHeading();
};

CreditCardPayment.prototype.getTitle = function () {
    return new CreditCardTitle();
};

module.exports = CreditCardPayment;