<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page session="true" import="java.util.*, com.bit.java54th.softdrink.doore.dao.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>doore - Enjoy with your friends </title>

    <!-- Bootstrap core CSS -->
    <link href="../css/bootstrap.css" rel="stylesheet">

    <!-- Add custom CSS here -->
    <link href="../css/modern-business.css" rel="stylesheet">
    <link href="../font-awesome/css/font-awesome.min.css" rel="stylesheet">
</head>

<body>

    <nav class= "navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <!-- You'll want to use a responsive image option so this logo looks good on devices - I recommend using something like retina.js (do a quick Google search for it and you'll find it) -->
                <a class="navbar-brand" href="goTest.jsp">doore</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"> Village <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <c:forEach var="villageVO" items="${villageList}">
                            	<li><a href="<c:url value='/action/village?todo=view&amp;village_id=${villageVO.id}'/>"> ${villageVO.name} </a>
                            	</li>
                            </c:forEach>
                            
                            <hr>
                            <li><a href="#"> 마을 등록 </a>
                            </li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"> Product <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="#"> 공유중인 물품 </a>
                            </li>
                            <li><a href="#"> 공유신청 물품 </a>
                            </li>
                            <li><a href="#"> 공유가능 물품 </a>
                            </li>
                            <li><a href="#"> 소유 물품 </a>
                            </li>
                            <hr>
                            <li><a href="#"> 물품 등록 </a>
                            </li>
                        </ul>
                    </li>
                    <li><a href="https://trello.com/b/Qj8TcNJB/soft-drink">${customerVO.customerName} 님</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <div class="container">

        <div class="row">

            <div class="col-lg-12">
                <h1 class="page-header">${customerVO.customerName}
                    <small> Collect & Share </small>
                </h1>
                <ol class="breadcrumb">
                    <td>물품검색 drop down 창 영역
                    </td>
                    <td>물품검색 drop down 창 영역
                    </td>
                    
                </ol>
            </div>

        </div>
        <!-- /.row -->
		
		<!--   		
		<div class="row">
         -->
         
		<c:forEach var="productVO" items="${productList}">
            <div class="col-md-4 portfolio-item">
                <a href="portfolio-item.html">
                    <img class="img-responsive" src="./img/product/work1.jpg">
                </a>
                <h3><a href="portfolio-item.html">${productVO.product_name}</a>
                </h3>
                <p></p>
            </div>
        </c:forEach>
        <!-- 
        </div>    
         -->

        <hr>

        <div class="row text-center">

            <div class="col-lg-12">
                <ul class="pagination">
                    <li><a href="#">&laquo;</a>
                    </li>
                    <li class="active"><a href="#">1</a>
                    </li>
                    <li><a href="#">2</a>
                    </li>
                    <li><a href="#">3</a>
                    </li>
                    <li><a href="#">4</a>
                    </li>
                    <li><a href="#">5</a>
                    </li>
                    <li><a href="#">&raquo;</a>
                    </li>
                </ul>
            </div>

        </div>

    </div>
    <!-- /.container -->

    <div class="container">

        <hr>

        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p>Copyright &copy;  soft drink</p>
                </div>
            </div>
        </footer>

    </div>
    <!-- /.container -->

    <!-- JavaScript -->
    <script src="../js/jquery-1.10.2.js"></script>
    <script src="../js/bootstrap.js"></script>
    <script src="../js/modern-business.js"></script>

</body>

</html>
