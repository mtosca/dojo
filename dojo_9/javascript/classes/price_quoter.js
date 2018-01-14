const Discount = require('./discount');
const Increment = require('./increment');
const FixedIncrement = require('./fixed_increment');
const Availability = require('./availability');
const Price = require('./price');
const HigherAvailabilityThanCondition = require('./higher_availability_than_condition');
const LowerAvailabilityThanCondition = require('./lower_availability_than_condition');
const BeforeDaysCondition = require('./before_days_condition');
const BetweenDaysCondition = require('./between_days_condition');


function PriceQuoter(_seatsAvailabilityService, _queryDate) {

    this.queryDate = _queryDate;

    this.discountsAndIncrements = [
        new Discount(
            10, /* percent */
            [
                new HigherAvailabilityThanCondition(_seatsAvailabilityService, new Availability(80)),
                new BeforeDaysCondition(180, this.queryDate)
            ]
        ),
        new Increment(
            20, /* percent */
            [
                new LowerAvailabilityThanCondition(_seatsAvailabilityService, new Availability(20)),
                new BeforeDaysCondition(180, this.queryDate)
            ]
        ),
        new Increment(
            50, /* percent */
            [
                new LowerAvailabilityThanCondition(_seatsAvailabilityService, new Availability(10)),
                new BetweenDaysCondition(90, 179, this.queryDate)
            ]
        ),
        new Discount(
            20, /* percent */
            [
                new HigherAvailabilityThanCondition(_seatsAvailabilityService, new Availability(10)),
                new BetweenDaysCondition(90, 179, this.queryDate)
            ]
        ),
        new Increment(
            10, /* percent */
            [
                new BetweenDaysCondition(7, 15, this.queryDate)
            ]
        ),
        new FixedIncrement(
            new Price(100),
            [
                new BetweenDaysCondition(0, 7, this.queryDate)
            ]
        ),
    ];
}

PriceQuoter.prototype.quoteJourney = function (_journey) {

    // ALTERNATIVE 1 -> IF statement implied in find()

    return this.discountsAndIncrements
        .find((element) => {
            return element.applies();
        })
        .applyToJourney(_journey);

    // ALTERNATIVE 2 -> forces an IF statement !!!
    /*
    let finalPrice = _journey.salePrice();
    this.discountsAndIncrements.forEach((e) => {
        console.log("final price " + finalPrice.amount);
        finalPrice = e.applyToJourney(_journey);
        console.log("final price 2 - " + finalPrice.amount);
    });

    return finalPrice;
    */
};

module.exports = PriceQuoter;