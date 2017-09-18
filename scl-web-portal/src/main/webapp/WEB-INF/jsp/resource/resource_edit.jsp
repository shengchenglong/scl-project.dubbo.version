<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon" href="images/favicon.png" type="image/png">
<title>新增资源</title>
<link rel="stylesheet" href="${ctx }/static/bracket/css/style.default.css" />
<link rel="stylesheet" href="${ctx }/static/bracket/css/select2.css">
<style type="text/css">
	body{background: none !important;}
	.panel{margin-bottom: 0px;}
</style>


<script type="text/javascript" src="${ctx }/static/layer-v3.0.1/layer/layer.js"></script>
<%-- <script type="text/javascript" src="${ctx }/static/bracket/js/select2.min.js"></script> --%>
</head>

<body>

<form id="editForm" class="form-horizontal form-bordered">
	<input type="hidden" value="${parentResource.code }" name="parentCode" />
	<c:if test="${resource ne null }">
		<input type="hidden" value="${resource.id }" name="id"/>
	</c:if>

	<div class="panel panel-default">
		<div class="panel-heading">
			<h4 class="panel-title">父节点：${parentResource.name }</h4>
		</div>
		
		<!-- panel-body 开始 -->
		<div class="panel-body panel-body-nopadding">
			<div class="form-group">
				<label class="col-sm-3 control-label">名称 <span class="asterisk">*</span></label>
				<div class="col-sm-6">
                    <input type="text" name="name" placeholder="资源名称..." class="form-control" 
						<c:if test="${resource ne null }">value="${resource.name }"</c:if>
						value="" />
                </div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-3 control-label">资源code<span class="asterisk">*</span></label>
				<div class="col-sm-6">
					<input type="text" name="code" placeholder="资源code..." class="form-control" 
						<c:if test="${resource ne null }">value="${resource.code }" readonly="readonly"</c:if> 
						value="" />
				</div>
			</div>
			
			<div class="form-group">
	            <label class="col-sm-3 control-label">资源类型<span class="asterisk">*</span></label>
	            <div class="col-sm-6">
		           <select id="type" class="form-control" name="type">
		           	 <option value="">--请选择--</option>
		             <option value="menu" <c:if test="${resource.type eq 'menu' }">selected="selected"</c:if>>menu</option>
					 <option value="button" <c:if test="${resource.type eq 'button' }">selected="selected"</c:if>>button</option>
		           </select>
	            </div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-3 control-label">权限字符串<span class="asterisk">*</span></label>
				<div class="col-sm-6">
					<input type="text" name="permission" placeholder="权限字符串..." class="form-control" 
						<c:if test="${resource ne null }">value="${resource.permission }"</c:if> 
						value="" />
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-3 control-label">URL路径</label>
				<div class="col-sm-6">
					<input type="text" name="url" placeholder="URL路径..." class="form-control" 
						value="<c:if test="${resource ne null }">${resource.url }</c:if>"/>
				</div>
			</div>
			
			<div id="priorityDiv" class="form-group">
				<label class="col-sm-3 control-label">排序</label>
				<div class="col-sm-6">
					<input type="text" name="priority" placeholder="排序..." class="form-control" 
						value="<c:if test="${resource ne null }">${resource.priority }</c:if>"
						data-rule-number="true"/>
				</div>
			</div>
		</div> 
		<!-- panel-body 结束 -->
		
		<div class="panel-footer" style="text-align: center;">
			<button id="submitBtn" class="btn btn-primary">Submit</button>
			&nbsp;
            <button type="reset" class="btn btn-default">Reset</button>
		</div>
		
	</div>
</form>

</body>

<script type="text/javascript">
$(function() {
	
	/**
	 *	目前只有菜单有顺序
	 */
	$("#type").change(function() {
		var val = $(this).val();
		if(val == "button") {
			$("#priorityDiv").hidde();
			$("input[name='priority']").val(null);
		} else {
			$("#priorityDiv").show();
		}
	});
	
	
	$("#editForm").validate({
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
		highlight: function(element) {
			$(element).closest('.form-group').removeClass('has-success').addClass('has-error');
		},
		success: function(element) {
			$(element).closest('.form-group').removeClass('has-error');
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
</html>