function GiftCard(_balance) {
    this.balance = _balance;
};

GiftCard.prototype.name = function () {
    return 'Gift Card';
};

GiftCard.prototype.printNameAndAmount = function () {
    return this.name() + ': $' + this.contributesWith();
};

GiftCard.prototype.contributesWith = function (_amount) {
    return Math.min(_amount, this.balance);
};

GiftCard.prototype.compare = function (a, b) {
    return -1
};

module.exports = GiftCard;
