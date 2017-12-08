const Price = require('./price.js');

function Train() {
    this.costByKm = 2;
}

Train.prototype.costForSection = function (_section) {
    return new Price(_section.travelDistance() * this.costByKm);
};

module.exports = Train;