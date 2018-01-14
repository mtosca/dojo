
function LowerAvailabilityThanCondition(_seatsAvailabilityService, _limit) {
    this.seatsAvailabilityService = _seatsAvailabilityService;
    this.limitAvailability = _limit
}

LowerAvailabilityThanCondition.prototype.applies = function (_journey) {
    let seatsAvailability = this.seatsAvailabilityService.getSeatsAvailability(_journey);
    return seatsAvailability.lowerOrEqualsThan(this.limitAvailability);
};

module.exports = LowerAvailabilityThanCondition;