
function Enemy() {

}

Enemy.prototype.bumpsWithBomberman = function(bomberman) {
      bomberman.die();
};

Enemy.prototype.isBlocking = function() {
    return false;
};

Enemy.prototype.isNotBlocking = function() {
    return !this.isBlocking();
};

module.exports = Enemy;