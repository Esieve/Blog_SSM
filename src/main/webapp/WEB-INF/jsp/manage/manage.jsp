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

</head>
<body class="grey lighten-4">

<div class="row">
    <!--侧栏-->
    <div class="col l3">
        <ul id="slide-out" class="side-nav fixed">
            <li style="margin-top: 30px;margin-bottom: 30px">
                <div class="center container">
                    <a href="/manage">
                        <img src="${userImage}" alt="${userImage}"
                             class="circle responsive-img brand-logo hoverable z-depth-3">
                    </a>
                </div>
            </li>
            <li><h5 class="center-align">Esieve's Blog Monitor</h5></li>
            <li><a href="/manage/article" class="grey-text"><i class="material-icons left">border_color</i>文章</a></li>
            <li><a href="/manage/category" class="grey-text"><i class="material-icons left">view_list</i>分类</a></li>
            <li><a href="/manage/link" class="grey-text"><i class="material-icons left">open_in_browser</i>链接</a></li>
            <li><a href="/manage/image" class="grey-text"><i class="material-icons left">photo</i>图片</a></li>
            <li><a href="/manage/user" class="grey-text"><i class="material-icons left">account_circle</i>用户</a></li>
            <li><a href="/manage/about" class="grey-text"><i class="material-icons left">error</i>关于</a></li>
            <li><a href="/manage/quit" class="waves-effect waves-green btn orange hoverable"><i
                    class="material-icons left">person</i>退出登录</a></li>
        </ul>
        <a href="" data-activates="slide-out" class="button-collapse grey-text"><i
                class="material-icons medium">menu</i></a>
    </div>

    <!--页面内容-->
    <div class="col l9 m12 s12">
        <div class="container">
            <%@ include file="../common/info.jsp" %>
            <jsp:include page="${mainPage}"></jsp:include>
        </div>
    </div>
</div>

</body>

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

    $(".button-collapse").sideNav();
</script>
</html>