function SectionTrip(_section, _transport) {
    this.section = _section;
    this.transport = _transport;
}

SectionTrip.prototype.cost = function () {
    return this.transport.costForSection(this.section);
};

module.exports = SectionTrip;