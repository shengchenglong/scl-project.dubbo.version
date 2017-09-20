<%--
  Created by IntelliJ IDEA.
  User: shengchenglong
  Date: 17/2/22
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta charset="utf-8" />
    <meta name="description" content="overview &amp; stats" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

    <!-- bootstrap & fontawesome -->
    <link rel="stylesheet" href="${ctx}/static/manage/ace-master/assets/css/bootstrap.min.css" />
    <link rel="stylesheet" href="${ctx}/static/manage/ace-master/assets/font-awesome/4.5.0/css/font-awesome.min.css" />

    <!-- page specific plugin styles -->

    <!-- text fonts -->
    <link rel="stylesheet" href="${ctx}/static/manage/ace-master/assets/css/fonts.googleapis.com.css" />

    <!-- ace styles -->
    <link rel="stylesheet" href="${ctx}/static/manage/ace-master/assets/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" />

    <!--[if lte IE 9]>
    <link rel="stylesheet" href="${ctx}/static/user/ace-master/assets/css/ace-part2.min.css" class="ace-main-stylesheet" />
    <![endif]-->
    <link rel="stylesheet" href="${ctx}/static/manage/ace-master/assets/css/ace-skins.min.css" />
    <link rel="stylesheet" href="${ctx}/static/manage/ace-master/assets/css/ace-rtl.min.css" />

    <!--[if lte IE 9]>
    <link rel="stylesheet" href="${ctx}/static/user/ace-master/assets/css/ace-ie.min.css" />
    <![endif]-->

    <!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->

    <!--[if lte IE 8]>
    <script src="${ctx}/static/user/ace-master/assets/js/html5shiv.min.js"></script>
    <script src="${ctx}/static/user/ace-master/assets/js/respond.min.js"></script>
    <![endif]-->
    <!--[if !IE]> -->
    <script src="${ctx}/static/manage/ace-master/assets/js/jquery-2.1.4.min.js"></script>
    <!-- <![endif]-->
    <!--[if IE]>
    <script src="${ctx}/static/user/ace-master/assets/js/jquery-1.11.3.min.js"></script>
    <![endif]-->

    <script type="text/javascript">
        if('ontouchstart' in document.documentElement) {
            document.write("<script src='${ctx}/static/user/ace-master/assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
        }
    </script>
    <script src="${ctx}/static/manage/ace-master/assets/js/bootstrap.min.js"></script>

    <!--[if lte IE 8]>
    <script src="${ctx}/static/user/ace-master/assets/js/excanvas.min.js"></script>
    <![endif]-->
    <script src="${ctx}/static/manage/ace-master/assets/js/jquery-ui.custom.min.js"></script>
    <script src="${ctx}/static/manage/ace-master/assets/js/jquery.ui.touch-punch.min.js"></script>
    <script src="${ctx}/static/manage/ace-master/assets/js/jquery.easypiechart.min.js"></script>
    <script src="${ctx}/static/manage/ace-master/assets/js/jquery.sparkline.index.min.js"></script>
    <script src="${ctx}/static/manage/ace-master/assets/js/jquery.flot.min.js"></script>
    <script src="${ctx}/static/manage/ace-master/assets/js/jquery.flot.pie.min.js"></script>
    <script src="${ctx}/static/manage/ace-master/assets/js/jquery.flot.resize.min.js"></script>
    <script src="${ctx}/static/manage/layer-v3.0.1/layer/layer.js"></script>

    <title>后台管理：<sitemesh:write property='title' /></title>

    <style>
        .ace-nav {height: 0px;}
        #nowDateTimeSpan {float: right; padding-right: 2%;}
    </style>
</head>

<body class="no-skin">
<%--最上方的一条admin导航栏 开始--%>
<div id="navbar" class="navbar navbar-default ace-save-state">
    <div class="navbar-container ace-save-state" id="navbar-container">
        <button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler" data-target="#sidebar">
            <span class="sr-only">Toggle sidebar</span>

            <span class="icon-bar"></span>

            <span class="icon-bar"></span>

            <span class="icon-bar"></span>
        </button>

        <div class="navbar-header pull-left">
            <a href="index.html" class="navbar-brand">
                <small>
                    <i class="fa fa-leaf"></i>
                    Ace Admin
                </small>
            </a>
        </div>

        <div class="navbar-buttons navbar-header pull-right" role="navigation">
            <ul class="nav ace-nav">
                <li class="grey dropdown-modal">
                    <a data-toggle="dropdown" class="dropdown-toggle" href="javascript:void(0);">
                        <i class="ace-icon fa fa-tasks"></i>
                        <span class="badge badge-grey">4</span>
                    </a>

                    <ul class="dropdown-menu-right dropdown-navbar dropdown-menu dropdown-caret dropdown-close">
                        <li class="dropdown-header">
                            <i class="ace-icon fa fa-check"></i>
                            4 Tasks to complete
                        </li>

                        <li class="dropdown-content">
                            <ul class="dropdown-menu dropdown-navbar">
                                <li>
                                    <a href="javascript:void(0);">
                                        <div class="clearfix">
                                            <span class="pull-left">Software Update</span>
                                            <span class="pull-right">65%</span>
                                        </div>

                                        <div class="progress progress-mini">
                                            <div style="width:65%" class="progress-bar"></div>
                                        </div>
                                    </a>
                                </li>

                                <li>
                                    <a href="javascript:void(0);">
                                        <div class="clearfix">
                                            <span class="pull-left">Hardware Upgrade</span>
                                            <span class="pull-right">35%</span>
                                        </div>

                                        <div class="progress progress-mini">
                                            <div style="width:35%" class="progress-bar progress-bar-danger"></div>
                                        </div>
                                    </a>
                                </li>

                                <li>
                                    <a href="javascript:void(0);">
                                        <div class="clearfix">
                                            <span class="pull-left">Unit Testing</span>
                                            <span class="pull-right">15%</span>
                                        </div>

                                        <div class="progress progress-mini">
                                            <div style="width:15%" class="progress-bar progress-bar-warning"></div>
                                        </div>
                                    </a>
                                </li>

                                <li>
                                    <a href="javascript:void(0);">
                                        <div class="clearfix">
                                            <span class="pull-left">Bug Fixes</span>
                                            <span class="pull-right">90%</span>
                                        </div>

                                        <div class="progress progress-mini progress-striped active">
                                            <div style="width:90%" class="progress-bar progress-bar-success"></div>
                                        </div>
                                    </a>
                                </li>
                            </ul>
                        </li>

                        <li class="dropdown-footer">
                            <a href="javascript:void(0);">
                                See tasks with details
                                <i class="ace-icon fa fa-arrow-right"></i>
                            </a>
                        </li>
                    </ul>
                </li>

                <li class="purple dropdown-modal">
                    <a data-toggle="dropdown" class="dropdown-toggle" href="javascript:void(0);">
                        <i class="ace-icon fa fa-bell icon-animated-bell"></i>
                        <span class="badge badge-important">8</span>
                    </a>

                    <ul class="dropdown-menu-right dropdown-navbar navbar-pink dropdown-menu dropdown-caret dropdown-close">
                        <li class="dropdown-header">
                            <i class="ace-icon fa fa-exclamation-triangle"></i>
                            8 Notifications
                        </li>

                        <li class="dropdown-content">
                            <ul class="dropdown-menu dropdown-navbar navbar-pink">
                                <li>
                                    <a href="javascript:void(0);">
                                        <div class="clearfix">
                                            <span class="pull-left">
                                                <i class="btn btn-xs no-hover btn-pink fa fa-comment"></i>
                                                New Comments
                                            </span>
                                            <span class="pull-right badge badge-info">+12</span>
                                        </div>
                                    </a>
                                </li>

                                <li>
                                    <a href="javascript:void(0);">
                                        <i class="btn btn-xs btn-primary fa fa-user"></i>
                                        Bob just signed up as an editor ...
                                    </a>
                                </li>

                                <li>
                                    <a href="javascript:void(0);">
                                        <div class="clearfix">
                                            <span class="pull-left">
                                                <i class="btn btn-xs no-hover btn-success fa fa-shopping-cart"></i>
                                                New Orders
                                            </span>
                                            <span class="pull-right badge badge-success">+8</span>
                                        </div>
                                    </a>
                                </li>

                                <li>
                                    <a href="javascript:void(0);">
                                        <div class="clearfix">
                                            <span class="pull-left">
                                                <i class="btn btn-xs no-hover btn-info fa fa-twitter"></i>
                                                Followers
                                            </span>
                                            <span class="pull-right badge badge-info">+11</span>
                                        </div>
                                    </a>
                                </li>
                            </ul>
                        </li>

                        <li class="dropdown-footer">
                            <a href="javascript:void(0);">
                                See all notifications
                                <i class="ace-icon fa fa-arrow-right"></i>
                            </a>
                        </li>
                    </ul>
                </li>

                <li class="green dropdown-modal">
                    <a data-toggle="dropdown" class="dropdown-toggle" href="javascript:void(0);">
                        <i class="ace-icon fa fa-envelope icon-animated-vertical"></i>
                        <span class="badge badge-success">5</span>
                    </a>

                    <ul class="dropdown-menu-right dropdown-navbar dropdown-menu dropdown-caret dropdown-close">
                        <li class="dropdown-header">
                            <i class="ace-icon fa fa-envelope-o"></i>
                            5 Messages
                        </li>

                        <li class="dropdown-content">
                            <ul class="dropdown-menu dropdown-navbar">
                                <li>
                                    <a href="javascript:void(0);" class="clearfix">
                                        <img src="${ctx}/static/manage/ace-master/assets/images/avatars/avatar.png" class="msg-photo" alt="Alex's Avatar" />
                                        <span class="msg-body">
                                            <span class="msg-title">
                                                <span class="blue">Alex:</span>
                                                Ciao sociis natoque penatibus et auctor ...
                                            </span>

                                            <span class="msg-time">
                                                <i class="ace-icon fa fa-clock-o"></i>
                                                <span>a moment ago</span>
                                            </span>
                                        </span>
                                    </a>
                                </li>

                                <li>
                                    <a href="javascript:void(0);" class="clearfix">
                                        <img src="${ctx}/static/manage/ace-master/assets/images/avatars/avatar3.png" class="msg-photo" alt="Susan's Avatar" />
                                        <span class="msg-body">
                                            <span class="msg-title">
                                                <span class="blue">Susan:</span>
                                                Vestibulum id ligula porta felis euismod ...
                                            </span>

                                            <span class="msg-time">
                                                <i class="ace-icon fa fa-clock-o"></i>
                                                <span>20 minutes ago</span>
                                            </span>
                                        </span>
                                    </a>
                                </li>

                                <li>
                                    <a href="javascript:void(0);" class="clearfix">
                                        <img src="${ctx}/static/manage/ace-master/assets/images/avatars/avatar4.png" class="msg-photo" alt="Bob's Avatar" />
                                        <span class="msg-body">
                                            <span class="msg-title">
                                                <span class="blue">Bob:</span>
                                                Nullam quis risus eget urna mollis ornare ...
                                            </span>

                                            <span class="msg-time">
                                                <i class="ace-icon fa fa-clock-o"></i>
                                                <span>3:15 pm</span>
                                            </span>
                                        </span>
                                    </a>
                                </li>

                                <li>
                                    <a href="javascript:void(0);" class="clearfix">
                                        <img src="${ctx}/static/manage/ace-master/assets/images/avatars/avatar2.png" class="msg-photo" alt="Kate's Avatar" />
                                        <span class="msg-body">
                                            <span class="msg-title">
                                                <span class="blue">Kate:</span>
                                                Ciao sociis natoque eget urna mollis ornare ...
                                            </span>

                                            <span class="msg-time">
                                                <i class="ace-icon fa fa-clock-o"></i>
                                                <span>1:33 pm</span>
                                            </span>
                                        </span>
                                    </a>
                                </li>

                                <li>
                                    <a href="javascript:void(0);" class="clearfix">
                                        <img src="${ctx}/static/manage/ace-master/assets/images/avatars/avatar5.png" class="msg-photo" alt="Fred's Avatar" />
                                        <span class="msg-body">
                                            <span class="msg-title">
                                                <span class="blue">Fred:</span>
                                                Vestibulum id penatibus et auctor  ...
                                            </span>

                                            <span class="msg-time">
                                                <i class="ace-icon fa fa-clock-o"></i>
                                                <span>10:09 am</span>
                                            </span>
                                        </span>
                                    </a>
                                </li>
                            </ul>
                        </li>

                        <li class="dropdown-footer">
                            <a href="inbox.html">
                                See all messages
                                <i class="ace-icon fa fa-arrow-right"></i>
                            </a>
                        </li>
                    </ul>
                </li>

                <li class="light-blue dropdown-modal">
                    <a data-toggle="dropdown" href="javascript:void(0);" class="dropdown-toggle">
                        <img class="nav-user-photo" src="${ctx}/static/manage/ace-master/assets/images/avatars/user.jpg" alt="Jason's Photo" />
                        <span class="user-info">
                            <small>Welcome,</small>
                            Jason
                        </span>

                        <i class="ace-icon fa fa-caret-down"></i>
                    </a>

                    <ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
                        <li>
                            <a href="javascript:void(0);">
                                <i class="ace-icon fa fa-cog"></i>
                                Settings
                            </a>
                        </li>

                        <li>
                            <a href="profile.html">
                                <i class="ace-icon fa fa-user"></i>
                                Profile
                            </a>
                        </li>

                        <li class="divider"></li>

                        <li>
                            <a href="javascript:void(0);">
                                <i class="ace-icon fa fa-power-off"></i>
                                Logout
                            </a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</div>
<%--最上方的一条admin导航栏 结束--%>

<%--除了admin导航栏的部分 开始--%>
<div class="main-container ace-save-state" id="main-container">
    <script type="text/javascript">
        try{ace.settings.loadState('main-container')}catch(e){}
    </script>

    <%--左侧菜单栏整体 开始--%>
    <div id="sidebar" class="sidebar responsive ace-save-state">
        <script type="text/javascript">
            try{ace.settings.loadState('sidebar')}catch(e){}
        </script>

        <div class="sidebar-shortcuts" id="sidebar-shortcuts">
            <div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
                <button class="btn btn-success">
                    <i class="ace-icon fa fa-signal"></i>
                </button>

                <button class="btn btn-info">
                    <i class="ace-icon fa fa-pencil"></i>
                </button>

                <button class="btn btn-warning">
                    <i class="ace-icon fa fa-users"></i>
                </button>

                <button class="btn btn-danger">
                    <i class="ace-icon fa fa-cogs"></i>
                </button>
            </div>

            <div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
                <span class="btn btn-success"></span>

                <span class="btn btn-info"></span>

                <span class="btn btn-warning"></span>

                <span class="btn btn-danger"></span>
            </div>
        </div><!-- /.sidebar-shortcuts -->

        <%--菜单栏 开始--%>
        <ul class="nav nav-list">
            <li class="">
                <a href="javascript:void(0);" class="dropdown-toggle">
                    <i class="menu-icon fa fa-list"></i>
                    <span class="menu-text">
                        后台用户管理
                    </span>
                    <b class="arrow fa fa-angle-down"></b>
                </a>

                <b class="arrow"></b>

                <ul class="submenu">
                    <li class="">
                        <a class="nav-a" href="${ctx}/manage/resource/index">
                            <i class="menu-icon fa fa-caret-right"></i>
                            资源管理
                        </a>
                        <b class="arrow"></b>
                    </li>

                    <li class="">
                        <a class="nav-a" href="${ctx}/manage/role/index">
                            <i class="menu-icon fa fa-caret-right"></i>
                            角色管理
                        </a>
                        <b class="arrow"></b>
                    </li>

                    <li class="">
                        <a class="nav-a" href="${ctx}/manage/menu/index">
                            <i class="menu-icon fa fa-caret-right"></i>
                            菜单管理
                        </a>
                        <b class="arrow"></b>
                    </li>

                    <li class="">
                        <a class="nav-a" href="${ctx}/manage/user/index">
                            <i class="menu-icon fa fa-caret-right"></i>
                            用户管理
                        </a>
                        <b class="arrow"></b>
                    </li>
                </ul>
            </li>

            <li class="">
                <a href="javascript:void(0);" class="dropdown-toggle">
                    <i class="menu-icon fa fa-list"></i>
                    <span class="menu-text">
                        门户信息管理
                    </span>
                    <b class="arrow fa fa-angle-down"></b>
                </a>

                <b class="arrow"></b>

                <ul class="submenu">
                    <li class="">
                        <a class="nav-a" href="${ctx}/manage/site/index">
                            <i class="menu-icon fa fa-caret-right"></i>
                            站点管理
                        </a>
                        <b class="arrow"></b>
                    </li>

                    <li class="">
                        <a class="nav-a" href="${ctx}/manage/column/index">
                            <i class="menu-icon fa fa-caret-right"></i>
                            栏目管理
                        </a>
                        <b class="arrow"></b>
                    </li>

                    <li class="">
                        <a class="nav-a" href="${ctx}/manage/article/index">
                            <i class="menu-icon fa fa-caret-right"></i>
                            文章管理
                        </a>
                        <b class="arrow"></b>
                    </li>

                    <li class="">
                        <a class="nav-a" href="${ctx}/manage/advertising/index">
                            <i class="menu-icon fa fa-caret-right"></i>
                            轮播图管理
                        </a>
                        <b class="arrow"></b>
                    </li>

                    <li class="">
                        <a class="nav-a" href="${ctx}/manage/template/index">
                            <i class="menu-icon fa fa-caret-right"></i>
                            模板管理
                        </a>
                        <b class="arrow"></b>
                    </li>
                </ul>
            </li>

            <li class="">
                <a href="javascript:void(0);" class="dropdown-toggle">
                    <i class="menu-icon fa fa-list"></i>
                    <span class="menu-text">
                        系统配置
                    </span>
                    <b class="arrow fa fa-angle-down"></b>
                </a>

                <b class="arrow"></b>

                <ul class="submenu">
                    <li class="">
                        <a class="nav-a" href="${ctx}/manage/dictionary/index">
                            <i class="menu-icon fa fa-caret-right"></i>
                            数据字典
                        </a>
                        <b class="arrow"></b>
                    </li>

                </ul>
            </li>
        </ul><!-- /.nav-list -->
        <%--菜单栏 结束--%>

        <div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
            <i id="sidebar-toggle-icon" class="ace-icon fa fa-angle-double-left ace-save-state" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
        </div>
    </div>
    <%--左侧菜单栏整体 结束--%>

    <%--右侧主体内容 开始--%>
    <div class="main-content">
        <div class="main-content-inner">
            <!--中上方 搜索 位置提示栏 开始-->
            <div class="breadcrumbs ace-save-state" id="breadcrumbs">
                <ul class="breadcrumb">
                    <li>
                        <i class="ace-icon fa fa-home home-icon"></i>
                        <a href="javascript:void(0);">Home</a>
                    </li>
                    <li class="active">Dashboard</li>
                </ul><!-- /.breadcrumb -->

                <div class="nav-search" id="nav-search">
                    <form class="form-search">
                    <span class="input-icon">
                        <input type="text" placeholder="Search ..." class="nav-search-input" id="nav-search-input" autocomplete="off" />
                        <i class="ace-icon fa fa-search nav-search-icon"></i>
                    </span>
                    </form>
                </div><!-- /.nav-search -->
            </div>
            <!--中上方 搜索 位置提示栏 结束-->


            <div class="page-content">
                <%--又边侧页面显示风格设置按钮 开始--%>
                <div class="ace-settings-container" id="ace-settings-container">
                    <div class="btn btn-app btn-xs btn-warning ace-settings-btn" id="ace-settings-btn">
                        <i class="ace-icon fa fa-cog bigger-130"></i>
                    </div>

                    <div class="ace-settings-box clearfix" id="ace-settings-box">
                        <div class="pull-left width-50">
                            <div class="ace-settings-item">
                                <div class="pull-left">
                                    <select id="skin-colorpicker" class="hide">
                                        <option data-skin="no-skin" value="#438EB9">#438EB9</option>
                                        <option data-skin="skin-1" value="#222A2D">#222A2D</option>
                                        <option data-skin="skin-2" value="#C6487E">#C6487E</option>
                                        <option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>
                                    </select>
                                </div>
                                <span>&nbsp; Choose Skin</span>
                            </div>

                            <div class="ace-settings-item">
                                <input type="checkbox" class="ace ace-checkbox-2 ace-save-state" id="ace-settings-navbar" autocomplete="off" />
                                <label class="lbl" for="ace-settings-navbar"> Fixed Navbar</label>
                            </div>

                            <div class="ace-settings-item">
                                <input type="checkbox" class="ace ace-checkbox-2 ace-save-state" id="ace-settings-sidebar" autocomplete="off" />
                                <label class="lbl" for="ace-settings-sidebar"> Fixed Sidebar</label>
                            </div>

                            <div class="ace-settings-item">
                                <input type="checkbox" class="ace ace-checkbox-2 ace-save-state" id="ace-settings-breadcrumbs" autocomplete="off" />
                                <label class="lbl" for="ace-settings-breadcrumbs"> Fixed Breadcrumbs</label>
                            </div>

                            <div class="ace-settings-item">
                                <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-rtl" autocomplete="off" />
                                <label class="lbl" for="ace-settings-rtl"> Right To Left (rtl)</label>
                            </div>

                            <div class="ace-settings-item">
                                <input type="checkbox" class="ace ace-checkbox-2 ace-save-state" id="ace-settings-add-container" autocomplete="off" />
                                <label class="lbl" for="ace-settings-add-container">
                                    Inside
                                    <b>.container</b>
                                </label>
                            </div>
                        </div><!-- /.pull-left -->

                        <div class="pull-left width-50">
                            <div class="ace-settings-item">
                                <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-hover" autocomplete="off" />
                                <label class="lbl" for="ace-settings-hover"> Submenu on Hover</label>
                            </div>

                            <div class="ace-settings-item">
                                <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-compact" autocomplete="off" />
                                <label class="lbl" for="ace-settings-compact"> Compact Sidebar</label>
                            </div>

                            <div class="ace-settings-item">
                                <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-highlight" autocomplete="off" />
                                <label class="lbl" for="ace-settings-highlight"> Alt. Active Item</label>
                            </div>
                        </div>
                    </div>
                </div>
                <%--又边侧页面显示风格设置按钮 结束--%>

                <%--当前页面描述 页眉 开始--%>
                <div class="page-header">
                    <h1>
                        Dashboard
                        <small>
                            <i class="ace-icon fa fa-angle-double-right"></i>
                            overview &amp; stats
                        </small>
                        <span id="nowDateTimeSpan"></span>
                    </h1>
                </div><!-- /.page-header -->
                <%--当前页面描述 页眉 开始--%>

                <sitemesh:write property='body' />
                <%--<div class="row"></div>--%>

            </div>

        </div>




        <%--回到顶部 按钮--%>
        <a href="javascript:void(0);" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse" title="回到顶部">
            <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
        </a>
    </div>
    <%--右侧主题内容 结束--%>

    <%--底部网站信息 开始--%>
    <div class="footer">
        <div class="footer-inner">
            <div class="footer-content">
                    <span class="bigger-120">
                        <span class="blue bolder">Ace</span>
                        Application &copy; 2013-2014
                    </span>

                &nbsp; &nbsp;
                <span class="action-buttons">
                        <a href="javascript:void(0);">
                            <i class="ace-icon fa fa-twitter-square light-blue bigger-150"></i>
                        </a>

                        <a href="javascript:void(0);">
                            <i class="ace-icon fa fa-facebook-square text-primary bigger-150"></i>
                        </a>

                        <a href="javascript:void(0);">
                            <i class="ace-icon fa fa-rss-square orange bigger-150"></i>
                        </a>
                    </span>
            </div>
        </div>
    </div>
    <%--底部网站信息 结束--%>
</div>
<%--除了admin导航栏的部分 结束--%>


</body>
<!--自定义的js文件在下方引用（防止提前绑定js，但是元素在后面生成，导致绑定失败的坑）-->
<!-- ace settings handler -->
<script src="${ctx}/static/manage/ace-master/assets/js/ace-extra.min.js"></script>
<!-- ace scripts -->
<script src="${ctx}/static/manage/ace-master/assets/js/ace-elements.min.js"></script>
<script src="${ctx}/static/manage/ace-master/assets/js/ace.min.js"></script>

<script>
    $(function() {
        activeMenu();
        startTime();
    });

    /**
     * 菜单栏选中效果
     */
    function activeMenu() {
        var uri = "${uri}";
        if(uri != undefined && uri != null) {
            $.each($(".nav-a"), function(i, item) {
                $(item).parent().removeClass("active");
                $(item).parents().find(".submenu").parent().removeClass("active").removeClass("open");
            });
            $("a[href$='"+uri+"']").parent().addClass("active");
            $("a[href$='"+uri+"']").parent().parent().parent().addClass("active").addClass("open");
        }
    }

    /**
     * 显示时间
     */
    function startTime() {
        var today=new Date();//定义日期对象
        var yyyy = today.getFullYear();//通过日期对象的getFullYear()方法返回年
        var MM = today.getMonth()+1;//通过日期对象的getMonth()方法返回年
        var dd = today.getDate();//通过日期对象的getDate()方法返回年
        var hh=today.getHours();//通过日期对象的getHours方法返回小时
        var mm=today.getMinutes();//通过日期对象的getMinutes方法返回分钟
        var ss=today.getSeconds();//通过日期对象的getSeconds方法返回秒
        // 如果分钟或小时的值小于10，则在其值前加0，比如如果时间是下午3点20分9秒的话，则显示15：20：09
        MM=checkTime(MM);
        dd=checkTime(dd);
        mm=checkTime(mm);
        ss=checkTime(ss);
        var day; //用于保存星期（getDay()方法得到星期编号）
        if(today.getDay()==0)   day   =   "星期日 "
        if(today.getDay()==1)   day   =   "星期一 "
        if(today.getDay()==2)   day   =   "星期二 "
        if(today.getDay()==3)   day   =   "星期三 "
        if(today.getDay()==4)   day   =   "星期四 "
        if(today.getDay()==5)   day   =   "星期五 "
        if(today.getDay()==6)   day   =   "星期六 "
        document.getElementById('nowDateTimeSpan').innerHTML = yyyy+"-"+MM +"-"+ dd +" " + hh+":"+mm+":"+ss+"   " + day;
        setTimeout('startTime()',1000);//每一秒中重新加载startTime()方法
    }

    function checkTime(i) {
        if (i<10){
            i="0" + i;
        }
        return i;
    }

</script>
</html>
