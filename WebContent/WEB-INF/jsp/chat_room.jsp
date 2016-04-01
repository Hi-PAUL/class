<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <title>唯空间</title>
     <link rel="shortcut icon" href="./images/faviconz.ico" />
     <link rel="bookmark" href="./images/faviconz.ico" />
     <link rel="stylesheet" type="text/css" href="./css/main.css" >
     <link rel="stylesheet" type="text/css" href="./css/chat.css" >
      <link rel="stylesheet" type="text/css" href="./easyui/themes/default/easyui.css">
     <link rel="stylesheet" type="text/css" href="./easyui/themes/icon.css">
     <script type="text/javascript" src="./easyui/jquery.min.js"></script>
     <script type="text/javascript" src="./easyui/jquery.easyui.min.js"></script> 
     
</head>
<body>
<div class="top">
  <div class="top_content">
    <ul>
      <li><a href="lang?langType=en&path=space_show">English</a></li>
      <li><a href="lang?langType=zh&path=pace_show">中文</a></li>
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
          <li><a href="chat_room.xhtml" style="color:#FF0">聊天室</a></li>
          <li><a href="space_show.xhtml" >唯空间</a></li>
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
  
  <div class="easyui-layout" style="width:1000px;height:500px;margin-top:18px">
     <div data-options="region:'center'" title="你现在的位置   >> 聊天室">
        <div class="easyui-tabs" style="width:100%;height:471px">
           <div title="聊天室" data-options="iconCls:'icon-bubbles4'" style="padding:10px">
              <div id="chat_main" style="width:100%;height: 368px; background: red">
               gggg
              </div>
              <div style="width:100%;margin:10px 0">
                <input class="easyui-textbox" data-options="buttonText:'发送',prompt:'inpout...'" style="width:100%;height:32px;">
              </div>
           </div>
           <!-- bubbles4结束 -->
           
           <div title="留言板" data-options="iconCls:'icon-twitch'" style="padding:10px">
             <div id="chat_main" style="width:100%;height:385px">
               <div style="width:100%;height:380px;overflow-y:auto">
                  <ul id="Message_list">
                  </ul>
                 </div>
                 <div>
                   <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'" style="padding:5px 0px;width:100%;">
                      <span style="font-size:14px;">新增</span>
                   </a>
                 </div>
              </div>
           </div>
           <!-- twitch结束 -->
           
           <div title="公告栏" data-options="iconCls:'icon-bullhorn'" style="padding:10px">
             <div id="chat_main" style="width:100%;height:100%">
                <ul id="notice_list">
                </ul>
              </div>
           </div>
            <!-- bullhorn结束 -->
            
        </div>
        <!--easyui-tabs结束-->
     </div>
    <!--center结束-->
     
     <div id="p" data-options="region:'east'" title="West" style="width:30%;padding:10px">
         <div style="width:100%;height:140px;">
            <div style="float:left">
             <a href="space_icon.xhtml"><img alt="点击上传头像" src="./images/icons/${user.cdkey}.jpg" style="width:100px;height:100px;margin:20px;border: 3px solid #E8E8E8"></a>
            </div> 
            <div class="chat_easy_name" style="width:100px;height:100px;float:left;margin-top:20px">
             <p><a href="#">Hi,${user.username}</a></p>  
             <p><a href="#">积分 : ${user.username}</a></p>        
            </div> 
         </div>
        
        <div class="easyui-accordion" style="width:100%;height:300px;">
         <div title="在线人数" data-options="iconCls:'icon-ok'" style="overflow:auto;padding:10px;">
             <ul id="onlion_list">
             </ul>
        </div>
        </div>
     </div>
        
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

<script type="text/javascript">
   $(document).ready(function(){
	   
	   getOnlionList();
	   window.setInterval(function(){
		   getOnlionList(); 
	   }, 10000);
	   function getOnlionList(){
		   $.ajax({
				url : "get_userOnlion_list.json",
				type : "POST",
				success : function(result) {
					if (!result.errorCode) {
					    $("#onlion_list").empty();
						$.each(result.data, function(i, r){
						  $("#onlion_list").append("<li>"+result.data[i].username+"   ("+result.data[i].email+")"+"</li>");
							
						 }); 
					} else {
						alert(result.errorMsg);
					}
				 }
			 });
	     }
	   
	   getNoticeList();
	   window.setInterval(function(){
		   getNoticeList(); 
	   }, 30000);
	   function getNoticeList(){
		   $.ajax({
				url : "get_notice_list.json",
				type : "POST",
				success : function(result) {
					if (!result.errorCode) {
					    $("#notice_list").empty();
						$.each(result.data, function(i, r){
						  $("#notice_list,#Message_list").append("<li><img src='./images/icons/"+result.data[i].publisher+".jpg'>"+
								                   "<i>"+result.data[i].title+"</i>"+
								                   "<samp>"+result.data[i].dateline+"</samp>"+
								                   "<samp>"+result.data[i].publisher+"</samp>"+
								                   "<p>"+result.data[i].content+"</p>"+"</li>");
							
						  }); 
					} else {
						alert(result.errorMsg);
					}
				 }
			 });
	     }
	   

   })
</script>

</html>