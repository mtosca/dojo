function Trip(_sectionList) {

    this.sectionTripList = _sectionList;
}

Trip.prototype.cost = function () {
    return this.sectionTripList.map((s) => s.cost()).reduce((c1, c2) => c1.sum(c2));
};

module.exports = Trip;