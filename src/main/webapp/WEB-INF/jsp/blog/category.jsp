<%--
  Created by IntelliJ IDEA.
  User: 77239
  Date: 2017/2/18/0018
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row">
    <div class="col s12">
        <nav class="indigo lighten-1">
            <div class="nav-wrapper">
                <div class="col s12">
                    <a href="/blog" class="breadcrumb">首页</a>
                    <a class="breadcrumb">分类</a>
                </div>
            </div>
        </nav>
        <br>
        <ul class="collapsible popout">
            <c:forEach var="category" items="${categories}">
                <li>
                    <div class="collapsible-header <c:if test='${categoryId==category.categoryId}'>active</c:if> ">
                            ${category.categoryName}<span class="badge">${category.articleNum}</span>
                    </div>
                    <div class="collapsible-body">
                        <table>
                            <tbody>
                            <c:forEach var="article" items="${articlesList[category.categoryId]}">
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
