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
                    var flda = $(this).val();
                    // $("#ts").html("请输入整数");
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
    <title>addFld</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/fld/insert" onsubmit="return verify()" c="post" enctype="multipart/form-data">
    <input type="file" name="fname">
    <font color="red" id="ts">${requestScope.error}</font>
    <input id="flda" name="flda" value="${param.flda}" placeholder="请输入整数。。。">
    <font color="red" id="ts2"></font>
    <input id="fldb" name="fldb" value="${param.fldb}" placeholder="请输入字符串。。。">
    <font color="red" id="ts3"></font>
    <input id="fldc" name="fldc" value="${param.fldc}" placeholder="请输入浮点数。。。">
    <input id="addFld" type="submit" name="addFld">
</form>
</body>
</html>
