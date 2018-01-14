function Trip(_section, _transport) {
    this.section = _section;
    this.transport = _transport;
}

Trip.prototype.cost = function () {
    return this.transport.costForSection(this.section);
};

Trip.prototype.salePrice = function () {
    return this.transport.salePriceForSection(this.section);
};

module.exports = Trip;