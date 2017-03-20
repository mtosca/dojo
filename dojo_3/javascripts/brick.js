
function Brick() {

}

Brick.prototype.bumpsWithBomberman = function() {
    throw new Error('Brick here!');
};

Brick.prototype.isBlocking = function() {
    return false;
};

Brick.prototype.isNotBlocking = function() {
    return !this.isBlocking();
};

module.exports = Brick;