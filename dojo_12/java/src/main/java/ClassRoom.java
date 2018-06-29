public class ClassRoom {

    private final BraileImage braile;
    protected final String name;
    public final PeopleCapacity peopleCapacity;
    public final SquareMeters squareMeters;
    public final ProvidesComputers providesComputers;

    public ClassRoom(
            String name,
            PeopleCapacity peopleCapacity,
            SquareMeters squareMeters) {
        this.name = name;
        this.peopleCapacity = peopleCapacity;
        this.squareMeters = squareMeters;
        this.providesComputers = new NotProvidesComputers();
        this.braile = new NoBraileImage();
    }

    public ClassRoom(
            String name,
            PeopleCapacity peopleCapacity) {
        this.name = name;
        this.peopleCapacity = peopleCapacity;
        this.squareMeters = new SquareMeters(Integer.MAX_VALUE);
        this.providesComputers = new NotProvidesComputers();
        this.braile = new NoBraileImage();
    }

    public ClassRoom(
            String name,
            PeopleCapacity peopleCapacity,
            SquareMeters squareMeters,
            ProvidesComputers providesComputers) {
        this.name = name;
        this.peopleCapacity = peopleCapacity;
        this.squareMeters = squareMeters;
        this.providesComputers = providesComputers;
        this.braile = new NoBraileImage();
    }

    public ClassRoom(
            String name,
            PeopleCapacity peopleCapacity,
            SquareMeters squareMeters,
            ProvidesComputers providesComputers,
            BraileImage braileImage) {
        this.name = name;
        this.peopleCapacity = peopleCapacity;
        this.squareMeters = squareMeters;
        this.providesComputers = providesComputers;
        this.braile = braileImage;
    }

    public Label label() {
        return new Label("Aula: " + this.name,
                this.braile);
    }
}
