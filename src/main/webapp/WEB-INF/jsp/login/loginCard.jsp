<%--
  Created by IntelliJ IDEA.
  User: 77239
  Date: 2017/2/13/0013
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="card-panel hoverable">

    <div class="center-align" style="margin-bottom: 40px">
        <h4><a href="blog" class="brand-logo indigo-text darken-3">ACodesigner's Blog</a></h4>
    </div>

    <form id="loginForm" method="post" action="/login/submit" onsubmit="return check()">
        <div class="input-field">
            <i class="material-icons prefix">account_circle</i>
            <input id="username" name="username" type="text" class="validate">
            <label for="username">用户名</label>
        </div>
        <div class="input-field">
            <i class="material-icons prefix">lock</i>
            <input id="password" name="password" type="password" class="validate">
            <label for="password">密码</label>
        </div>
        <div class="center-align">
            <a href="/register" class="waves-effect waves-light btn orange hoverable">注册</a>
            <button class="btn waves-effect waves-light hoverable" type="submit" name="action">登录
                <i class="material-icons right">send</i>
            </button>
        </div>
    </form>
</div>