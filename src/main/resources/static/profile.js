function loadProfileData() {
    picturesLikes();
    newsPictures();
    newsLikes();
    newsComments();
    userComment();
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
    let userId = document.getElementById('current_user_id').value
    xhttp = new XMLHttpRequest();
    xhttp.onload = function () {
        location.href = '/profile/'+userId;
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

function picturesLikes(){
    xhttp = new XMLHttpRequest();
    xhttp.onload = function () {
        var array = JSON.parse(this.responseText)
        for (let i = 0; i < array.pictures.length; i++) {
            if (document.getElementById(''+array.pictures[i].id+'_picture')!=null){
                document.getElementById(''+array.pictures[i].id+'_picture').innerHTML =
                    "<div class='d-flex justify-content-center mb-1 mt-1'><button onmouseover='likedUsers(" + array.pictures[i].id + ")' onmouseout='qwe()' class='btn' style='background-color: #00a6df; padding-bottom: 2px; width: 40px'></button></div>" +
                    "<div class='d-flex justify-content-center'>" +
                    "<button onclick='likePicture(" + array.pictures[i].id + ")' class='d-flex btn align-items-center' style='background-color: rgb(225,225,225);border-radius: 16px; padding: 6px;'>"+
                    "<i class='fa fa-thumbs-up' style='color: blue' aria-hidden='true'></i>"+
                    "<div style='padding-left: 2px;'>" + array.pictures[i].amountLikes + "</div>"+
                    "</button>"+
                    "</div>"

                // else if (array.check === false){
                //     document.getElementById(''+array.pictures[i].id+'_picture').innerHTML =
                //         "<div class='d-flex justify-content-center mb-1 mt-1'><button onmouseover='likedUsers(" + array.pictures[i].id + ")' onmouseout='qwe()' class='btn' style='background-color: #00a6df; padding-bottom: 2px; width: 40px'></button></div>" +
                //         "<div class='d-flex justify-content-center'>" +
                //         "<button onclick='likePicture(" + array.pictures[i].id + ")' class='d-flex btn align-items-center' style='background-color: rgb(225,225,225);border-radius: 16px; padding: 6px;'>"+
                //         "<i class='fa fa-thumbs-up' style='color: grey' aria-hidden='true'></i>"+
                //         "<div style='padding-left: 2px;'>" + array.pictures[i].amountLikes + "</div>"+
                //         "</button>"+
                //         "</div>"
                // }
            }
        }
    }
    xhttp.open("GET", "http://localhost:8000/picture/likes")
    xhttp.send();
}

function newsPictures(){
    xhttp = new XMLHttpRequest();
    xhttp.onload = function () {
        var array = JSON.parse(this.responseText)
        for (let i = 0; i < array.newsDtoList.length; i++) {
            if (document.getElementById(''+array.newsDtoList[i].id+'_news')!=null){
                for (let j = 0; j < array.pictureDtoList.length; j++) {
                    if (array.newsDtoList[i].pictureId == array.pictureDtoList[j].id){
                        document.getElementById(''+array.newsDtoList[i].id+'_news').innerHTML=
                            "<img src='/getPictures/"+array.pictureDtoList[j].picture+"' class='mb-2' style='width: 100%; border-radius: 5px'>"
                    }
                }
            }
        }
    }
    xhttp.open("GET", "http://localhost:8000/news/pictures")
    xhttp.send();
}

function newsLikes() {
    xhttp = new XMLHttpRequest();
    xhttp.onload = function () {
        var array = JSON.parse(this.responseText)
        for (let i = 0; i < array.length; i++) {
            if (document.getElementById(array[i].id + '_newsLikes') != null) {
                document.getElementById(array[i].id + '_newsLikes').innerHTML =
                "<div class='d-flex mb-2'>" +
                "<button onclick='likeNews(" + array[i].id + ")' class='d-flex btn align-items-center' style='background-color: rgb(225,225,225);border-radius: 16px; padding: 6px;'>" +
                "<i class='fa fa-thumbs-up' style='color: blue' aria-hidden='true'></i>" +
                "<div style='padding-left: 2px;'>" + array[i].amountLikes + "</div>" +
                "</button>" +
                "</div>"+
                "<hr>"
            }
        }
    }
    xhttp.open("GET", "http://localhost:8000/news/likes")
    xhttp.send();
}

function allNewsLikes() {
    xhttp = new XMLHttpRequest();
    xhttp.onload = function () {
        var array = JSON.parse(this.responseText)
        for (let i = 0; i < array.length; i++) {
            if (document.getElementById('' + array[i].id + '_news_likes') != null) {
                document.getElementById('' + array[i].id + '_news_likes').innerHTML =
                    "<div class='d-flex mb-2'>" +
                    "<button onclick='likeNews(" + array[i].id + ")' class='d-flex btn align-items-center' style='background-color: rgb(225,225,225);border-radius: 16px; padding: 6px;'>" +
                    "<i class='fa fa-thumbs-up' style='color: blue' aria-hidden='true'></i>" +
                    "<div style='padding-left: 2px;'>" + array[i].amountLikes + "</div>" +
                    "</button>" +
                    "</div>"
            }
        }
    }
    xhttp.open("GET", "http://localhost:8000/news/likes")
    xhttp.send();
}

function likedUsers(id) {
    xhttp = new XMLHttpRequest();
    xhttp.onload = function () {
        var users = JSON.parse(this.responseText);
        var result = "";
        for (let i = 0; i < users.length; i++) {
            result += "<div style='margin: 10px;' class='d-flex justify-content-between'>"
            result += "<div class='d-flex'>"
            if (users[i].statusAvatar == 'null'){
                result += "<img src='/getDefaultAvatar' style='width: 44px; height: 40px; border-radius: 40px'>"
            }else {
                result+="<img src=\"/getPictures/"+users[i].statusAvatar+"\" style='width: 44px; height: 40px; border-radius: 40px'>"
            }
            result += "<div style=\"padding-left: 8px; font-size: 13px; color: #0047c9\" class='d-flex align-items-center'><strong>" + users[i].fullName + "</strong></div>"
            result += "   </div>"
            result += "<div class=\"d-flex align-items-center text-secondary\" style='font-size: 13px;'>"
            result += "<div>liked at</div>"
            result += "   </div>"
            result += "<div class=\"d-flex align-items-center text-secondary\" style='font-size: 13px;'>2022.12.22</div>"
            result += "</div>"
            result += "<hr style='margin: 0px'>"
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
        picturesLikes();
    }
    let bodyObj = {
        "id": pictureId
    };
    xhttp.open("POST", "http://localhost:8000/likes")
    xhttp.setRequestHeader("Content-type", "application/json;charset=UTF-8");
    xhttp.send(JSON.stringify(bodyObj));
}

function likeNews(id) {
    let newsId = id;
    xhttp = new XMLHttpRequest();
    xhttp.onload = function () {
        newsLikes();
        allNewsLikes();
    }
    let bodyObj = {
        "id": newsId
    };
    xhttp.open("POST", "http://localhost:8000/likes/likeNews")
    xhttp.setRequestHeader("Content-type", "application/json;charset=UTF-8");
    xhttp.send(JSON.stringify(bodyObj));
}

function newsComments(){
    var id = document.getElementById('profile_user').value
    var result = ""
    xhttp = new XMLHttpRequest();
    xhttp.onload = function () {
        var array = JSON.parse(this.responseText)
        for (let i = 0; i < array.length; i++) {
            if (document.getElementById(''+array[i].id+'_comment')!=null){

                result+="<div id='"+array[i].id+"_comment_data'></div>"

                document.getElementById(''+array[i].id+'_comment').innerHTML = result
            }
        }
    }
    xhttp.open("GET", "http://localhost:8000/news/"+id)
    xhttp.send();
}

function userComment(){
    var id = document.getElementById('profile_user').value
    var comments = ""
    xhttp = new XMLHttpRequest();
    xhttp.onload = function () {
        var array = JSON.parse(this.responseText)
        for (let i = 0; i < array.commentDtoList.length; i++) {
            if(document.getElementById(array.commentDtoList[i].news.id+'_comment_data')!=null){
                comments ="<div class='row'>"
                    comments+="<div class='col-1'>"
                        if (array.commentDtoList[i].user.statusAvatar === "null"){
                            comments+="<img src='/getDefaultAvatar' style='width: 44px; height: 44px; border-radius: 40px;'>"
                        }else if (array.commentDtoList[i].user.statusAvatar !== "null"){
                            comments+="<img src='/getPictures/" + array.commentDtoList[i].user.statusAvatar + "' style='width: 44px; height: 44px; border-radius: 40px;'>";
                        }
                    comments+="</div>"
                    comments+="<div class='col-11' style='padding-left: 25px'>"
                        comments +="<div class='d-flex justify-content-between'>"
                        comments +="<div>"
                        comments +="<a href='/profile/"+array.commentDtoList[i].user.id+"' style='text-decoration: none'>"
                        comments += "<div style='margin-bottom: 0px; font-size: 12px; color:#0047c9; '><strong>"+array.commentDtoList[i].user.fullName+"</strong></div>"
                        comments +="</a>"
                        comments += "<div >"+array.commentDtoList[i].comment+"</div>"
                        comments += "<div style='font-size: 12px;color: grey;'>"+array.commentDtoList[i].createdAt+"</div>"
                        comments+="</div>"
                        comments+="<div>"
                        if (array.userDto.id === array.commentDtoList[i].user.id ){
                            comments += "<button onclick='deleteComment(" + array.commentDtoList[i].id + ")' class='btn'><i class='text-secondary'><strong>x</strong></i></button>"
                        }
                        comments+="</div>"
                        comments+="</div>"
                        comments+="<hr>"
                    comments+="</div>"
                comments+="</div>"
                document.getElementById(array.commentDtoList[i].news.id+'_comment_data').innerHTML += comments;
            }
        }
    }
    xhttp.open("GET", "http://localhost:8000/news/comments/"+id)
    xhttp.send();
}

function allNewsComments(){
    var result = ""
    xhttp = new XMLHttpRequest();
    xhttp.onload = function () {
        var array = JSON.parse(this.responseText)
        for (let i = 0; i < array.length; i++) {
            if (document.getElementById(''+array[i].id+'_news_comments')!=null){

                result+="<div id='"+array[i].id+"_comment_data_news_page'></div>"

                document.getElementById(''+array[i].id+'_news_comments').innerHTML = result
            }
        }
    }
    xhttp.open("GET", "http://localhost:8000/news/list")
    xhttp.send();
}


function allUserComments() {
    xhttp = new XMLHttpRequest();
    xhttp.onload = function () {
        var result = ""
        var array = JSON.parse(this.responseText)
        for (let i = 0; i < array.commentDtoList.length; i++) {
            if (document.getElementById('' + array.commentDtoList[i].news.id + '_comment_data_news_page') != null) {
                result = "<div class='row'>"
                result += "<div class='col-1'>"
                if (array.commentDtoList[i].user.statusAvatar == 'null') {
                    result += "<img src='/getDefaultAvatar' style='width: 44px; height: 44px; border-radius: 40px; margin-right: 15px; margin-left: 2px'>"
                }
                if (array.commentDtoList[i].user.statusAvatar != 'null') {
                    result += "<img src='/getPictures/" + array.commentDtoList[i].user.statusAvatar + "' style='width: 44px; height: 44px; border-radius: 40px; margin-right: 15px; margin-left: 2px'>"
                }
                result += "</div>"
                result += "<div class='col-11'>"
                result += "<div class='d-flex justify-content-between'>"
                result += "<div>"
                result += "<a href='/profile/" + array.commentDtoList[i].user.id + "' style='text-decoration: none'>"
                result += "<div style='font-size: 15px; color:#0047c9;'>" + array.commentDtoList[i].user.fullName + "</div>"
                result += "</a>"
                result += "<div style='font-size: 15px;' class='mb-1'>" + array.commentDtoList[i].comment + "</div>"
                result += "<div style='font-size: 12px; color: grey'>" + array.commentDtoList[i].createdAt + "</div>"
                result += "</div>"
                result += "<div>"
                if (array.userDto.id === array.commentDtoList[i].user.id) {
                    result += "<button onclick='deleteCommentNewsPage(" + array.commentDtoList[i].id + ")' class='btn'><i class='text-secondary'><strong>x</strong></i></button>"
                }
                result += "</div>"
                result += "</div>"
                result += "<hr>"
                result += "</div>"
                result += "</div>"
                document.getElementById('' + array.commentDtoList[i].news.id + '_comment_data_news_page').innerHTML += result
            }
        }
    }
    xhttp.open("GET", "http://localhost:8000/news/comments")
    xhttp.send();
}

function deleteNewsConfirm() {
    xhttp = new XMLHttpRequest();
    xhttp.onload = function () {
        location.href = '/profile/'+document.getElementById('profile_user').value;
    }
    let bodyObj = {
        "id": document.getElementById('news_id').value
    }

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
        newsComments();
        userComment();
        document.getElementById('comment_text_profile').value = ''
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

function addCommentNewsPage(id) {
    var comments = document.getElementsByName('comment_news_page')
    var comment = "";
    for (let i = 0; i < comments.length; i++) {
        if (comments[i].value != "") {
            comment = comments[i].value
        }
    }

    xhttp = new XMLHttpRequest();
    xhttp.onload = function () {
        allNewsComments();
        allUserComments();
        document.getElementById('comment_text').value = '';
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

function deleteCommentNewsPage(id) {
    const myModal = new bootstrap.Modal('#deleteCommentNewsPageModal', {backdrop: true, focus: false, keyboard: false});
    document.getElementById('comment_news_page_id').value = id;
    myModal.show();
}

function deleteCommentConfirm() {
    xhttp = new XMLHttpRequest();
    xhttp.onload = function () {
        newsComments();
        userComment();
    }
    let bodyObj = {
        "id": document.getElementById('comment_id').value
    };
    xhttp.open("DELETE", "http://localhost:8000/comment")
    xhttp.setRequestHeader("Content-type", "application/json;charset=UTF-8");
    xhttp.send(JSON.stringify(bodyObj));
}

function deleteCommentConfirmNewsPage() {
    xhttp = new XMLHttpRequest();
    xhttp.onload = function () {
        allNewsComments();
        allUserComments();
    }
    let bodyObj = {
        "id": document.getElementById('comment_news_page_id').value
    };
    xhttp.open("DELETE", "http://localhost:8000/comment")
    xhttp.setRequestHeader("Content-type", "application/json;charset=UTF-8");
    xhttp.send(JSON.stringify(bodyObj));
}

function getUnknownUsers() {
    xhttp = new XMLHttpRequest();
    xhttp.onload = function () {
        var array = JSON.parse(this.responseText)
        var result = ""
        for (let i = 0; i < array.users.length; i++) {
            if (array.users[i].id != array.currentUser.id) {
                result += "<div>"
                result += "<div class='d-flex justify-content-between'>"
                result += "<div class='d-flex'>"
                if (array.users[i].statusAvatar == "null") {
                    result += "<img src='/getDefaultAvatar' style='width: 80px; height: 80px; border-radius: 80px'>"
                } else {
                    for (let j = 0; j < array.getUsersAvatars.length; j++) {
                        if (array.getUsersAvatars[j] != null) {
                            if (array.getUsersAvatars[j].user.id == array.users[i].id) {
                                result += "<img src='/getPictures/" + array.getUsersAvatars[j].picture + "' style='width: 80px; height: 80px; border-radius: 80px;'>"
                            }
                        }
                    }
                }
                result += "<div style='margin-left: 10px'>"
                result += "<a href='/profile/"+array.users[i].id+"'  style='font-size: 15px; color: #0047c9; text-decoration: none'>" + array.users[i].fullName + "</a>"
                result += "<input type='hidden' id='user_sender_id' value='"+array.currentUser.id+"'>"
                result += "<div><button onclick='addFriend(" + array.users[i].id + ")' class='btn btn-light' style='font-size: 12px; background-color: rgb(243 243 243)'>+Add friend</button></div>"
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
        getUnknownUsers();
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
        }else if (array.users != 0) {
                result+="<div>"
                result += "<label>My friends</label>"
                result += "<hr class='mt-2'>"
                result+="</div>"
            for (let i = 0; i < array.users.length; i++) {
                result += "<div>"
                result += "<div class='d-flex justify-content-between'>"
                result += "<div class='d-flex'>"
                if (array.users[i].statusAvatar == "null") {
                    result += "<img src='/getDefaultAvatar' style='width: 80px; height: 80px; border-radius: 80px'>"
                } else {
                    for (let j = 0; j < array.getUsersAvatars.length; j++) {
                        if (array.getUsersAvatars[j] != null) {
                            if (array.getUsersAvatars[j].user.id == array.users[i].id) {
                                result += "<img src='/getPictures/" + array.getUsersAvatars[j].picture + "' style='width: 80px; height: 80px; border-radius: 80px;'>"
                            }
                        }
                    }
                }
                result += "<div style='margin-left: 10px'>"
                result+= "<a href='/profile/"+array.users[i].id+"'>"
                result += "<div class='mb-1' style='font-size: 15px; color: #0047c9; text-decoration: none'>" + array.users[i].fullName + "</div>"
                result+= "</a>"
                result += "<input type='hidden' id='user_sender_id' value='"+array.currentUser.id+"'>"
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
                    result+="<div>"
                    result += "<label>Friend requests</label>"
                    result += "<hr>"
                    result+="</div>"
                    for (let i = 0; i < array.users.length; i++) {
                        result += "<div>"
                        result += "<div class='d-flex justify-content-between'>"
                        result += "<div class='d-flex'>"
                        if (array.users[i].statusAvatar == "null") {
                            result += "<img src='/getDefaultAvatar' style='width: 80px; height: 80px; border-radius: 80px'>"
                        }

                        for (let j = 0; j < array.getUsersAvatars.length; j++) {
                            if (array.getUsersAvatars[j] != null) {
                                if (array.getUsersAvatars[j].user.id == array.users[i].id) {
                                    result += "<img src='/getPictures/" + array.getUsersAvatars[j].picture + "' style='width: 80px; height: 80px; border-radius: 80px;'>"
                                }
                            }
                        }
                        result += "<div style='margin-left: 10px'>"
                        result += "<div><label style='font-size: 15px; color: #0047c9'>" + array.users[i].fullName + "</label></div>"
                        result += "<input type='hidden' id='confirm_user_sender_id' value='"+array.currentUser.id+"'>"
                        result += "<div class='d-flex'>"
                        result += "<div><button onclick='confirmAddFriend(" + array.users[i].id + ")' class='btn btn-success' style='font-size: 12px'>Accept request</button></div>"
                        result += "<div><button onclick='cancelRequest(" + array.users[i].id + ")' class='btn btn-light' style='font-size: 12px; background-color: rgb(225,225,225)'>Unaccept request</button></div>"
                        result += "</div>"
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
        friendsData();
        friendRequests();
    }
    let bodyObj = {
        "userRecipientId": userRecipientId,
        "userSenderId": document.getElementById('confirm_user_sender_id').value
    };
    xhttp.open("POST", "http://localhost:8000/friends_controller/confirmAdd")
    xhttp.setRequestHeader("Content-type", "application/json;charset=UTF-8");
    xhttp.send(JSON.stringify(bodyObj))
}

function deleteFriend(id){
    currentUserId = document.getElementById('user_sender_id').value
    const myModal = new bootstrap.Modal('#deleteFriendModal', {backdrop: true, focus: false, keyboard: false});
    document.getElementById('friends_user_recipient_id').value = id;
    document.getElementById('friends_user_sender_id').value = currentUserId;
    myModal.show();
}

function deleteFriendConfirm(){
    xhttp = new XMLHttpRequest();
    xhttp.onload = function (){
        friendRequests();
        friendsData();
    }
    let bodyObj = {
        "userRecipientId": document.getElementById('friends_user_recipient_id').value,
        "userSenderId": document.getElementById('friends_user_sender_id').value
    };
    xhttp.open("DELETE", "http://localhost:8000/friends_controller/confirm_delete")
    xhttp.setRequestHeader("Content-type", "application/json;charset=UTF-8");
    xhttp.send(JSON.stringify(bodyObj))
}

function cancelRequest(userRecipientId){
    xhttp = new XMLHttpRequest();
    xhttp.onload = function (){
        friendRequests();
        friendsData();
    }
    let bodyObj = {
        "userRecipientId": userRecipientId,
        "userSenderId": document.getElementById('confirm_user_sender_id').value
    };
    xhttp.open("DELETE", "http://localhost:8000/friends_controller")
    xhttp.setRequestHeader("Content-type", "application/json;charset=UTF-8");
    xhttp.send(JSON.stringify(bodyObj))
}