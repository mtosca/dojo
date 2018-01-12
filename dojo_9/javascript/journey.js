function Journey(_trips) {

    this.trips = _trips;
}

Journey.prototype.cost = function () {
    return this.trips.map((s) => s.cost()).reduce((c1, c2) => c1.sum(c2));
};

Journey.prototype.salePrice = function () {
    return this.trips.map((s) => s.salePrice()).reduce((c1, c2) => c1.sum(c2));
};

module.exports = Journey;