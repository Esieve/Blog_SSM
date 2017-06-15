<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
            <a href="/blog" class="brand-logo indigo-text darken-3">ACodesigner's Blog</a>
            <a href="#" data-activates="mobile-demo" class="right button-collapse grey-text"><i class="material-icons">menu</i></a>
            <ul class="right hide-on-med-and-down">
                <li><a href="/blog" class="grey-text"><i class="material-icons left">home</i>首页</a></li>
                <li><a href="/blog/category" class="grey-text"><i class="material-icons left">view_list</i>分类</a></li>
                <li><a href="/blog/archive" class="grey-text"><i class="material-icons left">folder</i>归档</a></li>
                <li><a href="/blog/message" class="grey-text"><i class="material-icons left">message</i>留言</a>
                </li>
                <li><a href="/blog/about" class="grey-text"><i class="material-icons left">error</i>关于</a></li>
                <li><a href="/blog/login" class="waves-effect waves-green btn orange hoverable"><i
                        class="material-icons left">person</i>登录</a></li>
            </ul>
            <ul class="side-nav" id="mobile-demo">
                <li><a href="home" class="grey-text">首页</a></li>
                <li><a href="category" class="grey-text">分类</a></li>
                <li><a href="archive" class="grey-text">归档</a></li>
                <li><a href="message" class="grey-text">留言</a></li>
                <li><a href="about" class="grey-text">关于</a></li>
                <li><a href="login.jsp" class="grey-text">登录</a></li>
            </ul>
        </div>
    </nav>
</div>

<!--页面内容-->
<div class="container">
    <div class="row ">
        <div class="col s8">
            <%@ include file="../common/info.jsp" %>
            <jsp:include page="${mainPage}"></jsp:include>
        </div>
        <!--搜索条-->
        <div class="col s4">
            <nav style="margin-top: 30px;margin-bottom: 15px" class="indigo lighten-1 hoverable">
                <div class="nav-wrapper">
                    <form method="post" action="home?search=true">
                        <div class="input-field">
                            <input id="search" type="search" name="s_content" required>
                            <label class="label-icon" for="search"><i class="material-icons">search</i></label>
                            <i class="material-icons">close</i>
                        </div>
                    </form>
                </div>
            </nav>

            <div class="card grey hoverable">
                <div class="card-content white-text">
                    <span class="card-title">最近文章</span>
                    <table>
                        <c:forEach var="recentArticle" items="${recentArticles}">
                            <tr class="hoverable">
                                <td><a class="white-text"
                                       href="/blog/article/${recentArticle.articleId}">${recentArticle.title}</a></td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>

            <div class="card grey hoverable">
                <div class="card-content white-text">
                    <span class="card-title">最近回复</span>
                    <table>
                        <c:forEach var="recentMessage" items="${recentMessages}">
                            <tr class="hoverable">
                                <td><a class="white-text"
                                       href="message?action=leaveMessage">${recentMessage.content}</a></td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

<%--页脚--%>
<footer class="page-footer indigo darken-2">
    <div class="container">
        <div class="row">
            <div class="col l6 s12">
                <h5 class="white-text">反馈</h5>
                <p class="grey-text text-lighten-4">
                    如果您有什么建议或者发现了什么bug，可以通过我的邮箱反馈给我<br>
                    <i class="material-icons left">mail</i>
                    <a href="mailto:zhangqinyao123@gmail.com?subject=反馈">zhangqinyao123@gmail.com</a>
                </p>
            </div>
            <div class="col l4 offset-l2 s12">
                <h5 class="white-text">友情链接</h5>
                <ul>
                    <c:forEach var="link" items="${links}">
                        <li><a class="grey-text text-lighten-3" href="${link.url}" target="_blank">${link.linkName}</a>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>
    <div class="footer-copyright indigo darken-4">
        <div class="container">
            © 2017 ACodesigner
            <a href="https://github.com/codesign-er/Blog/blob/master/LICENSE" target="_blank"
               class="grey-text text-lighten-4 right" href="#!">MIT License</a>
        </div>
    </div>
</footer>
</body>
</html>
