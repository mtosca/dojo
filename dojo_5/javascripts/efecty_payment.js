var EfectyHeading = require('./efecty_heading');
var EfectyTitle = require('./efecty_title');

function EfectyPayment() {

}

EfectyPayment.prototype.getHeading = function() {
    return new EfectyHeading();
};

EfectyPayment.prototype.getTitle = function () {
    return new EfectyTitle();
};

module.exports = EfectyPayment;