
function Product(buyingCost) {

    this.buyingCost = buyingCost;
}

Product.prototype.buyingSellingDifference = function (sellingPrice) {
    return sellingPrice.subtract(this.buyingCost);
};

module.exports = Product;