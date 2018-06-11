public class PeopleCapacityOver implements Condition {

    private final PeopleCapacity peopleCapacity;

    public PeopleCapacityOver(PeopleCapacity peopleCapacity) {
        this.peopleCapacity = peopleCapacity;
    }

    @Override
    public boolean fulfilledBy(ClassRoom classRoom) {
        return classRoom.peopleCapacity.quantity >= this.peopleCapacity.quantity;
    }
}
