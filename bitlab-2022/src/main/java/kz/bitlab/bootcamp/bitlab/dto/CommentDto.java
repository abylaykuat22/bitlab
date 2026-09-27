package kz.bitlab.bootcamp.bitlab.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CommentDto {
    private Long id;
    private String comment;
    private UserDto user;
    private NewsDto news;
    private Date createdAt;
}
