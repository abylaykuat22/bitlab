package kz.bitlab.g130springbean.db;

import jakarta.annotation.PostConstruct;
import kz.bitlab.g130springbean.entity.Task;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DBManager {

    @Getter
    private final List<Task> tasks = new ArrayList<>();

    @PostConstruct
    public void init() {
        tasks.add(new Task(1L, "Task 1", null, "2024-12-5", false));
        tasks.add(new Task(2L, "Task 2", null, "2024-12-5", true));
        tasks.add(new Task(3L, "Task 3", null, "2024-12-6", true));
        tasks.add(new Task(4L, "Task 4", null, "2024-12-7", false));
        tasks.add(new Task(5L, "Task 5", null, "2024-12-30", false));
    }

    public void addTask(String name, String description, String deadlineDate) {
        Task task = new Task();
        task.setId((long) tasks.size() + 1);
        task.setName(name);
        task.setDescription(description);
        task.setDeadlineDate(deadlineDate);
        task.setCompleted(false);
        tasks.add(task);
    }
}
