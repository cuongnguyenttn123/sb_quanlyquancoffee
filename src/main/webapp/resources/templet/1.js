 $(function(){
   $('.n1').click(function(){
    $("html, body").animate({ scrollTop: 0 });
    $('.menu-right').removeClass('ra');
    return false;
})
    $('.n2').click(function(){
    $('html, body').animate({ scrollTop: $('.top2').offset().top });
    $('.menu-right').removeClass('ra');
    return false;
})
$('.n3').click(function(){
    $("html, body").animate({ scrollTop: $('.top6').offset().top });
    $('.menu-right').removeClass('ra');
    return false;
})
$('.n4').click(function(){
    $("html, body").animate({ scrollTop: $('.top8').offset().top });
    $('.menu-right').removeClass('ra');
    return false;
})
     var docao = $(window).height();
     $('.top1').css({'height':docao})

     $(window).resize(function(){
        var docao = $(window).height();
     $('.top1').css({'height':docao})
     });
     $('.nut-menu').click(function(){
         $('.menu-right').addClass('ra');
         return false;
     })
     $('.tat').click(function(){
        $('.menu-right').removeClass('ra');
        return false;
    })
})  
 