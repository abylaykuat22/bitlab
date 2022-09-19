function loadProfileData() {
    currentUserData();
    getFriendsData();
    loadNewsData();
    friendsData();
    friendRequests();
}

let input = document.getElementById("inputTag");
let imageName = document.getElementById("imageName")

input.addEventListener("change", () => {
    let inputImage = document.querySelector("input[type=file]").files[0];
    imageName.innerText = inputImage.name;
})

function deletePicture(id) {
    const myModal = new bootstrap.Modal('#deleteModal', {backdrop: true, focus: false, keyboard: false});
    document.getElementById('id').value = id;
    myModal.show();
}

function confirmDelete() {
    xhttp = new XMLHttpRequest();
    xhttp.onload = function () {
        location.href = '/profile';
    }
    let bodyObj = {
        "id": document.getElementById('id').value
    };
    xhttp.open("DELETE", "http://localhost:8000/likes/picture")
    xhttp.setRequestHeader("Content-type", "application/json;charset=UTF-8");
    xhttp.send(JSON.stringify(bodyObj));
}

function addNews() {
    xhttp = new XMLHttpRequest();
    xhttp.onload = function () {
        alert(this.responseText)
        location.href = '/profile';
    }
    let bodyObj = {
        "desciption": document.getElementById('desciption').value,
        "newsPicture": document.getElementById('news_picture').value
    };
    xhttp.open("POST", "http://localhost:8000/newss")
    xhttp.setRequestHeader("Content-type", "application/json;charset=UTF-8");
    xhttp.send(bodyObj);
}

function deleteNews(id) {
    const myModal = new bootstrap.Modal('#deleteNewsModal', {backdrop: true, focus: false, keyboard: false});
    document.getElementById('news_id').value = id;
    myModal.show();

}

function currentUserData() {
    xhttp = new XMLHttpRequest();
    xhttp.onload = function () {
        var currentUserData = JSON.parse(this.responseText);
        var result = "";
        var newsPicturesHTML = "";
        for (let i = 0; i < currentUserData.pictureList.length; i++) {
            for (let j = 0; j < currentUserData.amountLikesOnPicture.length; j++) {
                if (currentUserData.pictureList[i].rolePicture === 'ROLE_PROFILE' || currentUserData.pictureList[i].rolePicture === 'ROLE_PORTFOLIO') {
                    result += "<div class='col-4 mb-2'>"
                    result += "<div class='thumbnail'>"
                    result += "<div class='img-wrap' style='width: 100%;'>"
                    result += "<input type='hidden' id='rolePortfolio' value='ROLE_PORTFOLIO'>"
                    result += "<span onclick='deletePicture(" + currentUserData.pictureList[i].id + ")' class='close' style='padding-bottom: 9px;'>&times;</span>"
                    result += "<a href='/getPictures/" + currentUserData.pictureList[i].picture + "'>"
                    result += "<img src='/getPictures/" + currentUserData.pictureList[i].picture + "' style='width:100%; height: 130px;'>"
                    result += "</a>"
                    result += "<div class='d-flex justify-content-center mb-1 mt-1'><button onmouseover='likedUsers(" + currentUserData.pictureList[i].id + ")' onmouseout='qwe()' class='btn' style='background-color: #00a6df; padding-bottom: 2px; width: 40px'></button></div>"
                    result += "<div class='d-flex justify-content-center'>"
                    result += "<button onclick='likePicture(" + currentUserData.pictureList[i].id + ")' class='d-flex btn align-items-center' style='background-color: rgb(225,225,225);border-radius: 16px; padding: 6px;'>"
                    result += "<i class='fa fa-thumbs-up' style='color: blue' aria-hidden='true'></i>"
                    if (currentUserData.amountLikesOnPicture[i] != 0) {
                        result += "<div style='padding-left: 2px'>" + currentUserData.amountLikesOnPicture[i] + "</div>"
                    } else {
                        result += "<div style='padding-left: 2px; color: rgb(225,225,225)'>" + currentUserData.amountLikesOnPicture[i] + "</div>"
                    }
                    result += "</button>"
                    result += "</div>"
                    result += "</div>"
                    result += "</div>"
                    result += "</div>"
                    break;
                }
            }
        }
        document.getElementById('user_data').innerHTML = result;
    }
    xhttp.open("GET", "http://localhost:8000/user/currentUserData")
    xhttp.send();
}


