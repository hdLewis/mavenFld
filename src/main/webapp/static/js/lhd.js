//表单校验
function verify() {
    //是数字
    var b = $("#flda").val();
    flagb = true;
    if (b == null || b.length == 0) {
        $("#ts").html("必须是整数");
        flagb = false;
    }
    for (var i = 0; i < b.length; i++) {
        var ch = b.charAt(i);
        if (!(ch >= '0' && ch <= '9')) {
            document.getElementById("ts").innerHTML = "必须是整数";
            flagb = false;
        }
    }

    //统计数字和点的个数，是浮点数
    var c = $("#fldc").val();
    flagc = true;
    if (c == null || c == "" || c == "." || c.indexOf(".") != c.lastIndexOf(".")) {
        document.getElementById("ts3").innerHTML = "必须是浮点数";
        flagc = false;
    }
    for (var i = 0; i < c.length; i++) {
        var ch = c.charAt(i);
        if (!((ch >= '0' && ch <= '9') || (ch == '.'))) {
            document.getElementById("ts3").innerHTML = "必须是浮点数";
            flagc = false;
        }
    }
    //判断是否是字符串
    var d = $("#fldb").val();
    flagd = true;
    if (d == null || d.length == 0) {
        $("#ts2").html("必须是字符串");
        flagb = false;
    }
    //校验返回值
    if (flagb && flagc &&flagd) {
        return true;
    } else {
        return false;
    }
}