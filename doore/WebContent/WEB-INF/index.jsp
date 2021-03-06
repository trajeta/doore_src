<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page session="true" import="java.util.*"%>
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
    <link href="../css/bootstrap.css" rel="stylesheet" type="text/css"/>

    <!-- Add custom CSS here -->
    <link href="../css/modern-business.css" rel="stylesheet" type="text/css"/>
    <link href="../font-awesome/css/font-awesome.min.css" rel="stylesheet">
</head>

<body>
    
    
    	<!-- MAIN IMAGE SECTION -->
	<div id="headerwrap">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2">
					<h1>doore</h1>
					<h2>'두레'에서 지인들과 나눔의 기쁨을 느껴보세요.</h2>
				</div>
            </div><!-- row -->
            
            <div class="col-sm-3 col-sm-offset-4">
                <form name="login" class="form-signin" action="<c:url value='/action/login'/>" method="post">
                <label class="checkbox pull-left">
                <input type="checkbox" value="remember-me"><i>Remember me</i>
                </label>
                <input type="text" name="customer_email" class="form-control" placeholder="Email" required autofocus>
                <input type="password" name="customer_password" class="form-control" placeholder="Password" required>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
                
                
 
            <div class="row-sm-1 col-sm-offset-4">
                        <a href="<c:url value='/action/findPassword'/>" class="pull-right need-help">Find password!</a>
                        <a>/</a>
                        <a href="<c:url value='/action/signup'/>" class="pull-left need-help">Sign up</a>       
                    </div>
                
            </form>
            </div>
            
		</div><!-- /container -->        
	</div><!-- /headerwrap -->

    <div class="section">
        <div class="container">
            <div class="row">
                <div class="col-lg-4 col-md-4">
                    <h3><i class="fa fa-check-circle"></i> 내가 아는 사람들만 </h3>
                    <p> 내가 아는 그는 가슴에 멍 자국 같은 새 발자국 가득한 사람이어서 누구와 부딪혀도 ... 만 개의 기쁨과 만 개의 슬픔 ... 오화경 처음엔 내안에만 사는 사람으로 느끼고 </p>
                </div>
                <div class="col-lg-4 col-md-4">
                    <h3><i class="fa fa-pencil"></i> 편리한 공유 시스템 </h3>
                    <p> 세상 가장 안전하고 편리한 공유의 장: 빌리지 ... 있도록 하는 시스템이 나머지 99개를 아낄 수 있는 방법이라고 생각했어요. </p>
                </div>
                <div class="col-lg-4 col-md-4">
                    <h3><i class="fa fa-folder-open"></i> 나눌수록 커지는 우정 </h3>
                    <p> 우정이 살아 움직이는 용문고등학교 28회 카페 · 우정이 살아 움직이는 ... 나눌수록 더 커지는 기쁨 </p>
                </div>
            </div>
            <!-- /.row -->

        </div>
        <!-- /.container -->

    </div>
    <!-- /.section -->

    <div class="section-colored text-center">

        <div class="container">

            <div class="row">
                <div class="col-lg-12">
                    <h2> 두레 활용 방안에 대한 내용 기술 </h2>
                    <p> 자바 사이버 도서관에 대한 내용 이미지로 표현 </p>
                    <hr>
                </div>
            </div>
            <!-- /.row -->

        </div>
        <!-- /.container -->

    </div>
    <!-- /.section-colored -->

    

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
