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
<div style="width:1000px;margin:100px auto;">
<div class="easyui-panel" title="你现在的位置   >> 加入班级" >
<div >
   <table>
		<tr>
     		<td>学院:</td>
     		<td><input class="easyui-textbox" id="college" style="width:146px"></td>
			<td>专业:</td>
			<td><input class="easyui-textbox" id="major" style="width:146px"></td>
			<td>班级:</td>
			<td><input class="easyui-textbox" id="classname" style="width:146px"></td>
			  <td><a href="#" id="search" class="easyui-linkbutton" iconCls="icon-search">查询</a></td>
		 </tr>
	 </table>
</div>
<div>
    <table id="classList" class="easyui-datagrid" title="班级列表" style="width:100%" toolbar="#toolbar" pagination="true"  data-options="fitColumns:true,singleSelect:true,collapsible:false,rownumbers:true">
		
		    <!-- <div id="toolbar" style="height:auto">
				<div style="margin-bottom:5px">
					<a id="add" href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true">增加班级</a>
				</div>
		   </div>   -->
		
		<thead>
			<tr>
				<th data-options="field:'college',align:'center',width:'9%'">学院</th>
				<th data-options="field:'major',align:'center',width:'7%'">专业</th>
				<th data-options="field:'classname',align:'center',width:'8%'">班级</th>
				<th data-options="field:'classadviser',align:'center',width:'9%'">班主任</th>
				<th data-options="field:'number',align:'center',width:'8%'">人数</th>
				<th data-options="field:'slogan',align:'center',width:'9%'">班级口号</th>
				<th data-options="field:'introduce',align:'center',width:'9%'">班级介绍</th>
				<th data-options="field:'honour',align:'center',width:'9%'">荣誉</th>
				<th data-options="field:'feature',align:'center',width:'9%'">特色</th>
				<th data-options="field:'createdate',align:'center',width:'9%'">创建时间</th>
				<th data-options="field:'operate',width:80,align:'center',formatter:formatOper,width:'13%'">操作</th>  
			</tr>
		</thead>
    </table>
</div>
</div>
</div>
</body>
<script type="text/javascript">


//操作列
function formatOper(val, row, index) {
		return '<a href="#" onclick="editClass(\''
				+ index
				+ '\',\'join\')">加入</a>';
}


//编辑用户（包括查询、修改、删除）
function editClass(index, operType) {
		$('#classList').datagrid('selectRow', index);
		var row = $('#classList').datagrid('getSelected');
		if (row) {
			if (operType == 'query' || operType == 'edit') {
				var pageNumber = $('.pagination-num').val();
				window.location.href = "class_edit.xhtml?operType="+ operType + "&id=" + row.id+"&pageNumber="+pageNumber;
			} else if (operType == 'join') {
				if (window.confirm('你确定要加入'+row.classname+'吗？')) {
					window.location.href = "join_class.xhtml?classId=" + row.id;
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
			url : "get_class_list.json",
			data : {
				college : $("#college").val(),
				major : $("#major").val(),
				classname : $("#classname").val(),
				pageNumber : pageNumber,
				pageSize : pageSize
			},
			dataType : "json",
			success : function(result) {
				
				if (!result.errorCode) {
					if(result.data.total==0){
						window.alert("抱歉，没有搜到你要的结果！");
					}
					$("#classList").datagrid("loadData", {
						"total" : result.data.total,
						"rows" : result.data.rows
					});
					var pg = $("#classList").datagrid("getPager");
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
               window.location.href = "class_edit.xhtml?operType=add";
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