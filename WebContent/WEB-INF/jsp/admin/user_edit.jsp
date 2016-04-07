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
<style type="text/css">
	td{
	height:32px;
	}
</style>
<body>
<div style="margin-left:20px;margin-top:20px;">
      <a href="user_list.xhtml?pageNumber=${pageNumber}">用户列表</a><span>>></span>
	      <c:if test="${operType=='add'}">增加用户</c:if>
	      <c:if test="${operType=='query'}">查看用户</c:if>
	      <c:if test="${operType=='edit'}">修改用户</c:if>
</div>
<div style="margin-left:20px;margin-top:20px;">
	<form>
	   <table>
	   		 <tr>
				<td> <label>用户名称:</label></td>
	       		<td><input id="username" class="easyui-textbox" data-options="prompt:'Enter a information...'" style="width:200px" <c:if test="${operType == 'query'||operType == 'edit'}">readonly</c:if> />
	       		</td>
	   	     </tr>
	   	     
		      <tr>
	        	<td><label>性别:</label></td>
	       		<td><select id="sex" class="easyui-combobox" panelHeight="auto" style="width:200px" <c:if test="${operType == 'query'}">disabled</c:if>>
	          			<option value="1">男</option>
	          			<option value="0">女</option>
	        		</select>
	        	</td>
		     </tr>
		     
		      <tr>
				<td> <label>QQ:</label></td>
	       		<td><input id="qq" class="easyui-textbox" data-options="prompt:'Enter a information...'" style="width:200px" <c:if test="${operType == 'query'}">readonly</c:if> />
	       		</td>
	   	     </tr>
	         
	         <tr>
				<td> <label>电话号码:</label></td>
	       		<td><input id="phone" class="easyui-textbox" data-options="prompt:'Enter a information...'" style="width:200px" <c:if test="${operType == 'query'}">readonly</c:if> />
	       		</td>
	   	     </tr>
	   	     
	   	     <tr>
				<td> <label>电子邮件:</label></td>
	       		<td><input id="email" class="easyui-textbox" data-options="prompt:'Enter a information...'" style="width:200px" <c:if test="${operType == 'query'}">readonly</c:if> />
	       		</td>
	   	     </tr>
	   	     	     
		     <tr>
	        	<td><label>账号状态:</label></td>
	       		<td><select id="status" class="easyui-combobox" panelHeight="auto" style="width:200px" <c:if test="${operType == 'query'}">disabled</c:if>>
	       		        <option value="0">未激活</option>
	          			<option value="1">在线</option>
	          			<option value="2">离线</option>
	        		</select>
	        	</td>
		     </tr>
		     
		     <tr>
				<td> <label>用户积分:</label></td>
	       		<td><input id="point" class="easyui-textbox" data-options="prompt:'Enter a information...'" style="width:200px" <c:if test="${operType == 'query'}">readonly</c:if> />
	       		</td>
	   	     </tr>
	   	     
		     <tr>
				<td> <label>姓名:</label></td>
	       		<td><input id="name" class="easyui-textbox" data-options="prompt:'Enter a information...'" style="width:200px" <c:if test="${operType == 'query'}">readonly</c:if> />
	       		</td>
	   	     </tr>
	   	     
	   	     <tr>
				<td> <label>学号:</label></td>
	       		<td><input id="studentid" class="easyui-textbox" data-options="prompt:'Enter a information...'" style="width:200px" <c:if test="${operType == 'query'}">readonly</c:if> />
	       		</td>
	   	     </tr>
	   	     
	  	   <tr>
		     <td> <input type="button" id="save" name="save" value="保存" <c:if test="${operType=='query'}">style="display:none;"</c:if> />
		    <input type="button" id="return" name="return" value="返回"  />
		    </td>
		   </tr>
	    </table>
	</form>
</div>
</body>
<script type="text/javascript">
	(function() {

		//初始化模块
		var initObj = {};
		$.extend(initObj, {
			init : function() {
				var id= "${id}";
				if(id){
					dataObj.loadData(id);
				}
				btnObj.bindEvent();
			}
		});

		//按钮事件
		var btnObj = {};
		$.extend(btnObj, {
			bindEvent : function() {
				$("#save").click(function() {
					var operType="${operType}";
					var operName="";
					if(operType=="add"){
						operName = "添加";
					}else{
						operName = "修改";
					}
					/* if(!validateObj.validate()){
						return false;
					} */
					$.ajax({
						url : "insert_user_info.json",
						type : "POST",
						data : {
							id : "${id}",
							username : $("#username").val(),
							sex : $("#sex").combobox("getValue"),
							qq : $("#qq").val(),
							phone : $("#phone").val(),
							email : $("#email").val(),
							status : $("#status").combobox("getValue"),
							point : $("#point").val(),
							name : $("#name").val(),
							studentid : $("#studentid").val()
						},
						dataType : "json",
						success : function(result) {
							if (!result.errorCode) {
								alert("用户"+operName+"成功！");
								window.location = "user_list.xhtml?pageNumber=${pageNumber}";
							}else{
								alert(result.errorMsg);
							}
						}
					});
				});
				$("#return").click(function(){
				   window.location = "user_list.xhtml?pageNumber=${pageNumber}";
				});
			}
		});
		
		//数据模块
		var dataObj = {};
		$.extend(dataObj,{
			loadData : function(id){
				var operType="${operType}";
				$.ajax({
					type : "POST",
					url : "get_user_by_id.json",
					data : {
						id :id
					},
					dataType : "json",
					success : function(result) {
						if (!result.errorCode) {
							var data = result.data;
							$("#username").textbox("setValue",data.username);
							$("#sex").combobox("setValue",data.sex);
							$("#qq").textbox("setValue",data.qq);
							$("#phone").textbox("setValue",data.phone);
							$("#email").textbox("setValue",data.email);
							$("#status").combobox("setValue",data.status);
							$("#point").textbox("setValue",data.point);
							$("#name").textbox("setValue",data.name);
							$("#studentid").textbox("setValue",data.studentid);
						}
					}

				})
			}
		});
		
		
		//数据校验模块
		/* var validateObj = {};
		$.extend(validateObj,{
			validate : function(){
				var applicationId = $("#applicationId").val();
				if(!applicationId){
					$.messager.alert("警告","应用ID必须输入！");
					return false;
				}
				if(applicationId.length!=2){
					$.messager.alert("警告","应用ID长度必须是2位！");
					return false;
				}
				var reg =/[A-Z]{2}/;
			    if (!reg.test(applicationId)) {
				    $.messager.alert("警告","应用ID必须为两位大写字母简写！");
				    return false;
			      }
				var applicationName = $("#applicationName").val();
				if(!applicationName){
					$.messager.alert("警告","应用名称必须输入！");
					return false;
				}
				var businessGroupId = $("#businessGroupId").combobox("getValue");
				if(!businessGroupId){
					$.messager.alert("警告","请选择业务组ID！");
					return false;
				}
				return true;
			}
		}); */

		//初始化
		$(document).ready(function() {
			initObj.init();
		});
	})();
</script>
</html>