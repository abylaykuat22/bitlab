function inputForms(){
    var body = ""
    body+="<input type='password' id='current_password' class='form-control' placeholder='Current password'>"
    body+="<input type='password' id='new_password' class='form-control mt-3' placeholder='New password'>"
    body+="<input type='password' id='re_new_password' class='form-control mt-3' placeholder='Repeat new password'>"
    body+="<button onclick='changePassword()' class='mt-3 btn btn-success'>Change password</button>"
    document.getElementById('passwordInputs').innerHTML=body
}
function changePassword(){
    var bodyObj = {
        "currentPassword": document.getElementById('current_password').value,
        "newPassword": document.getElementById('new_password').value,
        "reNewPassword": document.getElementById('re_new_password').value,
    };


    if (bodyObj.newPassword === document.getElementById('re_new_password').value){
        xhttp = new XMLHttpRequest();
        xhttp.onload = function (){
            if (this.responseText==="success"){
                var result="";
                result+="<div class='alert alert-success alert-dismissible fade show' role='alert'>"
                result+="<h5 class='text-center'>Your password was successfully changed!</h5>"
                result+="<button type='button' class='btn-close' data-bs-dismiss='alert' aria-label='Закрыть'></button>"
                result+="</div>"
                document.getElementById('resultChangePassword').innerHTML=result
                document.getElementById('current_password').value=""
                document.getElementById('new_password').value=""
                document.getElementById('re_new_password').value=""
            }
        }
        xhttp.open("PUT","http://localhost:8000/user")
        xhttp.setRequestHeader("Content-type", "application/json;charset=UTF-8");
        xhttp.send(JSON.stringify(bodyObj));
    }else {
        var result="";
        result+="<div class='alert alert-danger alert-dismissible fade show' role='alert'>"
        result+="<h5 class='text-center'>Incorrect password! Try again.</h5>"
        result+="<button type='button' class='btn-close' data-bs-dismiss='alert' aria-label='Закрыть'></button>"
        result+="</div>"
        document.getElementById('resultChangePassword').innerHTML=result
    }
}