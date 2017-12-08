const Price = require('./price.js');

function Journey() {
    this.costByKm = 2;
}

Journey.prototype.costForSection = function (_section) {
    return new Price(_section.travelDistance() * this.costByKm);
};

module.exports = Journey;