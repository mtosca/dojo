
function Bomb() {

}

Bomb.prototype.explode = function() {
    return true;
};

Bomb.prototype.isBlocking = function() {
    return false;
};

Bomb.prototype.isNotBlocking = function() {
    return !this.isBlocking();
};

module.exports = Bomb;