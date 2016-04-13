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
      <a href="change_adminPassword.xhtml">登陆管理</a><span>>></span>
	     修改密码
</div>
<div style="margin-left:20px;margin-top:20px;">
	<form>
	   <table>
	   		 <tr>
				<td> <label>原密码:</label></td>
	       		<td><input id="oldpassword" class="easyui-textbox" data-options="prompt:'Enter a information...'" style="width:200px"  />
	       		</td>
	   	     </tr>
	   	     
		      <tr>
	        	<td><label>新密码:</label></td>
	       		<td><input id="newpassword" class="easyui-textbox" data-options="prompt:'Enter a information...'" style="width:200px"  />
	        	</td>
		     </tr>
		     
		      <tr>
				<td> <label>确认密码:</label></td>
	       		<td><input id="lastpassowrd" class="easyui-textbox" data-options="prompt:'Enter a information...'" style="width:200px" />
	       		</td>
	   	     </tr>
	   	     
	  	   <tr>
		     <td> <input type="button" id="save" name="save" value="保存" />
		   <!--  <input type="button" id="return" name="return" value="返回"  /> -->
		    </td>
		   </tr>
	    </table>
	</form>
</div>
</body>
<script type="text/javascript">
	(function() {

				$("#save").click(function() {
					 /* if(!validateObj.validate()){
						return false;
					}  */
					$.ajax({
						url : "save_admin_password.json",
						type : "POST",
						data : {
							id : "${id}",
							oldpassword : $("#oldpassword").val(),
							newpassword : $("#newpassword").val()
						},
						dataType : "json",
						success : function(result) {
							if (!result.errorCode) {
								alert("密码修改成功！");
								//window.location = "admin_home.xhtml";
							}else{
								alert(result.errorMsg);
							}
						}
					});
				});
				
				$("#return").click(function(){
				  // window.location = "admin_home.xhtml";
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

	})();
</script>
</html>