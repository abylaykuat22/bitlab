package kz.bitlab.bootcamp.bitlab.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "friends")
@Getter
@Setter
public class Friends extends BaseEntity{
    private String status;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<User> users;
    private Long userSenderId;
    private Long userRecipientId;
}
