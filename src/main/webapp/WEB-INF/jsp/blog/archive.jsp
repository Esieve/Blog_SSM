<%--
  Created by IntelliJ IDEA.
  User: 77239
  Date: 2017/2/19/0019
  Time: 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="row">
    <div class="col s12">
        <nav class="indigo lighten-1">
            <div class="nav-wrapper">
                <div class="col s12">
                    <a href="/blog" class="breadcrumb">首页</a>
                    <a class="breadcrumb">归档</a>
                </div>
            </div>
        </nav>

        <br>

        <ul class="collapsible popout">
            <c:forEach var="item" items="${archive}">
                <li>
                    <div class="collapsible-header">
                            ${item.key}<span class="badge">${fn:length(item.value)}</span>
                    </div>
                    <div class="collapsible-body">
                        <table>
                            <tbody>
                            <c:forEach var="article" items="${item.value}">
                                <tr>
                                    <td>『${article.pubDate }』</td>
                                    <td><a href="/blog/article/${article.articleId}">${article.title}</a></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>

                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>
</div>


<%--<script type="text/javascript">--%>
<%--var options = [--%>
<%--{--%>
<%--selector: '#archive', offset: 0, callback: function (el) {--%>
<%--Materialize.showStaggeredList($(el));--%>
<%--}--%>
<%--},--%>
<%--];--%>
<%--Materialize.scrollFire(options);--%>
<%--</script>--%>

<%--<div class="row">--%>
<%--<div class="col s12 m12 l12">--%>
<%--<!--breadcrumbs-->--%>
<%--<nav class="indigo lighten-1">--%>
<%--<div class="nav-wrapper">--%>
<%--<div class="col s12">--%>
<%--<a href="/blog" class="breadcrumb">首页</a>--%>
<%--<a class="breadcrumb">归档</a>--%>
<%--</div>--%>
<%--</div>--%>
<%--</nav>--%>
<%--<br>--%>

<%--<div class="card-panel hoverable">--%>
<%--<ul id="archive">--%>
<%--<c:forEach var="article" items="${articles}">--%>
<%--<li style="opacity: 0">--%>
<%--<table>--%>
<%--<td>『${article.pubDate }』</td>--%>
<%--<td><a href="/blog/article/${article.articleId}">${article.title}</a></td>--%>
<%--</table>--%>
<%--</li>--%>
<%--</c:forEach>--%>
<%--</ul>--%>
<%--</div>--%>
<%--</div>--%>
<%--</div>--%>