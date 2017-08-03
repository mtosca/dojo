
function BuyingCost(value) {

    this.value = value;
}

BuyingCost.prototype.subtract = function (costToSubtract) {
    return this.value - costToSubtract.value;
};

module.exports = BuyingCost;