function likedUsers(id) {
    xhttp = new XMLHttpRequest();
    xhttp.onload = function () {
        var users = JSON.parse(this.responseText);
        var result = "";
        for (let i = 0; i < users.length; i++) {
            result += "<div class='d-flex justify-content-between'>"
            result += "<div class='d-flex'>"
            // result+="<img src=\"/getPictures/"+avatarPicture[i].picture+"\" style='width: 44px; height: 40px; border-radius: 40px'>"
            result += "<img src='/getDefaultAvatar' style='width: 44px; height: 40px; border-radius: 40px'>"
            result += "<div style=\"padding-left: 8px; font-size: 13px; color: #0047c9\" class='d-flex align-items-center'>" + users[i].fullName + "</div>"
            result += "   </div>"
            result += "<div class=\"d-flex align-items-center text-secondary\" style='font-size: 13px;'>"
            result += "<div>liked at</div>"
            result += "   </div>"
            result += "<div class=\"d-flex align-items-center text-secondary\" style='font-size: 13px;'>11111111</div>"
            result += "</div>"
            result += "<hr style='margin: 0px;'>"
        }
        document.getElementById('likedUsersInfo').style = 'display:block; border: solid 1px #E1E1E1FF; border-radius: 5px; margin-top:10px;'
        document.getElementById('likedUsersInfo').innerHTML = result
    }

    xhttp.open("GET", "http://localhost:8000/likes/" + id)
    xhttp.send();
}

function qwe() {
    document.getElementById('likedUsersInfo').style = 'display:none;'
}

function likePicture(id) {
    let pictureId = id;
    xhttp = new XMLHttpRequest();
    xhttp.onload = function () {
        currentUserData();
    }
    let bodyObj = {
        "id": pictureId
    };
    xhttp.open("POST", "http://localhost:8000/likes")
    xhttp.setRequestHeader("Content-type", "application/json;charset=UTF-8");
    xhttp.send(JSON.stringify(bodyObj));
}

