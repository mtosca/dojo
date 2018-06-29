import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

/**
 * Tests for the dojo.
 */
public class DojoTest {

    @Before
    public void setup() {

    }

    @Test
    public void test_request_classroom_for_10_people() {

        CAU cau = new CAU(
                new ClassRoom("Lab A", new PeopleCapacity(5), new SquareMeters(10)),
                new ClassRoom("Lab B", new PeopleCapacity(15), new SquareMeters(20)));

        ClassRoomRequest classRoomRequest = new ClassRoomRequest()
                .forCondition(new PeopleCapacityOver(new PeopleCapacity(10)));

        ClassRoom classRoom = cau.request(classRoomRequest);

        assertEquals("Aula: Lab B", classRoom.label().print());
    }

    @Test
    public void test_no_classroom_for_30_people() {

        CAU cau = new CAU(
                new ClassRoom("Lab A", new PeopleCapacity(5), new SquareMeters(10)),
                new ClassRoom("Lab B", new PeopleCapacity(15), new SquareMeters(20)),
                new ClassRoom("Lab C", new PeopleCapacity(15), new SquareMeters(50)));

        ClassRoomRequest classRoomRequest = new ClassRoomRequest()
                .forCondition(new PeopleCapacityOver(new PeopleCapacity(30)));

        ClassRoom classRoom = cau.request(classRoomRequest);

        assertEquals("No hay aula disponible", classRoom.label().print());
    }

    @Test
    public void test_request_room_for_10_people_and_over_30_sq_meters() {

        CAU cau = new CAU(
                new ClassRoom("Lab A", new PeopleCapacity(5), new SquareMeters(10)),
                new ClassRoom("Lab B", new PeopleCapacity(15), new SquareMeters(20)),
                new ClassRoom("Lab C", new PeopleCapacity(15), new SquareMeters(50))
        );

        ClassRoomRequest classRoomRequest = new ClassRoomRequest()
                .forCondition(new PeopleCapacityOver(new PeopleCapacity(10)))
                .forCondition(new SquareMetersOver(new SquareMeters(30)));

        ClassRoom classRoom = cau.request(classRoomRequest);

        assertEquals("Aula: Lab C", classRoom.label().print());
    }

    @Test
    public void test_request_room_for_10_people_and_over_30_sq_meters_and_10_computers() {

        CAU cau = new CAU(
                new ClassRoom("Lab A", new PeopleCapacity(5), new SquareMeters(10)),
                new ClassRoom("Lab B", new PeopleCapacity(15), new SquareMeters(20)),
                new ClassRoom("Lab C", new PeopleCapacity(15), new SquareMeters(50)),
                new ClassRoom("Lab D",
                        new PeopleCapacity(15),
                        new SquareMeters(50),
                        new ProvidesComputers())
        );

        ClassRoomRequest classRoomRequest = new ClassRoomRequest()
                .forCondition(new PeopleCapacityOver(new PeopleCapacity(10)))
                .forCondition(new SquareMetersOver(new SquareMeters(30)))
                .forCondition(new NeedComputers());

        ClassRoom classRoom = cau.request(classRoomRequest);

        assertEquals("Aula: Lab D", classRoom.label().print());
    }

    @Test
    public void test_request_room_for_10_people_and_over_30_sq_meters_and_10_computers_in_Braile() {

        CAU cau = new CAU(
                new ClassRoom("Lab A", new PeopleCapacity(5), new SquareMeters(10)),
                new ClassRoom("Lab B", new PeopleCapacity(15), new SquareMeters(20)),
                new ClassRoom("Lab C", new PeopleCapacity(15), new SquareMeters(50)),
                new ClassRoom("Lab D",
                        new PeopleCapacity(15),
                        new SquareMeters(50),
                        new ProvidesComputers(),
                        new BraileImage("/Users/mtosca/Desktop/braile-lab-D.png"))
        );

        ClassRoomRequest classRoomRequest = new ClassRoomRequest()
                .forCondition(new PeopleCapacityOver(new PeopleCapacity(10)))
                .forCondition(new SquareMetersOver(new SquareMeters(30)))
                .forCondition(new NeedComputers());

        ClassRoom classRoom = cau.request(classRoomRequest);

        System.out.println(
                "BRAILE: " + new BraileImage("/Users/mtosca/Desktop/braile-lab-D.png") +
        "CS: " + classRoom.label().asBraile().imgUrl);

        assertEquals(new BraileImage("/Users/mtosca/Desktop/braile-lab-D.png"),
                classRoom.label().asBraile());
    }
}
