<%--
  Created by IntelliJ IDEA.
  User: shengchenglong
  Date: 17/2/24
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>资源编辑</title>

</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    .option-div { margin-left: 38%;}
</style>

<div class="row">
    <div class="col-xs-12">
        <div>
            <h4>父节点：${parentResource.name }</h4>
            <hr>
        </div>

        <form class="form-horizontal" id="editForm">
            <%--资源名称--%>
            <div class="form-group">
                <label class="control-label col-xs-12 col-sm-3 no-padding-right" for="name">名 称:</label>
                <div class="col-xs-12 col-sm-9">
                    <div class="clearfix">
                        <input type="text" id="name" name="name" class="col-xs-12 col-sm-5" />
                    </div>
                </div>
            </div>
            <div class="space-2"></div>

            <%--资源code--%>
            <div class="form-group">
                <label class="control-label col-xs-12 col-sm-3 no-padding-right" for="code">code:</label>
                <div class="col-xs-12 col-sm-9">
                    <div class="clearfix">
                        <input type="text" id="code" name="code" class="col-xs-12 col-sm-5" />
                    </div>
                </div>
            </div>
            <div class="space-2"></div>

            <%--资源类型--%>
            <div class="form-group">
                <label class="control-label col-xs-12 col-sm-3 no-padding-right" for="type">类 型</label>
                <div class="col-xs-12 col-sm-9">
                    <div class="clearfix">
                        <select id="type" name="type" data-placeholder="Click to Choose...">
                            <option value="">--请选择--</option>
                            <option <c:if test="${resource.type == 'menu'}">selected="selected"</c:if> value="menu">menu</option>
                            <option <c:if test="${resource.type == 'button'}">selected="selected"</c:if> value="button">button</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="space-2"></div>

            <%--权限字符串--%>
            <div class="form-group">
                <label class="control-label col-xs-12 col-sm-3 no-padding-right" for="permission">权限字符串:</label>
                <div class="col-xs-12 col-sm-9">
                    <div class="clearfix">
                        <input type="text" id="permission" name="permission" class="col-xs-12 col-sm-5" />
                    </div>
                </div>
            </div>
            <div class="space-2"></div>

            <%--URL路径--%>
            <div class="form-group">
                <label class="control-label col-xs-12 col-sm-3 no-padding-right" for="url">URL路径:</label>
                <div class="col-xs-12 col-sm-9">
                    <div class="clearfix">
                        <input type="text" id="url" name="url" class="col-xs-12 col-sm-5" />
                    </div>
                </div>
            </div>
            <div class="space-2"></div>

            <%--排序--%>
            <div class="form-group">
                <label class="control-label col-xs-12 col-sm-3 no-padding-right" for="priority">排 序:</label>
                <div class="col-xs-12 col-sm-9">
                    <div class="clearfix">
                        <input type="text" id="priority" name="priority" class="col-xs-12 col-sm-5" />
                    </div>
                </div>
            </div>
            <div class="space-2"></div>

            <%--操作按钮--%>
            <div class="clearfix form-actions" style="background-color: inherit">
                <div class="option-div col-md-offset-3 col-md-9">
                    <button id="submitBtn" class="btn btn-info" type="submit">
                        <i class="ace-icon fa fa-check bigger-110"></i>
                        提交
                    </button>

                    &nbsp; &nbsp; &nbsp;
                    <button class="btn" type="reset">
                        <i class="ace-icon fa fa-undo bigger-110"></i>
                        重置
                    </button>
                </div>
            </div>
        </form>


    </div>
</div>
<script type="text/javascript" src="${ctx}/static/manage/ace-master/assets/js/jquery.validate.min.js"></script>
<script type="text/javascript">
    $(function() {
        $("#submitBtn").click(function() {
            var editData = $("#editform").serializeArray();
            console.log(editData);
            console.log($("#editform").serialize());
        });
    });

</script>
</body>
</html>
