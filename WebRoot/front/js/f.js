function checkserAgent() {
    var userAgentInfo = navigator.userAgent;
    var userAgentKeywords = new Array("Android", "iPhone", "SymbianOS", "Windows Phone", "iPad", "iPod", "MQQBrowser");
    var flag = false;
    //排除windows系统 苹果系统
    if (userAgentInfo.indexOf("Windows NT") == -1) {
        flag = true;
    }
    return flag;
}
//移动设备
if (!checkserAgent()) {
    document.location.href = "/";
}