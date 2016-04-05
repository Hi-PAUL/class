 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <title>我的班级</title>
     <link rel="shortcut icon" href="./images/faviconz.ico" />
     <link rel="bookmark" href="./images/faviconz.ico" />
     <link rel="stylesheet" type="text/css" href="./css/main.css" >
     <link rel="stylesheet" type="text/css" href="./css/class.css" >
     <link rel="stylesheet" type="text/css" href="./easyui/themes/default/easyui.css">
     <link rel="stylesheet" type="text/css" href="./easyui/themes/icon.css">
     <script type="text/javascript" src="./easyui/jquery.min.js"></script>
     <script type="text/javascript" src="./easyui/jquery.easyui.min.js"></script> 
     
     
</head>
<body>
<div class="top">
  <div class="top_content">
    <ul>
      <li><a href="lang?langType=en&path=address_book">English</a></li>
      <li><a href="lang?langType=zh&path=address_book">中文</a></li>
      <li><a href="#"><spring:message code="help"/></a></li>
      <li><a onclick="AddFavorite(window.location,document.title)" href="javascript:void(0)"><spring:message code="StoreUp"/></a></li>
      <li><a href="#"><spring:message code="logout"/></a></li>
      <li><a href="#">${user.username}</a></li>
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
      <div class="nav_mida_left">
        <ul>
          <li><a href="activity.xhtml">首页</a></li>
          <li><a href="my_class.xhtml">我的班级</a></li>
          <li><a href="#">相册墙</a></li>
          <li><a href="address_book.xhtml">通讯录</a></li>
          <li><a href="chat_room.xhtml">聊天室</a></li>
          <li><a href="space_show.xhtml">唯空间</a></li>
          <li><a href="result.xhtml">成绩表</a></li>
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
 
<div  style="margin-top:18px;">    
  <div id="my_class" class="easyui-panel" title="你现在的位置   >> 我的班级" style="width:100%;height:700px;">
    <div id="class_logo">
    
    </div>
    <table id="warm">
      <tr>
        <td>学    院 : </td>
        <td>${classes.college}</td>
        <td>专 业 : </td>
        <td>${classes.major}</td>
      </tr>
       <tr>
        <td>班级名称 ：</td>
        <td>${classes.classname}</td>
        <td>班主任 : </td>
        <td>${classes.classadviser}</td>
      </tr>
       <tr>
        <td>人  数 : </td>
        <td>${classes.number}</td>
        <td>创建时间 : </td>
        <td>${classes.createdate}</td>
      </tr>
       <tr>
        <td>班级口号 : </td>
        <td>${classes.slogan}</td>
        <td>班级介绍 : </td>
        <td>${classes.introduce}</td>
      </tr>
       <tr>
        <td>荣  誉 : </td>
        <td>${classes.honour}</td>
        <td>荣 誉  : </td>
        <td>${classes.feature}</td>
      </tr>
    </table>

  </div>
</div>    
<!-- my_class结束 -->
  
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