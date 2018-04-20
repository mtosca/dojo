const Distance = require('./distance');

function BuenosAires() {

    this.name = 'Buenos Aires';
    this.distance = new Distance();
}

BuenosAires.prototype.distanceFromZero = function () {
    return this.distance;
};

module.exports = BuenosAires;