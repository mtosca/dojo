import java.util.ArrayList;

public class ClassRoomRequest {

    public ArrayList<Condition> conditions = new ArrayList<>();

    public ClassRoomRequest forCondition(Condition condition) {
        this.conditions.add(condition);
        return this;
    }

    public boolean fulfilledBy(ClassRoom classRoom) {
        return this.conditions.stream()
                .allMatch(condition -> condition.fulfilledBy(classRoom));
    }
}
