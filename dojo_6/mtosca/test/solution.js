const chai = require('chai');

const SellingPrice = require('../src/selling_price.js');
const Product = require('../src/product.js');
const BuyingCost = require('../src/buying_cost.js');
const UnitSale = require('../src/unit_sale.js');

describe("checkout", () => {
    describe("dummy", function() {

        it("calculate earning for 1 product sale", () => {

            var sellingPrice = new SellingPrice(20);

            var product = new Product(new BuyingCost(10));

            var sale = new UnitSale(product, sellingPrice);

            var earning = sale.profit();

            chai.assert.equal(earning, 10);
        });

        it("calculate earning for 2x1 product sale", () => {

        });
    });
});
