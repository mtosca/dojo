function EfectyTitle() {

}

EfectyTitle.prototype.printMessage = function() {
    return "Paga ${price} en ${paymentMethodName} para reservar tu compra";
};

module.exports = EfectyTitle;