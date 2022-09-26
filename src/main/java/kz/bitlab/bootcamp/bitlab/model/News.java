package kz.bitlab.bootcamp.bitlab.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "news")
@Getter
@Setter
public class News extends BaseEntity{
    private String description;
    private Long pictureId;
    private int amountLikes;
    @ManyToOne
    private User user;
}
