<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <title>创建空间</title>
     <link rel="shortcut icon" href="./images/faviconz.ico" />
     <link rel="bookmark" href="./images/faviconz.ico" />
     <link rel="stylesheet" type="text/css" href="./css/main.css" >
     <link rel="stylesheet" type="text/css" href="./css/space.css" >
     <link rel="stylesheet" type="text/css" href="./easyui/themes/default/easyui.css">
     <link rel="stylesheet" type="text/css" href="./easyui/themes/icon.css">
     <script type="text/javascript" src="./easyui/jquery.min.js"></script>
     <script type="text/javascript" src="./easyui/jquery.easyui.min.js"></script> 
     
     
</head>
<body>
<div class="top">
  <div class="top_content">
    <ul>
      <li><a href="lang?langType=en&path=space_add">English</a></li>
      <li><a href="lang?langType=zh&path=space_add">中文</a></li>
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
          <li><a href="#">我的班级</a></li>
          <li><a href="#">通讯录</a></li>
          <li><a href="#">聊天室</a></li>
          <li><a href="space_show.xhtml" style="color:#FF0">唯空间</a></li>
          <li><a href="#">留言板</a></li>
          <li><a href="#">公告栏</a></li>
          <li><a href="#">成绩表</a></li>
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
  
  <div class="easyui-layout" style="margin-top:18px; width:1000px;height:850px;">
       <div id="p" data-options="region:'west'" title="你现在的位置  : 唯空间 >> 创建空间" style="width:22%;padding:50px">
           <div style="margin-bottom:20px">
             <a href="space_icon.xhtml"><img alt="点击上传头像" src="./images/icon/${user.cdkey}.jpg" style="width: 100px;height: 100px"></a>
           </div>
           <div class="username" style="margin-bottom:10px">
             <a href="#">Hi,${user.username}</a>
           </div>
            <div class="username" style="margin-bottom:10px">
             <a href="#">积分 : ${user.username}</a>
           </div>
           <div style="margin-bottom:25px">
             <ul class="message_list" >
             <li style="background-image: url('./images/space_1.jpg');"></li>
             <li><a href="#">上传头像</a></li>
             <li><a href="#">上传头像</a></li>
             <li><a href="#">上传头像</a></li>
             </ul>
           
           </div>
       </div>
       <!--West结束-->
        
       <div data-options="region:'center'" title="填写资料" style="padding:50px 200px">
         <div style="margin-bottom:20px">
            <div>Email:</div>
            <input class="easyui-textbox" data-options="prompt:'Enter a email address...'" style="width:100%;height:32px">
         </div>
         <div style="margin-bottom:20px">
            <div>Email:</div>
            <select class="easyui-combobox" id="" name="" style="width:100%;height:32px">
                <option value="AL">Alabama</option>
                <option value="AK">Alaska</option>
                <option value="AZ">Arizona</option>
            </select>
         </div>
         <div style="margin-bottom:20px">
            <div>Email:</div>
            <select class="easyui-combobox" id="" name="" style="width:100%;height:32px">
                <option value="AL">Alabama</option>
                <option value="AK">Alaska</option>
                <option value="AZ">Arizona</option>
            </select>
         </div>
         <div style="margin-bottom:20px">
            <div>Email:</div>
            <select class="easyui-combobox" id="" name="" style="width:100%;height:32px">
                <option value="AL">Alabama</option>
                <option value="AK">Alaska</option>
                <option value="AZ">Arizona</option>
            </select>
         </div>
         <div style="margin-bottom:20px">
            <div>Email:</div>
            <input class="easyui-textbox" data-options="prompt:'Enter a email address...'" style="width:100%;height:32px">
         </div>
         <div style="margin-bottom:20px">
            <div>Email:</div>
            <input class="easyui-textbox" data-options="prompt:'Enter a email address...'" style="width:100%;height:32px">
         </div>
         <div style="margin-bottom:20px">
            <div>Email:</div>
            <input class="easyui-textbox" data-options="prompt:'Enter a email address...'" style="width:100%;height:32px">
         </div>
         <div style="margin-bottom:20px">
            <div>Email:</div>
            <input class="easyui-textbox" data-options="prompt:'Enter a email address...'" style="width:100%;height:32px">
         </div>
         <div style="margin-bottom:20px">
            <div>Email:</div>
            <input class="easyui-textbox" data-options="prompt:'Enter a email address...'" style="width:100%;height:32px">
         </div>
         <div style="margin-bottom:20px">
            <div>Email:</div>
            <input class="easyui-textbox" data-options="prompt:'Enter a email address...'" style="width:100%;height:32px">
         </div>
         <div style="margin-bottom:20px">
            <div>Email:</div>
            <input class="easyui-textbox" data-options="prompt:'Enter a email address...'" style="width:100%;height:32px">
         </div>
         <div style="margin-bottom:20px">
            <div>Email:</div>
            <input class="easyui-textbox" data-options="prompt:'Enter a email address...'" style="width:100%;height:32px">
         </div>
        
        
      </div>
      <!--Center结束-->
    </div>
  <!--ad结束-->
  
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