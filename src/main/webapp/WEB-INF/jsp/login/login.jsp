<%--
  Created by IntelliJ IDEA.
  User: 77239
  Date: 2017/2/6/0006
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/tag.jsp" %>
<html>
<head>
    <%@ include file="../common/head.jsp" %>
    <script type="text/javascript">
        $(document).ready(function () {
            <c:if test="${not empty info }">
            showErrorInfo();
            </c:if>
        });
        function showErrorInfo() {
            $("div.info").fadeIn(1000, function () {
                $("div.info").delay(1000).fadeOut(500);
            });
        }
        function check() {
            var username = $("#username").val();
            var password = $("#password").val();
            var confirmPassword = $("#confirmPassword").val();
            if (username == "") {
                $("#info").text("用户名不能为空！");
                showErrorInfo();
                return false;
            }
            if (password == "") {
                $("#info").text("密码不能为空！");
                showErrorInfo();
                return false;
            }
            if (confirmPassword == "") {
                $("#info").text("确认密码不能为空！");
                showErrorInfo();
                return false;
            }
            if (password != null && confirmPassword != null && password != "" && password != confirmPassword) {
                $("#info").text("两次密码输入不一致！");
                showErrorInfo();
                return false;
            }
            return true;
        }
    </script>
</head>
<body class="grey lighten-4">

<div class="row">
    <div class="col s4"></div>
    <div class="col s4">
        <jsp:include page="${mainPage}"></jsp:include>
        <div class="info center" style="display: none;">
            <a id="info" class="waves-effect waves-light btn red">${info}</a>
        </div>
    </div>
    <div class="col s4"></div>
</div>

</body>
</html>
