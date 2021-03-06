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
     <link rel="stylesheet" type="text/css" href="./css/main.css">
          <link rel="stylesheet" type="text/css" href="./easyui/themes/default/easyui.css">
     <link rel="stylesheet" type="text/css" href="./easyui/themes/icon.css">
     <script type="text/javascript" src="./easyui/jquery.min.js"></script>
     <script type="text/javascript" src="./easyui/jquery.easyui.min.js"></script> 
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
         <li><a href="index.xhtml">首页</a></li>
          <li><a href="list_news.xhtml">新闻动态</a></li>
          <li><a href="list_active.xhtml">活动中心</a></li>
          <li><a href="list_school.xhtml">校园风景</a></li>
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
  
<div  style="margin-top:10px;">    
  <div id="my_class" class="easyui-panel" title="你现在的位置   >> 人才招聘" style="width:100%;height:700px;">
   <div style="width:100px;margin:10px auto;"><h1>加入我们吧</h1></div>
   <div style="width:800px;margin:10px auto;"><h3>我们的网站刚刚上线，急需热血青年进入到我们的队伙中来。</h3></div>
    <div style="margin:20px">
      <p>一. 进入条件<br>
            1.年满18岁的有志青年<br>
            2.热爱计算机行业<br>
            3.兴趣多样，善于交谈<br><br>
                       二. 联系方式<br>
              1.电话：0755-4838798<br>  
              2.Email: 3475428346@163.com<br>
              3.地址：广东省深圳市福田区<br><br>
                     三. 截至日期<br>
            1.报名截至日期：2016.08.08<br>
      </p>
    </div>
  
  
  </div>
</div>
  
  
    
</div>
<!--最外层wrap结束  -->
<jsp:include page="../include/inc_footer.jsp"/>
</body>
</html>