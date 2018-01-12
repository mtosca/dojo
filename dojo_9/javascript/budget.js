const Price = require('./price');


function Budget(_journey, _queryDate) {
    this.journey = _journey;
    this.queryDate = _queryDate;
}

Budget.prototype.salePrice = function () {

    let soldSeatsPercentage = 0;
    let discount = 0;

    if (soldSeatsPercentage < 80) {
        discount = 0.1;
    }

    let discountAmount = this.journey.salePrice().amount * discount;
    let salePrice = this.journey.salePrice().amount - discountAmount;

    return new Price(salePrice);
};

module.exports = Budget;