
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
      
        $(this).find("label[for='id']").html('id');
        $(this).find("label[for='password']").html('password');
        var  id = $(this).find('input#id').val();
        var password = $(this).find('input#password').val();
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
       
    });


});


