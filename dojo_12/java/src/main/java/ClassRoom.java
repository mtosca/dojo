public class ClassRoom {

    protected final String name;
    public final PeopleCapacity peopleCapacity;
    public final SquareMeters squareMeters;

    public ClassRoom(String name, PeopleCapacity peopleCapacity, SquareMeters squareMeters) {
        this.name = name;
        this.peopleCapacity = peopleCapacity;
        this.squareMeters = squareMeters;
    }

    public Label label() {
        return new Label("Aula: " + this.name);
    }
}
