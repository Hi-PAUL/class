<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <title>班级首页</title>
     <link rel="shortcut icon" href="./images/faviconz.ico" />
     <link rel="bookmark" href="./images/faviconz.ico" />
     <link rel="stylesheet" type="text/css" href="./css/main.css" >
     <script type="text/javascript" src="./js/setHomeSetFav.js"></script>
     <script type="text/javascript" src="./js/myfocus-2.0.1.min.js"></script>
     <script type="text/javascript">
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
      <li><a href="#"><spring:message code="help"/></a></li>
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
          <li><a href="list.html">我的班级</a></li>
          <li><a href="list.html">新闻动态</a></li>
          <li><a href="list.html">活动中心</a></li>
          <li><a href="list.html">校园风景</a></li>
          <li><a href="list.html">人才招聘</a></li>
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
          <li><a href="#"><img src="images/ad2.jpg" thumb="" alt="" text="详细描述2" /></a></li>
          <li><a href="#"><img src="images/ad3.jpg" thumb="" alt="" text="详细描述3" /></a></li>
          <li><a href="#"><img src="images/ad4.jpg" thumb="" alt="" text="详细描述4" /></a></li>
          <li><a href="#"><img src="images/ad3.jpg" thumb="" alt="" text="详细描述5" /></a></li>
        </ul>
      </div>
    </div>
  </div>
  <!--ad结束-->
  
  <div class="main">
    <div class="news">
      <div class="title">
        <h2 class="titile_left">新闻中心</h2>
        <span class="title_right"><a href="#">More&gt;&gt;</a></span> </div>
      <!--title结束-->
      
      <div class="pic_news"> <img src="images/news.jpg" alt="520 慕女神喊你来表白" width="113" height="77" />
        <h2><a href="news.html">520 慕女神喊你来表白！</a></h2>
        <p>活动时间：5月20日—5月25日<br />
          获奖公布时间：5月26日<br />
          <a href="news.html">Learn More>></a></p>
      </div>
      <!--pic_news结束-->
      
      <div class="news_list">
        <ul>
          <li><span>2014-06-01</span> <a href="news.html">【慕客访谈 用户篇】“有为屌丝”在路上</a></li>
          <li><span>2014-06-01</span><a href="news.html">【有奖活动】给父亲的三行书信</a></li>
          <li><span>2014-05-30</span><a href="news.html">《程序猿，请晒出你的童年》活动获奖公告</a></li>
          <li><span>2014-05-28</span><a href="news.html" title="aa">【慕课访谈】破茧成蝶——美女程序员的蜕变史</a></li>
        </ul>
      </div>
      <!--news_list结束--> 
      
    </div>
    <!--news结束-->
    
    <div class="products">
      <div class="title">
        <h2 class="titile_left">活动中心</h2>
        <span class="title_right"><a href="#">More&gt;&gt;</a></span> </div>
      <!--title结束-->
      
      <div class="product_list"><img src="images/css.jpg" alt="CSS圆角进化论" width="158" height="106" />
        <h2><a href="news.html">CSS圆角进化论</a></h2>
        <p> CSS圆角的实现，经历了三大发展阶段：背景图片方式、CSS2.0+HTML标签模拟、CSS3.0圆角属性）。</p>
      </div>
      <!--product_list结束-->
      
      <div class="product_type">
        <ul>
          <li><a href="#">十大歌手</a></li>
          <li><a href="#">最美班花</a></li>
          <li><a href="#">百里徒步</a></li>
        </ul>
      </div>
    </div>
    <!--products结束-->
   
  </div>
  <!--main结束--> 
</div>
<!--最外层wrap结束  -->
<div class="copyright">
  <div class="copyright_content">
    <ul>
      <li>关于
        <ul>
          <li>品牌故事</li>
          <li>联系我们</li>
          <li>加入我们</li>
          <li>版权声明</li>
        </ul>
      </li>
      <li>活动
        <ul>
          <li>十大歌手</li>
          <li>最美班花</li>
          <li>百里徒步</li>
          <li>青年志愿者</li>
        </ul>
      </li>
      <li>关注
        <ul>
          <li>新浪微博</li>
          <li>腾讯微博</li>
          <li>企业微信</li>
          <li>QQ空间</li>
        </ul>
      </li>
      <li>留言
        <ul>
          <li>意见反馈</li>
          <li>问题留言</li>
          <li>媒体联络</li>
          <li>在线客服</li>
        </ul>
      </li>     
    </ul>
  </div>
  <!--copyright_content结束--> 
</div>
</body>
</html>