const chai = require('chai');

const Site = require('../classes/site');
const Section = require('../classes/section');
const Trip = require('../classes/trip');
const Journey = require('../classes/journey');
const Bus = require('../classes/bus');
const Train = require('../classes/train');
const Price = require('../classes/price');
const Distance = require('../classes/distance');
const PriceQuoter = require('../classes/price_quoter'); // -> Cotizador
const QueryDate = require('../classes/query_date');
const SeatsAvailabilityService = require('../classes/seats_availability_service');
const Availability = require('../classes/availability');
const BuenosAires = require('../classes/buenos_aires');
const MarDelPlata = require('../classes/mar_del_plata');

describe("Travel system", () => {

    describe("Journey Bs As to Mardel", function () {

        it("Travel from Bs As to Mardel, by bus costs $1200", () => {

            let from = new BuenosAires();
            let to = new MarDelPlata();

            let trip = new Journey([
                new Trip(new Section(from, to), new Bus('Andesmar'))
            ]);

            chai.assert.equal(trip.cost().equals(new Price(1200)), true);
        });

        it("Travel from Bs As to Mardel, by train costs $800", () => {

            let from = new BuenosAires();
            let to = new MarDelPlata();

            let journey = new Journey([
                new Trip(new Section(from, to), new Train('TBA'))
            ]);

            chai.assert.equal(journey.cost().equals(new Price(800)), true);
        });

        it("Travel to Mardel by Bus, sale price is 10% over the cost", () => {

            let from = new BuenosAires();
            let to = new MarDelPlata();

            let trip = new Journey([
                new Trip(new Section(from, to), new Bus('Andesmar'))
            ]);

            chai.assert.equal(trip.salePrice().equals(new Price(1320)), true);
        });

        it("Travel from Bs As to Mardel by train, sale price is 10% over the cost", () => {

            let from = new BuenosAires();
            let to = new MarDelPlata();

            let journey = new Journey([
                new Trip(new Section(from, to), new Train('TBA'))
            ]);

            chai.assert.equal(journey.salePrice().equals(new Price(880)), true);
        });

        it("180 days before journey, no seat has been sold. Sales price is reduced 10%", () => {

            let from = new BuenosAires();
            let to = new MarDelPlata();

            let journey = new Journey([
                new Trip(new Section(from, to), new Bus('Andesmar'))
            ]);

            let priceQuoter = new PriceQuoter(
                new SeatsAvailabilityService(new Availability(100)),
                new QueryDate(181)
            ); // -> Cotizador

            chai.assert.equal(priceQuoter.quoteJourney(journey, new QueryDate(180)).equals(new Price(1188)), true);
        });

        it("180 days before journey, 80% has been sold. Price increases 20%", () => {

            let from = new BuenosAires();
            let to = new MarDelPlata();

            let journey = new Journey([
                new Trip(new Section(from, to), new Bus('Andesmar'))
            ]);

            let priceQuoter = new PriceQuoter(
                new SeatsAvailabilityService(new Availability(19)),
                new QueryDate(181)
            ); // -> Cotizador

            chai.assert.equal(priceQuoter.quoteJourney(journey).equals(new Price(1584)), true);
        });

        it("90 days before journey, 90% has been sold. Price increases 50%", () => {

            let from = new BuenosAires();
            let to = new MarDelPlata();

            let journey = new Journey([
                new Trip(new Section(from, to), new Bus('Andesmar'))
            ]);

            let priceQuoter = new PriceQuoter(
                new SeatsAvailabilityService(new Availability(9)),
                new QueryDate(91)
            ); // -> Cotizador

            chai.assert.equal(priceQuoter.quoteJourney(journey).equals(new Price(1980)), true);
        });

        it("90 days before journey, less than 90% has been sold. Price decreases 20%", () => {

            let from = new BuenosAires();
            let to = new MarDelPlata();

            let journey = new Journey([
                new Trip(new Section(from, to), new Bus('Andesmar'))
            ]);

            let priceQuoter = new PriceQuoter(
                new SeatsAvailabilityService(new Availability(11)),
                new QueryDate(91)
            ); // -> Cotizador

            chai.assert.equal(priceQuoter.quoteJourney(journey).equals(new Price(1056)), true);
        });

        it("15 days before journey price increases 10%, no exceptions", () => {

            let from = new BuenosAires();
            let to = new MarDelPlata();

            let journey = new Journey([
                new Trip(new Section(from, to), new Bus('Andesmar'))
            ]);

            let priceQuoter = new PriceQuoter(
                new SeatsAvailabilityService(new Availability(100)),
                new QueryDate(14)
            ); // -> Cotizador

            chai.assert.equal(priceQuoter.quoteJourney(journey).equals(new Price(1452)), true);
        });

        it("A week before journey price increases $100 fixed, no exceptions", () => {

            let from = new BuenosAires();
            let to = new MarDelPlata();

            let journey = new Journey([
                new Trip(new Section(from, to), new Bus('Andesmar'))
            ]);

            let priceQuoter = new PriceQuoter(
                new SeatsAvailabilityService(new Availability(100)),
                new QueryDate(6)
            ); // -> Cotizador

            chai.assert.equal(priceQuoter.quoteJourney(journey).equals(new Price(1420)), true);
        });
    });

    describe("Journey Bs As to Trelew", function () {

        it("Travel from Bs As to Trelew by bus costs $4200", () => {

            let from = new BuenosAires();
            let to = new Site('Trelew', new Distance(1400, 'km'));

            let trip = new Journey([
                new Trip(new Section(from, to), new Bus('Andesmar'))
            ]);

            chai.assert.equal(trip.cost().equals(new Price(4200)), true);
        });

        it("Travel from Bs As to Trelew by bus, with Bahia Blanca stopover, costs $4200", () => {

            let from = new BuenosAires();
            let stopover = new Site('Bahia Blanca', new Distance(700, 'km'));
            let to = new Site('Trelew', new Distance(1400, 'km'));

            let trip = new Journey([
                new Trip(new Section(from, stopover), new Bus('Andesmar')),
                new Trip(new Section(stopover, to), new Bus('Via Bariloche'))
            ]);

            chai.assert.equal(trip.cost().equals(new Price(4200)), true);
        });

        it("Travel from Bs As to Trelew by bus and train, with Bahia Blanca stopover, costs $3500", () => {

            let from = new BuenosAires();
            let stopover = new Site('Bahia Blanca', new Distance(700, 'km'));
            let to = new Site('Trelew', new Distance(1400, 'km'));

            let trip = new Journey([
                new Trip(new Section(from, stopover), new Bus('Andesmar')),
                new Trip(new Section(stopover, to), new Train('TBA'))
            ]);

            chai.assert.equal(trip.cost().equals(new Price(3500)), true);
        });

        it("From Bs As to Trelew by bus and train, with Bahia Blanca stopover, sale price is $3850", () => {

            let from = new BuenosAires();
            let stopover = new Site('Bahia Blanca', new Distance(700, 'km'));
            let to = new Site('Trelew', new Distance(1400, 'km'));

            let trip = new Journey([
                new Trip(new Section(from, stopover), new Bus('Andesmar')),
                new Trip(new Section(stopover, to), new Train('TBA'))
            ]);

            chai.assert.equal(trip.salePrice().equals(new Price(3850)), true);
        });
    });
});
