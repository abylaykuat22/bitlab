package kz.bitlab.bootcamp.bitlab.services;

import kz.bitlab.bootcamp.bitlab.Courier.Courier;
import kz.bitlab.bootcamp.bitlab.dto.CommentDto;
import kz.bitlab.bootcamp.bitlab.model.Comment;
import kz.bitlab.bootcamp.bitlab.model.News;

import java.util.List;

public interface CommentService {
    List<CommentDto> getAllComments();
    List<CommentDto> getCommentsByNews(List<News> news);
    void saveComment(Comment comment);
    void deleteComment(Comment comment);
    void deleteCommentById(Long id);
}
