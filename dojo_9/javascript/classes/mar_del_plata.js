const Distance = require('./distance');

function MarDelPlata() {

    this.name = "Mar del plata";
    this.distance = new Distance(400, 'km');
}

MarDelPlata.prototype.distanceFromZero = function () {
    return this.distance;
};

module.exports = MarDelPlata;