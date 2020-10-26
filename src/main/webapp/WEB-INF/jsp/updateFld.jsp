<%--
  Created by IntelliJ IDEA.
  User: hdLewis
  Date: 2020/9/1
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta charset="UTF-8">
<%@ include file="inc.jsp" %>

<script type="text/javascript">
    $(
        function () {
            $("#flda").keyup(
                function () {
                    var flda=$("#flda").val();
                    var oldflda=$("#oldflda").val();
                    if (flda==oldflda){
                        return;
                    }

                    var flda = $(this).val();
                    //$("#ts").html("请输入整数");
                    $.ajax({
                        url: "${pageContext.request.contextPath}/fld/check/" + flda,
                        success: function (res) {
                            if (res.indexOf("occupied") != -1) {
                                $("#ts").html("编号已被占用");
                                $("#addFld").prop("disabled", true);
                            } else {
                                $("#ts").html("编号可用");
                                $("#addFld").prop("disabled", false);
                            }
                        }
                    });
                }
            );
        }
    )
</script>
<html>
<head>
    <title>updateFld</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/fld/update" onsubmit="return verify()" method="post">
    <input type="hidden" id="oldflda" name="oldflda" value="${param.flda}" >
    <font color="red" id="ts">${requestScope.error}</font>
    <input id="flda" name="flda" value="${param.flda}" placeholder="请输入整数。。。">
    <font color="red" id="ts2"></font>
    <input id="fldb" name="fldb" value="${param.fldb}" placeholder="请输入字符串。。。">
    <font color="red" id="ts3"></font>
    <input id="fldc" name="fldc" value="${param.fldc}" placeholder="请输入浮点数。。。">
    <input id="addFld" type="submit" name="addFld">
</form>
<a href="${pageContext.request.contextPath}/fld">showFld</a>

<script>
    var flda="${param.flda}";
    alert(flda);
</script>

</body>
</html>
