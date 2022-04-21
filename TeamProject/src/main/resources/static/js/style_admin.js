$(document).ready(function(){
    $(".next").click(function(e){
        if($(e.target).parent().next().hasClass("regist")){
            $(e.target).parent().fadeOut();
            $(e.target).parent().next().fadeIn();
        } else{
            alert("마지막 페이지입니다");
        }
    })
    
    $(".prev").click(function(e){
        if($(e.target).parent().prev().hasClass("regist")){
            $(e.target).parent().fadeOut();
            $(e.target).parent().prev().fadeIn();
        } else{
            alert("첫 페이지입니다");            
        }
    })
     
    $(".click_menu").click(function(e){
        $(e.target).parent().next("ul").slideToggle();
    })
    
    $(document).ready(function () {
    $(".datepicker").datepicker({
        dateFormat: 'yy-mm-dd',
        dayNames: ['일', '월', '화', '수', '목', '금', '토'],
        dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
        dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
    });
    $(".datepicker").prop('readonly', false); //required사용 
    });

})
