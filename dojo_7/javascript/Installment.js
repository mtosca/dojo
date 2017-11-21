function Installment(_intallmentsQuantity) {
    this.installmentsQuantity = _intallmentsQuantity || 1;
}

Installment.prototype.print = function (_amount) {
    return this.installmentsQuantity + ' x $' + _amount/this.installmentsQuantity;
};

/*Installment.prototype.splitAmount = function (_amount) {
    this.amount = _amount/this.installmentsQuantity;
}*/

module.exports = Installment;