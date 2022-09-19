package kz.bitlab.bootcamp.bitlab.services.impl;

import kz.bitlab.bootcamp.bitlab.Courier.Courier;
import kz.bitlab.bootcamp.bitlab.dto.CommentDto;
import kz.bitlab.bootcamp.bitlab.mapper.CommentMapper;
import kz.bitlab.bootcamp.bitlab.model.*;
import kz.bitlab.bootcamp.bitlab.repositories.NewsRepository;
import kz.bitlab.bootcamp.bitlab.services.*;
import liquibase.pro.packaged.N;
import liquibase.pro.packaged.P;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsRepository newsRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private PictureService pictureService;
    @Autowired
    private LikesService likesService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private CommentMapper commentMapper;
    @Value("${targetUrl}")
    private String targetUrl;

    @Override
    public List<News> getNews() {
        return newsRepository.findAll();
    }

    @Override
    public Courier addNews(MultipartFile file, Courier courier) {
        News news = new News();
        news.setDescription(courier.getDescription());
        news.setUser(userService.getCurrentUser());
        newsRepository.save(news);
        Courier courierWithNews = new Courier();
        courierWithNews.setNews(news);
        if (!file.isEmpty()) {
            try {
                Picture picture = new Picture();
                picture.setUser(userService.getCurrentUser());
                picture.setPicture("empty");
                picture.setRolePicture("ROLE_NEWS");
                pictureService.updateProfilePicture(picture);
                String fileToken = DigestUtils.sha1Hex(picture.getId() + "_#!?");
                String fileName = fileToken + ".jpg";
                byte bytes[] = file.getBytes();
                Path path = Paths.get(targetUrl + "/", fileName);
                Files.write(path, bytes);
                Picture newPicture = pictureService.getPictureById(picture.getId());
                newPicture.setPicture(fileToken);
                newPicture.setNews(news);
                pictureService.updateProfilePicture(picture);
                courierWithNews.setPictureObj(newPicture);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return courierWithNews;
    }

    @Override
    public void deleteNewsById(Long id) {
        News news = newsRepository.findById(id).orElseThrow();
        List<Picture> pictures = pictureService.getPictures();
        for (Picture p : pictures){
            if (p.getNews()!=null){
                if (p.getNews().getId().equals(news.getId())){
                    pictureService.deletePicture(p.getId());
                }
            }
        }
        List<CommentDto> comments = commentService.getAllComments();
        for (CommentDto c : comments){
            if (c.getNews()!=null){
                if (c.getNews().getId().equals(news.getId())){
                    commentService.deleteComment(commentMapper.toEntity(c));
                }
            }
        }
        List<Likes> likes = likesService.allLikes();
        for (Likes l : likes){
            if (l.getNews()!=null){
                if (l.getNews().getId().equals(news.getId())){
                    likesService.deleteLike(l);
                }
            }
        }
        newsRepository.deleteById(id);
    }

    @Override
    public Courier getNewsData() {
        Courier courier = new Courier();
        courier.setCurrentUser(userService.getCurrentUser());
        courier.setCurrentUserAvatar(userService.getCurrentUserPicture());

        List<News> news = getNews();
        List<News> newsList = new ArrayList<>();
        for (News n : news){
            if (n.getUser().getId().equals(userService.getCurrentUser().getId())){
                newsList.add(n);
            }
        }
        courier.setNewsList(newsList);

        List<Picture> pictures = pictureService.getPictures();
        List<Picture> pictureList = new ArrayList<>();
        for (News n : newsList){
            for (Picture p : pictures){
                if (p.getNews()!=null && p.getNews().getId().equals(n.getId())){
                    pictureList.add(p);
                }
            }
        }
        courier.setNewsPictures(pictureList);


        List<Likes> likes = likesService.allLikes();
        List<Likes> newsLikes = new ArrayList<>();
        for (Likes l : likes){
            if (l.getNews()!=null){
                newsLikes.add(l);
            }
        }
        List<Integer> likesList = new ArrayList<>();
        int amount = 0;
        for (News n : newsList) {
            for (Likes l : newsLikes) {
                if (l.getNews().getId().equals(n.getId())) {
                    amount++;
                }
            }
            likesList.add(amount);
            amount=0;
        }
        courier.setAmountLikesOnNews(likesList);

        List<CommentDto> comments = commentService.getCommentsByNews(newsList);
        courier.setCommentsByNews(comments);

        return courier;
    }

    @Override
    public String addDeleteNewsLike(Long newsId) {
        List<Likes> likes = likesService.allLikes();
        List<Likes> newsLikes = new ArrayList<>();
        for (Likes l : likes){
            if (l.getNews()!=null){
                newsLikes.add(l);
            }
        }
        News news = newsRepository.findById(newsId).orElseThrow();
        for (Likes l : newsLikes){
            if (l.getNews().getId().equals(news.getId()) && l.getUser().getId().equals(userService.getCurrentUser().getId())){
                likesService.deleteLike(l);
                return "delete";
            }
        }
        Likes like = new Likes();
        like.setUser(userService.getCurrentUser());
        like.setNews(news);
        likesService.saveLike(like);
        return "add";
    }

    @Override
    public void addComment(Courier courier) {
        if (courier.getCommentNewsId()!=null && courier.getCommentUserEmail()!=null && courier.getCommentNews()!=null){
            Comment comment = new Comment();
            comment.setNews(newsRepository.findById(courier.getCommentNewsId()).orElseThrow());
            comment.setUser(userService.getUserByEmail(courier.getCommentUserEmail()));
            comment.setComment(courier.getCommentNews());
            commentService.saveComment(comment);
        }
    }
}
