function Price(_amount) {
    this.amount = _amount;
}

Price.prototype.equals = function (otherPrice) {
    return this.amount == otherPrice.amount;
};

Price.prototype.sum = function (otherPrice) {
    return new Price(this.amount + otherPrice.amount);
};

Price.prototype.applyDiscount = function (discount) {
    return new Price(this.amount - (this.amount * discount));
};

Price.prototype.applyIncrement = function (discount) {
    return new Price(this.amount + (this.amount * discount));
};

module.exports = Price;