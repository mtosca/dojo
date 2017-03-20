const Empty = require('./empty.js');


function Cell(_occupant) {

    this.occupant = _occupant;
}

Cell.prototype.claimedBy = function(claimer) {

    claimer.bumpsInto(this.occupant);
    claimer.releasePosition();
    this.occupant = claimer;
};

Cell.prototype.removeOccupant = function() {
    this.occupant = new Empty();
};

Cell.prototype.bombermanBornsHere = function(bomberman) {
    this.occupant = bomberman;
};

Cell.prototype.isEmpty = function() {
    return this.occupant.isNotBlocking();
};

Cell.prototype.isNotEmpty = function() {
    return !this.occupant.isNotBlocking();
};

module.exports = Cell;