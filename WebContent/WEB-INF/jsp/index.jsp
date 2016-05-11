<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<head>
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <title>班级首页</title>
     <link rel="shortcut icon" href="./images/faviconz.ico" />
     <link rel="bookmark" href="./images/faviconz.ico" />
     <link rel="stylesheet" type="text/css" href="./css/main.css" >
     <script type="text/javascript" src="./js/jquery.js"></script>
     <script type="text/javascript" src="./js/setHomeSetFav.js"></script>
     <script type="text/javascript" src="./js/myfocus-2.0.1.min.js"></script>
     <script type="text/javascript" src="./js/up-top.js"></script>
     <script type="text/javascript" src="./js/jquery.jcarousellite.js"></script>
     <script type="text/javascript">
     
	   //作品展示滚动图片
		  $(".scrollpanel").jCarouselLite({     
		      auto: 2000,
		      speed: 300,
		      scroll: 1,
		      visible: 3
	     });
     
	    myFocus.set({
	    id:'boxID',//焦点图盒子ID type="image/x-icon" 
	    pattern:'mF_fancy',//风格应用的名称
	    time:3,//切换时间间隔(秒)
	    trigger:'click',//触发切换模式:'click'(点击)/'mouseover'(悬停)
	    width:1000,//设置图片区域宽度(像素)
	    height:310,//设置图片区域高度(像素)
	    txtHeight:'default'//文字层高度设置(像素),'default'为默认高度，0为隐藏
	  });
      </script>
</head>
<body>
<div class="top">
  <div class="top_content">
    <ul>
      <li><a href="lang?langType=en&path=index">English</a></li>
      <li><a href="lang?langType=zh&path=index">中文</a></li>
      <li><a href="help.xhtml"><spring:message code="help"/></a></li>
      <li><a onclick="AddFavorite(window.location,document.title)" href="javascript:void(0)"><spring:message code="StoreUp"/></a></li>
      <li><a href="register.xhtml"><spring:message code="register"/></a></li>
      <li><a href="login.xhtml"><spring:message code="login"/></a></li>
    </ul>
  </div>
</div>
<!--页面顶端top结束-->

