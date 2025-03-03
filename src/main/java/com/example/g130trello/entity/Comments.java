package com.example.g130trello.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "COMMENTS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMMENT_ID")
    private int id;

//    @ManyToOne
//    @JoinColumn(name = "TASK_ID", nullable = false)
//    private Task task;
//
//    @ManyToOne
//    @JoinColumn(name = "USER_ID", nullable = false)
//    private User user;

    @Column(name = "COMMENT_TEXT", nullable = false)
    private String commentText;

    @Column(name = "CREATED_AT", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
}