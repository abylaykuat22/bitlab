package kz.bitlab.g130trello.entity.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

public class Tasklog {
    @Entity
    @Table(name = "TASK_LOGS")
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public class Tasklogs {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "LOG_ID")
        private Long logId;

        @Column(name = "TASK_ID", nullable = false)
        private Long taskId;

        @Column(name = "USER_ID", nullable = false)
        private Long userId;

        @Column(name = "ACTION", nullable = false)
        private String action;

        @Column(name = "PREVIOUSVALUE", nullable = false)
        private String previousValue;

        @Column(name = "NEWVALUE", nullable = false)
        private String newValue;

        @Column(name = "LOCALDATETIME", nullable = false)
        private LocalDateTime createdAt;
    }

}
