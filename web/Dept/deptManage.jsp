<%--设置文档编码 --%>
<%--
	jsp三大指令：
		page：针对于当前页面的设置
		taglib：引入第三方标签库
		include：引入另外的jsp页面
--%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.util.List" %>
<%@ page import="dao.DeptDaoImpl" %>
<%@ page import="pojo.Dept" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    //获取项目信息（项目名称）
    String path = request.getContextPath();
//获取项目相对路径
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    DeptDaoImpl dao = new DeptDaoImpl();
    List<Dept> deptList = null;
    deptList = dao.selectDeptList();
    request.setAttribute("list", deptList);
%>

<!doctype html>
<!--[if lt IE 7]> <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]> <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]> <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js" lang="">
<!--<![endif]-->

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>查看部门信息</title>
    <meta name="description" content="Ela Admin - HTML5 Admin Template">
    <meta name="viewport" content="width=device-width, initial-scale=1">


    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/normalize.css@8.0.0/normalize.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/font-awesome@4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/lykmapipo/themify-icons@0.1.2/css/themify-icons.css">
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/pixeden-stroke-7-icon@1.2.3/pe-icon-7-stroke/dist/pe-icon-7-stroke.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/flag-icon-css/3.2.0/css/flag-icon.min.css">
    <link rel="stylesheet" href="<%=path%>/assets/css/cs-skin-elastic.css">
    <link rel="stylesheet" href="<%=path%>/assets/css/style.css">
    <link rel="stylesheet" href="<%=path%>/assets/css/lib/datatable/dataTables.bootstrap.min.css">
    <!-- <script type="text/javascript" src="https://cdn.jsdelivr.net/html5shiv/3.7.3/html5shiv.min.js"></script> -->
    <link href="https://cdn.jsdelivr.net/npm/chartist@0.11.0/dist/chartist.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/jqvmap@1.5.1/dist/jqvmap.min.css" rel="stylesheet">

    <link href="https://cdn.jsdelivr.net/npm/weathericons@2.1.0/css/weather-icons.css" rel="stylesheet"/>
    <link href="https://cdn.jsdelivr.net/npm/fullcalendar@3.9.0/dist/fullcalendar.min.css" rel="stylesheet"/>
    <style>
        #weatherWidget .currentDesc {
            color: #ffffff !important;
        }

        .traffic-chart {
            min-height: 335px;
        }

        #flotPie1 {
            height: 150px;
        }

        #flotPie1 td {
            padding: 3px;
        }

        #flotPie1 table {
            top: 20px !important;
            right: -10px !important;
        }

        .chart-container {
            display: table;
            min-width: 270px;
            text-align: left;
            padding-top: 10px;
            padding-bottom: 10px;
        }

        #flotLine5 {
            height: 105px;
        }

        #flotBarChart {
            height: 150px;
        }

        #cellPaiChart {
            height: 160px;
        }

    </style>
</head>

<body>
<!-- Left Panel -->
<aside id="left-panel" class="left-panel">
    <nav class="navbar navbar-expand-sm navbar-default">
        <div id="main-menu" class="main-menu collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active">
                    <a href="<%=basePath%>index.jsp"><i class="menu-icon fa fa-laptop"></i>主页 </a>
                </li>
                <li class="menu-title">管理中心</li><!-- /.menu-title -->
                <li class="menu-item-has-children dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true"
                       aria-expanded="false"> <i class="menu-icon fa fa-cogs"></i>部门管理</a>
                    <ul class="sub-menu children dropdown-menu">
                        <li><i class="fa fa-id-badge"></i><a href="<%=basePath%>/Dept/addDept.jsp">新建部门</a></li>
                        <li><i class="fa fa-bars"></i><a href="<%=basePath%>/Dept/deptManage.jsp">部门信息</a></li>
                    </ul>
                </li>
                <li class="menu-item-has-children dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true"
                       aria-expanded="false"> <i class="menu-icon fa fa-table"></i>岗位管理</a>
                    <ul class="sub-menu children dropdown-menu">
                        <li><i class="fa fa-id-badge"></i><a href="<%=basePath%>Jobs/addJob.jsp">增加岗位</a></li>
                        <li><i class="fa fa-bars"></i><a href="<%=basePath%>Jobs/modify.jsp">岗位信息</a></li>
                    </ul>
                </li>
                <li class="menu-item-has-children dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true"
                       aria-expanded="false"> <i class="menu-icon fa fa-user"></i>员工入职管理</a>
                    <ul class="sub-menu children dropdown-menu">
                        <li><i class="menu-icon fa fa-th"></i><a href="<%=basePath%>Entry/TalentPool.jsp">从人才库中入职</a>
                        </li>
                        <li><i class="menu-icon fa fa-book"></i><a href="<%=basePath%>Entry/addEmp.jsp">普通入职</a></li>
                    </ul>
                </li>
                <li class="menu-item-has-children dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true"
                       aria-expanded="false"> <i class="menu-icon fa fa-minus-circle"></i>员工离职管理</a>
                    <ul class="sub-menu children dropdown-menu">
                        <li><i class="menu-icon fa fa-th"></i><a href="<%=basePath%>Emps/deleteEmp.jsp">员工离职</a></li>
                        <li><i class="menu-icon fa fa-book"></i><a href="<%=basePath%>Emps/search.jsp">已离职员工信息查询</a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </nav>
