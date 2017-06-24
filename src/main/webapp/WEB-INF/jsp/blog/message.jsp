<%--
  Created by IntelliJ IDEA.
  User: 张秦遥
  Date: 2017/2/21/0021
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="row">
    <div class="col s12">
        <nav class="indigo lighten-1">
            <div class="nav-wrapper">
                <div class="col s12">
                    <a href="/blog" class="breadcrumb">首页</a>
                    <a class="breadcrumb">留言</a>
                </div>
            </div>
        </nav>
        <br>
        <div class="card-panel hoverable">
            <h3>留言</h3>
            <p>如果您有什么意见或建议的话，欢迎您在此留言，谢谢。</p>
        </div>
    </div>
</div>
<jsp:include page="messageDetail.jsp"></jsp:include>