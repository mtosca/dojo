function Installment(_intallmentsQuantity) {
    this.installmentsQuantity = _intallmentsQuantity || 1;
}

Installment.prototype.print = function () {
    return this.installmentsQuantity + ' x $' + this.amount;
};

Installment.prototype.splitAmount = function (_amount) {
    this.amount = _amount/this.installmentsQuantity;
}

module.exports = Installment;