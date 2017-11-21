const Installment = require('./Installment.js');

function CreditCard(_selectedInstallment) {

    this.selectedInstallment =  _selectedInstallment || new Installment();
}

CreditCard.prototype.name = function () {
    return 'Tarjeta de crédito';
};

CreditCard.prototype.printNameAndAmount = function () {
    return this.name() + ': ' + this.selectedInstallment.print(this.amount);
};

CreditCard.prototype.contributesWith = function (_amount) {
    return _amount;
};

CreditCard.prototype.compare = function (a, b) {
    return 1
}

module.exports = CreditCard;