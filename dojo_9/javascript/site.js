function Site(_name, _distance) {

    this.name = _name;
    this.distance = _distance || 0;
}

Site.prototype.distanceFromZero = function () {
    return this.distance;
};

module.exports = Site;