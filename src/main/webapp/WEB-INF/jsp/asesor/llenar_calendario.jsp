<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>V-Tesis!</title>

    <%@include file = "/WEB-INF/jsp/comun/recursos.jsp" %>
    <script src="<c:url value="/js/nprogress.js"/>"></script>
    <script>
        NProgress.start();
    </script>

    <!-- Custom styling plus plugins -->
    <link href="<c:url value="/css/custom.css"/>" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/maps/jquery-jvectormap-2.0.1.css"/>" />
    <link href="<c:url value="/css/icheck/flat/green.css"/>" rel="stylesheet" />
    <link href="<c:url value="/css/floatexamples.css"/>" rel="stylesheet" type="text/css" />

</head>


<body class="nav-md">

    <div class="container body">


        <div class="main_container">

            <div class="col-md-3 left_col">
                <div class="left_col scroll-view">

                    <div class="navbar nav_title" style="border: 0;">
                        <a href="<c:url value="/home.do"/>" class="site_title"><i class="fa fa-paw"></i> <span>V-Tesis</span></a>
                    </div>
                    <div class="clearfix"></div>

                    <!-- menu prile quick info -->
                    <div class="profile">
                        <div class="profile_pic">
                            <img src="<c:url value="/images/vtesis-logo.jpg"/>" alt="..." class="img-circle profile_img">
                        </div>
                        <div class="profile_info">
                            <span>Welcome,</span>
                            <h2>${persona.nombres} ${persona.apellidos}</h2>
                        </div>
                    </div>
                    <!-- /menu prile quick info -->

                    <br />

                    <!-- sidebar menu -->
                    <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">

                        <div class="menu_section">
                            <h3>General</h3>
                            <ul class="nav side-menu">
                                <li><a><i class="fa fa-home"></i> Home <span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu" style="display: none">
                                        <li><a href="<c:url value="/home.do"/>">Perfil</a>
                                        </li>
                                        
                                    </ul>
                                </li>
                                <li><a><i class="fa fa-calendar"></i> Acciones <span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu" style="display: none">
                                        <li><a href="<c:url value= "/asesor/llenarFechas"/>">Llenar calendario</a>
                                        </li>
                                        
                                    </ul>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <!-- /sidebar menu -->

                    <!-- /menu footer buttons -->
                    <div class="sidebar-footer hidden-small">
                        <a data-toggle="tooltip" data-placement="top" title="Logout" href="<c:url value="/logout.do"/>">
                            <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
                        </a>
                    </div>
                    <!-- /menu footer buttons -->
                </div>
            </div>

            <!-- top navigation -->
            <div class="top_nav">

                <div class="nav_menu">
                    <nav class="" role="navigation">
                        <div class="nav toggle">
                            <a id="menu_toggle"><i class="fa fa-bars"></i></a>
                        </div>

                        <ul class="nav navbar-nav navbar-right">
                            <li class="">
                                <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                                    <img src="<c:url value="/images/img.jpg"/>" alt="">${persona.nombres} ${persona.apellidos}
                                    <span class=" fa fa-angle-down"></span>
                                </a>
                                <ul class="dropdown-menu dropdown-usermenu animated fadeInDown pull-right">
                                    <li><a href="javascript:;">  Profile</a>
                                    </li>
                                    <!--<li>
                                        <a href="javascript:;">
                                            <span class="badge bg-red pull-right">50%</span>
                                            <span>Settings</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="javascript:;">Help</a>
                                    </li> -->
                                    <li><a href="<c:url value="/logout.do"/>"><i class="fa fa-sign-out pull-right"></i> Log Out</a>
                                    </li>
                                </ul>
                            </li>

                        <!-- :v -->    

                        </ul>
                    </nav>
                </div>

            </div>
            <!-- /top navigation -->


            <!-- page content -->
            <div class="right_col" role="main">

                <!-- top tiles -->
                
                <!-- /top tiles -->

                
                <br />

               


                <div class="row">
                   


                    <div class="col-md-20 col-sm-20 col-xs-24">



                        <div class="row">

                            <div class="col-md-30 col-sm-30 col-xs-30">
                                <div class="x_panel">
                                    <div class="x_title">
                                        <h2>Calendario de presentacion de avances 2015-2 <small></small></h2>
                                        <div class="col-md-md-4 col-sm-4 col-xs-7">
                                            <a href="javascript:history.back()">
                                            <button type="submit" class="btn btn-primary">Regresar</button>
                                            </a>
                                        </div>
                                                                                
                                       <div class="clearfix"></div>
                                    </div>
                                    <div>
                                        <table class="table table-striped responsive-utilities jambo_table bulk_action" style="text-align:center">
                                                      <thead>
                                                          <tr class = "headings">
                                                              <th class="column-title"> Entregables</th>
                                                               <th class="column-title"> Fecha Limite</th>
                                                               <th class="column-title"> Seleccionar</th>
                                                              <a class="antoo" style="color:#fff;font-weight:500">... </a>
                                                          </tr>
                                            </thead>
                                            <tbody>
                                                <tr class="even pointer">
                                                    <td class="">Nuevo Estudio</td>
                                                    <td id="reportrange" class="pull-right" style="background:#ffff;cursor:pointer;padding: 5px 10px; border:1px solid #ccc">
                                                    <i class="glyphicon glyphicon-calendar fa fa-calendar"></i>
                                                    <span>August 26, 2015 - September 24, 2015</span>
                                                    <b class="caret"></b></td>
                                                    <td>
                                                        <li>
                                                    <p>
                                                        <input type="checkbox" class="flat">  </p>
                                                </li>
                                                    </td>
                                                </tr>
                                                 <tr class="even pointer">
                                                    <td class="">Entregable 1</td>
                                                    <td id="reportrange" class="pull-right" style="background:#ffff;cursor:pointer;padding: 5px 10px; border:1px solid #ccc">
                                                    <i class="glyphicon glyphicon-calendar fa fa-calendar"></i>
                                                    <span>August 26, 2015 - September 24, 2015</span>
                                                    <b class="caret"></b></td>
                                                    <td>
                                                        <li>
                                                    <p>
                                                        <input type="checkbox" class="flat">  </p>
                                                </li>
                                                    </td>
                                                </tr>
                                                 <tr class="even pointer">
                                                    <td class="">Entregable 2</td>
                                                    <td id="reportrange" class="pull-right" style="background:#ffff;cursor:pointer;padding: 5px 10px; border:1px solid #ccc">
                                                    <i class="glyphicon glyphicon-calendar fa fa-calendar"></i>
                                                    <span>August 26, 2015 - September 24, 2015</span>
                                                    <b class="caret"></b></td>
                                                    <td>
                                                        <li>
                                                    <p>
                                                        <input type="checkbox" class="flat">  </p>
                                                </li>
                                                    </td>
                                                </tr>
                                                 <tr class="even pointer">
                                                    <td class="">Entregable 3</td>
                                                    <td id="reportrange" class="pull-right" style="background:#ffff;cursor:pointer;padding: 5px 10px; border:1px solid #ccc">
                                                    <i class="glyphicon glyphicon-calendar fa fa-calendar"></i>
                                                    <span>August 26, 2015 - September 24, 2015</span>
                                                    <b class="caret"></b></td>
                                                    <td>
                                                        <li>
                                                    <p>
                                                        <input type="checkbox" class="flat">  </p>
                                                </li>
                                                    </td>
                                                </tr>
                                                 <tr class="even pointer">
                                                    <td class="">Entregable 4</td>
                                                    <td id="reportrange" class="pull-right" style="background:#ffff;cursor:pointer;padding: 5px 10px; border:1px solid #ccc">
                                                    <i class="glyphicon glyphicon-calendar fa fa-calendar"></i>
                                                    <span>August 26, 2015 - September 24, 2015</span>
                                                    <b class="caret"></b></td>
                                                    <td>
                                                        <li>
                                                    <p>
                                                        <input type="checkbox" class="flat">  </p>
                                                </li>
                                                    </td>
                                                </tr>
                                                 <tr class="even pointer">
                                                    <td class="">Entregable 5</td>
                                                    <td id="reportrange" class="pull-right" style="background:#ffff;cursor:pointer;padding: 5px 10px; border:1px solid #ccc">
                                                    <i class="glyphicon glyphicon-calendar fa fa-calendar"></i>
                                                    <span>August 26, 2015 - September 24, 2015</span>
                                                    <b class="caret"></b></td>
                                                    <td>
                                                        <li>
                                                    <p>
                                                        <input type="checkbox" class="flat">  </p>
                                                </li>
                                                    </td>
                                                </tr>
                                                 <tr class="even pointer">
                                                    <td class="">Entregable 6</td>
                                                    <td id="reportrange" class="pull-right" style="background:#ffff;cursor:pointer;padding: 5px 10px; border:1px solid #ccc">
                                                    <i class="glyphicon glyphicon-calendar fa fa-calendar"></i>
                                                    <span>August 26, 2015 - September 24, 2015</span>
                                                    <b class="caret"></b></td>
                                                    <td>
                                                        <li>
                                                    <p>
                                                        <input type="checkbox" class="flat">  </p>
                                                </li>
                                                    </td>
                                                </tr>
                                                 <tr class="even pointer">
                                                    <td class="">Entregable 7</td>
                                                    <td id="reportrange" class="pull-right" style="background:#ffff;cursor:pointer;padding: 5px 10px; border:1px solid #ccc">
                                                    <i class="glyphicon glyphicon-calendar fa fa-calendar"></i>
                                                    <span>August 26, 2015 - September 24, 2015</span>
                                                    <b class="caret"></b></td>
                                                    <td>
                                                        <li>
                                                    <p>
                                                        <input type="checkbox" class="flat">  </p>
                                                </li>
                                                    </td>
                                                </tr>
                                                
                                            
                                            </tbody>
                                            </table>
                                    </div>
                                    
                                </div>
                            </div>

                        </div>
                        <div class="row">
                            <div class="col-md-md-20 col-sm-20 col-xs-23">
                                <button type="button" class="btn btn-primary">Nueva Entrega</button>
                                       
                            
                                            <button type="submit" class="btn btn-primary">Editar</button>
                                        
                            
                                            <button type="reset" class="btn btn-primary">Borrar Seleccionados</button>
                                        </div>


                            <!-- Start to do list -->
                           
                                </div>
                            </div>
                            <!-- End to do list -->


                           
                        </div>









                    </div>

                </div>

                <!-- footer content -->

                <footer>
                    <div class="">
                        <p class="pull-right">Gentelella Alela! a Bootstrap 3 template by <a>Kimlabs</a>. |
                            <span class="lead"> <i class="fa fa-paw"></i> Gentelella Alela!</span>
                        </p>
                    </div>
                    <div class="clearfix"></div>
                </footer>
                <!-- /footer content -->
            </div>
            <!-- /page content -->

        </div>

    </div>

    <div id="custom_notifications" class="custom-notifications dsp_none">
        <ul class="list-unstyled notifications clearfix" data-tabbed_notifications="notif-group">
        </ul>
        <div class="clearfix"></div>
        <div id="notif-group" class="tabbed_notifications"></div>
    </div>

    <script src="<c:url value="/js/bootstrap.min.js"/>"></script>

    <!-- gauge js -->
    <script type="text/javascript" src="<c:url value="/js/gauge/gauge.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/gauge/gauge_demo.js"/>"></script>
    <!-- chart js -->
    <script src="<c:url value="/js/chartjs/chart.min.js"/>"></script>
    <!-- bootstrap progress js -->
    <script src="<c:url value="/js/progressbar/bootstrap-progressbar.min.js"/>"></script>
    <script src="<c:url value="/js/nicescroll/jquery.nicescroll.min.js"/>"></script>
    <!-- icheck -->
    <script src="<c:url value="/js/icheck/icheck.min.js"/>"></script>
    <!-- daterangepicker -->
    <script type="text/javascript" src="<c:url value="/js/moment.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/datepicker/daterangepicker.js"/>"></script>

    <script src="<c:url value="/js/custom.js"/>"></script>

    <!-- flot js -->
    <!--[if lte IE 8]><script type="text/javascript" src="js/excanvas.min.js"></script><![endif]-->
    <script type="text/javascript" src="<c:url value="/js/flot/jquery.flot.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/flot/jquery.flot.pie.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/flot/jquery.flot.orderBars.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/flot/jquery.flot.time.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/flot/date.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/flot/jquery.flot.spline.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/flot/jquery.flot.stack.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/flot/curvedLines.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/flot/jquery.flot.resize.js"/>"></script>
    <script>
        $(document).ready(function () {
            // [17, 74, 6, 39, 20, 85, 7]
            //[82, 23, 66, 9, 99, 6, 2]
            var data1 = [[gd(2012, 1, 1), 17], [gd(2012, 1, 2), 74], [gd(2012, 1, 3), 6], [gd(2012, 1, 4), 39], [gd(2012, 1, 5), 20], [gd(2012, 1, 6), 85], [gd(2012, 1, 7), 7]];

            var data2 = [[gd(2012, 1, 1), 82], [gd(2012, 1, 2), 23], [gd(2012, 1, 3), 66], [gd(2012, 1, 4), 9], [gd(2012, 1, 5), 119], [gd(2012, 1, 6), 6], [gd(2012, 1, 7), 9]];
            $("#canvas_dahs").length && $.plot($("#canvas_dahs"), [
                data1, data2
            ], {
                series: {
                    lines: {
                        show: false,
                        fill: true
                    },
                    splines: {
                        show: true,
                        tension: 0.4,
                        lineWidth: 1,
                        fill: 0.4
                    },
                    points: {
                        radius: 0,
                        show: true
                    },
                    shadowSize: 2
                },
                grid: {
                    verticalLines: true,
                    hoverable: true,
                    clickable: true,
                    tickColor: "#d5d5d5",
                    borderWidth: 1,
                    color: '#fff'
                },
                colors: ["rgba(38, 185, 154, 0.38)", "rgba(3, 88, 106, 0.38)"],
                xaxis: {
                    tickColor: "rgba(51, 51, 51, 0.06)",
                    mode: "time",
                    tickSize: [1, "day"],
                    //tickLength: 10,
                    axisLabel: "Date",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 10
                        //mode: "time", timeformat: "%m/%d/%y", minTickSize: [1, "day"]
                },
                yaxis: {
                    ticks: 8,
                    tickColor: "rgba(51, 51, 51, 0.06)",
                },
                tooltip: false
            });

            function gd(year, month, day) {
                return new Date(year, month - 1, day).getTime();
            }
        });
    </script>

    <!-- worldmap -->
    <script type="text/javascript" src="<c:url value="/js/maps/jquery-jvectormap-2.0.1.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/maps/gdp-data.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/maps/jquery-jvectormap-world-mill-en.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/maps/jquery-jvectormap-us-aea-en.js"/>"></script>
    <script>
        $(function () {
            $('#world-map-gdp').vectorMap({
                map: 'world_mill_en',
                backgroundColor: 'transparent',
                zoomOnScroll: false,
                series: {
                    regions: [{
                        values: gdpData,
                        scale: ['#E6F2F0', '#149B7E'],
                        normalizeFunction: 'polynomial'
                    }]
                },
                onRegionTipShow: function (e, el, code) {
                    el.html(el.html() + ' (GDP - ' + gdpData[code] + ')');
                }
            });
        });
    </script>
    <!-- skycons -->
    <script src="<c:url value="/js/skycons/skycons."/>"></script>
    <script>
        var icons = new Skycons({
                "color": "#73879C"
            }),
            list = [
                "clear-day", "clear-night", "partly-cloudy-day",
                "partly-cloudy-night", "cloudy", "rain", "sleet", "snow", "wind",
                "fog"
            ],
            i;

        for (i = list.length; i--;)
            icons.set(list[i], list[i]);

        icons.play();
    </script>

    <!-- dashbord linegraph -->
    <script>
        var doughnutData = [
            {
                value: 30,
                color: "#455C73"
            },
            {
                value: 30,
                color: "#9B59B6"
            },
            {
                value: 60,
                color: "#BDC3C7"
            },
            {
                value: 100,
                color: "#26B99A"
            },
            {
                value: 120,
                color: "#3498DB"
            }
    ];
        var myDoughnut = new Chart(document.getElementById("canvas1").getContext("2d")).Doughnut(doughnutData);
    </script>
    <!-- /dashbord linegraph -->
    <!-- datepicker -->
    <script type="text/javascript">
        $(document).ready(function () {

            var cb = function (start, end, label) {
                console.log(start.toISOString(), end.toISOString(), label);
                $('#reportrange span').html(start.format('MMMM D, YYYY') + ' - ' + end.format('MMMM D, YYYY'));
                //alert("Callback has fired: [" + start.format('MMMM D, YYYY') + " to " + end.format('MMMM D, YYYY') + ", label = " + label + "]");
            }

            var optionSet1 = {
                startDate: moment().subtract(29, 'days'),
                endDate: moment(),
                minDate: '01/01/2012',
                maxDate: '12/31/2015',
                dateLimit: {
                    days: 60
                },
                showDropdowns: true,
                showWeekNumbers: true,
                timePicker: false,
                timePickerIncrement: 1,
                timePicker12Hour: true,
                ranges: {
                    'Today': [moment(), moment()],
                    'Yesterday': [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
                    'Last 7 Days': [moment().subtract(6, 'days'), moment()],
                    'Last 30 Days': [moment().subtract(29, 'days'), moment()],
                    'This Month': [moment().startOf('month'), moment().endOf('month')],
                    'Last Month': [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
                },
                opens: 'left',
                buttonClasses: ['btn btn-default'],
                applyClass: 'btn-small btn-primary',
                cancelClass: 'btn-small',
                format: 'MM/DD/YYYY',
                separator: ' to ',
                locale: {
                    applyLabel: 'Submit',
                    cancelLabel: 'Clear',
                    fromLabel: 'From',
                    toLabel: 'To',
                    customRangeLabel: 'Custom',
                    daysOfWeek: ['Su', 'Mo', 'Tu', 'We', 'Th', 'Fr', 'Sa'],
                    monthNames: ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'],
                    firstDay: 1
                }
            };
            $('#reportrange span').html(moment().subtract(29, 'days').format('MMMM D, YYYY') + ' - ' + moment().format('MMMM D, YYYY'));
            $('#reportrange').daterangepicker(optionSet1, cb);
            $('#reportrange').on('show.daterangepicker', function () {
                console.log("show event fired");
            });
            $('#reportrange').on('hide.daterangepicker', function () {
                console.log("hide event fired");
            });
            $('#reportrange').on('apply.daterangepicker', function (ev, picker) {
                console.log("apply event fired, start/end dates are " + picker.startDate.format('MMMM D, YYYY') + " to " + picker.endDate.format('MMMM D, YYYY'));
            });
            $('#reportrange').on('cancel.daterangepicker', function (ev, picker) {
                console.log("cancel event fired");
            });
            $('#options1').click(function () {
                $('#reportrange').data('daterangepicker').setOptions(optionSet1, cb);
            });
            $('#options2').click(function () {
                $('#reportrange').data('daterangepicker').setOptions(optionSet2, cb);
            });
            $('#destroy').click(function () {
                $('#reportrange').data('daterangepicker').remove();
            });
        });
    </script>
    <!-- /datepicker -->
    <script type="text/javascript">
        $(document).ready(function () {
            $('#single_cal1').daterangepicker({
                singleDatePicker: true,
                calender_style: "picker_1"
            }, function (start, end, label) {
                console.log(start.toISOString(), end.toISOString(), label);
            });
            $('#single_cal2').daterangepicker({
                singleDatePicker: true,
                calender_style: "picker_2"
            }, function (start, end, label) {
                console.log(start.toISOString(), end.toISOString(), label);
            });
            $('#single_cal3').daterangepicker({
                singleDatePicker: true,
                calender_style: "picker_3"
            }, function (start, end, label) {
                console.log(start.toISOString(), end.toISOString(), label);
            });
            $('#single_cal4').daterangepicker({
                singleDatePicker: true,
                calender_style: "picker_4"
            }, function (start, end, label) {
                console.log(start.toISOString(), end.toISOString(), label);
            });
        });
    </script>
    <script type="text/javascript">
        $(document).ready(function () {
            $('#reservation').daterangepicker(null, function (start, end, label) {
                console.log(start.toISOString(), end.toISOString(), label);
            });
        });
    </script>
    <!-- /datepicker -->
    <!-- input_mask -->
    <script>
        $(document).ready(function () {
            $(":input").inputmask();
        });
    </script>
    <!-- /input mask -->
    <!-- ion_range -->
    <script>
        $(function () {
            $("#range_27").ionRangeSlider({
                type: "double",
                min: 1000000,
                max: 2000000,
                grid: true,
                force_edges: true
            });
            $("#range").ionRangeSlider({
                hide_min_max: true,
                keyboard: true,
                min: 0,
                max: 5000,
                from: 1000,
                to: 4000,
                type: 'double',
                step: 1,
                prefix: "$",
                grid: true
            });
            $("#range_25").ionRangeSlider({
                type: "double",
                min: 1000000,
                max: 2000000,
                grid: true
            });
            $("#range_26").ionRangeSlider({
                type: "double",
                min: 0,
                max: 10000,
                step: 500,
                grid: true,
                grid_snap: true
            });
            $("#range_31").ionRangeSlider({
                type: "double",
                min: 0,
                max: 100,
                from: 30,
                to: 70,
                from_fixed: true
            });
            $(".range_min_max").ionRangeSlider({
                type: "double",
                min: 0,
                max: 100,
                from: 30,
                to: 70,
                max_interval: 50
            });
            $(".range_time24").ionRangeSlider({
                min: +moment().subtract(12, "hours").format("X"),
                max: +moment().format("X"),
                from: +moment().subtract(6, "hours").format("X"),
                grid: true,
                force_edges: true,
                prettify: function (num) {
                    var m = moment(num, "X");
                    return m.format("Do MMMM, HH:mm");
                }
            });
        });
    </script>
    <script>
        NProgress.done();
    </script>
    <!-- /datepicker -->
    <!-- /footer content -->
</body>

</html>
