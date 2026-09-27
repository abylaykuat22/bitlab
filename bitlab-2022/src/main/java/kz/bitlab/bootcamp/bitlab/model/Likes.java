package kz.bitlab.bootcamp.bitlab.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "likes")
@Getter
@Setter
public class Likes{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;
    @ManyToOne
    private News news;
    @ManyToOne
    private Picture picture;
    private Date createdAt;
    @PrePersist
    protected void prePersist() {
        createdAt = new Date();
    }
}
