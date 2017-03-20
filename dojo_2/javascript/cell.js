/**
 * Created by mtosca on 2/17/17.
 */

function Cell() {

    var content;
    var address;

    Cell.prototype.setNumber = function(number) {
        this.content = new NumericContent(number);
    };

    Cell.prototype.getAddress = function() {
        return this.address;
    };
}
