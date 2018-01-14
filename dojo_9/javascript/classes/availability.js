function Availability(_percentage) {
    this.percentage = _percentage;
}

Availability.prototype.greaterThan = function(_otherAvailability) {
    return this.percentage > _otherAvailability.percentage;
}

Availability.prototype.lowerOrEqualsThan = function(_otherAvailability) {
    return (this.percentage <= _otherAvailability.percentage);
}

module.exports = Availability;