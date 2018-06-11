public class PeopleCapacity {

    public final Integer quantity;

    public PeopleCapacity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return this.quantity.toString();
    }
}
