import java.util.Arrays;
import java.util.List;

public class CAU {

    private final List<ClassRoom> classRooms;

    public CAU(ClassRoom... classRooms) {
        this.classRooms = Arrays.asList(classRooms);
    }

    public ClassRoom request(final ClassRoomRequest classRoomRequest) {
        return this.classRooms.stream()
                .filter(classRoom -> classRoomRequest.fulfilledBy(classRoom))
                .findFirst()
                .orElse(new NoClassRoomAvailable());
    }
}
