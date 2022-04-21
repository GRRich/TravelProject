//메뉴처리JS
$(document).ready(function () {

    $(".gnb").mouseover(function() {
        $(".gnb_depth").stop().fadeIn("fast")
        $(".gnb_depth").css({display: 'block'});
        $(".gnb").append($(".gnb_depth")[0]);
    });
    $(".gnb").mouseleave(function() {
        $(".gnb_depth").stop().fadeOut("fast")
        $(".gnb_depth").css({display: 'none'});
    });

    $(".gnb_depth").mouseover(function() {
        $(".gnb_depth").stop().fadeIn("fast")
        $(".gnb_depth").css({display: 'block' });
        $(".gnb").append($(".gnb_depth")[0]);
    })
    $(".gnb_depth").mouseleave(function() {
        $(".gnb_depth").stop().fadeOut("fast")
        $(".gnb_depth").css({display: 'none'});

    })

});