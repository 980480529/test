
jQuery(document).ready(function() {

    /*
        Background slideshow
    */
    $.backstretch([
      "assets/img/backgrounds/1.jpg"
    , "assets/img/backgrounds/2.jpg"
    , "assets/img/backgrounds/3.jpg"
    ], {duration: 3000, fade: 750});

    /*
        Tooltips
    */
    $('.links a.home').tooltip();
    $('.links a.blog').tooltip();

    /*
        Form validation
    */
    $('.register form').submit(function(){
        $(this).find("label[for='username']").html('username');
        $(this).find("label[for='id']").html('id');
        $(this).find("label[for='password']").html('password');
        $(this).find("label[for='passagin']").html('passagain');
        var username = $(this).find('input#username').val();
        var  id = $(this).find('input#id').val();
        var password = $(this).find('input#password').val();
        var passagain = $(this).find('input#passagain').val();
        if(username == '') {
            $(this).find("label[for='firstname']").append("<span style='display:none' class='red'> - 请输入用户名.</span>");
            $(this).find("label[for='firstname'] span").fadeIn('medium');
            return false;
        }
        if( id == '') {
            $(this).find("label[for='id']").append("<span style='display:none' class='red'> -请输入账号.</span>");
            $(this).find("label[for='id'] span").fadeIn('medium');
            return false;
        }
        if(password == '') {
            $(this).find("label[for='password']").append("<span style='display:none' class='red'> - 请输入密码.</span>");
            $(this).find("label[for='password'] span").fadeIn('medium');
            return false;
        }
        
         if(passagain!=password ) {
            $(this).find("label[for='passagain']").append("<span style='display:none' class='red'> - 两次密码不匹配!.</span>");
            $(this).find("label[for='passagain'] span").fadeIn('medium');
            return false;
        }
       
    });


});


