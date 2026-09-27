package kz.bitlab.g130springbean.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Task {
    private Long id;
    private String name;
    private String description;
    private String deadlineDate;
    private boolean isCompleted;
}
