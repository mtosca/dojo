const Installment = require('./Installment.js');

function CreditCard(_selectedInstallment) {

    this.selectedInstallment =  _selectedInstallment || new Installment();
}

CreditCard.prototype.paidAmount = function () {
    return this.amount;
};

CreditCard.prototype.name = function () {
    return 'Tarjeta de crédito';
};

CreditCard.prototype.printNameAndAmount = function () {
    return this.name() + ': ' + this.selectedInstallment.print();
};

CreditCard.prototype.contributesWith = function (_amount) {
    this.selectedInstallment.splitAmount(_amount);
};

module.exports = CreditCard;