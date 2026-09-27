package bitlab.g111.springsecurity.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "posts")
@Getter
@Setter
public class Post extends BaseEntity{
  private String title;
  private String description;
  @ManyToOne
  private User author;
  @ManyToMany
  private List<Category> categories;
}
