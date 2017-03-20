var cell = require('cell.js');
var _ = require('lodash');

module.exports = SpreadSheet;

function SpreadSheet() {

    var cells = [];
}

SpreadSheet.prototype.setNumber = function (address, number) {

    var cell = this.getCell(address);

    cell.setNumber(number);

    this.cells.add(cell);
};

SpreadSheet.prototype.getCell = function(address) {

    var cell = _.find(this.cells, function(cell) {
        return cell.address == address;
    });

    if (!cell) {
        cell = new Cell();
    }

    return cell;
};