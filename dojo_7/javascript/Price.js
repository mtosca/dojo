function Price(_value) {
    this.value = _value || 0;
}

Price.prototype.print = function () {
    return '$' + this.value;
};

module.exports = Price;