</aside>
<!-- /#left-panel -->

<!-- Right Panel -->
<div id="right-panel" class="right-panel">
    <!-- Header-->
    <header id="header" class="header">
        <div class="top-left">
            <div class="navbar-header">
                <a class="navbar-brand" href=""><img src="<%=path%>/images/logo.png" alt="Logo"></a>
                <a class="navbar-brand hidden" href=""><img src="<%=path%>/images/logo2.png" alt="Logo"></a>
                <a id="menuToggle" class="menutoggle"><i class="fa fa-bars"></i></a>
            </div>
        </div>
        <div class="top-right">
            <div class="header-menu">
                <div class="header-left">
                    <button class="search-trigger"><i class="fa fa-search"></i></button>
                    <div class="form-inline">
                        <form class="search-form">
                            <input class="form-control mr-sm-2" type="text" placeholder="输入搜索内容"
                                   aria-label="Search">
                            <button class="search-close" type="submit"><i class="fa fa-close"></i></button>
                        </form>
                    </div>

                    <div class="dropdown for-notification">
                        <button class="btn btn-secondary dropdown-toggle" type="button" id="notification"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="fa fa-bell"></i>
                            <span class="count bg-danger">0</span>
                        </button>
                        <div class="dropdown-menu" aria-labelledby="notification">
                            <p class="red">You have 0 Notification</p>
                        </div>
                    </div>

                    <div class="dropdown for-message">
                        <button class="btn btn-secondary dropdown-toggle" type="button" id="message"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="fa fa-envelope"></i>
                            <span class="count bg-primary">0</span>
                        </button>
                        <div class="dropdown-menu" aria-labelledby="message">
                            <p class="red">You have 0 Mails</p>
                        </div>
                    </div>
                </div>

                <div class="user-area dropdown float-right">
                    <a href="#" class="dropdown-toggle active" data-toggle="dropdown" aria-haspopup="true"
                       aria-expanded="false">
                        <img class="user-avatar rounded-circle" src="<%=path%>/images/admin.jpg" alt="User Avatar">
                    </a>

                    <div class="user-menu dropdown-menu">
                        <a class="nav-link" href="#"><i class="fa fa- user"></i>我的信息</a>

                        <a class="nav-link" href="#"><i class="fa fa- user"></i>消息<span
                                class="count">0</span></a>

                        <a class="nav-link" href="#"><i class="fa fa -cog"></i>设置</a>

                        <a class="nav-link" href="#"><i class="fa fa-power -off"></i>退出登录</a>
                    </div>
                </div>

            </div>
        </div>
    </header>
    <!-- /#header -->
    <!-- Content -->
    <div class="content">
        <!-- Animated -->
        <div class="animated fadeIn">
            <div class="row">
                <c:if test="${not empty error }">
                    <div class="alert alert-primary" role="alert" style="margin-left: 40px">${error}</div>
                </c:if>
                <div class="col-lg-12">
                    <div class="card">
                        <div class="card-header">
                            <strong class="card-title">部门信息</strong>
                        </div>
                        <div class="card-body">
                            <table id="bootstrap-data-table" class="table table-striped table-bordered">
                                <thead>
                                <tr>
                                    <th scope="col">部门编号</th>
                                    <th scope="col">部门名称</th>
                                    <th scope="col">电话</th>
                                    <th scope="col">成立日期</th>
                                    <th scope="col">部门类型</th>
                                    <th scope="col">操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${list }" var="list">
                                    <tr>
                                        <td>${list.deptNo }</td>
                                        <td>${list.dName }</td>
                                        <td>${list.dTel }</td>
                                        <td>${list.dBirth }</td>
                                        <td>${list.dType }</td>
                                        <td>
                                            <button type="button" class="btn btn-primary"
                                                    onclick="deleteConfirm(${list.deptNo})"> 删除
                                            </button>
                                            <a href="<%=basePath%>UpdateController?deptNo=${list.deptNo }">
                                                <button type="button" class="btn btn-primary">修改</button>
                                                <a href="<%=basePath%>DeptShowEmp?deptNo=${list.deptNo}">
                                                    <button type="button" class="btn btn-primary">查询部门下员工</button>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>

                            </table>
                        </div>
                    </div>
                </div>

            </div>
        </div>
        <!-- .animated -->
    </div>
    <!-- .content -->
    <div class="clearfix"></div>
    <!-- Footer -->
    <footer class="site-footer">
        <div class="footer-inner bg-white">
            <div class="row">
                <div class="col-sm-6">
                    Copyright &copy; 2018 Ela Admin
                </div>
            </div>
        </div>
    </footer>
    <!-- /.site-footer -->
