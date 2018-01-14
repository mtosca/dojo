const Price = require('./price.js');

function Bus() {

    this.earningDifference = 0.1;
    this.costByKm = 3;
}

Bus.prototype.costForSection = function (_section) {
    return new Price(_section.travelDistance() * this.costByKm);
};

Bus.prototype.salePriceForSection = function (_section) {
    let cost = _section.travelDistance() * this.costByKm;
    let earningValue = cost * this.earningDifference;

    return new Price(cost + earningValue);
};

module.exports = Bus;