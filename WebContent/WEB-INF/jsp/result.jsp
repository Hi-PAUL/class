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
  
  <div class="easyui-layout" style="margin-top:18px; width:1000px;height:700px;">
       <div id="p" data-options="region:'west'" title="你现在的位置   >> 成绩表 " style="width:22%;padding:50px">
           <div style="margin-bottom:20px">
             <a href="space_icon.xhtml"><img alt="点击上传头像" src="./images/icons/${user.cdkey}.jpg" style="width: 100px;height: 100px"></a>
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
             <li><a href="#" class="session">第一学期</a></li>
             <li><a href="#" class="session">第二学期</a></li>
             <li><a href="#" class="session">第三学期</a></li>
             <li><a href="#" class="session">第四学期</a></li>
             <li><a href="#" class="session">第五学期</a></li>
             <li><a href="#" class="session">第六学期</a></li>
             </ul>
           
           </div>
       </div>
       <!--West结束-->
        
       <div data-options="region:'center'" title="查询" style="padding:0px 0px">
         <div class="easyui-panel"  style="width:100%;height:50px;padding: 8px">
            <input id="search" class="easyui-textbox" value="${user.studentid}" data-options="buttonText:'查询',prompt:'Search...'" style="width:350px;height:32px;">
             <a id="print" class="easyui-linkbutton" data-options="iconCls:'icon-print'" style="height:30px; width:60px;float: right;">打印</a>
             <a href="javascript:location.reload();" class="easyui-linkbutton" data-options="iconCls:'icon-reload'" style="height:30px;width:60px;float:right;margin-right:6px">刷新</a>
         </div>
         <!-- SearchBox结束 -->
         
          
	     <table id="resultList" class="easyui-datagrid" style="width:100%;" title="成绩列表" toolbar="#toolbar" pagination="true"  data-options="fitColumns:true,singleSelect:true,collapsible:false,rownumbers:true">
			<thead>
				<tr>
					<th data-options="field:'studentid',align:'center',width:'10%'">学号</th>
					<th data-options="field:'banbie',align:'center',width:'10%'">班别</th>
					<th data-options="field:'name',align:'center',width:'10%'">姓名</th>
					<th data-options="field:'session',align:'center',width:'10%'">学期</th>
					<th data-options="field:'courseName',align:'center',width:'10%'">学科</th>
					<th data-options="field:'courseCode',align:'center',width:'10%'">代号</th>
					<th data-options="field:'period',align:'center',width:'10%'">课时</th>
					<th data-options="field:'credit',align:'center',width:'9%'">学分</th>
					<th data-options="field:'scores',align:'center',width:'9%'">分数</th>
					<th data-options="field:'remark',align:'center',width:'10%'">备注</th>
					
					
				</tr>
			</thead>
	    </table>
        <!-- result_list结束 -->
        
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
<script type="text/javascript">

	$(document).ready(function(){
		
		var session=null;
		
		//init
		setData(1, 15 ,session);
	
		//选择学期
		var eachp=$(".session");
		for(var i=0;i<eachp.length;i++)
		{
			eachp.eq(i).click(function(){
			      var s=$(this).text();
			      session=s;
			      setData(1, 15 ,session);
			});
		}
		
		$("#search").textbox().next("span").click(function(){
			setData(1, 15 ,session);
		});
		
			
	  function setData(pageNumber, pageSize ,session) {
			
			$.ajax({
				type : "POST",
				url : "get_result_list.json",
				data : {
					studentId : $("#search").val(),
					session : session,
					pageNumber : pageNumber,
					pageSize : pageSize
				},
				dataType : "json",
				success : function(result) {
					
					if (!result.errorCode) {
						if(result.data.total==0){
							//window.alert("抱歉，没有搜到你要的结果！");
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
											          setData(pageNumber,pageSize,session);
										}
							});
						}//end if(pg)
					}//end if(!result.errorCode)
				}//end success
			})//end ajax
		}//end setData	
	
	  //打印成绩
	   $("#print").click(function(){
		 window.location.href ="print_result.json?studentId="+$("#search").val()+"&session="+session;
	   });
		
		
		//数据校验模块
		var validateObj = {};
		$.extend(validateObj, {
			validate : function() {
				/* var shool = $("#shool").val();
				if (shool) {
					$.messager.alert('警告','学校必须输入','warning');
					return false;
				} */
				return true;
			}
		});

	});

</script>
</html>