</div>
<!-- /#right-panel -->


<script type="text/javascript">
    function deleteConfirm(deptNo) {
        if (confirm("确定要删除吗") == true) {
            location.href = "<%=basePath%>" + "DeptDeleteController?deptNo=" + deptNo;
            return true;
        } else {
            return false;
        }
    }
</script>
<!-- Scripts -->
<script src="https://cdn.jsdelivr.net/npm/jquery@2.2.4/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.4/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery-match-height@0.7.2/dist/jquery.matchHeight.min.js"></script>
<script src="<%=basePath%>assets/js/main.js"></script>

<script src="<%=path%>/assets/js/lib/data-table/datatables.min.js"></script>
<script src="<%=path%>/assets/js/lib/data-table/dataTables.bootstrap.min.js"></script>
<script src="<%=path%>/assets/js/lib/data-table/dataTables.buttons.min.js"></script>
<script src="<%=path%>/assets/js/lib/data-table/buttons.bootstrap.min.js"></script>
<script src="<%=path%>/assets/js/lib/data-table/jszip.min.js"></script>
<script src="<%=path%>/assets/js/lib/data-table/vfs_fonts.js"></script>
<script src="<%=path%>/assets/js/lib/data-table/buttons.html5.min.js"></script>
<script src="<%=path%>/assets/js/lib/data-table/buttons.print.min.js"></script>
<script src="<%=path%>/assets/js/lib/data-table/buttons.colVis.min.js"></script>
<script src="<%=path%>/assets/js/init/datatables-init.js"></script>

<!--  Chart js -->
<script src="https://cdn.jsdelivr.net/npm/chart.js@2.7.3/dist/Chart.bundle.min.js"></script>

<!--Chartist Chart-->
<script src="https://cdn.jsdelivr.net/npm/chartist@0.11.0/dist/chartist.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chartist-plugin-legend@0.6.2/chartist-plugin-legend.min.js"></script>

<script src="https://cdn.jsdelivr.net/npm/jquery.flot@0.8.3/jquery.flot.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/flot-pie@1.0.0/src/jquery.flot.pie.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/flot-spline@0.0.1/js/jquery.flot.spline.min.js"></script>

<script src="https://cdn.jsdelivr.net/npm/simpleweather@3.1.0/jquery.simpleWeather.min.js"></script>
<script src="<%=basePath%>assets/js/init/weather-init.js"></script>

<script src="https://cdn.jsdelivr.net/npm/moment@2.22.2/moment.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/fullcalendar@3.9.0/dist/fullcalendar.min.js"></script>
<script src="<%=basePath%>/assets/js/init/fullcalendar-init.js"></script>

<script type="text/javascript">
    $(document).ready(function () {
        $('#bootstrap-data-table-export').DataTable();
    });
</script>

