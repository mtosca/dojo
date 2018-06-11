public class SquareMetersOver implements Condition {

    private final SquareMeters squareMeters;

    public SquareMetersOver(SquareMeters squareMeters) {
        this.squareMeters = squareMeters;
    }

    @Override
    public boolean fulfilledBy(ClassRoom classRoom) {
        return classRoom.squareMeters.quantity >= this.squareMeters.quantity;
    }
}
