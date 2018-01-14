
function Discount(_percentage, _conditions) {
    this.value = _percentage / 100;
    this.conditions = _conditions;
}

Discount.prototype.applies = function (_journey) {
    return this.conditions.every((c) => c.applies(_journey));
};

Discount.prototype.applyToJourney = function (_journey) {

    let salePrice = _journey.salePrice();

    // ALTERNATIVE 1
    return salePrice.applyDiscount(this.value);

    // ALTERNATIVE 2
    //return this.applies(_journey) ? salePrice.applyDiscount(this.value) : salePrice;
};

module.exports = Discount;