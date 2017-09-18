<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<%-- <link rel="shortcut icon" href="${ctx }/static/bracket/images/favicon.png" type="image/png"> --%>
<link href="${ctx }/static/bracket/css/style.default.css" rel="stylesheet">

<script src="${ctx }/static/bracket/js/jquery-1.11.1.min.js"></script>
<%-- <script src="${ctx }/static/js/jquery-1.8.3.min.js"></script> --%>
<script src="${ctx }/static/bracket/js/jquery-migrate-1.2.1.min.js"></script>
<script src="${ctx }/static/bracket/js/jquery-ui-1.10.3.min.js"></script>
<script src="${ctx }/static/bracket/js/bootstrap.min.js"></script>
<script src="${ctx }/static/bracket/js/bootstrap-editable.min.js"></script>
<script src="${ctx }/static/bracket/js/modernizr.min.js"></script>
<script src="${ctx }/static/bracket/js/jquery.sparkline.min.js"></script>
<script src="${ctx }/static/bracket/js/toggles.min.js"></script>
<%--<script src="${ctx }/static/bracket/js/retina.min.js"></script>--%>
<script src="${ctx }/static/bracket/js/jquery.cookies.js"></script>
<script src="${ctx }/static/layer-v3.0.1/layer/layer.js"></script>

<script src="${ctx }/static/bracket/js/flot/jquery.flot.min.js"></script>
<script src="${ctx }/static/bracket/js/flot/jquery.flot.resize.min.js"></script>
<script src="${ctx }/static/bracket/js/flot/jquery.flot.spline.min.js"></script>
<script src="${ctx }/static/bracket/js/morris.min.js"></script>
<script src="${ctx }/static/bracket/js/raphael-2.1.0.min.js"></script>

