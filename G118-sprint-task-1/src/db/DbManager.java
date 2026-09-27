package db;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import models.Task;

public class DbManager {
  private static List<Task> tasks = new ArrayList<>();

  private static Long id = 7L;

  static {
    tasks.add(new Task(1L, "ASD", "ZXC", "123"));
    tasks.add(new Task(2L, "ASD1", "ZXC1", "1231"));
    tasks.add(new Task(3L, "ASD2", "ZXC2", "1232"));
    tasks.add(new Task(5L, "ASD3", "ZXC3", "1233"));
    tasks.add(new Task(6L, "ASD4", "ZXC4", "1234"));
  }

  public static void addTask(Task task) {
    task.setId(id);
    tasks.add(task);
    id++;
  }

  public static List<Task> getTasks() {
    return tasks;
  }

  public static Task getTaskById(Long id) {
    return tasks.stream()
        .filter(task -> Objects.equals(id, task.getId()))
        .findFirst()
        .orElse(null);
  }

  public static void deleteTaskById(Long id) {
    tasks.removeIf(task -> Objects.equals(id, task.getId()));
  }
}
