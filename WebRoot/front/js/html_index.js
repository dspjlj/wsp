
var count = document.getElementById("thelist").getElementsByTagName("img").length;


if (tpl == 13 || tpl == 14 || tpl == 15 || tpl == 16 || tpl == 17) {
    for (i = 0; i < count; i++) {
        document.getElementById("thelist").getElementsByTagName("img").item(i).style.cssText = " width:" + document.body.clientWidth + "px";
    }
    document.getElementById("scroller").style.cssText = "width:" + document.body.clientWidth * count + "px";
}
else {
    for (i = 0; i < count; i++) {
        document.getElementById("thelist").getElementsByTagName("img").item(i).style.cssText = "min-height:183px; max-height:200px; width:" + document.body.clientWidth + "px";
    }
    document.getElementById("scroller").style.cssText = "min-height:183px; max-height:200px;width:" + document.body.clientWidth * count + "px";
}

setInterval(function () {
    myScroll.scrollToPage('next', 0, 400, count);
}, 3500);
window.onresize = function () {
    for (i = 0; i < count; i++) {
        document.getElementById("thelist").getElementsByTagName("img").item(i).style.cssText = " width:" + document.body.clientWidth + "px";
    }
    document.getElementById("scroller").style.cssText = " width:" + document.body.clientWidth * count + "px";
}

document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
    window.shareData = {
        "imgUrl": web + $("#img0").attr("src"),
        "timeLineLink": web+"/i"+id+token,
        "sendFriendLink": web+"/i" + id + token,
        "weiboLink": web + "/i" + id + token,
        "tTitle": document.title,
        "tContent": document.title,
        "fTitle": document.title,
        "fContent": desc,
        "wContent": document.title
    };
    // 发送给好友
    WeixinJSBridge.on('menu:share:appmessage', function (argv) {
        WeixinJSBridge.invoke('sendAppMessage', {
            "img_url": window.shareData.imgUrl,
            "img_width": "640",
            "img_height": "640",
            "link": window.shareData.sendFriendLink,
            "desc": window.shareData.fContent,
            "title": window.shareData.fTitle
        }, function (res) {
            _report('send_msg', res.err_msg);
        })
    });

    // 分享到朋友圈
    WeixinJSBridge.on('menu:share:timeline', function (argv) {
        WeixinJSBridge.invoke('shareTimeline', {
            "img_url": window.shareData.imgUrl,
            "img_width": "640",
            "img_height": "640",
            "link": window.shareData.timeLineLink,
            "desc": window.shareData.tContent,
            "title": window.shareData.tTitle
        }, function (res) {
            _report('timeline', res.err_msg);
        });
    });

    // 分享到微博
    WeixinJSBridge.on('menu:share:weibo', function (argv) {
        WeixinJSBridge.invoke('shareWeibo', {
            "content": window.shareData.wContent,
            "url": window.shareData.weiboLink,
        }, function (res) {
            _report('weibo', res.err_msg);
        });
    });
}, false)
