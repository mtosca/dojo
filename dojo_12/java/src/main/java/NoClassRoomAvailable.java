public class NoClassRoomAvailable extends ClassRoom {

    public NoClassRoomAvailable() {

        super("No hay aula disponible", new PeopleCapacity(0), new SquareMeters(0));
    }

    @Override
    public Label label() {
        return new Label(this.name);
    }
}
