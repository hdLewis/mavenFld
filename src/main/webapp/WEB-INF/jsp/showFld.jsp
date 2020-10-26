<%--
  Created by IntelliJ IDEA.
  User: hdLewis
  Date: 2020/9/1
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="inc.jsp" %>

<script type="text/javascript">
    function ajaxdel(flda) {
        if (confirm("都确定要删除【" + flda + "】？")) {
            $.ajax({
                type: 'post',
                url: "${pageContext.request.contextPath}/fld/delete",
                data: {flda: flda},
                success: function (res) {
                    if (res.indexOf("success") != -1) {
                        $("#ye"+flda).remove();
                    }
                }
            });
        }
        return false;
    }
</script>


<html>
<head>
    <title>showFld</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/fld/insert">addFld</a>


<form action="${pageContext.request.contextPath}/fld">
    <input id="fldb" name="fldb" placeholder="第二字段模糊查询。。。">
    <input id="addFld" type="submit" value="查询">
</form>



<table class="table table-bordered">
    <tr>
        <td>FLDA</td>
        <td>FLDB</td>
        <td>FLDC</td>
        <td>IMAGE</td>
        <td>OP</td>
    </tr>

    <c:forEach items="${requestScope.lstFld}" var="y">
        <tr id="ye${y.flda}">
            <td>${y.flda}</td>
            <td>${y.fldb}</td>
            <td>${y.fldc}</td>
            <td>
                <img alt="sorry" src="${pageContext.request.contextPath}/static/upload/${y.fldd}" width="100px" height="100px"></td>
            <td>
                <a href="${pageContext.request.contextPath}/fld/delete/${y.flda}"
                   onclick="return confirm('del?')">del</a>
                <a href="#" onclick="return ajaxdel(${y.flda})">ajaxdel</a>
                &nbsp;
                <a href="${pageContext.request.contextPath}/fld/update?flda=${y.flda}&fldb=${y.fldb}&fldc=${y.fldc}">update</a>
            </td>
        </tr>

    </c:forEach>
    <%--<a href="lhdb?op=logout" onclick="return confirm('确认要退出吗？')">logout</a>--%>
</table>


</body>
</html>
