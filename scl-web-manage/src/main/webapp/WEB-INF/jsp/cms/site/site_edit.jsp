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
    <title>站点编辑</title>

</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<style>
    .option-div { margin-left: 38%;}
</style>

<div class="row">
    <div class="col-xs-12">
        <form class="form-horizontal" id="editForm">
            <input type="hidden" name="id" value="${site.id}">


            <%--资源名称--%>
            <div class="form-group">
                <label class="control-label col-xs-12 col-sm-3 no-padding-right" for="name">名 称:</label>
                <div class="col-xs-12 col-sm-9">
                    <div class="clearfix">
                        <input type="text" id="name" name="name" class="col-xs-12 col-sm-5" value="${site.name}" />
                    </div>
                </div>
            </div>
            <div class="space-2"></div>

            <%--资源code--%>
            <div class="form-group">
                <label class="control-label col-xs-12 col-sm-3 no-padding-right" for="code">code:</label>
                <div class="col-xs-12 col-sm-9">
                    <div class="clearfix">
                        <input type="text" id="code" name="code" class="col-xs-12 col-sm-5" value="${site.code}" />
                    </div>
                </div>
            </div>
            <div class="space-2"></div>

            <%--资源类型--%>
            <div class="form-group">
                <label class="control-label col-xs-12 col-sm-3 no-padding-right" for="languageCode">语言版本</label>
                <div class="col-xs-12 col-sm-9">
                    <div class="clearfix">
                        <c:forEach items="${languagesDict}" var="dict" varStatus="vs">
                            <label class="control-label">
                                <input type="checkbox" id="languageCode" name="languageCode" value="${dict.code}"
                                    <c:if test="${fn:contains(site.languageCode, dict.code )}">checked="checked"</c:if>
                                >
                                <span class="lbl"> ${dict.value} </span>
                            </label>
                        </c:forEach>
                    </div>
                </div>
            </div>
            <div class="space-2"></div>

            <%--权限字符串--%>
            <div class="form-group">
                <label class="control-label col-xs-12 col-sm-3 no-padding-right" for="defaultLanguage">默认语言:</label>
                <div class="col-xs-12 col-sm-9">
                    <div class="clearfix">
                        <c:forEach items="${languagesDict}" var="dict" varStatus="vs">
                            <label class="control-label">
                                <input type="radio" id="defaultLanguage" name="defaultLanguage" value="${dict.code}"
                                    <c:if test="${site.defaultLanguage eq dict.code}">checked="checked"</c:if>
                                >
                                <span class="lbl"> ${dict.value} </span>
                            </label>
                        </c:forEach>
                    </div>
                </div>
            </div>
            <div class="space-2"></div>

            <%--排序--%>
            <div class="form-group">
                <label class="control-label col-xs-12 col-sm-3 no-padding-right" for="sort">排 序:</label>
                <div class="col-xs-12 col-sm-9">
                    <div class="clearfix">
                        <input type="text" id="sort" name="sort" class="col-xs-12 col-sm-5" value="${site.sort}" />
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

        $('#editForm').validate({
            errorElement: 'div',
            errorClass: 'help-block',
            focusInvalid: false,
            ignore: "",
            rules: {
            },
            messages: {
            },
            highlight: function (e) {
                $(e).closest('.form-group').removeClass('has-info').addClass('has-error');
            },
            success: function (e) {
                $(e).closest('.form-group').removeClass('has-error');//.addClass('has-info');
                $(e).remove();
            },
            errorPlacement: function (error, element) {
                if(element.is('input[type=checkbox]') || element.is('input[type=radio]')) {
                    var controls = element.closest('div[class*="col-"]');
                    if(controls.find(':checkbox,:radio').length > 1) controls.append(error);
                    else error.insertAfter(element.nextAll('.lbl:eq(0)').eq(0));
                }
                else if(element.is('.select2')) {
                    error.insertAfter(element.siblings('[class*="select2-container"]:eq(0)'));
                }
                else if(element.is('.chosen-select')) {
                    error.insertAfter(element.siblings('[class*="chosen-container"]:eq(0)'));
                }
                else error.insertAfter(element.parent());
            },
            submitHandler: function () {
                var editData = $("#editForm").serializeArray();
                $.post("${ctx}/user/site/doEdit", editData, function(data) {
                    if(data.success) {
                        layer.alert("编辑成功", function() {
                            window.location.href = "${ctx}/user/site/index";
                        })
                    } else {
                        layer.alert("编辑失败")
                    }
                });
            }
        })

    });

</script>
</body>
</html>
