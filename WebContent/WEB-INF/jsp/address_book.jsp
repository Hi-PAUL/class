 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <title>通讯录</title>
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
          <li><a href="album.xhtml">相册墙</a></li>
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
         
<table id="resultList" class="easyui-datagrid" style="width:100%;" title="你现在的位置   >> 通讯录" toolbar="#toolbar" pagination="true"  data-options="fitColumns:true,singleSelect:true,collapsible:false,rownumbers:true">
  <thead>
	<tr>
		<th data-options="field:'username',align:'center',width:'10%'">账号</th>
		<th data-options="field:'name',align:'center',width:'10%'">姓名</th>
		<th data-options="field:'sex',align:'center',width:'9%'">性别</th>
		<th data-options="field:'qq',align:'center',width:'10%'">QQ</th>
		<th data-options="field:'phone',align:'center',width:'10%'">电话</th>
		<th data-options="field:'email',align:'center',width:'10%'">邮箱</th>
		<th data-options="field:'point',align:'center',width:'9%'">用户积分</th>
		<th data-options="field:'studentid',align:'center',width:'10%'">学号</th>
		<th data-options="field:'registerdate',align:'center',width:'10%'">注册时间</th>
		<th data-options="field:'laterdate',align:'center',width:'10%'">最后登陆时间</th>
	</tr>
  </thead>
</table>
<!-- result_list结束 -->
  
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
		
	 //init
	 setData(1, 15);
			
	  function setData(pageNumber, pageSize ) {
			
			$.ajax({
				type : "POST",
				url : "get_address_book_list.json",
				data : {
					pageNumber : pageNumber,
					pageSize : pageSize
				},
				dataType : "json",
				success : function(result) {
					
					if (!result.errorCode) {
						if(result.data.total==0){
							$.messager.show({
				                title:'信息',
				                msg:'抱歉，没有搜到你要的结果!',
				                timeout:5000,
				                showType:'slide'
				            });
						}
						$("#resultList").datagrid("loadData", {
							"total" : result.data.total,
							"rows" : result.data.rows
						});
						var pg = $("#resultList").datagrid("getPager");
						if (pg) {
							$(pg).pagination({
										pageNumber : pageNumber,
										pageSize : pageSize,
										showPageList : false,
										showRefresh : false,
										beforePageText : '第',
										afterPageText : '页，共{pages}页',
										displayMsg : '',
										onSelectPage : function(pageNumber,pageSize) {
											          setData(pageNumber,pageSize);
										}
							});
						}//end if(pg)
					}//end if(!result.errorCode)
				}//end success
			})//end ajax
		}//end setData	
		
	  });
</script>
</html>