function loadNewsData() {
    xhttp = new XMLHttpRequest();
    xhttp.onload = function () {
        var newsData = JSON.parse(this.responseText)
        var result = "";
        for (let i = 0; i < newsData.newsList.length; i++) {
            for (let j = 0; j < newsData.amountLikesOnNews.length; j++) {
                result += "<div class='bg-white mt-3' style='border-radius: 8px; padding: 10px'>"
                result += "<div class='mb-3'>"
                result += "<div>"
                result += "<div>"
                result += "<div class='d-flex justify-content-between'>"
                result += "<div class='d-flex'>"
                result += "<div style='padding-right: 11px'>"
                if (newsData.currentUser.statusAvatar == "null") {
                    result += "<img src='/getDefaultAvatar' style='width: 44px; height: 40px; border-radius: 40px'>"
                } else {
                    result += "<img src='/getPictures/" + newsData.currentUserAvatar.picture + "' style='width: 44px; height: 44px; border-radius: 40px; margin-right: 3px; margin-left: 2px'>"
                }
                result += "</div>"
                result += "<div>"
                result += "<p style='margin-bottom: 0px; font-size: 0.8rem;' class='text-primary'>"
                result += "<strong style='color: #0047c9'>" + newsData.newsList[i].user.fullName + "</strong>"
                result += "</p>"
                result += "<p style='font-size: 10px;color: grey;'>" + newsData.newsList[i].createdAt + "</p>"
                result += "</div>"
                result += "</div>"
                result += "<div>"
                result += "<button onclick='deleteNews(" + newsData.newsList[i].id + ")' class='btn'><i style='color: #7d99c0' class='fa fa-trash'></i></button>"
                result += "</div>"
                result += "</div>"
                result += "</div>"
                result += "</div>"
                result += "<p class='mt-2'>" + newsData.newsList[i].description + "</p>"
                result += "<div class='mt-2'>"
                for (let k = 0; k < newsData.newsPictures.length; k++) {
                    if (newsData.newsPictures[k].news != null) {
                        if (newsData.newsPictures[k].news.id == newsData.newsList[i].id) {
                            result += "<a href='/getPictures/" + newsData.newsPictures[k].picture + "'>"
                            result += "<img src='/getPictures/" + newsData.newsPictures[k].picture + "' style='width: 100%; border-radius: 5px'>"
                            result += "</a>"
                        }
                    }
                }
                result += "</div>"
                result += "<div class='mt-2 d-flex'>"
                result += "<button onclick='likeNews(" + newsData.newsList[i].id + ")' class='d-flex btn align-items-center' style='background-color: rgb(225,225,225);border-radius: 16px; padding: 6px;'>"
                result += "<i style='color: blue' class='fa fa-thumbs-up' aria-hidden='true'></i>"

                if (newsData.amountLikesOnNews[i] != 0) {
                    result += "<div style='padding-left: 2px'>" + newsData.amountLikesOnNews[i] + "</div>"
                } else {
                    result += "<div style='padding-left: 2px; color: rgb(225,225,225)'>" + newsData.amountLikesOnNews[i] + "</div>"
                }
                result += "</button>"
                result += "</div>"
                result += "<hr>"
                for (let k = 0; k < newsData.commentsByNews.length; k++) {
                    if (newsData.commentsByNews[i] != null) {
                        if (newsData.commentsByNews[k].news.id == newsData.newsList[i].id) {
                            result += "<div class='text-center text-secondary' style='font-size: 9px'>Comments</div>"
                            result += "<div class='d-flex justify-content-between'>"
                            result += "<div>"
                            result += "<div class='d-flex mt-2'>"
                            result += "<img src='/getDefaultAvatar' style='width: 44px; height: 40px; border-radius: 40px'>"
                            result += "<div>"
                            result += "<div style='font-size: 12px; color:#0047c9;'><strong>" + newsData.commentsByNews[k].user.fullName + "</strong></div>"
                            result += "<div style='font-size: 12px'><strong>" + newsData.commentsByNews[k].comment + "</strong></div>"
                            result += "<div style='font-size: 12px'>" + newsData.commentsByNews[k].createdAt + "</div>"
                            result += "</div>"
                            result += "</div>"
                            result += "</div>"
                            result += "<div>"
                            result += "<button onclick='deleteComment(" + newsData.commentsByNews[k].id + ")' class='btn'><i style='color: #7d99c0' class='text-dark'><strong>x</strong></i></button>"
                            result += "</div>"
                            result += "</div>"
                            result += "<hr style='margin: 8px;'>"
                        }
                    }
                }
                result += "<div class='d-flex'>"
                if (newsData.currentUser.statusAvatar == "null") {
                    result += "<img src='/getDefaultAvatar' style='width: 44px; height: 44px; border-radius: 40px'>"
                } else {
                    result += "<img src='/getPictures/" + newsData.currentUserAvatar.picture + "' style='width: 44px; height: 44px; border-radius: 40px; margin-right: 5px; margin-left: 2px'>"
                }
                result += "<textarea name='comment_news' class='form-control' placeholder='Leave a comment...' rows='1' style='margin-left: 10px'></textarea>"
                result += "<input type='hidden' id='comment_user_email' value='" + newsData.currentUser.email + "'>"
                result += "<button onclick='addComment(" + newsData.newsList[i].id + ")' class='btn'><i class='fa fa-chevron-right' aria-hidden='true'></i></button>"
                result += "</div>"
                result += "</div>"
                result += "</div>"
                break;
            }
        }
        document.getElementById('news_data').innerHTML = result;
    }
    xhttp.open("GET", "http://localhost:8000/news")
    xhttp.send();
}

function likeNews(id) {
    let newsId = id;
    xhttp = new XMLHttpRequest();
    xhttp.onload = function () {
        loadNewsData();
    }
    let bodyObj = {
        "id": newsId
    };
    xhttp.open("POST", "http://localhost:8000/likes/likeNews")
    xhttp.setRequestHeader("Content-type", "application/json;charset=UTF-8");
    xhttp.send(JSON.stringify(bodyObj));
}

