<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>CopGO</title>
        <!-- Tell the browser to be responsive to screen width -->
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <!-- Bootstrap 3.3.6 -->
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
        <!-- Ionicons -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
        <!-- Theme style -->
        <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
        <!-- AdminLTE Skins. We have chosen the skin-blue for this starter
              page. However, you can choose any other skin. Make sure you
              apply the skin class to the body tag so the changes take effect.
        -->
        <link rel="stylesheet" href="dist/css/skins/skin-blue.min.css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
         <!-- Mapbox -->
        <script src='https://api.tiles.mapbox.com/mapbox-gl-js/v0.24.0/mapbox-gl.js'></script>
        <link rel='stylesheet' href='https://api.tiles.mapbox.com/mapbox-gl-js/v0.24.0/mapbox-gl.css' />
        <style>
            body { margin:0; padding:0; }
            #map { position:absolute; top:0; bottom:0; width:100%; }
        </style>
        
        <script src="js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
        <style>
            body { margin:0; padding:0; }
            #map { position:absolute; top:0; bottom:0; width:100%; }
        </style>
    </head>
    <!--
    BODY TAG OPTIONS:
    =================
    Apply one or more of the following classes to get the
    desired effect
    |---------------------------------------------------------|
    | SKINS         | skin-blue                               |
    |               | skin-black                              |
    |               | skin-purple                             |
    |               | skin-yellow                             |
    |               | skin-red                                |
    |               | skin-green                              |
    |---------------------------------------------------------|
    |LAYOUT OPTIONS | fixed                                   |
    |               | layout-boxed                            |
    |               | layout-top-nav                          |
    |               | sidebar-collapse                        |
    |               | sidebar-mini                            |
    |---------------------------------------------------------|
    -->
    <body class="hold-transition skin-blue sidebar-collapse">
        <div class="wrapper">

            <!-- Main Header -->
            <header class="main-header">

                <!-- Logo -->
                <a href="starter.html" class="logo">
                    <!-- mini logo for sidebar mini 50x50 pixels -->
                    <span class="logo-mini"><b>G</b>C</span>
                    <!-- logo for regular state and mobile devices -->
                    <span class="logo-lg"><b>Cop</b>GO</span>
                </a>

                <!-- Header Navbar -->
                <nav class="navbar navbar-static-top" role="navigation">
                    <!-- Sidebar toggle button-->
                    <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
                        <span class="sr-only">Toggle navigation</span>
                    </a>
                    <!-- Navbar Right Menu -->
                    <div class="navbar-custom-menu">
                        <ul class="nav navbar-nav">
                            <!-- Messages: style can be found in dropdown.less-->
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><b>Login</b> <span class="caret"></span></a>
                                <ul id="login-dp" class="dropdown-menu">
                                    <li>
                                        <div class="row">
                                            <div class="col-md-12">
                                                <form class="form" role="form" method="post" action="login" accept-charset="UTF-8" id="login-nav">
                                                    <div class="form-group">
                                                        <label class="sr-only" for="exampleInputEmail2">Email</label>
                                                        <input type="email" class="form-control" id="exampleInputEmail2" placeholder="Email address" required>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="sr-only" for="exampleInputPassword2">Senha</label>
                                                        <input type="password" class="form-control" id="exampleInputPassword2" placeholder="Password" required>
                                                        <div class="help-block text-right"><a href="">Esqueceu a senha ?</a></div>
                                                    </div>
                                                    <div class="form-group">
                                                        
                                                        <button type="submit" class="btn btn-primary btn-block">Entrar</button>
                                                        
                                                    </div>
                                                    <div class="checkbox">
                                                        <label>
                                                            <input type="checkbox"> Salvar login
                                                        </label>
                                                    </div>
                                                </form>
                                                Entrar pelo facebook
                                                <div class="social-buttons">
                                                    <a href="home.html" class="btn btn-fb"><i class="fa fa-facebook"></i> Facebook</a>
                                                </div>
                                                
                                                
                                            </div>
                                           
                                        </div>
                                    </li>
                                </ul>
                            </li>
                            <!-- Control Sidebar Toggle Button -->
                            
                        </ul>
                    </div>
                </nav>
            </header>
            <!-- Left side column. contains the logo and sidebar -->
            <aside class="main-sidebar">

                <!-- sidebar: style can be found in sidebar.less -->
                <section class="sidebar">

                    <!-- Sidebar user panel (optional) -->
                    <!-- <div class="user-panel">
                      <div class="pull-left image">
                        <img src="dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
                      </div>
                      <div class="pull-left info">
                        <p>Alexander Pierce</p>
                    <!-- Status -->
                    <!--  <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
                    </div>
                   </div>-->

                    <!-- search form (Optional) 
                    <form action="#" method="get" class="sidebar-form">
                      <div class="input-group">
                        <input type="text" name="q" class="form-control" placeholder="Search...">
                            <span class="input-group-btn">
                              <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                              </button>
                            </span>
                      </div>
                    </form>
                     /.search form -->

                    <!-- Sidebar Menu -->
                    <ul class="sidebar-menu">
                        <div class="register-box">

                            <div class="register-box-body-index" style=" width: 280px;" >
                                <p class="login-box-msg">Registrar novo usuário</p>
                            <form id="contact-form" class="contact" name="contact-form" method="post" action="UsuarioSV">
                            <input type="hidden" name="action" value="salvar" />
                            <input type="hidden" name="id" value="${objUsuario.id}" />
                                 <!--<form action="../../index.html" method="post">
                                    <a href="../../Gruntfile.js"></a> -->
                                    <div class="form-group has-feedback">
                                        <input type="text" name="nome" class="form-control" required="required" placeholder="Nome completo" value="${objUsuario.nome}">
                                        <span class="glyphicon glyphicon-user form-control-feedback"></span>
                                    </div>
                                    <div class="form-group has-feedback">
                                        <input type="email" name="email" class="form-control" required="required" placeholder="Email" value="${objUsuario.email}">
                                        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
                                    </div>
                                    <div class="form-group has-feedback">
                                        <input type="password" name="senha" class="form-control" required="required" placeholder="Senha" value="${objUsuario.senha}">
                                        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                                    </div>
                                    <div class="form-group has-feedback">
                                        <input type="password" name="senha" class="form-control" required="required" placeholder="Confirmar senha" value="${objUsuario.senha}">
                                        <span class="glyphicon glyphicon-log-in form-control-feedback"></span>
                                    </div>

                                    <a>
                                        <button type="submit" name="btnSalvar" value="salvar" class="btn btn-primary">Enviar</button>
                                        <button type="button" class="btn btn-primary btn-social btn-facebook "><span class="fa fa-facebook"></span>Cadastro com facebook</button>
                                    </a>

                                </form>
                            </div>
                            <!-- /.form-box -->
                        </div>
                        <!-- /.register-box -->

                        <!--<li class="treeview">
                          <a href="#"><i class="fa fa-link"></i> <span>Multilevel</span>
                            <span class="pull-right-container">
                              <i class="fa fa-angle-left pull-right"></i>
                            </span>
                          </a>
                          <ul class="treeview-menu">
                            <li><a href="#">Link in level 2</a></li>
                            <li><a href="#">Link in level 2</a></li>
                          </ul>
                        </li>
                      </ul>
                        <!-- /.sidebar-menu -->
                </section>
                <!-- /.sidebar -->
            </aside>

            <!-- Content Wrapper. Contains page content -->
            <div class="content-wrapper">
                <!-- Content Header (Page header) -->
                <section class="content-header">

                    <h1>
                        Page Header
                        <small>Optional description</small>
                    </h1>
                    <!-- <ol class="breadcrumb">
                      <li><a href="#"><i class="fa fa-dashboard"></i> Level</a></li>
                      <li class="active">Here</li>
                    </ol>-->
                </section>

                <!-- Main content -->


                <!-- Your Page Content Here -->

                </section>
                <!-- /.content -->
            </div>
            <!-- /.content-wrapper -->


            <!-- Main Footer -->
            <footer class="main-footer" center>
                <!-- To the right -->
                
                <!-- Default to the left -->
                <strong>CopGO &copy; 2016 <a href="#">Company</a>.</strong> All rights reserved.
            </footer>

            <!-- Control Sidebar -->
            
        </div>
        <!-- ./wrapper -->
    <div id='map' class='map'></div>
    <script>
        
        mapboxgl.accessToken = 'pk.eyJ1IjoidGh5cm9uaXVzIiwiYSI6ImNpdGhjdGltdTAxN3MyeW52YWgwcDg2anoifQ.0qN-ov63vzY5fDAHe0tpzw';
        var map = new mapboxgl.Map({
            container: 'map', // container id
            style: 'mapbox://styles/mapbox/streets-v9', //stylesheet location
            center: [-48.933177, -16.297057], // starting position
            zoom: 13 // starting zoom
            
        });
        
    </script>
    var myLayer = L.mapbox.featureLayer().setGeoJSON(geojson).addTo(map);
    myLayer.setGeoJSON(geojson);

    <script>window.jQuery || document.write('<script src="js/vendor/jquery-1.11.2.js"><\/script>')</script>

        <script src="js/vendor/bootstrap.min.js"></script>

        <script src="js/main.js"></script>
        <!-- REQUIRED JS SCRIPTS -->

        <!-- jQuery 2.2.3 -->
        <script src="plugins/jQuery/jquery-2.2.3.min.js"></script>
        <!-- Bootstrap 3.3.6 -->
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <!-- AdminLTE App -->
        <script src="dist/js/app.min.js"></script>

        <!-- Optionally, you can add Slimscroll and FastClick plugins.
             Both of these plugins are recommended to enhance the
             user experience. Slimscroll is required when using the
             fixed layout. -->
    </body>
</html>
