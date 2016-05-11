 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title>通讯录</title>
   <link rel="shortcut icon" href="./images/faviconz.ico"/>
   <link rel="bookmark" href="./images/faviconz.ico"/>
   <link rel="stylesheet" type="text/css" href="./css/main.css" >
   <link rel="stylesheet" type="text/css" href="./css/space.css" >
   <link rel="stylesheet" type="text/css" href="./easyui/themes/default/easyui.css">
   <link rel="stylesheet" type="text/css" href="./easyui/themes/icon.css">
   <script type="text/javascript" src="./easyui/jquery.min.js"></script>
   <script type="text/javascript" src="./easyui/jquery.easyui.min.js"></script>      
</head>
<body>
<jsp:include page="include/inc_header.jsp"/>
<div class="wrap">       
	<table id="resultList" class="easyui-datagrid" style="width:100%;" title="你现在的位置   >> 通讯录" toolbar="#toolbar" pagination="true"  data-options="fitColumns:true,singleSelect:true,collapsible:false,rownumbers:true">
	  <thead>
		<tr>
	      <th data-options="field:'username',align:'center',width:'11%'">账号</th>
		  <th data-options="field:'name',align:'center',width:'11%'">姓名</th>
		  <th data-options="field:'sex',align:'center',width:'10%'">性别</th>
		  <th data-options="field:'qq',align:'center',width:'11%'">QQ</th>
		  <th data-options="field:'phone',align:'center',width:'11%'">电话</th>
		  <th data-options="field:'email',align:'center',width:'11%'">邮箱</th>
		  <th data-options="field:'point',align:'center',width:'11%'">用户积分</th>
		  <th data-options="field:'studentid',align:'center',width:'11%'">学号</th>
		  <th data-options="field:'registerdate',align:'center',width:'11%'">注册时间</th>
		</tr>
	  </thead>
	</table>
<!-- result_list结束 -->
</div>
<jsp:include page="include/inc_footer.jsp"/>
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