function deleteNewsConfirm() {
    xhttp = new XMLHttpRequest();
    xhttp.onload = function () {
        loadNewsData();
    }
    let bodyObj = {
        "id": document.getElementById('news_id').value
    };
    xhttp.open("DELETE", "http://localhost:8000/news")
    xhttp.setRequestHeader("Content-type", "application/json;charset=UTF-8");
    xhttp.send(JSON.stringify(bodyObj));
}

function addComment(id) {
    var comments = document.getElementsByName('comment_news')
    var comment = "";
    for (let i = 0; i < comments.length; i++) {
        if (comments[i].value != "") {
            comment = comments[i].value
        }
    }

    xhttp = new XMLHttpRequest();
    xhttp.onload = function () {
        loadNewsData();
    }
    let bodyObj = {
        "commentNewsId": id,
        "commentUserEmail": document.getElementById('comment_user_email').value,
        "commentNews": comment
    }
    xhttp.open("POST", "http://localhost:8000/comment")
    xhttp.setRequestHeader("Content-type", "application/json;charset=UTF-8");
    xhttp.send(JSON.stringify(bodyObj));
}

function deleteComment(id) {
    const myModal = new bootstrap.Modal('#deleteCommentModal', {backdrop: true, focus: false, keyboard: false});
    document.getElementById('comment_id').value = id;
    myModal.show();

}

function deleteCommentConfirm() {
    xhttp = new XMLHttpRequest();
    xhttp.onload = function () {
        loadNewsData();
    }
    let bodyObj = {
        "id": document.getElementById('comment_id').value
    };
    xhttp.open("DELETE", "http://localhost:8000/comment")
    xhttp.setRequestHeader("Content-type", "application/json;charset=UTF-8");
    xhttp.send(JSON.stringify(bodyObj));
}

function getFriendsData() {
    xhttp = new XMLHttpRequest();
    xhttp.onload = function () {
        var array = JSON.parse(this.responseText)
        var result = ""
        for (let i = 0; i < array.getAllUsers.length; i++) {
            if (array.getAllUsers[i].id != array.currentUser.id) {
                result += "<div>"
                result += "<div class='d-flex justify-content-between'>"
                result += "<div class='d-flex'>"

                if (array.getAllUsers[i].statusAvatar == "null") {
                    result += "<img src='/getDefaultAvatar' style='width: 44px; height: 44px; border-radius: 40px'>"
                } else {
                    for (let j = 0; j < array.getUsersAvatars.length; j++) {
                        if (array.getUsersAvatars[j] != null) {
                            if (array.getUsersAvatars[j].user.id == array.getAllUsers[i].id) {
                                result += "<img src='/getPictures/" + array.getUsersAvatars[j].picture + "' style='width: 44px; height: 44px; border-radius: 40px; margin-right: 5px; margin-left: 2px'>"
                            }
                        }
                    }
                }
                result += "<div style='margin-left: 10px'>"
                result += "<div><label style='font-size: 12px; color: #0047c9'>" + array.getAllUsers[i].fullName + "</label></div>"
                result += "<input type='hidden' id='user_sender_id' value='"+array.currentUser.id+"'>"
                result += "<div><button onclick='addFriend(" + array.getAllUsers[i].id + ")' class='btn btn-light' style='font-size: 12px'>+Add friend</button></div>"
                result += "</div>"
                result += "</div>"
                result += "<div>"
                result += "</div>"
                result += "</div>"
                result += "<hr>"
                result += "</div>"
            }
        }
        document.getElementById('unknown_users').innerHTML = result
    }
    xhttp.open("GET", "http://localhost:8000/friends_controller")
    xhttp.send();
}

function addFriend(userRecipientId) {
    xhttp = new XMLHttpRequest();
    xhttp.onload = function () {
        getFriendsData();
    }
    let bodyObj = {
        "userRecipientId": userRecipientId,
        "userSenderId": document.getElementById('user_sender_id').value
    };
    xhttp.open("POST", "http://localhost:8000/friends_controller")
    xhttp.setRequestHeader("Content-type", "application/json;charset=UTF-8");
    xhttp.send(JSON.stringify(bodyObj));
}

