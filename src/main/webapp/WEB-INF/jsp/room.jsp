<%--
  Created by IntelliJ IDEA.
  User: 41809
  Date: 2018/8/21
  Time: 21:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/tag/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>AdminLTE 2 | Data Tables</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.7 -->
    <link rel="stylesheet" href="../../static/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="../../static/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="../../static/css/ionicons.min.css">
    <!-- DataTables -->
    <link rel="stylesheet" href="../../static/css/dataTables.bootstrap.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="../../static/css/AdminLTE.min.css">
    <!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
    <link rel="stylesheet" href="../../static/css/_all-skins.min.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="../../static/js/html5shiv.min.js"></script>
    <script src="../../static/js/respond.min.js"></script>
    <![endif]-->

    <!-- Google Font -->
    <link rel="stylesheet" href="../../static/css/google-font.css">
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

    <header class="main-header">
        <!-- Logo -->
        <a href="/homepage" class="logo">
            <!-- mini logo for sidebar mini 50x50 pixels -->
            <span class="logo-mini"><b>L</b>H</span>
            <!-- logo for regular state and mobile devices -->
            <span class="logo-lg"><b>Luxury</b>HOTEL</span>
        </a>
        <!-- Header Navbar: style can be found in header.less -->
        <nav class="navbar navbar-static-top">
            <!-- Sidebar toggle button-->
            <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>

            <div class="navbar-custom-menu">
                <ul class="nav navbar-nav">
                    <!-- Messages: style can be found in dropdown.less-->
                    <li class="dropdown messages-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="fa fa-envelope-o"></i>
                            <span class="label label-success">4</span>
                        </a>
                        <ul class="dropdown-menu">
                            <li class="header">You have 4 messages</li>
                            <li>
                                <!-- inner menu: contains the actual data -->
                                <ul class="menu">
                                    <li><!-- start message -->
                                        <a href="#">
                                            <div class="pull-left">
                                                <img src="../../static/imgs/defaultImg.jpg" class="img-circle" alt="User Image">
                                            </div>
                                            <h4>
                                                Support Team
                                                <small><i class="fa fa-clock-o"></i> 5 mins</small>
                                            </h4>
                                            <p>Why not buy a new awesome theme?</p>
                                        </a>
                                    </li>
                                    <!-- end message -->
                                </ul>
                            </li>
                            <li class="footer"><a href="#">See All Messages</a></li>
                        </ul>
                    </li>
                    <!-- User Account: style can be found in dropdown.less -->
                    <li class="dropdown user user-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <img src="../../static/imgs/defaultImg.jpg" class="user-image" alt="User Image">
                            <span class="hidden-xs">${user.name}</span>
                        </a>
                        <ul class="dropdown-menu">
                            <!-- User image -->
                            <li class="user-header">
                                <img src="../../static/imgs/defaultImg.jpg" class="img-circle" alt="User Image">

                                <p>
                                    <c:forEach items="${user.roleList}" var="role">
                                        <c:forEach items="${userTypeEnum}" var="userType">
                                            <c:if test="${userType.key eq role.id}">
                                                ${userType.value}
                                            </c:if>
                                        </c:forEach>
                                    </c:forEach>
                                    <small>${user.phoneNumber}</small>
                                </p>
                            </li>
                            <!-- Menu Footer-->
                            <li class="user-footer">
                                <div class="pull-right">
                                    <a href="/logout" class="btn btn-default btn-flat">退出</a>
                                </div>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </nav>
    </header>
    <!-- Left side column. contains the sidebar -->
    <aside class="main-sidebar">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
            <!-- Sidebar user panel -->
            <div class="user-panel">
                <div class="pull-left image">
                    <img src="../../static/imgs/defaultImg.jpg" class="img-circle" alt="User Image">
                </div>
                <div class="pull-left info">
                    <p>${user.name}</p>
                </div>
            </div>
            <!-- /.search form -->
            <!-- sidebar menu: : style can be found in sidebar.less -->
            <ul class="sidebar-menu" data-widget="tree">
                <li class="header">MENU</li>
                <li class="treeview">
                    <a href="#">
                        <i class="fa fa-dashboard"></i> <span>Dashboard</span>
                        <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="../../index.html"><i class="fa fa-circle-o"></i> Dashboard v1</a></li>
                        <li><a href="../../index2.html"><i class="fa fa-circle-o"></i> Dashboard v2</a></li>
                    </ul>
                </li>

            </ul>
        </section>
        <!-- /.sidebar -->
    </aside>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                Data Tables
                <small>advanced tables</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li><a href="#">Tables</a></li>
                <li class="active">Data tables</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header with-border">
                            <h3 class="box-title">住房信息</h3>

                            <div class="box-tools">
                                <ul class="pagination pagination-sm no-margin pull-right">
                                    页面大小
                                    <select name="pageSize" >
                                        <option value="10" <c:if test="${page.pageSize eq 10}">selected="selected"</c:if>>10</option>
                                        <option value="20" <c:if test="${page.pageSize eq 20}">selected="selected"</c:if>>20</option>
                                        <option value="50" <c:if test="${page.pageSize eq 50}">selected="selected"</c:if>>50</option>
                                    </select>
                                    条记录
                                </ul>
                            </div>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <table class="table table-bordered table-hover" style="text-align: center">
                                <thead>
                                <tr>
                                    <th width="15%" style="text-align: center">房间号</th>
                                    <th width="15%" style="text-align: center">房间类型</th>
                                    <th width="15%" style="text-align: center">房间价格</th>
                                    <th width="15%" style="text-align: center">房间状态</th>
                                    <th width="15%" style="text-align: center">入住者</th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${page.content}" var="room">
                                    <tr>
                                        <td>${room.roomNumber}</td>
                                        <td>
                                            <c:forEach items="${roomTypeEnum}" var="roomType">
                                                <c:if test="${roomType.key eq room.roomType}">
                                                    ${roomType.value}
                                                </c:if>
                                            </c:forEach>
                                        </td>
                                        <td>￥ ${room.roomPrice} 元/晚</td>
                                        <td>
                                            <c:forEach items="${roomStatusEnum}" var="roomStatus">
                                                <c:if test="${roomStatus.key eq room.roomStatus}">
                                                    ${roomStatus.value}
                                                </c:if>
                                            </c:forEach>
                                        </td>
                                        <td>
                                                <c:if test="${ empty room.tenant}">
                                                    N/A
                                                </c:if>
                                                ${room.tenant}
                                        </td>
                                        <td></td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                                <tfoot>
                                <tr>
                                    <th width="15%" style="text-align: center">房间号</th>
                                    <th width="15%" style="text-align: center">房间类型</th>
                                    <th width="15%" style="text-align: center">房间价格</th>
                                    <th width="15%" style="text-align: center">房间状态</th>
                                    <th width="15%" style="text-align: center">入住者</th>
                                    <th></th>
                                </tr>
                                </tfoot>
                            </table>
                        </div>
                        <!-- /.box-body -->
                        <div class="box-footer clearfix">
                            <ul class="pagination pagination-sm no-margin pull-right">
                                <li <c:if test="${page.pageNumber eq 0}">class="disabled" </c:if>><a href="#" ><i class="fa fa-angle-double-left" ></i></a></li>
                                <li <c:if test="${page.pageNumber eq 0}">class="disabled" </c:if>><a href="#"><i class="fa fa-angle-left" ></i></a></li>
                                <li class="active"><span>${page.pageNumber+1}&nbsp;of &nbsp;${page.totalPages} </span></li>
                                <li <c:if test="${page.pageNumber eq page.totalPages-1}">class="disabled" </c:if>><a href="#"><i class="fa fa-angle-right"></i></a></li>
                                <li <c:if test="${page.pageNumber eq page.totalPages-1}">class="disabled" </c:if>><a href="#"><i class="fa fa-angle-double-right"></i></a></li>
                            </ul>
                        </div>
                    </div>
                    <!-- /.box -->
                </div>
                <!-- /.col -->
            </div>
            <!-- /.row -->
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
    <footer class="main-footer">
        <div class="pull-right hidden-xs">
            <b>Version</b> 1.0.0
        </div>
        <strong>Copyright &copy; 2018 <a >Hotel</a>.</strong> All rights reserved.
    </footer>
    <!-- Add the sidebar's background. This div must be placed
         immediately after the control sidebar -->
    <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->

<!-- jQuery 3 -->
<script src="../../static/js/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="../../static/js/bootstrap.min.js"></script>
<!-- DataTables -->
<script src="../../static/js/jquery.dataTables.min.js"></script>
<script src="../../static/js/dataTables.bootstrap.min.js"></script>
<!-- SlimScroll -->
<script src="../../static/js/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="../../static/js/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="../../static/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="../../static/js/demo.js"></script>
<!-- page script -->
</body>
</html>

