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
     		<td>学 号:</td>
     		<td><input class="easyui-textbox" id="studentid" style="width:146px"></td>
			<td>班 级:</td>
			<td><input class="easyui-textbox" id="banbie" style="width:146px"></td>
			<td>课程名称:</td>
			<td><input class="easyui-textbox" id="coursename" style="width:146px"></td>
			  <td><a href="#" id="search" class="easyui-linkbutton" iconCls="icon-search">查询</a></td>
		 </tr>
	 </table>
</div>
<div>
    <table id="resultList" class="easyui-datagrid" title="成绩列表" style="width:100%" toolbar="#toolbar" pagination="true"  data-options="fitColumns:true,singleSelect:true,collapsible:false,rownumbers:true">
		
		    <div id="toolbar" style="height:auto">
				<div style="margin-bottom:5px">
					<a id="add" href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true">增加成绩</a>
				</div>
		   </div>  
		
		<thead>
			<tr>
				<th data-options="field:'studentid',align:'center',width:'9%'">学号</th>
				<th data-options="field:'banbie',align:'center',width:'7%'">班级</th>
				<th data-options="field:'name',align:'center',width:'9%'">姓名</th>
				<th data-options="field:'session',align:'center',width:'9%'">学期</th>
				<th data-options="field:'coursename',align:'center',width:'8%'">课程名称</th>
				<th data-options="field:'coursecode',align:'center',width:'9%'">课程代号</th>
				<th data-options="field:'period',align:'center',width:'9%'">课时</th>
				<th data-options="field:'credit',align:'center',width:'8%'">学分</th>
				<th data-options="field:'scores',align:'center',width:'9%'">分数</th>
				<th data-options="field:'remark',align:'center',width:'9%'">备注</th>
				<th data-options="field:'operate',width:80,align:'center',formatter:formatOper,width:'13%'">操作</th>  
			</tr>
		</thead>
    </table>
</div>
</body>
<script type="text/javascript">


//操作列
function formatOper(val, row, index) {
		return '<a href="#" onclick="editResult(\''
				+ index
				+ '\',\'query\')">查看</a>&nbsp;&nbsp;<a href="#" onclick="editResult(\''
				+ index
				+ '\',\'edit\')">修改</a>&nbsp;&nbsp;<a href="#" onclick="editResult(\''
				+ index + '\',\'del\')" >删除</a>';
}


//编辑用户（包括查询、修改、删除）
function editResult(index, operType) {
		$('#resultList').datagrid('selectRow', index);
		var row = $('#resultList').datagrid('getSelected');
		if (row) {
			if (operType == 'query' || operType == 'edit') {
				var pageNumber = $('.pagination-num').val();
				window.location.href = "result_edit.xhtml?operType="+ operType + "&id=" + row.id+"&pageNumber="+pageNumber;
			} else if (operType == 'del') {
				if (window.confirm('你确定要删除吗？')) {
					$.ajax({
						type : "POST",
						url : "delete_result_by_id.json",
						data : {
							id :row.id
						},
						dataType : "json",
						success : function(result) {
							if (!result.errorCode) {
								window.alert("成绩删除成功！");
								window.location = "result_list.xhtml";
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
			url : "find_result_list.json",
			data : {
				studentid : $("#studentid").val(),
				banbie : $("#banbie").val(),
				coursename : $("#coursename").val(),
				pageNumber : pageNumber,
				pageSize : pageSize
			},
			dataType : "json",
			success : function(result) {
				
				if (!result.errorCode) {
					if(result.data.total==0){
						window.alert("抱歉，没有搜到你要的结果！");
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
               window.location.href = "result_edit.xhtml?operType=add";
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