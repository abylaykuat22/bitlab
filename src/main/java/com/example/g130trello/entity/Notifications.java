package com.example.g130trello.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="NOTIFICATIONS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class Notifications {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "ID")
    private long id;

    @Column(name = "USER_ID")
    private long userId;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "MESSAGE")
    private String message;

    @Column(name = "IS_READ")
    private boolean isRead;

    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

    @Column(name = "UPDATED_ID")
    private LocalDateTime updatedId;


}
