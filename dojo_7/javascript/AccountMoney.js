function AccountMoney(_balance) {

    this.balance = _balance;
}

AccountMoney.prototype.paidAmount = function () {
    return this.amount;
};

AccountMoney.prototype.name = function () {
    return 'Dinero en cuenta';
};

AccountMoney.prototype.printNameAndAmount = function () {
    return this.name() + ': $' + this.paidAmount();
};

AccountMoney.prototype.contributesWith = function (_amount) {
    return this.amount = _amount;
};

module.exports = AccountMoney;