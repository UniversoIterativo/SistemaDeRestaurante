<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Modern Business - Start Bootstrap Template</title>

  	<!-- Bootstrap Core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<c:url value="/resources/css/modern-business.css"/>" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="<c:url value="/resources/font-awesome/css/font-awesome.min.css"/>" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
        <!-- jQuery -->
    <script src="resources/js/jquery.js"></script>
    <script src="resources/angularjs/angular.js"></script>
    <script src="resources/angularjs/angular-sanitize.js"></script>
    <script src="resources/angularjs/app.js"></script>

</head>

<body>
    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">Start Bootstrap</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="about.html">About</a>
                    </li>
                    <li>
                        <a href="services.html">Services</a>
                    </li>
                    <li class="active">
                        <a href="contact.html">Contact</a>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Portfolio <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="portfolio-1-col.html">1 Column Portfolio</a>
                            </li>
                            <li>
                                <a href="portfolio-2-col.html">2 Column Portfolio</a>
                            </li>
                            <li>
                                <a href="portfolio-3-col.html">3 Column Portfolio</a>
                            </li>
                            <li>
                                <a href="portfolio-4-col.html">4 Column Portfolio</a>
                            </li>
                            <li>
                                <a href="portfolio-item.html">Single Portfolio Item</a>
                            </li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Blog <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="blog-home-1.html">Blog Home 1</a>
                            </li>
                            <li>
                                <a href="blog-home-2.html">Blog Home 2</a>
                            </li>
                            <li>
                                <a href="blog-post.html">Blog Post</a>
                            </li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Other Pages <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="full-width.html">Full Width Page</a>
                            </li>
                            <li>
                                <a href="sidebar.html">Sidebar Page</a>
                            </li>
                            <li>
                                <a href="faq.html">FAQ</a>
                            </li>
                            <li>
                                <a href="404.html">404</a>
                            </li>
                            <li>
                                <a href="pricing.html">Pricing Table</a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <!-- Page Content -->
    <div class="container">
        <!-- Page Heading/Breadcrumbs -->
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Contact
                    <small>Subheading</small>
                </h1>
                <ol class="breadcrumb">
                    <li><a href="index.html">Home</a>
                    </li>
                    <li class="active">Contact</li>
                </ol>
            </div>
        </div>
        <!-- /.row -->

        <!-- Content Row -->
        <div class="row">
                    <!-- Contact Form -->
			        <!-- In order to set the email address and subject line for the contact form go to the bin/contact_me.php file. -->
			            <form action="transferir" method="post">
			            <div class="col-md-4">
			            	<h4>Conta de Origem</h4>
			                    <div class="control-group form-group">
			                        <div class="controls">
			                            <label>Ag�ncia:</label>
			                            <input name="origemAgencia" type="text" class="form-control" id="name" required data-validation-required-message="Please enter your name.">
			                            <p class="help-block"></p>
			                        </div>
			                    </div>
			                    <div class="control-group form-group">
			                        <div class="controls">
			                            <label>Conta:</label>
			                            <input name="origemNumero" type="tel" class="form-control" id="phone" required data-validation-required-message="Please enter your phone number.">
			                        </div>
			                    </div>
			                    <div class="control-group form-group">
			                        <div class="controls">
			                            <label>CPF:</label>
			                            <input name="origemCPF" type="text" class="form-control" id="email" required data-validation-required-message="Please enter your email address.">
			                        </div>
			                    </div>
			                   
			            </div>
			            <div class="col-md-4">
			            <h4>Conta de Destino</h4>
			                    <div class="control-group form-group">
			                        <div class="controls">
			                            <label>Ag�ncia:</label>
			                            <input name="destinoAgencia" type="text" class="form-control" id="name" required data-validation-required-message="Please enter your name.">
			                            <p class="help-block"></p>
			                        </div>
			                    </div>
			                    <div class="control-group form-group">
			                        <div class="controls">
			                            <label>Conta:</label>
			                            <input name="destinoNumero" type="tel" class="form-control" id="phone" required data-validation-required-message="Please enter your phone number.">
			                        </div>
			                    </div>
			                    <div class="control-group form-group">
			                        <div class="controls">
			                            <label>Valor R$:</label>
			                            <input name="valor" type="text" class="form-control" id="email" required data-validation-required-message="Please enter your email address.">
			                        </div>
			                    </div>
			                   
			                    <div id="success"></div>
			                    <!-- For success/fail messages -->
			                    <button type="submit" class="btn btn-primary">Send Message</button>
			                
			            </div>
						</form>
			            <!-- Contact Details Column -->
			            <div class="col-md-4">
			                <h3>Contact Details</h3>
			                <p>
			                    3481 Melrose Place<br>Beverly Hills, CA 90210<br>
			                </p>
			                <p><i class="fa fa-phone"></i> 
			                    <abbr title="Phone">P</abbr>: (123) 456-7890</p>
			                <p><i class="fa fa-envelope-o"></i> 
			                    <abbr title="Email">E</abbr>: <a href="mailto:name@example.com">name@example.com</a>
			                </p>
			                <p><i class="fa fa-clock-o"></i> 
			                    <abbr title="Hours">H</abbr>: Monday - Friday: 9:00 AM to 5:00 PM</p>
			                <ul class="list-unstyled list-inline list-social-icons">
			                    <li>
			                        <a href="#"><i class="fa fa-facebook-square fa-2x"></i></a>
			                    </li>
			                    <li>
			                        <a href="#"><i class="fa fa-linkedin-square fa-2x"></i></a>
			                    </li>
			                    <li>
			                        <a href="#"><i class="fa fa-twitter-square fa-2x"></i></a>
			                    </li>
			                    <li>
			                        <a href="#"><i class="fa fa-google-plus-square fa-2x"></i></a>
			                    </li>
			                </ul>
			            </div>
			        </div>
			        <!-- /.row -->

        <hr>

        <!-- Footer -->
        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p>Copyright &copy; Your Website 2014</p>
                </div>
            </div>
        </footer>

    </div>
    <!-- /.container -->



    <!-- Bootstrap Core JavaScript -->
    <script src="resources/js/bootstrap.min.js"></script>

    <!-- Contact Form JavaScript -->
    <!-- Do not edit these files! In order to set the email address and subject line for the contact form go to the bin/contact_me.php file. -->
    <script src="resources/js/jqBootstrapValidation.js"></script>
    <script src="resources/js/contact_me.js"></script>

</body>

</html>
