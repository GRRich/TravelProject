$(document).on('mouseover', '.topMenu', function() {
    $('.dept01').stop().slideDown(100);
    
});

$(document).on('mouseout', '.dept01', function () {
    if (!$(this).hasClass('topMenu')) {
        $('.dept01').stop().slideUp();
    }
});

$(document).on('mouseout', '.topMenu', function () {
        $('.dept01').stop().slideUp();
});

var tasteImg = document.getElementById("tasteImg");
var outer = document.querySelector(".taste-middle-outer")
var locaImg = document.getElementById("locaImg");
var outer2 = document.querySelector(".taste-middle-outer2")
var playImg = document.getElementById("playImg");
var outer3 = document.querySelector(".taste-middle-outer3")

tasteImg.onclick = function() {
  outer.style.display = "block";

  if(outer2.style.display = "block") {
    outer2.style.display = "none"
  }
  if(outer3.style.display = "block") {
    outer3.style.display = "none"
  }

}


locaImg.onclick = function() {
  outer2.style.display = "block";

  if(outer.style.display = "block") {
    outer.style.display = "none"
  }
  if(outer3.style.display = "block") {
    outer3.style.display = "none"
  }

}


playImg.onclick = function() {
  outer3.style.display = "block";

  if(outer2.style.display = "block") {
    outer2.style.display = "none"
  }
  if(outer.style.display = "block") {
    outer.style.display = "none"
  }

}