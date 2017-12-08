const chai = require('chai');

const Destination = require('../destination');
const Section = require('../section');
const SectionTrip = require('../section_trip');
const Trip = require('../trip');
const Bus = require('../bus');
const Train = require('../train');
const Price = require('../price');

describe("Travel system", () => {

    describe("Trip Bs As to Mardel", function () {

        it("Travel from Bs As to Mardel by bus costs $1200", () => {

            let from = new Destination('Buenos Aires');
            let to = new Destination('Mardel', 400);

            let sectionTrip = new SectionTrip(new Section(from, to), new Bus('Andesmar'));

            let trip = new Trip([sectionTrip]);

            chai.assert.equal(trip.cost().equals(new Price(1200)), true);
        });

        it("Travel from Bs As to Mardel by train costs $800", () => {

            let from = new Destination('Buenos Aires');
            let to = new Destination('Mardel', 400);

            let sectionTrip = new SectionTrip(new Section(from, to), new Train('TBA'));

            let trip = new Trip([sectionTrip]);

            chai.assert.equal(trip.cost().equals(new Price(800)), true);
        });
    });

    describe("Trip Bs As to Trelew", function () {

        it("Travel from Bs As to Trelew by bus costs $4200", () => {

            let from = new Destination('Buenos Aires');
            let to = new Destination('Trelew', 1400);

            let sectionTrip = new SectionTrip(new Section(from, to), new Bus('Andesmar'));

            let trip = new Trip([sectionTrip]);

            chai.assert.equal(trip.cost().equals(new Price(4200)), true);
        });

        it("Travel from Bs As to Trelew by bus with Bahia Blanca stopover costs $4200", () => {

            let from = new Destination('Buenos Aires');
            let stopover = new Destination('Bahia Blanca', 700);
            let to = new Destination('Trelew', 1400);

            let sectionTrip1 = new SectionTrip(new Section(from, stopover), new Bus('Andesmar'));
            let sectionTrip2 = new SectionTrip(new Section(stopover, to), new Bus('Via Bariloche'));

            let trip = new Trip([sectionTrip1, sectionTrip2]);

            chai.assert.equal(trip.cost().equals(new Price(4200)), true);
        });

        it("Travel from Bs As to Trelew by bus and train with Bahia Blanca stopover costs $3500", () => {

            let from = new Destination('Buenos Aires');
            let stopover = new Destination('Bahia Blanca', 700);
            let to = new Destination('Trelew', 1400);

            let sectionTrip1 = new SectionTrip(new Section(from, stopover), new Bus('Andesmar'));
            let sectionTrip2 = new SectionTrip(new Section(stopover, to), new Train('TBA'));

            let trip = new Trip([sectionTrip1, sectionTrip2]);

            chai.assert.equal(trip.cost().equals(new Price(3500)), true);
        });
    });
});
