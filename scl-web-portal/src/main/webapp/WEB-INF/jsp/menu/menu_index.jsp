<%--
  Created by IntelliJ IDEA.
  User: shengchenglong
  Date: 17/2/21
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>菜单管理</title>
</head>
<body>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath }"/>


<script type="text/javascript" src="${ctx}/static/zTree_v3-master/js/jquery.ztree.all.js">
<script type="text/javascript">
var treeObj;
$(function() {
    alert(111);
    initMenuTree();

});

function initMenuTree() {
    var setting = {
        async: {
            url: "${ctx}/user/menu/getMenus",
            type: "post",
            dataType: "json",
            enable: true, // 这里配置为true dataFilter才起作用
            dataFilter: function(treeId, parentNode, responseData) {
                if(responseData.success) {
                    return responseData.object;
                } else {
                    return null;
                }
            }
        },
        data: {
            key: {
                name: "cnname" // 这里配置的是显示菜单时节点的显示名称
            },
            simpleData: {
                enable: true,
                idKey: "id",
                pIdKey: "parentId",
                rootPid: null
            }
        }
    }

    treeObj = $.fn.zTree.init($("#menuTreeDiv"), setting);
}
</script>

<div class="contentpanel panel-menu">

    <div class="row">
        <%-- 中间菜单树部分 开始 --%>
        <div id="menuTreeDiv" class="col-sm-3 col-lg-2">

        </div><%-- 中间菜单树部分 开始 --%>

        <div class="col-sm-9 col-lg-10">

            <div class="panel panel-default">
                <div class="panel-body">

                    <div class="pull-right">

                    </div><!-- pull-right -->

                    <h5 class="subtitle mb5">Inbox</h5>
                    <p class="text-muted">Showing 1 - 15 of 230 messages</p>

                    <div class="table-responsive">

                    </div><!-- table-responsive -->

                </div><!-- panel-body -->
            </div><!-- panel -->

        </div><!-- col-sm-9 -->

    </div><!-- row -->

</div>



</body>

</html>
