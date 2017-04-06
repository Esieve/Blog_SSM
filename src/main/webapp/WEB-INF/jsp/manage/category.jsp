<%--
  Created by IntelliJ IDEA.
  User: 77239
  Date: 2017/2/16/0016
  Time: 13:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<script type="text/javascript">--%>
<%--function deleteCategory(id) {--%>
<%--if(confirm("您确定要删除这个类别吗？")){--%>
<%--window.location="categoryManage?action=delete&categoryId="+categoryId;--%>
<%--}--%>
<%--}--%>
<%--</script>--%>
<div class="row">
    <div class="col s12">
        <div class="card-panel">
            <table class="centered">
                <thead>
                <tr>
                    <th>类别名称</th>
                    <th>文章数</th>
                    <th>操作</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach var="category" items="${categories}">
                    <tr class="hoverable">
                        <td>${category.categoryName}</td>
                        <td>${category.articleNum}</td>
                        <td>
                            <a href="/manage/category/modify/${category.categoryId}"
                               class="waves-effect waves-light btn green hoverable">修改</a>
                            <a class="waves-effect waves-light btn red hoverable"
                               href="/manage/category/delete/${category.categoryId}">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <br>
            <div class="center">
                <a href="/manage/category/add" class="waves-effect waves-light btn green hoverable">添加类别</a>
            </div>
        </div>
    </div>
</div>