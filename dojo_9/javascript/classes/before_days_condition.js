
function BeforeDaysCondition(_limitDays, _queryDate) {
    this.limitDays = _limitDays;
    this.queryDate = _queryDate;
}

BeforeDaysCondition.prototype.applies = function (_journey) {
    return this.limitDays < this.queryDate.daysToJourney(_journey);
};

module.exports = BeforeDaysCondition;