<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<!--
Template Name: Pesaton
Author: <a href="https://www.os-templates.com/">OS Templates</a>
Author URI: https://www.os-templates.com/
Licence: Free to use under our free template licence terms
Licence URI: https://www.os-templates.com/template-terms
-->
<html>
<head>
<script type="text/javascript" src="ckeditor/ckeditor.js"></script>
<title>CYR's Page</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link href="layout/styles/layout.css" rel="stylesheet" type="text/css" media="all">
</head>
<body id="top">
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- Top Background Image Wrapper -->
<div class="bgded overlay" style="background-image:url('images/dark.png');"> 
  <!-- ################################################################################################ -->
  <!-- 최상단 네비게이션 -->
   <div class="wrapper row0">
    <div id="topbar" class="hoc clear"> 
      <!-- ################################################################################################ -->
      <div class="fl_left">
        <ul class="nospace">
          <li><a href="index"><i class="fa fa-lg fa-home"></i></a></li>
          <li><a href="about">About</a></li>
          <c:if test="${sessionScope.loginId==null}">
          <li><a href="loginMember">Login</a></li>
          </c:if>
          <c:if test="${sessionScope.loginId!=null}">
          <li><a href="logout">Logout</a></li>
          </c:if>
          <li><a href="joinMember">Register</a></li>
        </ul>
      </div>
      <div class="fl_right">
        <ul class="nospace">
          <li><i class="fa fa-phone"></i> +82 (02) 6000 7138</li>
          <li><i class="fa fa-envelope-o"></i>c1.yrkk@gmail.com</li>
        </ul>
      </div>
      <!-- ################################################################################################ -->
    </div>
  </div>
  <!-- ################################################################################################ -->
 <!-- 페이지 메뉴 -->
  <div class="wrapper row1">
    <header id="header" class="hoc clear"> 
      <!-- ################################################################################################ -->
      <div id="logo" class="fl_left">
        <h1><a href="index">CYR's Page</a></h1>
      </div>
      <nav id="mainav" class="fl_right">
       <ul class="clear">
          <li class="active"><a href="index">Home</a></li>
          <li><a href="about">About</a></li>
          <li><a href="board">Communication</a></li>
       	  <li><a href="karaoke">Karaoke</a></li>
        </ul>
      </nav>
      <!-- ################################################################################################ -->
    </header>
  </div>
  <!-- ################################################################################################ -->
  <!-- ################################################################################################ -->
  <!-- ################################################################################################ -->
  <!-- ################################################################################################ -->
</div>
<!-- End Top Background Image Wrapper -->
<!-- ################################################################################################ -->
<div class="wrapper row3">
  <div class="hoc container clear"> 
    <!-- main body -->
    <!-- ################################################################################################ -->
    <div class="content three_quarter first"> 
      <!-- ################################################################################################ -->
      <div id="comments">
        <h2>작성</h2>
        <form action="updateBoard" method="get" id="boardform">
        <input type="hidden" name="boardnum" value="${boardnum}">
			<table>
				<tr>
					<td width="50px;">제목</td>
					<td><input type="text" id="title" name="title" autocomplete="off" value="${title}">
				</tr>
				<tr>
					<td colspan="2">
					<textarea id="context" name="boardtext" >${boardtext}</textarea>
					</td>
				</tr>
				<tr>
				<td colspan="2" align="center">
					<input type="submit" value="수정">
				</td>
				</tr>
			</table>
			<script type="text/javascript">
			CKEDITOR.replace('context');
			</script>
      	</form>
      </div>
      <!-- ################################################################################################ -->
    </div>
    <!-- ################################################################################################ -->
    <div class="sidebar one_quarter"> 
      <!-- ################################################################################################ -->
      <h6>Menu</h6>
  	  <nav class="sdb_holder">
   	     <ul>
          <li><a href="board">자유 게시판</a></li>
        </ul> 
      </nav>
      <div class="sdb_holder">
        <h6>Contact Me</h6>
        <address>
        Choi Yongrak<br>
        SC IT Master<br>
        Seoul/Coex<br>
        <br>
        Tel: 02) 6000 7139 <br>
        Email: <a href="#">c1.yrkk@gmail.com</a>
        </address>
      </div>
      <!-- ################################################################################################ -->
    </div>
    <!-- ################################################################################################ -->
  </div>
</div>
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<div class="wrapper row4 bgded overlay" style="background-image:url('images/bottom.png');">
  <footer id="footer" class="hoc clear"> 
    <!-- ################################################################################################ -->
    <!-- ################################################################################################ -->
    <div class="group">
      <div class="one_third first">
        <h6 class="title">Hello</h6>
        <p>인터넷으로 즐기는 노래방!</p>
        <p class="btmspace-15">언제든지 어디서든지 유튜브와 함께 노래방을 즐기세요!</p>
      </div>
      <div class="one_third">
        <h6 class="title">Contact</h6>
        <ul class="nospace linklist contact">
          <li><i class="fa fa-map-marker"></i>
            <address>
            Yeongdong-daero &amp; 513, Gangnam-gu, 06164/Coex
            </address>
          </li>
          <li><i class="fa fa-envelope-o"></i>c1.yrkk@gmail.com</li>
        </ul>
      </div>
      <div class="one_third">
        <h6 class="title">what</h6>
        <ul class="nospace linklist">
          <li>
            <article>
              <h2 class="nospace font-x1"><a href="about">페이지정보</a></h2>
              <time class="font-xs block btmspace-10" datetime="2018-07-26">Thursday, 26<sup>th</sup> July 2018</time>
              <p class="nospace">Start this web</p>
            </article>
          </li>
        </ul>
      </div>
    </div>
    <!-- ################################################################################################ -->
  </footer>
</div>
<!-- ################################################################################################ -->
<div class="wrapper row5">
  <div id="copyright" class="hoc clear"> 
    <!-- ################################################################################################ -->
    <p class="fl_left">Copyright &copy; 2018 - All Rights Reserved - <a href="index">CYR's Page</a></p>
    <!-- ################################################################################################ -->
  </div>
</div>
<!-- ################################################################################################ -->
<a id="backtotop" href="#top"><i class="fa fa-chevron-up"></i></a>
<!-- JAVASCRIPTS -->
<script src="layout/scripts/jquery.min.js"></script>
<script src="layout/scripts/jquery.backtotop.js"></script>
<script src="layout/scripts/jquery.mobilemenu.js"></script>
<!-- IE9 Placeholder Support -->
<script src="layout/scripts/jquery.placeholder.min.js"></script>
<!-- / IE9 Placeholder Support -->
<script type="text/javascript" src="layout/scripts/joinCheck.js"></script>
</body>
</html>