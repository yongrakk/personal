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
<title>CYR's Page</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link href="layout/styles/layout.css" rel="stylesheet" type="text/css" media="all">
<script src="jquery-3.3.1.min.js"></script>
<script>
      // 2. This code loads the IFrame Player API code asynchronously.
      var tag = document.createElement('script');

      tag.src = "https://www.youtube.com/iframe_api";
      var firstScriptTag = document.getElementsByTagName('script')[0];
      firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);

      // 3. This function creates an <iframe> (and YouTube player)
      //    after the API code downloads.     
      var player;
      function onYouTubeIframeAPIReady() {
        player = new YT.Player('player', {
          height: '360',
          width: '640',
          videoId: ${videoid},
          events: {
            'onReady': onPlayerReady,
            'onStateChange': onPlayerStateChange
          }
        });
      }

      // 4. The API will call this function when the video player is ready.
      function onPlayerReady(event) {
        event.target.playVideo();
      }

      // 5. The API calls this function when the player's state changes.
      //    The function indicates that when playing a video (state=1),
      //    the player should play for six seconds and then stop.
      var done = false;
      function onPlayerStateChange(event) {
        if (event.data == YT.PlayerState.PLAYING && !done) {
          done = true;
        }
      }
      function stopVideo() {
        player.stopVideo();
      }
      </script>
      
      
     <script>
		function fnGetList(sGetToken){
			var search = "[TJ노래방]";
			var $getval = search+$("#search_box").val();
			if($getval==""){
				alert("검색어를 입력하세요.");
				$("#search_box").focus();
				return;
			}
			$("#click_video").empty();
			$("#nav_view").empty()

			var sTargetUrl = "https://www.googleapis.com/youtube/v3/search?part=snippet&order=relevance"
								+ "&q="+ encodeURIComponent($getval) +"&key=AIzaSyBQc0aSWVQteXRqi0akHdSrsstE5js2LB8";
			if(sGetToken){
				sTargetUrl += "&pageToken="+sGetToken;
			}
			$.ajax({
				type: "POST",
				url: sTargetUrl,
				dataType: "jsonp",
				success: function(jdata) {
					console.log(jdata);

					$(jdata.items).each(function(i){
						//console.log(this.snippet.channelId);
						var titles ="";
						for(var i =0; i<10; i++){
							titles=this.snippet.title.replace(/ /g,"");
						}
						var videoid= JSON.stringify(this.id.videoId);
						var thumnail = JSON.stringify(this.snippet.thumbnails.default.url);
						var title = JSON.stringify(titles);
						$("#click_video").append("<p class='box'><a href='videoget?id="+this.id.videoId+"&playlisttitle="
								+this.snippet.title+"'>"
								+"<img src='"+this.snippet.thumbnails.default.url+"'><span>"
								+this.snippet.title+"</span></a></p>"
								+"<a href='javascript:onclick=addPlayList("+videoid+","+thumnail+","+title+")'>예약하기</a>")
					}).promise().done(function(){
						if(jdata.prevPageToken){
							$("#nav_view").append("<a href='javascript:fnGetList(\""+jdata.prevPageToken+"\");'><이전페이지></a>");
						}
						if(jdata.nextPageToken){
							$("#nav_view").append("<a href='javascript:fnGetList(\""+jdata.nextPageToken+"\");'><다음페이지></a>");
						}
					});
				},
				error:function(xhr, textStatus) {
					console.log(xhr.responseText);
					alert("지금은 시스템 사정으로 인하여 요청하신 작업이 이루어지지 않았습니다.\n잠시후 다시 이용하세요.[2]");
					return;
				}
			});
		}
	</script>
	
	<script type="text/javascript">
		function addPlayList(videoid,thumnail,title){
			var playList = {"videoid":videoid,"thumnail":thumnail,"title":title};
			var videoid = "";
			var title = "";
			var thumnail = "";
			$.ajax({
				method:'POST'
				,url:'addList'
				,data: JSON.stringify(playList)
				,dataType:'json'
				,contentType:'application/json; charset:utf-8'
				,success :function(rep){
					title=JSON.stringify(rep[0].playlisttitle);
					videoid=JSON.stringify(rep[0].videoid);
					thumnail=JSON.stringify(rep[0].thumnail);
					$("#playlist").append("<div><a href='videoget?id="+videoid+"&playlisttitle="+title+"'>"
						+"<img src="+thumnail+"/><span>"+title+"</span></a></div>");
					
				}
			});
		}
	</script>
</head>
<body id="top">
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- Top Background Image Wrapper -->
<div class="bgded overlay" style="background-image:url('images/pp1.png');"> 
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
  <div class="wrapper row2">
    <div id="breadcrumb" class="hoc clear"> 
      <!-- ################################################################################################ -->
      <ul>
        <li><a href="index">Home</a></li>
        <li><a href="karaoke">노래방</a></li>
      </ul>
      <!-- ################################################################################################ -->
    </div>
  </div>
  <!-- ################################################################################################ -->
</div>
<!-- End Top Background Image Wrapper -->
<!-- ################################################################################################ -->
<div class="wrapper row3">
    <!-- main body -->
    <div class="hoc container clear"> 
    <!-- ################################################################################################ -->
    <div class="content three_quarter first" style="float:left;"> 
      <!-- ################################################################################################ -->
      <div id="comments">
        <h2>Enjoy!!</h2>
        <h1>${title}</h1>
        <div id="player"></div>
  		<form name="form1" method="post" onsubmit="return false;">
  		<input type="text" id="search_box"><input type="button" value="검색" onclick="fnGetList()">
  		</form>
  		<div id="click_video"></div>
  		<div id="nav_view"></div>
     </div>
     
      <!-- ################################################################################################ -->
   </div>
   <div id="playlist"></div>
   <div style="float: left;">
   		
   		<div>
  		<c:if test="${not empty playList}" >
			<c:forEach var="list" items="${playList}">
				<ul style="margin-bottom: 20px; padding: 0px;">
					<li>
						<a href="videoget?id=${list.videoid}&playlisttitle=${list.playlisttitle}"><img src="${list.thumnail}"/><span>${list.playlisttitle}</span></a>
						<a style="float: right;" href="deleteList?listnum=${list.playlistnum}">삭제</a>
					</li>
				</ul>
			</c:forEach>  
			</c:if>
		</div>
	</div>		
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
</body>
</html>