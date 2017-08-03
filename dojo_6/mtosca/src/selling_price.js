function SellingPrice(value) {

    this.value = value;
}

SellingPrice.prototype.subtract = function (valueToSubtract) {
    return this.value - valueToSubtract.value;
};

module.exports = SellingPrice;