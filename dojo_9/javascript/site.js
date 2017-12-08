const Distance = require('./distance');

function Site(_name, _distance) {

    this.name = _name;
    this.distance = _distance || new Distance();
}

Site.prototype.distanceFromZero = function () {
    return this.distance;
};

module.exports = Site;