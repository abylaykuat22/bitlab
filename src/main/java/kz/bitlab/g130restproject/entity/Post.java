package kz.bitlab.g130restproject.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "POSTS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TITLE", nullable = false, length = 100, unique = true)
    private String title;

    @Column(name = "CONTENT")
    private String content;

    @Column(name = "AUTHOR")
    private String author;

    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;
}
