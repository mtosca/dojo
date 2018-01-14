
function BeforeDaysCondition(_minDays, _maxDays, _queryDate) {
    this.minDays = _minDays;
    this.maxDays = _maxDays;
    this.queryDate = _queryDate;
}

BeforeDaysCondition.prototype.applies = function (_journey) {

    let daysToJourney = this.queryDate.daysToJourney(_journey);
    return (this.minDays < daysToJourney) && (this.maxDays > daysToJourney);
};

module.exports = BeforeDaysCondition;