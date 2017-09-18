<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>Bracket Responsive Bootstrap3 Admin</title>

  <link href="${ctx }/static/bracket/css/style.default.css" rel="stylesheet">

  <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!--[if lt IE 9]>
  <script src="js/html5shiv.js"></script>
  <script src="js/respond.min.js"></script>
  <![endif]-->
<title>Insert title here</title>
</head>
<body class="signin">
<section>
  
    <div class="signuppanel">
        
        <div class="row">
            
            <div class="col-md-6">
                
                <div class="signup-info">
                    <div class="logopanel">
                        <h1><span>[</span> bracket <span>]</span></h1>
                    </div><!-- logopanel -->
                
                    <div class="mb20"></div>
                
                    <h5><strong>Bootstrap 3 Admin Template!</strong></h5>
                    <p>Bracket is a theme that is perfect if you want to create your own content management, monitoring or any other system for your project.</p>
                    <p>Below are some of the benefits you can have when purchasing this template.</p>
                    <div class="mb20"></div>
                    
                    <div class="feat-list">
                        <i class="fa fa-wrench"></i>
                        <h4 class="text-success">Easy to Customize</h4>
                        <p>Bracket is made using Bootstrap 3 so you can easily customize any element of this template following the structure of Bootstrap 3.</p>
                    </div>
                    
                    <div class="feat-list">
                        <i class="fa fa-compress"></i>
                        <h4 class="text-success">Fully Responsive Layout</h4>
                        <p>Bracket is design to fit on all browser widths and all resolutions on all mobile devices. Try to scale your browser and see the results.</p>
                    </div>
                    
                    <div class="feat-list mb20">
                        <i class="fa fa-search-plus"></i>
                        <h4 class="text-success">Retina Ready</h4>
                        <p>When a user load a page, a script checks each image on the page to see if there's a high-res version of that image. If a high-res exists, the script will swap that image in place.</p>
                    </div>
                    
                    <h4 class="mb20">and much more...</h4>
                
                </div><!-- signup-info -->
            
            </div><!-- col-sm-6 -->
            
            <div class="col-md-6">
                
                <form id="registForm" method="post" action="${ctx }/manage/doRegist">
                    
                    <h3 class="nomargin">Sign Up</h3>
                    <p class="mt5 mb20">Already a member? <a href="${ctx }/manage/login"><strong>Sign In</strong></a></p>
                
                    <div class="mb10">
                        <label class="control-label"><span class="asterisk">*</span>Username</label>
                        <input name="username" type="text" class="form-control" />
                    </div>
                    
                    <div class="mb10">
                        <label class="control-label"><span class="asterisk">*</span>Password</label>
                        <input name="password" type="password" class="form-control" />
                    </div>
                    
                    <div class="mb10">
                        <label class="control-label"><span class="asterisk">*</span>Retype Password</label>
                        <input equalto="password" name="rePassword" type="password" class="form-control" />
                    </div>

                    <br />
                    
                    <button id="registBtn" class="btn btn-success btn-block">Sign Up</button>     
                </form>
            </div><!-- col-sm-6 -->
            
        </div><!-- row -->
        
        <div class="signup-footer">
            <div class="pull-left">
                &copy; 2014. All Rights Reserved. Bracket Bootstrap 3 Admin Template
            </div>
            <div class="pull-right">
                Created By: <a href="http://themepixels.com/" target="_blank">ThemePixels</a>
            </div>
        </div>
        
    </div><!-- signuppanel -->
  
</section>

<script type="text/javascript" src="${ctx }/static/bracket/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${ctx }/static/bracket/js/jquery.validate.min.js"></script>

<script type="text/javascript">
$(function() {
	
	//配置通用的默认提示语
	$.extend($.validator.messages, {
		required: '该输入框必填',
	    equalTo: "请再次输入相同的值"
	});
	
	// 密码字符匹配
	jQuery.validator.addMethod("passwordCode", function (value, element) {
	    var password = /^[_0-9a-z]{6,16}$/;
	    return this.optional(element) || (password.test(value));
	});
	
	// 比较输入是否相同
	jQuery.validator.addMethod("equalTo",function(value, element){
	    var returnVal = false;
	    var destName = $(element).attr("equalto");
	    var destVal = $("input[name="+destName+"]").val();
	    if(value === destVal){
	        returnVal = true;
	    }
	    return returnVal;
	});
	
	$("#registForm").validate({
		onkeyup: false,
		rules: {
			username: {
				required: true,
				remote: {
					type: "POST",
					url: "${ctx}/user/start/checkUsername",
					data: {
						"username": function() { return $("input[name='username']").val(); }
					},
					dataFilter: function(data) { //data为字符串
	                    data = $.parseJSON(data);
	                    if(data.success) {
	                        return true;
	                    }else if(data.code == 'exist'){
	                        return false;
	                    }
	                }
				}
			},
			password: {
				required: true,				
				passwordCode: true
			},
			rePassword: {
				required: true,
				equalTo: true				
			}
		},
		messages: {
			username: {
				remote: "该用户名已经存在"
			},
			password: {
				passwordCode: "密码由数字、字母、下划线组成，6～16位"
			},
			rePassword: {
				equalTo: "密码不一致"
			}
		},
		submitHandler: function() {
			var editData = $("#registForm").serializeArray();
			$.post("${ctx }/user/start/doRegist", editData, function(data) {
				if(data.success) {
					window.location.href = "${ctx}/user/login";
				} else {
					layer.msg("注册失败");
				}
			});
		}
	});
});
</script>

</body>
</html>