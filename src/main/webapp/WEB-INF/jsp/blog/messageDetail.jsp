<%--
  Created by IntelliJ IDEA.
  User: 张秦遥
  Date: 2017/2/20/0020
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
    var cloudTieConfig = {
        sourceId: ${articleId},
        productKey: "8c7b3d60f89347e4a0dc77b2e50ca276",
        target: "cloud-tie-wrapper"
    };
</script>
<script src="https://img1.cache.netease.com/f2e/tie/yun/sdk/loader.js"></script>
<div class="row">
    <div class="col s10">
        <div class="card-panel hoverable">
            <div id="cloud-tie-wrapper" class="cloud-tie-wrapper"></div>
        </div>
    </div>
</div>