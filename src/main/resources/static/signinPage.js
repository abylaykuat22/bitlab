function addUser(){
    var radios = document.getElementsByName('gender');
    var userGender="";
    for (let i = 0; i < radios.length; i++) {
        if (radios[i].checked){
            userGender = radios[i].value;
            break;
        }
    }

    let bodyObj = {
        "email": document.getElementById('email').value,
        "password": document.getElementById('password').value,
        "rePassword": document.getElementById('re_password').value,
        "fullName": document.getElementById('code_word').value,
        "birthdate": document.getElementById('birthdate').value,
        "codeWord":document.getElementById('code_word').value,
        "gender": userGender
    };

    if (document.getElementById('email').value!=="",
    document.getElementById('password').value!=="",
    document.getElementById('re_password').value!=="",
    document.getElementById('code_word').value!=="",
    document.getElementById('birthdate').value!=="",
    document.getElementById('code_word').value!=="",
    userGender!=="") {
        if (bodyObj.password === document.querySelector('#re_password').value) {
            xhttp = new XMLHttpRequest();
            xhttp.onload = function () {

                var result = "";
                result += "<div class='alert alert-success alert-dismissible fade show' style='padding: 15px' role='alert'>"
                result += "<strong>" + "Your account created successfully! Enter data to log in." + "</strong>"
                result += "<div style='padding-left: 150px; padding-right: 150px'>"
                result += "<button type='button' class='btn btn-success mt-3 form-control' data-bs-dismiss='modal'>" + "OK" + "</button>"
                result += "</div>"
                result += "</div>"
                document.getElementById('addSuccess').innerHTML = result;
            }
            xhttp.open("POST", "http://localhost:8000/user")
            xhttp.setRequestHeader("Content-type", "application/json;charset=UTF-8");
            xhttp.send(JSON.stringify(bodyObj));
        } else {
            document.getElementById('errorPassword').innerHTML = "Incorrect password! Try again."
        }
    }
}

function getDate() {
    var today = new Date();
    var dd = today.getDate();
    var mm = today.getMonth() + 1; //January is 0!
    var yyyy = today.getFullYear();

    if (dd < 10) {
        dd = '0' + dd
    }

    if (mm < 10) {
        mm = '0' + mm
    }

    today = yyyy + '-' + mm + '-' + dd;
    console.log(today);
    document.getElementById("birthdate").value = today;
};


window.onload = function () {
    getDate();
};


function openAddModal() {
    const myModal = new bootstrap.Modal('#addModal', {backdrop: true, focus: false, keyboard: false});
    myModal.show();
}

function resetPassword(){
    var result="";

    result+="<div id='errorResetPassword'></div>"
    result+="<input type='email' id='email' placeholder='Email' class='form-control mt-3'>"
    result+="<input type='text' id='code_word' placeholder='Enter your code word' class='form-control mt-3'>"
    result+="<button onclick='checkCodeWord()' class='btn btn-primary mt-3 form-control'>Reset password</button>"
    document.getElementById('codeWord').innerHTML=result
}


function checkCodeWord(){
    xhttp = new XMLHttpRequest();
    xhttp.onload = function (){
        var user = JSON.stringify(this.responseText)
        if (user!=null){
            document.getElementById('errorResetPassword').innerHTML=result
            const myModal = new bootstrap.Modal('#resetPasswordModal', {backdrop: true, focus: false, keyboard: false});
            var user = JSON.parse(this.responseText)
            document.getElementById('user_email').value = user.email
            myModal.show();
        }
    }
    var bodyObj = {
        "email": document.getElementById('email').value,
        "codeWord": document.getElementById('code_word').value,
    };
    xhttp.open("POST","http://localhost:8000/user/checkCW")
    xhttp.setRequestHeader("Content-type", "application/json;charset=UTF-8");
    xhttp.send(JSON.stringify(bodyObj));

    var result="";
    result+="<div class='alert alert-danger alert-dismissible fade show' role='alert'>"
    result+="<h5 class='text-center'>Incorrect data! Try again.</h5>"
    result+="<button type='button' class='btn-close' data-bs-dismiss='alert' aria-label='Закрыть'></button>"
    result+="</div>"
    document.getElementById('errorResetPassword').innerHTML=result
}

function addNewPassword(){
    xhttp = new XMLHttpRequest();
    var bodyObj = {
        "email":document.getElementById('user_email').value,
        "newPassword": document.getElementById('new_password').value
    };

    if (bodyObj.newPassword === document.getElementById('re_new_password').value){
        xhttp.onload = function (){
            var result = "";
            result += "<div class='alert alert-success alert-dismissible fade show' style='padding: 15px' role='alert'>"
            result += "<strong>Your password changed successfully!</strong>"
            result += "<div>"
            result += "</div>"
            result += "</div>"
            location.href="/signin"
            document.getElementById('addNewPasswordResult').innerHTML=result
        }
        xhttp.open("POST","http://localhost:8000/user/newPassword")
        xhttp.setRequestHeader("Content-type", "application/json;charset=UTF-8");
        xhttp.send(JSON.stringify(bodyObj));
    }else {
        document.getElementById('newPasswordError').innerHTML="You entered two different passwords. Please try again."
    }
}