const chai = require('chai');

const Bomberman = require('../bomberman.js');
const Cell = require('../cell.js');
const Brick = require('../brick.js');
const Enemy = require('../enemy.js');
const Empty = require('../empty.js');

describe("bomberman", () => {
    describe("bomberman", () => {

        it("steps into a cell which is empty then it moves in", () => {

            let bornPosition = new Cell(new Empty());
            let bomberman = new Bomberman(bornPosition);

            let emptyCell = new Cell(new Empty());

            bomberman.stepInto(emptyCell);

            chai.assert.equal(bomberman.isIn(emptyCell), true);
        });

        it("steps into a cell which is busy with an object then it doesn't move and throw an exception", () => {

            let occupiedCell = new Cell(new Brick());

            let bomberman = new Bomberman(new Cell(new Empty()));

            chai.assert.throws( () => {
                bomberman.stepInto(occupiedCell);
            })
        });

        it("steps into a cell which is busy with an enemy then it dies", () => {

            let cellWithEnemy = new Cell(new Enemy()); // enemy
            let bornPosition = new Cell(new Empty());

            let bomberman = new Bomberman(bornPosition);

            bomberman.stepInto(cellWithEnemy);

            chai.assert.equal(bomberman.isDead(), true);
            chai.assert.equal(bomberman.isAlive(), false);
            chai.assert.equal(bornPosition.isEmpty(), true);
            chai.assert.equal(bomberman.isIn(bornPosition), false);
            chai.assert.equal(bomberman.isIn(cellWithEnemy), false); // TODO... como hacemos acá?!
        });

        it("leaves a boom next to a brick, the boom explotes and the bricks disappears", () => {

            let cellWithBrick = new Cell(new Brick());
            let nextToBrickCell = new Cell(new Empty());

            let bornPosition = new Cell(new Empty());
            let bomberman = new Bomberman(bornPosition);

            bomberman.leaveBomb(nextToBrickCell);

            chai.assert.equal(cellWithBrick.isEmpty(), true);
        });

        it.skip("throws a boom to a brick, the boom explotes and the bricks disappears", () => {
        });
    });

});
