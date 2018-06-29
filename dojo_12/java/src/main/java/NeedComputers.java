public class NeedComputers implements Condition {

    @Override
    public boolean fulfilledBy(ClassRoom classRoom) {
        return classRoom.providesComputers.provides();
    }
}
