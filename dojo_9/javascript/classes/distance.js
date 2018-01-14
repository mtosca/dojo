function Distance(_value, _unit) {

    this.value = _value || 0;
    this.unit = _unit || 'km';
}

Distance.prototype.minus = function (otherDistance) {
    return this.value - otherDistance.value;
};

module.exports = Distance;