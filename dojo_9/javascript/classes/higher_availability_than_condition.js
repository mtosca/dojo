
function HigherAvailabilityThanCondition(_seatsAvailabilityService, _limitAvailability) {
    this.seatsAvailabilityService = _seatsAvailabilityService;
    this.limitAvailability = _limitAvailability;
}

HigherAvailabilityThanCondition.prototype.applies = function (_journey) {
    let seatsAvailability = this.seatsAvailabilityService.getSeatsAvailability(_journey);
    return seatsAvailability.greaterThan(this.limitAvailability);
};

module.exports = HigherAvailabilityThanCondition;