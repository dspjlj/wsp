function menuAutoHeight(){var e=".list .box",t=$(e),n=t.data("scale");autoHeight(e,n)}function indexSwipe(e,t,n){t&&setSlide("#"+e);var i=new Swipe(document.getElementById(e),{speed:500,auto:n||!1,callback:function(){var t=this.index;$("#"+e+" .sub-slide a").removeClass("active").eq(t).addClass("active")}}),r=$("#"+e).siblings(".slide-prev"),s=$("#"+e).siblings(".slide-next");r.on("click",function(){i.prev()}),s.on("click",function(){i.next()})}function autoHeight(e,t){{var n=$(e).width(),i=parseInt(n*t);$(e).find(".menu-img")}$(e).height(i).css({"line-height":i+"px"})}function setSlide(e){for(var t=$(e),n=t.children().children("li").length,i='<div class="sub-slide">',r='<a href="javascript:;"></a>',s=0;n>s;s++)i+=0==s?'<a href="javascript:;" class="active"></a>':r;i+="</div>",t.append(i)}function newAudio(){var e=$(".mod-music"),t=new Audio("assets/music/music.mp3"),n=e.find("i");t.paused&&(n.attr("class","fa fa-volume-off"),$(document).one("click touchstart",function(){t.play(),n.attr("class","fa fa-volume-up")})),$(e).on("click",function(){t.paused?(t.play(),n.attr("class","fa fa-volume-up")):(t.pause(),n.attr("class","fa fa-volume-off"))})}function fade(){var e=$("#mod-animate"),t=e.data("animate");switch(t){case"fade1":setTimeout(function(){e.fadeOut(3e3)},3e3);break;case"fade2":setTimeout(function(){e.hide(1e3)},3e3);break;case"fade3":setTimeout(function(){e.addClass("active"),setTimeout(function(){e.hide()},500)},3e3);break;case"fade4":setTimeout(function(){e.addClass("active"),setTimeout(function(){e.hide()},500)},3e3);break;case"fade5":setTimeout(function(){e.addClass("active"),setTimeout(function(){e.hide()},500)},3e3);break;case"fade6":setTimeout(function(){e.addClass("active"),setTimeout(function(){e.hide()},500)},3e3);break;case"fade7":setTimeout(function(){e.addClass("active"),setTimeout(function(){e.hide()},500)},3e3)}}function navPop(){var e=$(".mod-navPop"),t=e.find(".navPop-btn"),n=e.find(".menu-pop");t.on("click",function(){t.toggleClass("active"),n.toggleClass("on")}),n.on("click",function(){t.toggleClass("active"),n.toggleClass("on")})}function categorySelect(){var e=$(".head-name"),t=$(".category"),n=t.find(".category-main");$(document).on("click",".head-name",function(){e.is(".active")?(e.removeClass("active"),n.slideUp(function(){t.hide(),$(".main").removeAttr("style")})):(e.addClass("active"),t.show(),n.slideDown(),$(".main").css({height:"100%",overflow:"hidden"}))}),$(document).on("click",".category a",function(){var e=$(this);e.is(".all")?alert("\u5168\u90e8"):e.is(".back")?e.is(".disabled")||alert("\u8fd4\u56de"):alert("next")}),$(document).on("click",".category-bg",function(){e.removeClass("active"),n.slideUp(function(){t.hide(),$(".main").removeAttr("style")})})}function searchFn(){$(document).on("click",".search",function(){var e=$(".search-box");e.toggle().find("input").focus()})}function selectTheme(){var e='<div class="slide-bar"><a href="javascript:;" data-class="theme-1">\u8272\u7cfb1</a><a href="javascript:;" data-class="theme-2">\u8272\u7cfb2</a><a href="javascript:;" data-class="theme-3">\u8272\u7cfb3</a><a href="javascript:;" data-class="theme-4">\u8272\u7cfb4</a></div><style>.slide-bar{position:fixed;right:10px;bottom:100px;}.slide-bar a{padding:5px;color:#fff;display:block;width:60px;height:30px;margin:5px 0;background:rgba(0,0,0,.7);border:1px solid  #ccc;}</style>';$("body").append(e),$(document).on("click",".slide-bar a",function(){var e=$(this),t=e.data("class");$(".main").attr("class","main "+t)})}function bannerSet(e){var t=$(".banner .sub-slide"),n=e.background.substr(1,2),i=e.background.substr(3,2),r=e.background.substr(5),s=parseInt("0x"+n),o=parseInt("0x"+i),a=parseInt("0x"+r),l=e.opacity/100;t.css({background:"rgba("+s+","+o+","+a+","+l+")",color:e.color})}$(function(){autoHeight(".banner",400/720),menuAutoHeight(),indexSwipe("list",!0),fade(),navPop("#navPop-wrap","#navPop-btn"),indexSwipe("navLine-menu"),searchFn()});