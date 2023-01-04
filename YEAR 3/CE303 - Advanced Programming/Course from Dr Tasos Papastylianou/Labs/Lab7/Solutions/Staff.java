import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

  public static  Map<String,List<Staff>> roomStaffMap(Path path){
     try (Stream<String> lines = Files.lines(path)) {
      return lines.map(Staff::new).collect(Collectors.groupingBy(Staff::getRoomNumber));
    } catch (IOException e) {
      e.printStackTrace();
      return new HashMap<>();
    }
  }
}
