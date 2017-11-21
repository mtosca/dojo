function AccountMoney(_balance) {

    this.balance = _balance;
}

AccountMoney.prototype.name = function () {
    return 'Dinero en cuenta';
};

AccountMoney.prototype.printNameAndAmount = function () {
    return this.name() + ': $' + this.contributesWith();
};

AccountMoney.prototype.contributesWith = function (_amount) {
    return Math.min(_amount, this.balance);
};

AccountMoney.prototype.compare = function (a, b) {
    return -1
};

module.exports = AccountMoney;