<div class="wrap">
  <div  class="logo">
    <div class="logo_left"><img src="images/logoz.jpg" /></div>
    <div class="logo_right"><img src="images/tel.jpg" width="28" height="28" /><spring:message code="Hotline"/>：<span class="tel">123-456-7890</span></div>
  </div>
  <!--logo结束-->
  
  <div class="nav">
    <div  class="nav_left"></div>
    <div class="nav_mid">
      <div class="nav_mid_left">
        <ul>
          <li><a href="#">首页</a></li>
          <li><a href="list_news.xhtml">新闻动态</a></li>
          <li><a href="list_active.xhtml">活动中心</a></li>
          <li><a href="#">校园风景</a></li>
          <li><a href="join.xhtml">人才招聘</a></li>
          <li><a href="admin_login.xhtml">管理中心</a></li>
        </ul>
      </div>
      <!--nav_mid_left结束-->
      <div class="nav_mid_right">
        <form action="" method="post">
          <input type="text" class="search_text" />
          <!--<input type="text" class="search_text" x-webkit-speech />-->
        </form>
      </div>
      <!--nav_mid_right结束--> 
    </div>
    <!--导航主体nav_mid结束-->
    <div class="nav_right"></div>
  </div>
  <!--nav结束-->
  
  <div class="ad">
    <div id="boxID"><!--焦点图盒子-->
      <div class="loading"><img src="images/loading.gif" alt="请稍候..." /></div>
      <!--载入画面(可删除)-->
      <div class="pic"><!--内容列表(li数目可随意增减)-->
        <ul>
          <li><a href="#"><img src="images/ad.jpg" alt="" /></a></li>
          <li><a href="#"><img src="images/ad1.jpg" alt="" /></a></li>
          <li><a href="#"><img src="images/ad2.jpg" alt="" /></a></li>
          <li><a href="#"><img src="images/ad3.jpg" alt="" /></a></li>
          <li><a href="#"><img src="images/ad4.jpg" alt="" /></a></li>
        </ul>
      </div>
    </div>
  </div>
  <!--ad结束-->
  <br>
  <div class="main">
    <div class="news">
      <div class="title">
        <h2 class="titile_left">新闻中心</h2>
        <span class="title_right"><a href="list_news.xhtml">More&gt;&gt;</a></span>         
       </div>
       <!--title结束-->
      
      <div class="pic_news"> <img src="images/news.jpg" alt="918 蓝桥杯喊你来助威" width="113" height="77" />
        <h2><a href="#"> 930 蓝桥杯喊你来助威！</a></h2>
        <p>活动时间：9月01日—9月25日<br />
                              获奖公布时间：10月25日<br />
          <a href="list_news.xhtml">Learn More>></a></p>
      </div> 
      <!--pic_news结束-->
      
      <div class="news_list">
        <ul>
          <c:forEach items="${newsList}" var="list" begin="0" end="3">
               <li><span>${list.dateline}</span> <a href="info_news.xhtml?id=${list.id}">${list.title}</a></li>
          </c:forEach>
        </ul>
      </div>
      <!--news_list结束--> 
      
    </div>
    <!--news结束-->
    
    <div class="products">
      <div class="title">
        <h2 class="titile_left">活动中心</h2>
        <span class="title_right"><a href="list_active.xhtml">More&gt;&gt;</a></span> </div>
        <!--title结束-->
      
        <div class="pic_news"> <img src="images/css.jpg" alt="520 女神喊你来表白" width="113" height="77" />
        <h2><a href="#">520 女神喊你来表白！</a></h2>
        <p>活动时间：5月20日—5月25日<br />
                              获奖公布时间：5月26日<br />
          <a href="list_active.xhtml">Learn More>></a></p>
      </div> 
      <!--pic_news结束-->
      
      <div class="news_list">
        <ul>
          <c:forEach items="${activeList}" var="list" begin="0" end="3">
               <li><span>${list.dateline}</span> <a href="info_news.xhtml?id=${list.id}">${list.title}</a></li>
          </c:forEach>
        </ul>
      </div>
      <!--news_list结束--> 
         
    </div>
    <!--products结束-->
   
  </div>
  <!--main结束--> 
  
  <br>
  <!-- main2 -->
  <div class="main">
    <div class="news2">
      <div class="message">
         <a href="#"><img alt="人才招聘" src="images/index08.jpg" style="width:260px;height:100px;"></a>    
      </div>
      <!--title结束-->
            
      <div class="message">
          <a href="admin_login.xhtml"><img alt="管理中心" src="images/index09.jpg" style="width:260px;height:100px;"></a>   
      </div>
      <!--news_list结束--> 
      
    </div>
    <!--news结束-->
    
    <div class="school">
      <div class="title">
        <h2 class="titile_left">校园风景</h2>
        <span class="title_right"><a href="#">More&gt;&gt;</a></span> 
       </div>
        <!--title结束-->
          
      <div class="img_list">
         <div class="artlist scrollpanel" style="margin:18px;height:200px;">
		   <ul class="artlist" >														
          	  <li>
	          	  <a href="#" target="_blank" title="">
	          	    <img border=0 src="images/index08.jpg" width="210px" height="170px" alt="" >
	          	  </a>
          	  </li>
          	  <li>
	          	  <a href="#" target="_blank" title="">
	          	    <img border=0 src="images/index09.jpg" width="210px" height="170px" alt="" >
	          	  </a>
          	  </li>
          	  <li>
	          	  <a href="#" target="_blank" title="">
	          	    <img border=0 src="images/index08.jpg" width="210px" height="170px" alt="" >
	          	  </a>
          	  </li>
		  </ul>
		</div>
      </div>
      <!--img_list结束-->   
    </div>
    <!--school结束-->
   
  </div>
  <!--main2结束-->   
      
</div>
<!--最外层wrap结束  -->
<jsp:include page="include/inc_footer.jsp"/>
</body>
</html>