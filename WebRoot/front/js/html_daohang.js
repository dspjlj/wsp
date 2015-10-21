window.onload = function () {
    var oWin = document.getElementById("win");
    var oLay = document.getElementById("overlay");
    var oBtn = document.getElementById("popmenu");
    var oClose = document.getElementById("close");
    oBtn.onclick = function () {
        oLay.style.display = "block";
        oWin.style.display = "block"
    };
    oLay.onclick = function () {
        oLay.style.display = "none";
        oWin.style.display = "none"
    }
};