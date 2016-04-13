<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="./easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="./easyui/themes/icon.css">
	<script type="text/javascript" src="./easyui/jquery.min.js"></script>
	<script type="text/javascript" src="./easyui/jquery.easyui.min.js"></script>
</head>

<body>
<div>
   <table>
		<tr>
     		<td>发布者:</td>
     		<td><input class="easyui-textbox" id="publisher" style="width:160px"></td>
			<td>标题:</td>
			<td><input class="easyui-textbox" id="title" style="width:160px"></td>
			  <td><a href="#" id="search" class="easyui-linkbutton" iconCls="icon-search">查询</a></td>
		 </tr>
	 </table>
</div>
<div>
    <table id="noticeList" class="easyui-datagrid" title="留言列表" style="width:100%" toolbar="#toolbar" pagination="true"  data-options="fitColumns:true,singleSelect:true,collapsible:false,rownumbers:true">
		
		     <div id="toolbar" style="height:auto">
				<div style="margin-bottom:5px">
					<a id="add" href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true">增加公告</a>
				</div>
		   </div>   
		 
		<thead>
			<tr>
				<th data-options="field:'publisher',align:'center',width:'16%'">发布者</th>
				<th data-options="field:'sex',align:'center',width:'16%'">性别</th>
				<th data-options="field:'title',align:'center',width:'16%'">标题</th>
				<th data-options="field:'content',align:'center',width:'16%'">内容</th>
				<th data-options="field:'dateline',align:'center',width:'16%'">发布时间</th>
				<th data-options="field:'operate',width:80,align:'center',formatter:formatOper,width:'20%'">操作</th>  
			</tr>
		</thead>
    </table>
</div>
</body>
<script type="text/javascript">


//操作列
function formatOper(val, row, index) {
		return '<a href="#" onclick="editNotice(\''
				+ index
				+ '\',\'query\')">查看</a>&nbsp;&nbsp;<a href="#" onclick="editNotice(\''
				+ index
				+ '\',\'edit\')">修改</a>&nbsp;&nbsp;<a href="#" onclick="editNotice(\''
				+ index + '\',\'del\')" >删除</a>';
}


//编辑用户（包括查询、修改、删除）
function editNotice(index, operType) {
		$('#noticeList').datagrid('selectRow', index);
		var row = $('#noticeList').datagrid('getSelected');
		if (row) {
			if (operType == 'query' || operType == 'edit') {
				var pageNumber = $('.pagination-num').val();
				window.location.href = "notice_edit.xhtml?operType="+ operType + "&id=" + row.id+"&pageNumber="+pageNumber;
			} else if (operType == 'del') {
				if (window.confirm('你确定要删除吗？')) {
					$.ajax({
						type : "POST",
						url : "delete_notice_by_id.json",
						data : {
							id :row.id
						},
						dataType : "json",
						success : function(result) {
							if (!result.errorCode) {
								window.alert("公告删除成功！");
								window.location = "notice_list.xhtml";
							}
						}
					})
				} else {
					return false;
				}
			}
		}
	}


//定义数据对象
var dataObj = {};
$.extend(dataObj, {
	setData : function(pageNumber, pageSize) {
		
		$.ajax({
			type : "POST",
			url : "find_notice_list.json",
			data : {
				publisher : $("#publisher").val(),
				title : $("#title").val(),
				pageNumber : pageNumber,
				pageSize : pageSize
			},
			dataType : "json",
			success : function(result) {
				if (!result.errorCode) {
					if(result.data.total==0){
						window.alert("抱歉，没有搜到你要的结果！");
					}
					$("#noticeList").datagrid("loadData", {
						"total" : result.data.total,
						"rows" : result.data.rows
					});
					var pg = $("#noticeList").datagrid("getPager");
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


//定event事件
var eventObj = {};
    $.extend(eventObj,{
      	bindEvent : function(){
      		$("#search").click(function(){
      			dataObj.setData(1, 15);
            });
             $("#add").click(function(){
               window.location.href = "notice_edit.xhtml?operType=add";
            }); 
    }
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