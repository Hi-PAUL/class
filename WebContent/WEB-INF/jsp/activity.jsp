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
<jsp:include page="include/inc_header.jsp"/>
<div class="wrap">
  <div class="ad">
    <div id="boxID"><!--焦点图盒子-->
      <div class="loading"><img src="images/loading.gif" alt="请稍候..." /></div>
      <!--载入画面(可删除)-->
      <div class="pic"><!--内容列表(li数目可随意增减)-->
        <ul>
          <li><a href="#"><img src="images/ad2.jpg" alt="" /></a></li>
          <li><a href="#"><img src="images/ad3.jpg" alt="" /></a></li>
          <li><a href="#"><img src="images/ad4.jpg" alt="" /></a></li>
          <li><a href="#"><img src="images/ad3.jpg" alt="" /></a></li>
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
      
      <div class="pic_news"> <img src="images/news.jpg" alt="918 蓝桥杯喊你来助威" width="113" height="77" />
        <h2><a href="news.html"> 930 蓝桥杯喊你来助威！</a></h2>
        <p>活动时间：9月01日—9月25日<br />
                              获奖公布时间：10月25日<br />
          <a href="#">Learn More>></a></p>
      </div>
      <!--pic_news结束-->
      
      <div class="news_list">
        <ul>
          <li><span>2016-09-01</span> <a href="#">【开学季】欢迎学校2万新成员</a></li>
          <li><span>2016-09-10</span><a href="#">【领导风】校长看望退休教师</a></li>
          <li><span>2016-10-30</span><a href="#">【教师美】汗流湿润他们的衣襟</a></li>
          <li><span>2016-12-12</span><a href="#" title="aa">【新气象】我校综合教学楼下月将投入使用</a></li>
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
      
        <div class="pic_news"> <img src="images/css.jpg" alt="520 女神喊你来表白" width="113" height="77" />
        <h2><a href="news.html">520 女神喊你来表白！</a></h2>
        <p>活动时间：5月20日—5月25日<br />
                              获奖公布时间：5月26日<br />
          <a href="#">Learn More>></a></p>
      </div>
      <!--pic_news结束-->
      
      <div class="news_list">
        <ul>
          <li><span>2016-04-08</span> <a href="#">【校园动态】“校园十大歌手”报名马上开始</a></li>
          <li><span>2016-05-01</span><a href="#">【公益活动】“下乡支教”有你同行</a></li>
          <li><span>2016-06-25</span><a href="#">【户外扩展】“万里徒步”要你来参赛</a></li>
          <li><span>2016-07-06</span><a href="#" title="aa">【社区关怀】“社区家电维修”让你一展身手</a></li>
        </ul>
      </div>
      <!--news_list结束--> 
         
    </div>
    <!--products结束-->
   
  </div>
  <!--main结束--> 
</div>
<!--最外层wrap结束  -->
<jsp:include page="include/inc_footer.jsp"/>
</body>
</html>