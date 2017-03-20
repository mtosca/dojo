
function Empty() {

}

Empty.prototype.bumpsWithBomberman = function() {
    return true;
};

Empty.prototype.isBlocking = function() {
    return false;
};

Empty.prototype.isNotBlocking = function() {
    return !this.isBlocking();
};

module.exports = Empty;