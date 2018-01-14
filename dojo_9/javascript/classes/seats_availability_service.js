const Availability = require('./availability');

function SeatsAvailabilityService(_mockedAvailability) {
    this.availability = _mockedAvailability;
}

SeatsAvailabilityService.prototype.getSeatsAvailability = function (_journey) {
    _journey; // assume we use it
    return this.availability;
};

module.exports = SeatsAvailabilityService;