<!--Local Stuff-->
<script>
    jQuery(document).ready(function ($) {
        "use strict";

        // Pie chart flotPie1
        var piedata = [
            {label: "Desktop visits", data: [[1, 32]], color: '#5c6bc0'},
            {label: "Tab visits", data: [[1, 33]], color: '#ef5350'},
            {label: "Mobile visits", data: [[1, 35]], color: '#66bb6a'}
        ];

        $.plot('#flotPie1', piedata, {
            series: {
                pie: {
                    show: true,
                    radius: 1,
                    innerRadius: 0.65,
                    label: {
                        show: true,
                        radius: 2 / 3,
                        threshold: 1
                    },
                    stroke: {
                        width: 0
                    }
                }
            },
            grid: {
                hoverable: true,
                clickable: true
            }
        });
        // Pie chart flotPie1  End
        // cellPaiChart
        var cellPaiChart = [
            {label: "Direct Sell", data: [[1, 65]], color: '#5b83de'},
            {label: "Channel Sell", data: [[1, 35]], color: '#00bfa5'}
        ];
        $.plot('#cellPaiChart', cellPaiChart, {
            series: {
                pie: {
                    show: true,
                    stroke: {
                        width: 0
                    }
                }
            },
            legend: {
                show: false
            }, grid: {
                hoverable: true,
                clickable: true
            }

        });
        // cellPaiChart End
        // Line Chart  #flotLine5
        var newCust = [[0, 3], [1, 5], [2, 4], [3, 7], [4, 9], [5, 3], [6, 6], [7, 4], [8, 10]];

        var plot = $.plot($('#flotLine5'), [{
                data: newCust,
                label: 'New Data Flow',
                color: '#fff'
            }],
            {
                series: {
                    lines: {
                        show: true,
                        lineColor: '#fff',
                        lineWidth: 2
                    },
                    points: {
                        show: true,
                        fill: true,
                        fillColor: "#ffffff",
                        symbol: "circle",
                        radius: 3
                    },
                    shadowSize: 0
                },
                points: {
                    show: true,
                },
                legend: {
                    show: false
                },
                grid: {
                    show: false
                }
            });
        // Line Chart  #flotLine5 End
        // Traffic Chart using chartist
        if ($('#traffic-chart').length) {
            var chart = new Chartist.Line('#traffic-chart', {
                labels: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun'],
                series: [
                    [0, 18000, 35000, 25000, 22000, 0],
                    [0, 33000, 15000, 20000, 15000, 300],
                    [0, 15000, 28000, 15000, 30000, 5000]
                ]
            }, {
                low: 0,
                showArea: true,
                showLine: false,
                showPoint: false,
                fullWidth: true,
                axisX: {
                    showGrid: true
                }
            });

            chart.on('draw', function (data) {
                if (data.type === 'line' || data.type === 'area') {
                    data.element.animate({
                        d: {
                            begin: 2000 * data.index,
                            dur: 2000,
                            from: data.path.clone().scale(1, 0).translate(0, data.chartRect.height()).stringify(),
                            to: data.path.clone().stringify(),
                            easing: Chartist.Svg.Easing.easeOutQuint
                        }
                    });
                }
            });
        }
        // Traffic Chart using chartist End
        //Traffic chart chart-js
        if ($('#TrafficChart').length) {
            var ctx = document.getElementById("TrafficChart");
            ctx.height = 150;
            var myChart = new Chart(ctx, {
                type: 'line',
                data: {
                    labels: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul"],
                    datasets: [
                        {
                            label: "Visit",
                            borderColor: "rgba(4, 73, 203,.09)",
                            borderWidth: "1",
                            backgroundColor: "rgba(4, 73, 203,.5)",
                            data: [0, 2900, 5000, 3300, 6000, 3250, 0]
                        },
                        {
                            label: "Bounce",
                            borderColor: "rgba(245, 23, 66, 0.9)",
                            borderWidth: "1",
                            backgroundColor: "rgba(245, 23, 66,.5)",
                            pointHighlightStroke: "rgba(245, 23, 66,.5)",
                            data: [0, 4200, 4500, 1600, 4200, 1500, 4000]
                        },
                        {
                            label: "Targeted",
                            borderColor: "rgba(40, 169, 46, 0.9)",
                            borderWidth: "1",
                            backgroundColor: "rgba(40, 169, 46, .5)",
                            pointHighlightStroke: "rgba(40, 169, 46,.5)",
                            data: [1000, 5200, 3600, 2600, 4200, 5300, 0]
                        }
                    ]
                },
                options: {
                    responsive: true,
                    tooltips: {
                        mode: 'index',
                        intersect: false
                    },
                    hover: {
                        mode: 'nearest',
                        intersect: true
                    }

                }
            });
        }
        //Traffic chart chart-js  End
        // Bar Chart #flotBarChart
        $.plot("#flotBarChart", [{
            data: [[0, 18], [2, 8], [4, 5], [6, 13], [8, 5], [10, 7], [12, 4], [14, 6], [16, 15], [18, 9], [20, 17], [22, 7], [24, 4], [26, 9], [28, 11]],
            bars: {
                show: true,
                lineWidth: 0,
                fillColor: '#ffffff8a'
            }
        }], {
            grid: {
                show: false
            }
        });
        // Bar Chart #flotBarChart End
    });
</script>
</body>
</html>