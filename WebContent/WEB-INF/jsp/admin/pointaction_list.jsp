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
     		<td>动作名称:</td>
     		<td><input class="easyui-textbox" id="actionname" style="width:160px"></td>
			  <td><a href="#" id="search" class="easyui-linkbutton" iconCls="icon-search">查询</a></td>
		 </tr>
	 </table>
</div>
<div>
    <table id="pointActionList" class="easyui-datagrid" title="积分动作列表" style="width:100%" toolbar="#toolbar" pagination="true"  data-options="fitColumns:true,singleSelect:true,collapsible:false,rownumbers:true">
		
		     <div id="toolbar" style="height:auto">
				<div style="margin-bottom:5px">
					<a id="add" href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true">增加积分动作</a>
				</div>
		   </div>   
		 
		<thead>
			<tr>
				<th data-options="field:'actionname',align:'center',width:'24%'">动作名称</th>
				<th data-options="field:'point',align:'center',width:'24%'">积分</th>
				<th data-options="field:'description',align:'center',width:'24%'">描述</th>
				<th data-options="field:'operate',width:80,align:'center',formatter:formatOper,width:'26%'">操作</th>  
			</tr>
		</thead>
    </table>
</div>
</body>
<script type="text/javascript">


//操作列
function formatOper(val, row, index) {
		return '<a href="#" onclick="editPointAction(\''
				+ index
				+ '\',\'query\')">查看</a>&nbsp;&nbsp;<a href="#" onclick="editPointAction(\''
				+ index
				+ '\',\'edit\')">修改</a>&nbsp;&nbsp;<a href="#" onclick="editPointAction(\''
				+ index + '\',\'del\')" >删除</a>';
}


//编辑用户（包括查询、修改、删除）
function editPointAction(index, operType) {
		$('#pointActionList').datagrid('selectRow', index);
		var row = $('#pointActionList').datagrid('getSelected');
		if (row) {
			if (operType == 'query' || operType == 'edit') {
				var pageNumber = $('.pagination-num').val();
				window.location.href = "pointaction_edit.xhtml?operType="+ operType + "&id=" + row.id+"&pageNumber="+pageNumber;
			} else if (operType == 'del') {
				if (window.confirm('你确定要删除吗？')) {
					$.ajax({
						type : "POST",
						url : "delete_pointaction_by_id.json",
						data : {
							id :row.id
						},
						dataType : "json",
						success : function(result) {
							if (!result.errorCode) {
								window.alert("公告删除成功！");
								window.location = "pointaction_list.xhtml";
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
			url : "get_pointaction_list.json",
			data : {
				actionname : $("#actionname").val(),
				pageNumber : pageNumber,
				pageSize : pageSize
			},
			dataType : "json",
			success : function(result) {
				if (!result.errorCode) {
					if(result.data.total==0){
						window.alert("抱歉，没有搜到你要的结果！");
					}
					$("#pointActionList").datagrid("loadData", {
						"total" : result.data.total,
						"rows" : result.data.rows
					});
					var pg = $("#pointActionList").datagrid("getPager");
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
               window.location.href = "pointaction_edit.xhtml?operType=add";
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