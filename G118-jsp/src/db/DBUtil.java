package db;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import models.Developer;

public class DBUtil {

  private static List<Developer> developers = new ArrayList<>();

  private static Long id = 6L;
  static {
    developers.add(new Developer(1L, "Marat", "Marat", "Almaty", 21));
    developers.add(new Developer(2L, "Diyar", "Diyar", "Almaty", 18));
    developers.add(new Developer(3L, "Sania", "Sania", "Bishkek", 18));
    developers.add(new Developer(4L, "Aliya", "Aliya", "Almaty", 18));
    developers.add(new Developer(5L, "Vova", "Vova", "Taraz", 15));
  }

  public static List<Developer> getDevelopers() {
    return developers;
  }

  public static void addDeveloper(Developer developer) {
    developer.setId(id);
    developers.add(developer);
    id++;
  }

  public static Developer getDeveloperById(Long id) {
    return developers.stream()
        .filter(developer -> Objects.equals(developer.getId(), id))
        .findFirst()
        .orElse(null);
  }
}
