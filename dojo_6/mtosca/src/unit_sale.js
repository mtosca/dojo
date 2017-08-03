
function UnitSale(product, sellingPrice) {

    this.product = product;
    this.sellingPrice = sellingPrice;
}

UnitSale.prototype.profit = function() {
    return this.product.buyingSellingDifference(this.sellingPrice);
};

module.exports = UnitSale;