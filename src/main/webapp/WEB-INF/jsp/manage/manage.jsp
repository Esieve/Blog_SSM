<%--
  Created by IntelliJ IDEA.
  User: 77239
  Date: 2017/2/6/0006
  Time: 18:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="../common/head.jsp" %>
    <script type="text/javascript">
        $(document).ready(function () {
            if (${not empty info})
                showErrorInfo();
        });
        function showErrorInfo() {
            $("div.info").fadeIn(1000, function () {
                $("div.info").delay(1000).fadeOut(500);
            });
        }
    </script>
</head>
<body class="grey lighten-4">
<!--导航条-->
<div class="navbar-fixed">
    <nav>
        <div class="nav-wrapper white">
            <a href="/manage" class="brand-logo indigo-text darken-3">ACodesigner's Blog Back End</a>
            <a href="#" data-activates="mobile-demo" class="right button-collapse grey-text"><i class="material-icons">menu</i></a>
            <ul class="right hide-on-med-and-down">
                <li><a href="/manage/article" class="grey-text"><i class="material-icons left">border_color</i>文章</a>
                </li>
                <li><a href="/manage/category" class="grey-text"><i class="material-icons left">view_list</i>分类</a></li>
                <li><a href="/manage/link" class="grey-text"><i class="material-icons left">open_in_browser</i>链接</a>
                </li>
                <li><a href="/manage/image" class="grey-text"><i class="material-icons left">photo</i>图片</a></li>
                <li><a href="/manage/user" class="grey-text"><i class="material-icons left">account_circle</i>用户</a>
                </li>
                <li><a href="/manage/about" class="grey-text"><i class="material-icons left">error</i>关于</a></li>
                <li><a href="/manage/quit" class="waves-effect waves-green btn orange hoverable"><i
                        class="material-icons left">person</i>退出登录</a></li>
            </ul>
            <ul class="side-nav" id="mobile-demo">
                <li><a href="/manage/article" class="grey-text">文章</a></li>
                <li><a href="/manage/category" class="grey-text">分类</a></li>
                <li><a href="/manage/link" class="grey-text">链接</a></li>
                <li><a href="/manage/image" class="grey-text">图片</a></li>
                <li><a href="/manage/user" class="grey-text">用户</a></li>
                <li><a href="/manage/about" class="grey-text">关于</a></li>
                <li><a href="/manage/quit" class="grey-text">退出登录</a></li>
            </ul>
        </div>
    </nav>
</div>

<!--页面内容-->
<div class="row">
    <div class="col s2"></div>
    <div class="col s8">
        <%@ include file="../common/info.jsp" %>
        <jsp:include page="${mainPage}"></jsp:include>
    </div>
    <div class="col s2"></div>
</div>

</body>
</html>