package kz.bitlab.bootcamp.bitlab.Courier;

import kz.bitlab.bootcamp.bitlab.dto.CommentDto;
import kz.bitlab.bootcamp.bitlab.dto.NewsDto;
import kz.bitlab.bootcamp.bitlab.dto.PictureDto;
import kz.bitlab.bootcamp.bitlab.dto.UserDto;
import kz.bitlab.bootcamp.bitlab.model.News;
import kz.bitlab.bootcamp.bitlab.model.Picture;
import kz.bitlab.bootcamp.bitlab.model.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class Courier {
    private Long id;
    private String currentPassword;
    private String password;
    private String fullName;
    private LocalDate birthdate;
    private String gender;
    private String newPassword;
    private String reNewPassword;
    private String codeWord;
    private String email;
    private String picture;
    private String rolePicture;
    private String description;
    private News news;
    private Picture pictureObj;
    private List<Picture> pictures;
    private List<Long> pictureLongList;
    private List<Integer> countLikes;
    private List<Integer> amountLikesOnPicture;
    private List<Picture> pictureList;
    private List<News> newsList;
    private List<Integer> amountLikesOnNews;
    private List<UserDto> users;
    private User currentUser;
    private User user;
    private Picture currentUserAvatar;
    private List<Picture> newsPictures;
    private List<CommentDto> commentsByNews;
    private Long commentNewsId;
    private String commentUserEmail;
    private String commentNews;
    private List<UserDto> getAllUsers;
    private List<PictureDto> getUsersAvatars;
    private Long userId;
    private List<Long> userSenderIdList;
    private Long userSenderId;
    private Long userRecipientId;
    private List<Long> usersId;
    private boolean check;
    private List<PictureDto> pictureDtoList;
    private List<NewsDto> newsDtoList;
    private List<CommentDto> commentDtoList;
    private UserDto userDto;
}
