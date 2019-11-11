function setCookie(name, value) {
        document.cookie = name + '=' + value ;
}
function getCookie(name) {
	var value = document.cookie.match('(^|;) ?' + name + '=([^;]*)(;|$)');
    return value? value[2] : null;
}
function deleteCookie() {
    document.cookie = "";
<<<<<<< HEAD
}
=======
}
>>>>>>> 477b340027fb1dbd3ad9ddeb549b90ce575782c4
