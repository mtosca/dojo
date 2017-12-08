function Destination(_name, _distance) {

    this.name = _name;
    this.distance = _distance || 0;
}

Destination.prototype.distanceFromZero = function () {
    return this.distance;
};

module.exports = Destination;