function friendsData() {
    xhttp = new XMLHttpRequest();
    xhttp.onload = function () {
        var array = JSON.parse(this.responseText)
        var result = ""
        if (array.currentUser.statusFriends == "null") {
            result += "<div class='text-center'>You don't have any friends yet</div>"
        }
        if (array.users != 0) {
            for (let i = 0; i < array.users.length; i++) {
                result += "<div>"
                result += "<div class='d-flex justify-content-between'>"
                result += "<div class='d-flex'>"
                if (array.users[i].statusAvatar == "null") {
                    result += "<img src='/getDefaultAvatar' style='width: 44px; height: 44px; border-radius: 40px'>"
                } else {
                    for (let j = 0; j < array.getUsersAvatars.length; j++) {
                        if (array.getUsersAvatars[j] != null) {
                            if (array.getUsersAvatars[j].user.id == array.users[i].id) {
                                result += "<img src='/getPictures/" + array.getUsersAvatars[j].picture + "' style='width: 44px; height: 44px; border-radius: 40px; margin-right: 5px; margin-left: 2px'>"
                            }
                        }
                    }
                }
                result += "<div style='margin-left: 10px'>"
                result += "<div><label style='font-size: 12px; color: #0047c9'>" + array.users[i].fullName + "</label></div>"
                result += "<div><button onclick='deleteFriend(" + array.users[i].id + ")' class='btn btn-danger' style='font-size: 12px'>Unfriend</button></div>"
                result += "</div>"
                result += "</div>"
                result += "<div>"
                result += "</div>"
                result += "</div>"
                result += "<hr>"
                result += "</div>"
            }
        }

        document.getElementById('friends_data').innerHTML = result
    }
    xhttp.open("GET", "http://localhost:8000/friends_controller/friendsList")
    xhttp.send();
}


function friendRequests() {
    xhttp = new XMLHttpRequest();
    xhttp.onload = function () {
        var array = JSON.parse(this.responseText)
        var result = ""
        if (array.users != 0) {
            for (let j = 0; j < array.userSenderIdList.length; j++) {
                if (array.userSenderIdList[j] != array.currentUser.id){
                    result += "<label>Friend requests</label>"
                    result += "<hr>"
                    for (let i = 0; i < array.users.length; i++) {
                        result += "<div>"
                        result += "<div class='d-flex justify-content-between'>"
                        result += "<div class='d-flex'>"
                        if (array.users[i].statusAvatar == "null") {
                            result += "<img src='/getDefaultAvatar' style='width: 44px; height: 44px; border-radius: 40px'>"
                        } else {
                            for (let j = 0; j < array.getUsersAvatars.length; j++) {
                                if (array.getUsersAvatars[j] != null) {
                                    if (array.getUsersAvatars[j].user.id == array.users[i].id) {
                                        result += "<img src='/getPictures/" + array.getUsersAvatars[j].picture + "' style='width: 44px; height: 44px; border-radius: 40px; margin-right: 5px; margin-left: 2px'>"
                                    }
                                }
                            }
                        }
                        result += "<div style='margin-left: 10px'>"
                        result += "<div><label style='font-size: 12px; color: #0047c9'>" + array.users[i].fullName + "</label></div>"
                        result += "<input type='hidden' id='confirm_user_sender_id' value='"+array.currentUser.id+"'>"
                        result += "<div><button onclick='confirmAddFriend(" + array.users[i].id + ")' class='btn btn-success' style='font-size: 12px'>Accept request</button></div>"
                        result += "</div>"
                        result += "</div>"
                        result += "<div>"
                        result += "</div>"
                        result += "</div>"
                        result += "<hr>"
                        result += "</div>"
                    }
                    break;
                }
            }
        }
        document.getElementById('friend_requests').innerHTML = result
    }
    xhttp.open("GET", "http://localhost:8000/friends_controller/friendRequests")
    xhttp.send();
}

function confirmAddFriend(userRecipientId){
    xhttp = new XMLHttpRequest();
    xhttp.onload = function (){
        friendRequests();
        friendsData();
    }
    let bodyObj = {
        "userRecipientId": userRecipientId,
        "userSenderId": document.getElementById('confirm_user_sender_id').value
    };
    xhttp.open("POST", "http://localhost:8000/friends_controller/confirmAdd")
    xhttp.setRequestHeader("Content-type", "application/json;charset=UTF-8");
    xhttp.send(JSON.stringify(bodyObj))
}