package kz.bitlab.bootcamp.bitlab.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pictures")
@Getter
@Setter
public class Picture extends BaseEntity{
    private String picture;
    private String rolePicture;
    @ManyToOne
    private User user;
    @ManyToOne
    private News news;
}
