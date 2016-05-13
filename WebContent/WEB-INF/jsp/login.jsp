<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <title>登陆页面</title>
     <link rel="shortcut icon" href="./images/faviconz.ico" />
     <link rel="bookmark" href="./images/faviconz.ico" />
     <link rel="stylesheet" type="text/css" href="./css/main.css" >
     <link rel="stylesheet" type="text/css" href="./easyui/themes/default/easyui.css">
     <link rel="stylesheet" type="text/css" href="./easyui/themes/icon.css">
     <script type="text/javascript" src="./easyui/jquery.min.js"></script>
     <script type="text/javascript" src="./easyui/jquery.easyui.min.js"></script> 
 
</head>
<body>
<div class="top">
  <div class="top_content">
    <ul>
      <li><a href="lang?langType=en&path=login">English</a></li>
      <li><a href="lang?langType=zh&path=login">中文</a></li>
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
  
  <div class="easyui-panel" title="当前位置  >> 登陆" style="width:1000px;padding:30px 80px">
  <div style="float: left"><img alt="" src="./images/login.jpg"></div>
  <div style="float: right">
   <div style="margin-bottom:20px">
       <div>账  号：</div>
       <input id="username" name="username" value="${username}" class="easyui-textbox" data-options="prompt:'Enter a account...',iconCls:'icon-man',iconWidth:38" style="width:300px;height:32px">
   </div>
   <div style="margin-bottom:20px">
       <div>密  码：</div>
       <input id="password"  type="password" name="password" class="easyui-textbox" data-options="prompt:'Enter a password...',iconCls:'icon-lock',iconWidth:38" style="width:300px;height:32px">
   </div>
   <div style="margin-bottom:20px">
       <div>验 证 码：</div>
       <input id="authCode" name="authCode" class="easyui-textbox" data-options="prompt:'Enter auth code...'" style="width:140px;height:32px">
       <a href="javascript:location.reload()" class="easyui-linkbutton" style="width:80px;height:32px"><img src="authImg.do" style="width:60px;height:20px"/></a>
   </div>
   <div style="margin-bottom:20px">
       <input id="autoLogin" class="easyui-switchbutton" >
       <span style="width:30px;height:22px;margin-left:5px">自动登陆</span>
   </div>
   <div>
       <a  id="login" class="easyui-linkbutton" iconCls="icon-ok" style="width:300px;height:32px">登陆</a>
    </div>
  </div> 
 </div>
  <!--ad结束--> 
</div>
<!--最外层wrap结束  -->

<jsp:include page="include/inc_footer.jsp"/>
</body>
<script type="text/javascript">
	$(document).ready(function(){
		
	  $("#login").click(function(){
		 if(!validateObj.validate()){
			return false;
		} 
		
	   $.ajax({
			url : "user_login.json",
			type : "POST",
			data : {
				username : $("#username").val(),
				password : $("#password").val(),
				authCode : $("#authCode").val(),
				autoLogin : $("#autoLogin").switchbutton("options").checked
			},
			dataType : "json",
			success : function(result) {
				if (!result.errorCode) {
					window.location.href = "activity.xhtml";
				} else {
					if(result.errorCode)
					 $.messager.alert('警告',result.errorMsg,'warning');
					
					   if(result.errorCode!=110){
						window.location.href = "select_class.xhtml";
					  } 
				   }
				}
		 });

		});

		//数据校验模块
		var validateObj = {};
		$.extend(validateObj, {
			validate : function() {
				var username = $("#username").val();
				if (!username) {
					$.messager.alert('警告','账号必须输入!','warning');
					return false;
				}
				if (username.length < 3) {
					$.messager.alert('警告','账号必须至少3位!','warning');
					return false;
				}

				var password = $("#password").val();
				if (!password) {
					$.messager.alert('警告','密码必须输入!','warning');
					return false;
				}
				if (password.length < 6) {
					$.messager.alert('警告','密码必须至少6位!','warning');
					return false;
				}
				
				var authCode = $("#authCode").val();
				if (!authCode) {
					$.messager.alert('警告','验证码必须输入!','warning');
					return false;
				}
				return true;
			}
		});

	});
</script>
</html>