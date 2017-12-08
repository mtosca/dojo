function Price(_amount) {
    this.amount = _amount;
}

Price.prototype.equals = function (otherPrice) {
    return this.amount == otherPrice.amount;
};

Price.prototype.sum = function (otherPrice) {
    return new Price(this.amount + otherPrice.amount);
};

module.exports = Price;