const Price = require('./price.js');

function Train() {
    this.costByKm = 2;
}

Train.prototype.costForSection = function (_section) {
    return new Price(_section.travelDistance() * this.costByKm);
};

Train.prototype.salePriceForSection = function (_section) {
    let cost = _section.travelDistance() * this.costByKm;
    let earningValue = cost * this.earningDifference;

    return new Price(cost + earningValue);
};

module.exports = Train;