const Price = require('./price.js');

function Bus() {

    this.costByKm = 3;
}

Bus.prototype.costForSection = function (_section) {
    return new Price(_section.travelDistance() * this.costByKm);
};

module.exports = Bus;