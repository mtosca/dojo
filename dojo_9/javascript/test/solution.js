const chai = require('chai');

const Site = require('../site');
const Section = require('../section');
const Trip = require('../trip');
const Journey = require('../journey');
const Bus = require('../bus');
const Train = require('../train');
const Price = require('../price');
const Distance = require('../distance');

describe("Travel system", () => {

    describe("Journey Bs As to Mardel", function () {

        it("Travel from Bs As to Mardel by bus costs $1200", () => {

            let from = new Site('Buenos Aires');
            let to = new Site('Mardel', new Distance(400, 'km'));

            let trip = new Journey([
                new Trip(new Section(from, to), new Bus('Andesmar'))
            ]);

            chai.assert.equal(trip.cost().equals(new Price(1200)), true);
        });

        it("Travel from Bs As to Mardel by train costs $800", () => {

            let from = new Site('Buenos Aires');
            let to = new Site('Mardel', new Distance(400, 'km'));

            let trip = new Journey([
                new Trip(new Section(from, to), new Train('TBA'))
            ]);

            chai.assert.equal(trip.cost().equals(new Price(800)), true);
        });
    });

    describe("Journey Bs As to Trelew", function () {

        it("Travel from Bs As to Trelew by bus costs $4200", () => {

            let from = new Site('Buenos Aires');
            let to = new Site('Trelew', new Distance(1400, 'km'));

            let trip = new Journey([
                new Trip(new Section(from, to), new Bus('Andesmar'))
            ]);

            chai.assert.equal(trip.cost().equals(new Price(4200)), true);
        });

        it("Travel from Bs As to Trelew by bus with Bahia Blanca stopover costs $4200", () => {

            let from = new Site('Buenos Aires');
            let stopover = new Site('Bahia Blanca', new Distance(700, 'km'));
            let to = new Site('Trelew', new Distance(1400, 'km'));

            let trip = new Journey([
                new Trip(new Section(from, stopover), new Bus('Andesmar')),
                new Trip(new Section(stopover, to), new Bus('Via Bariloche'))
            ]);

            chai.assert.equal(trip.cost().equals(new Price(4200)), true);
        });

        it("Travel from Bs As to Trelew by bus and train with Bahia Blanca stopover costs $3500", () => {

            let from = new Site('Buenos Aires');
            let stopover = new Site('Bahia Blanca', new Distance(700, 'km'));
            let to = new Site('Trelew', new Distance(1400, 'km'));

            let trip = new Journey([
                new Trip(new Section(from, stopover), new Bus('Andesmar')),
                new Trip(new Section(stopover, to), new Train('TBA'))
            ]);

            chai.assert.equal(trip.cost().equals(new Price(3500)), true);
        });
    });
});