<script src="${ctx}/static/bracket/js/chosen.jquery.min.js"></script>
<script src="${ctx }/static/bracket/js/custom.js"></script>
<script src="${ctx }/static/bracket/js/dashboard.js"></script>
<title>后台管理:<sitemesh:write property='title' /></title>
</head>
<body>

	<!-- Preloader -->
	<div id="preloader">
		<div id="status">
			<i class="fa fa-spinner fa-spin"></i>
		</div>
	</div>

	<section> <!-- 左边菜单 开始 -->
	<div class="leftpanel">

		<div class="logopanel">
			<h1>
				<span>[</span> bracket <span>]</span>
			</h1>
		</div>
		<!-- logopanel -->

		<div class="leftpanelinner">
			<h5 class="sidebartitle">Navigation</h5>
			<!-- 菜单开始 -->
			<ul id=ul1 class="nav nav-pills nav-stacked nav-bracket">
				<li class="nav-parent active"><a href="javascript:void(0);"><i class="fa fa-home"></i> <span>后台用户管理</span></a>
					<ul class="children">
						<li><a class="a" href="${ctx }/manage/resource/index"><i class="fa fa-caret-right"></i> 资源管理</a></li>
						<li><a class="a" href="${ctx }/manage/menu/index"><i class="fa fa-caret-right"></i> 菜单管理</a></li>
						<li><a class="a" href="${ctx }/manage/role/index"><i class="fa fa-caret-right"></i> 角色管理</a></li>
						<li><a class="a" href="${ctx }/manage/organization/index"><i class="fa fa-caret-right"></i> 组织管理</a></li>
					</ul>
				</li>
				
				<li class="nav-parent"><a href="javascript:void(0);"><i class="fa fa-home"></i> <span>权限管1理</span></a>
					<ul class="children">
						<li><a class="a" href="${ctx }/manage/ureqfaser/index"><i class="fa fa-caret-right"></i> 用户1管理</a></li>
						<li><a class="a" href="${ctx }/manage/rorefadsqle/index"><i class="fa fa-caret-right"></i> 角色1管理</a></li>
						<li><a class="a" href="${ctx }/manage/resrqfaewrource/index"><i class="fa fa-caret-right"></i> 资源管1理</a></li>
						<li><a class="a" href="${ctx }/manage/orgaqnfaization/index"><i class="fa fa-caret-right"></i> 组1织管理</a></li>
					</ul>
				</li>
			</ul>
				

			<!-- infosummary 开始 -->
			<div class="infosummary">
				<h5 class="sidebartitle">Information Summary</h5>
				<ul>
					<li>
						<div class="datainfo">
							<span class="text-muted">Daily Traffic</span>
							<h4>630, 201</h4>
						</div>
						<div id="sidebar-chart" class="chart"></div>
					</li>
					<li>
						<div class="datainfo">
							<span class="text-muted">Average Users</span>
							<h4>1, 332, 801</h4>
						</div>
						<div id="sidebar-chart2" class="chart"></div>
					</li>
					<li>
						<div class="datainfo">
							<span class="text-muted">Disk Usage</span>
							<h4>82.2%</h4>
						</div>
						<div id="sidebar-chart3" class="chart"></div>
					</li>
					<li>
						<div class="datainfo">
							<span class="text-muted">CPU Usage</span>
							<h4>140.05 - 32</h4>
						</div>
						<div id="sidebar-chart4" class="chart"></div>
					</li>
					<li>
						<div class="datainfo">
							<span class="text-muted">Memory Usage</span>
							<h4>32.2%</h4>
						</div>
						<div id="sidebar-chart5" class="chart"></div>
					</li>
				</ul>
			</div>
			<!-- infosummary 结束 -->

		</div>
		<!-- leftpanelinner -->
	</div>
	<!-- leftpanel --> <!-- 左边菜单 结束 -->

	<div class="mainpanel">

		<div class="headerbar">

			<a class="menutoggle"><i class="fa fa-bars"></i></a>

			<form class="searchform" action="index.html" method="post">
				<input type="text" class="form-control" name="keyword"
					placeholder="Search here..." />
			</form>

			<div class="header-right">
				<ul class="headermenu">
					<li>
						<div class="btn-group">
							<button class="btn btn-default dropdown-toggle tp-icon"
								data-toggle="dropdown">
								<i class="glyphicon glyphicon-user"></i> <span class="badge">2</span>
							</button>
							<div class="dropdown-menu dropdown-menu-head pull-right">
								<h5 class="title">2 Newly Registered Users</h5>
								<ul class="dropdown-list user-list">
									<li class="new">
										<div class="thumb">
											<a href=""><img
												src="${ctx }/static/bracket/images/photos/user1.png" alt="" /></a>
										</div>
										<div class="desc">
											<h5>
												<a href="">Draniem Daamul (@draniem)</a> <span
													class="badge badge-success">new</span>
											</h5>
										</div>
									</li>
									<li class="new">
										<div class="thumb">
											<a href=""><img
												src="${ctx }/static/bracket/images/photos/user2.png" alt="" /></a>
										</div>
										<div class="desc">
											<h5>
												<a href="">Zaham Sindilmaca (@zaham)</a> <span
													class="badge badge-success">new</span>
											</h5>
										</div>
									</li>
									<li>
										<div class="thumb">
											<a href=""><img
												src="${ctx }/static/bracket/images/photos/user3.png" alt="" /></a>
										</div>
										<div class="desc">
											<h5>
												<a href="">Weno Carasbong (@wenocar)</a>
											</h5>
										</div>
									</li>
									<li>
										<div class="thumb">
											<a href=""><img
												src="${ctx }/static/bracket/images/photos/user4.png" alt="" /></a>
										</div>
										<div class="desc">
											<h5>
												<a href="">Nusja Nawancali (@nusja)</a>
											</h5>
										</div>
									</li>
									<li>
										<div class="thumb">
											<a href=""><img
												src="${ctx }/static/bracket/images/photos/user5.png" alt="" /></a>
										</div>
										<div class="desc">
											<h5>
												<a href="">Lane Kitmari (@lane_kitmare)</a>
											</h5>
										</div>
									</li>
									<li class="new"><a href="">See All Users</a></li>
								</ul>
							</div>
						</div>
					</li>
					<li>
						<div class="btn-group">
							<button class="btn btn-default dropdown-toggle tp-icon"
								data-toggle="dropdown">
								<i class="glyphicon glyphicon-envelope"></i> <span class="badge">1</span>
							</button>
							<div class="dropdown-menu dropdown-menu-head pull-right">
								<h5 class="title">You Have 1 New Message</h5>
								<ul class="dropdown-list gen-list">
									<li class="new"><a href=""> <span class="thumb"><img
												src="${ctx }/static/bracket/images/photos/user1.png" alt="" /></span>
											<span class="desc"> <span class="name">Draniem
													Daamul <span class="badge badge-success">new</span>
											</span> <span class="msg">Lorem ipsum dolor sit amet...</span>
										</span>
									</a></li>
									<li><a href=""> <span class="thumb"><img
												src="${ctx }/static/bracket/images/photos/user2.png" alt="" /></span>
											<span class="desc"> <span class="name">Nusja
													Nawancali</span> <span class="msg">Lorem ipsum dolor sit
													amet...</span>
										</span>
									</a></li>
									<li><a href=""> <span class="thumb"><img
												src="${ctx }/static/bracket/images/photos/user3.png" alt="" /></span>
											<span class="desc"> <span class="name">Weno
													Carasbong</span> <span class="msg">Lorem ipsum dolor sit
													amet...</span>
										</span>
									</a></li>
									<li><a href=""> <span class="thumb"><img
												src="${ctx }/static/bracket/images/photos/user4.png" alt="" /></span>
											<span class="desc"> <span class="name">Zaham
													Sindilmaca</span> <span class="msg">Lorem ipsum dolor sit
													amet...</span>
										</span>
									</a></li>
									<li><a href=""> <span class="thumb"><img
												src="${ctx }/static/bracket/images/photos/user5.png" alt="" /></span>
											<span class="desc"> <span class="name">Veno
													Leongal</span> <span class="msg">Lorem ipsum dolor sit
													amet...</span>
										</span>
									</a></li>
									<li class="new"><a href="">Read All Messages</a></li>
								</ul>
							</div>
						</div>
					</li>
					<li>
						<div class="btn-group">
							<button class="btn btn-default dropdown-toggle tp-icon"
								data-toggle="dropdown">
								<i class="glyphicon glyphicon-globe"></i> <span class="badge">5</span>
							</button>
							<div class="dropdown-menu dropdown-menu-head pull-right">
								<h5 class="title">You Have 5 New Notifications</h5>
								<ul class="dropdown-list gen-list">
									<li class="new"><a href=""> <span class="thumb"><img
												src="${ctx }/static/bracket/images/photos/user4.png" alt="" /></span>
											<span class="desc"> <span class="name">Zaham
													Sindilmaca <span class="badge badge-success">new</span>
											</span> <span class="msg">is now following you</span>
										</span>
									</a></li>
									<li class="new"><a href=""> <span class="thumb"><img
												src="${ctx }/static/bracket/images/photos/user5.png" alt="" /></span>
											<span class="desc"> <span class="name">Weno
													Carasbong <span class="badge badge-success">new</span>
											</span> <span class="msg">is now following you</span>
										</span>
									</a></li>
									<li class="new"><a href=""> <span class="thumb"><img
												src="${ctx }/static/bracket/images/photos/user3.png" alt="" /></span>
											<span class="desc"> <span class="name">Veno
													Leongal <span class="badge badge-success">new</span>
											</span> <span class="msg">likes your recent status</span>
										</span>
									</a></li>
									<li class="new"><a href=""> <span class="thumb"><img
												src="${ctx }/static/bracket/images/photos/user3.png" alt="" /></span>
											<span class="desc"> <span class="name">Nusja
													Nawancali <span class="badge badge-success">new</span>
											</span> <span class="msg">downloaded your work</span>
										</span>
									</a></li>
									<li class="new"><a href=""> <span class="thumb"><img
												src="${ctx }/static/bracket/images/photos/user3.png" alt="" /></span>
											<span class="desc"> <span class="name">Nusja
													Nawancali <span class="badge badge-success">new</span>
											</span> <span class="msg">send you 2 messages</span>
										</span>
									</a></li>
									<li class="new"><a href="">See All Notifications</a></li>
								</ul>
							</div>
						</div>
					</li>
					<li>
						<div class="btn-group">
							<button type="button" class="btn btn-default dropdown-toggle"
								data-toggle="dropdown">
								<img src="${ctx }/static/bracket/images/photos/loggeduser.png"
									alt="" /> John Doe <span class="caret"></span>
							</button>
							<ul class="dropdown-menu dropdown-menu-usermenu pull-right">
								<li><a href="profile.html"><i
										class="glyphicon glyphicon-user"></i> My Profile</a></li>
								<li><a href="#"><i class="glyphicon glyphicon-cog"></i>
										Account Settings</a></li>
								<li><a href="#"><i
										class="glyphicon glyphicon-question-sign"></i> Help</a></li>
								<li><a href="signin.html"><i
										class="glyphicon glyphicon-log-out"></i> Log Out</a></li>
							</ul>
						</div>
					</li>
					<li>
						<button id="chatview" class="btn btn-default tp-icon chat-icon">
							<i class="glyphicon glyphicon-comment"></i>
						</button>
					</li>
				</ul>
			</div>
			<!-- header-right -->

		</div>
		<!-- headerbar -->

		<div class="pageheader">
			<h2>
				<i class="fa fa-home"></i> Dashboard <span>Subtitle goes
					here...</span>
			</h2>
			<div class="breadcrumb-wrapper">
				<span class="label">You are here:</span>
				<ol class="breadcrumb">
					<li><a href="index.html">Bracket</a></li>
					<li class="active">Dashboard</li>
				</ol>
			</div>
		</div>
		
		<!-- contentPanel begin -->
		<sitemesh:write property='body' />
		<!-- conetntPanel end -->
	</div>
	<!-- mainpanel --> </section>

</body>
<script type="text/javascript">
$(function() {
	/**
	 * 处理菜单选中效果
	 */
	var uri = "${uri}";
	if(uri != undefined && uri != null) {
		$.each($(".a"), function(i, item) {
			$(item).parent().removeClass("active");
			$(item).parents().find(".children").css("display","none");
		});
		$("a[href$='"+uri+"']").parent().addClass("active");
		$("a[href$='"+uri+"']").parent().parent().css("display","block");
	}

	alert(111);
});
</script>
</html>