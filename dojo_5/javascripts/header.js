var Title = require('./title');
var Heading = require('./approved_heading');

function Header(payment, shipment) {
    this.payment = payment;
    this.shipment = shipment;
}

Header.prototype.asJSON = function() {

    var heading = new Heading(this.payment, this.shipment);
    var title = new Title(this.payment, this.shipment);

    return {
        "status": "success",
        "substatus": null,
        "heading": heading.toString(),
        "title": title.toString()
    };
};

module.exports = Header;