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

        <form class="form-horizontal" id="validation-form">
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
<script type="text/javascript" src="${ctx}/static/ace-master/assets/js/jquery.validate.min.js"></script>
<script type="text/javascript">
    $(function() {
        $("#validation-form").validate({
            errorElement: 'div',
            errorClass: 'help-block',
            focusInvalid: false,
            ignore: "",
            onkeyup :false,// 是否在敲击键盘时验证
            rules: {
                name: {
                    required: true,
                    remote:{
                        type:"POST",
                        url:"${ctx}/user/resource/checkName",  //检测地址
                        data:{
                            "name": function() { return $("input[name='name']").val() }, //获取邮箱
                            "id": function() { return $("input[name='id']").val() }
                        },
                        dataFilter: function(data) { //data为字符串
                            data = $.parseJSON(data);
                            if(data.success) {
                                return true;
                            }else {
                                return false;
                            }
                        }
                    }
                },
                code: {
                    required: true,
                    remote:{
                        type:"POST",
                        url:"${ctx}/user/resource/checkCode",  //检测地址
                        data:{
                            "code": function() { return $("input[name='code']").val()}, //获取邮箱
                            "id": function() { return $("input[name='id']").val() }
                        },
                        dataFilter: function(data) { //data为字符串
                            data = $.parseJSON(data);
                            if(data.success) {
                                return true;
                            }else {
                                return false;
                            }
                        }
                    }
                },
                type: {
                    required: true
                },
                permission: {
                    required: true,
                    remote: {
                        type:"POST",
                        url:"${ctx}/user/resource/checkPermission",
                        data: {
                            "permission": function() {return $("input[name='permission']").val()},
                            "id": function() { return $("input[name='id']").val() }
                        },
                        dataFilter: function(data) {
                            data = $.parseJSON(data);
                            if(data.success) {
                                return true;
                            }else {
                                return false;
                            }
                        }
                    }
                },
                url: {
                    remote: {
                        type: "POST",
                        url: "${ctx}/user/resource/checkUrl",
                        data: {
                            "url": function() { return $("input[name='url']").val(); },
                            "id": function() { return $("input[name='id']").val() }
                        },
                        dataFilter: function(data) {
                            data = $.parseJSON(data);
                            if(data.success) {
                                return true;
                            }else {
                                return false;
                            }
                        }
                    }
                }
            },
            messages: {
                name: {
                    required: "资源名称为必填！",
                    remote: "资源名称已经存在！"
                },
                code: {
                    required: "资源Code为必填！",
                    remote: "资源Code已经存在！"
                },
                type: {
                    required: "请选择资源类型！"
                },
                permission: {
                    required: "权限字符串必填！",
                    remote: "权限字符串已经存在！"
                },
                url: {
                    remote: "URL路径已经存在！",
                }
            },
            highlight: function (e) {
                $(e).closest('.form-group').removeClass('has-info').addClass('has-error');
            },
            success: function (e) {
                $(e).closest('.form-group').removeClass('has-error');//.addClass('has-info');
                $(e).remove();
            },
            errorPlacement: function (error, element) {
//                if(element.is('input[type=checkbox]') || element.is('input[type=radio]')) {
//                    var controls = element.closest('div[class*="col-"]');
//                    if(controls.find(':checkbox,:radio').length > 1) controls.append(error);
//                    else error.insertAfter(element.nextAll('.lbl:eq(0)').eq(0));
//                }
//                else if(element.is('.select2')) {
//                    error.insertAfter(element.siblings('[class*="select2-container"]:eq(0)'));
//                }
//                else if(element.is('.chosen-select')) {
//                    error.insertAfter(element.siblings('[class*="chosen-container"]:eq(0)'));
//                }
//                else
                error.insertAfter(element.parent());
            },
            submitHandler: function() {
                var editData = $("#editForm").serializeArray();
                $.post("${ctx }/user/resource/doEdit", editData, function(data) {
                    if(data.success) {
                        layer.alert("编辑成功！", function() {
                            var index = parent.layer.getFrameIndex(window.name);
                            parent.layer.close(index);
                        });
                    } else {
                        layer.alert("编辑失败！")
                    }
                });
            }
        });
    });

</script>
</body>
</html>
