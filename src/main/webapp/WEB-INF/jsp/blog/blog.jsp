<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                    <a href="/login">
                        <img src="${userImage}" alt="${userImage}"
                             class="circle responsive-img brand-logo hoverable z-depth-3">
                    </a>
                </div>
            </li>
            <li><h5 class="center-align">Esieve's Blog</h5></li>
            <li><a href="/blog" class="grey-text"><i class="material-icons left">home</i>首页</a></li>
            <li><a href="/blog/category" class="grey-text"><i class="material-icons left">view_list</i>分类</a></li>
            <li><a href="/blog/archive" class="grey-text"><i class="material-icons left">folder</i>归档</a></li>
            <li><a href="/blog/message" class="grey-text"><i class="material-icons left">message</i>留言</a></li>
            <li><a href="/blog/about" class="grey-text"><i class="material-icons left">error</i>关于</a></li>
        </ul>
        <a href="" data-activates="slide-out" class="button-collapse grey-text"><i
                class="material-icons medium">menu</i></a>
    </div>

    <!--页面内容-->
    <div class="col l9 s12 m12">
        <div class="row ">
            <div class="col s7">
                <%@ include file="../common/info.jsp" %>
                <jsp:include page="${mainPage}"></jsp:include>
            </div>

            <div class="col s4">
                <!--搜索条-->
                <nav style="margin-top: 30px;margin-bottom: 15px" class="indigo lighten-1 hoverable z-depth-4">
                    <div class="nav-wrapper">
                        <form method="get" action="/blog">
                            <div class="input-field">
                                <input id="search" type="search" name="search" required>
                                <label class="label-icon" for="search"><i class="material-icons">search</i></label>
                                <i class="material-icons">close</i>
                            </div>
                        </form>
                    </div>
                </nav>

                <!--访问量-->
                <div class="card grey hoverable">
                    <div class="card-content white-text">
                        <P class="flow-text">
                            访问量：
                            <script type="text/javascript">
                                var sc_project = 11378771;
                                var sc_invisible = 0;
                                var sc_security = "ef303859";
                                var sc_text = 2;
                                var scJsHost = (("https:" == document.location.protocol) ?
                                    "https://secure." : "http://www.");
                                document.write("<sc" + "ript type='text/javascript' src='" +
                                    scJsHost +
                                    "statcounter.com/counter/counter.js'></" + "script>");
                            </script>
                        <noscript>
                            <div class="statcounter">
                                <a title="free hitcounter" href="http://statcounter.com/" target="_blank">
                                    <img class="statcounter" src="//c.statcounter.com/11378771/0/ef303859/0/"
                                         alt="freehit counter">
                                </a>
                            </div>
                        </noscript>
                        </P>
                    </div>
                </div>

                <div class="card grey hoverable">
                    <div class="card-content white-text">
                        <span class="card-title">最近文章</span>
                        <table>
                            <c:forEach var="recentArticle" items="${recentArticles}">
                                <tr class="hoverable">
                                    <td><a class="white-text"
                                           href="/blog/article/${recentArticle.articleId}">${recentArticle.title}</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>

                <div class="card grey hoverable">
                    <div class="card-content white-text">
                        <span class="card-title">最多浏览文章</span>
                        <table>
                            <c:forEach var="mostViewedArticle" items="${mostViewedArticles}">
                                <tr class="hoverable">
                                    <td><a class="white-text"
                                           href="/blog/article/${mostViewedArticle.articleId}">${mostViewedArticle.title}</a>
                                    </td>
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
</div>

<%--页脚--%>
<footer class="page-footer indigo darken-2">
    <div class="container">
        <div class="row">
            <div class="col l4 offset-l3 s12">
                <h5 class="white-text">反馈</h5>
                <p class="grey-text text-lighten-4">
                    如果您有什么建议或者发现了什么bug，可以通过我的邮箱反馈给我<br>
                    <i class="material-icons left">mail</i>
                    <a href="mailto:zhangqinyao123@gmail.com?subject=反馈">zhangqinyao123@gmail.com</a>
                </p>
            </div>
            <div class="col l4 offset-l1 s12">
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
            © 2017 Esieve
            <a href="https://github.com/codesign-er/Blog/blob/master/LICENSE" target="_blank"
               class="grey-text text-lighten-4 right" href="#!">MIT License</a>
        </div>
    </div>
</footer>
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
