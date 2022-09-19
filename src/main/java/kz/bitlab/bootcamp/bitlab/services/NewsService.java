package kz.bitlab.bootcamp.bitlab.services;

import kz.bitlab.bootcamp.bitlab.Courier.Courier;
import kz.bitlab.bootcamp.bitlab.model.News;
import liquibase.pro.packaged.N;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface NewsService {
    List<News> getNews();
    Courier addNews(MultipartFile file, Courier courier);
    void deleteNewsById(Long id);
    Courier getNewsData();
    String addDeleteNewsLike(Long newsId);
    void addComment(Courier courier);

}
