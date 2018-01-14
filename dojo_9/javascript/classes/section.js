function Section(_from, _to) {
    this.from = _from;
    this.to = _to;
}
Section.prototype.travelDistance = function () {
    return this.to.distanceFromZero().minus(this.from.distanceFromZero());
};

module.exports = Section;