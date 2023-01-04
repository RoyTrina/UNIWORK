import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Staff {
  public String name;
  public String phoneNumber;
  public String roomNumber;

  public Staff(String name, String phoneNumber, String roomNumber) {
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.roomNumber = roomNumber;
  }

  public Staff(String line) {
    String[] tokens = line.trim().split("\\s*,\\s*");
    this.name = tokens[0];
    this.phoneNumber = tokens[1];
    this.roomNumber = tokens[2];
  }

  @Override
  public String toString() {
    return name + ", " + phoneNumber + ", " + roomNumber;
  }

  public String getRoomNumber() {
    return roomNumber;
  }

  public static void main(String[] args) {
    Map<String, List<Staff>> staffMap = roomStaffMap(Paths.get("data/staff.csv"));
    System.out.println(staffMap);
  }

  public static Comparator<Staff> compareByPhone = Comparator.comparing((Staff st) -> st.phoneNumber)
      .thenComparing(Comparator.comparing(st -> st.name));


  // Implement the method below using Java 8 streams. It should:
  // 1. Read a stream of lines from the file,
  // 2. Transform this into a stream of Staff objects
  // 3. Collect this stream into a map from room numbers to lists of staff objects

  public static  Map<String,List<Staff>> roomStaffMap(Path path){
    return null;
  }
}
