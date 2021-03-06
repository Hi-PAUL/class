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
      <table id="messageList" class="easyui-datagrid" title="资讯列表" style="width:100%" toolbar="#toolbar" pagination="true"  data-options="fitColumns:true,singleSelect:true,collapsible:false,rownumbers:true">  
		<thead>
			<tr>
				<th data-options="field:'title',align:'center',width:'40%'">标题</th>
				<th data-options="field:'publisher',align:'center',width:'19%'">作者</th>
				<th data-options="field:'dateline',align:'center',width:'19%'">发布时间</th>
				<th data-options="field:'operate',width:80,align:'center',formatter:formatOper,width:'20%'">操作</th>  
			</tr>
		</thead>
    </table>
 <!--  </div> -->
</div>
</div>
<!--最外层wrap结束  -->
<jsp:include page="../include/inc_footer.jsp"/>
</body>
<script type="text/javascript">


//操作列
function formatOper(val, row, index) {
		return '<a href="#" onclick="editmessage(\''
				+ index
				+ '\',\'query\')">查看</a>';
}


//编辑用户（包括查询、修改、删除）
function editmessage(index, operType) {
		$('#messageList').datagrid('selectRow', index);
		var row = $('#messageList').datagrid('getSelected');
		if (row) {
			if (operType == 'query' ) {
				window.location.href ="info_news.xhtml?id="+row.id;
			} 
		}
	}


//定义数据对象
var dataObj = {};
$.extend(dataObj, {
	setData : function(pageNumber, pageSize) {
		
		$.ajax({
			type : "POST",
			url : "find_news_list.json",
			data : {
				node : "新闻",
				pageNumber : pageNumber,
				pageSize : pageSize
			},
			dataType : "json",
			success : function(result) {
				if (!result.errorCode) {
					if(result.data.total==0){
						window.alert("抱歉，没有搜到你要的结果！");
					}
					$("#messageList").datagrid("loadData", {
						"total" : result.data.total,
						"rows" : result.data.rows
					});
					var pg = $("#messageList").datagrid("getPager");
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
										dataObj.setData(pageNumber,pageSize);
									}
						});
					}//end if(pg)
				}//end if(!result.errorCode)
			}//end success
		})//end ajax
	}//end setData
});


//初始化对象
var initObj = {};
$.extend(initObj, {
   init : function() {
      	  var pageNumber = "${pageNumber}";
      	  if((pageNumber == null) || (pageNumber == "") || (pageNumber == undefined)){
      	  	   dataObj.setData(1,15);
      	  }else{
      		   dataObj.setData(pageNumber, 15);
      	  }
      	  eventObj.bindEvent();
   }
});
  

//初始化
$(document).ready(function() {
      	initObj.init();
});
</script>

</html>