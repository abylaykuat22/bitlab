package kz.bitlab.bootcamp.bitlab.services.impl;

import kz.bitlab.bootcamp.bitlab.Courier.Courier;
import kz.bitlab.bootcamp.bitlab.dto.CommentDto;
import kz.bitlab.bootcamp.bitlab.mapper.CommentMapper;
import kz.bitlab.bootcamp.bitlab.model.Comment;
import kz.bitlab.bootcamp.bitlab.model.News;
import kz.bitlab.bootcamp.bitlab.repositories.CommentRepository;
import kz.bitlab.bootcamp.bitlab.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<CommentDto> getAllComments() {
        return commentMapper.toDtoList(commentRepository.findAll());
    }

    @Override
    public List<CommentDto> getCommentsByNews(List<News> news) {
        List<Comment> comments = commentMapper.toEntityList(getAllComments());
        List<Comment> commentList = new ArrayList<>();
        for (News n : news){
            for (Comment c : comments){
                if (c.getNews()!=null){
                    if (c.getNews().getId().equals(n.getId())){
                        commentList.add(c);
                    }
                }
            }
        }
        return commentMapper.toDtoList(commentList);
    }

    @Override
    public void saveComment(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void deleteComment(Comment comment) {
        commentRepository.delete(comment);
    }

    @Override
    public void deleteCommentById(Long id) {
        commentRepository.deleteById(id);
    }
}
