
function Bomberman(bornPosition) {

    this.position = bornPosition;
    this.status = 'alive';
    this.position.bombermanBornsHere(this);
}

Bomberman.prototype.stepInto = function(cell) {

    cell.claimedBy(this);
    this.position = cell;
};

Bomberman.prototype.isIn = function(cell) {
    if (this.isDead()) {
        return false;
    }
    return this.position == cell;
};

Bomberman.prototype.die = function() {
    this.status = 'dead';
};

Bomberman.prototype.isDead = function() {
    return this.status === 'dead';
};

Bomberman.prototype.isAlive = function() {
    return this.status === 'alive';
};

Bomberman.prototype.bumpsInto = function(bumper) {
    bumper.bumpsWithBomberman(this);
};

Bomberman.prototype.releasePosition = function() {
    this.position.removeOccupant();
    this.position = null;
};

Bomberman.prototype.isBlocking = function() {
    return false;
};

module.exports = Bomberman;
