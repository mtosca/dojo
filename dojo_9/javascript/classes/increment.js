
function Increment(_percentage, _conditions) {
    this.value = _percentage / 100;
    this.conditions = _conditions;
}

Increment.prototype.applies = function (_journey) {
    return this.conditions.every((c) => c.applies(_journey));
};

Increment.prototype.applyToJourney = function (_journey) {

    let salePrice = _journey.salePrice();

    // ALTERNATIVE 1
    return salePrice.applyIncrement(this.value);

    // ALTERNATIVE 2
    //return this.applies(_journey) ? salePrice.applyIncrement(this.value) : salePrice;
};

module.exports = Increment;