<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" import="com.hisun.common.bean.Space"%>

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
<jsp:include page="include/inc_header.jsp"/>
<div class="wrap">
  <div class="easyui-layout" style="margin-top:18px; width:1000px;height:1280px;">
       <div id="p" data-options="region:'west'" title="你现在的位置  : 唯空间 >> 创建空间" style="width:22%;padding:50px">
           <div style="margin-bottom:20px">
             <a href="space_icon.xhtml"><img alt="点击上传头像" src="./images/icons/${user.username}.jpg" style="width: 100px;height: 100px"></a>
           </div>
           <div class="username" style="margin-bottom:10px">
             <a href="#">Hi,${user.username}</a>
           </div>
            <div class="username" style="margin-bottom:10px">
             <a href="#">积分 : ${user.point}</a>
           </div>
           <div style="margin-bottom:25px">
             <ul class="message_list" >
             <li style="background-image: url('./images/space_1.jpg');"></li>
             <!-- <li><a href="#">上传头像</a></li>
             <li><a href="#">上传头像</a></li>
             <li><a href="#">上传头像</a></li> -->
             </ul>
           </div>
       </div>
       <!--West结束-->
        
       <div data-options="region:'center'" title="填写资料" style="padding:50px 200px">
         <div style="margin-bottom:20px">
            <div>学  校 :</div>
            <input id="spaceId" type="hidden" class="easyui-textbox"  value="${space.id}" style="width:0;height:0">
            <input id="school" class="easyui-textbox" data-options="prompt:'Enter a information...'" style="width:100%;height:32px">
         </div>
         <div style="margin-bottom:20px">
            <div>学  院 :</div>
            <input id="college" class="easyui-textbox" data-options="prompt:'Enter a information...'" style="width:100%;height:32px">
         </div>
         <div style="margin-bottom:20px">
            <div>专  业 :</div>
            <input id="major" class="easyui-textbox" data-options="prompt:'Enter a information...'" style="width:100%;height:32px">
         </div>
         <div style="margin-bottom:20px">
            <div>班  别 :</div>
            <input id="banbie" class="easyui-textbox" data-options="prompt:'Enter a information...'" style="width:100%;height:32px">
         </div>
         <div style="margin-bottom:20px">
            <div>学  号 :</div>
            <input id="studentId" class="easyui-textbox" data-options="prompt:'Enter a information...'" style="width:100%;height:32px">
         </div>  
         <div style="margin-bottom:20px">
            <div>入学时间 :</div>
            <input id="admissionDate" class="easyui-datebox" data-options="prompt:'Enter a information...'" style="width:100%;height:32px">
         </div>
         <div style="margin-bottom:20px">
            <div>出生日期 :</div>
            <input id="birthday" class="easyui-datebox" data-options="prompt:'Enter a information...'" style="width:100%;height:32px">
         </div>
         <div style="margin-bottom:20px">
            <div>地 址:</div>
            <input id="address" class="easyui-textbox" data-options="prompt:'Enter a information...'" style="width:100%;height:32px">
         </div>
         <div style="margin-bottom:20px">
            <div>姓  名 :</div>
            <input id="name" class="easyui-textbox" data-options="prompt:'Enter a information...'" style="width:100%;height:32px">
         </div>
         <div style="margin-bottom:20px">
            <div>QQ :</div>
            <input id="qq" class="easyui-textbox" data-options="prompt:'Enter a information...'" style="width:100%;height:32px">
         </div>
         <div style="margin-bottom:20px">
            <div>电  话 :</div>
            <input id="phone" class="easyui-textbox" data-options="prompt:'Enter a information...'" style="width:100%;height:32px">
         </div>
         <div style="margin-bottom:20px">
            <div>性  别 :</div>
             <select id="sex" class="easyui-combobox"  style="width:100%;height:32px">
                <option value="1">男</option>
                <option value="0">女</option>
             </select>
         </div>
         <div style="margin-bottom:20px">
            <div>兴趣爱好 :</div>
            <input id="hobbies" class="easyui-textbox" data-options="prompt:'Enter a information...',multiline:true" style="width:100%;height:64px">
         </div>
         <div style="margin-bottom:20px">
            <div>个人介绍 :</div>
            <input id="inttroduction" class="easyui-textbox" data-options="prompt:'Enter a information...',multiline:true" style="width:100%;height:64px">
         </div>
         <div>
            <a href="#" id="save" class="easyui-linkbutton" iconCls="icon-ok" style="width:49%;height:32px">保存</a>
            <a href="javascript:history.go(-1);" id="quit" class="easyui-linkbutton" iconCls="icon-ok" style="width:49%;height:32px">取消</a>
        </div>
      </div>
      <!--Center结束-->
    </div>
  <!--ad结束-->
  
</div>
<!--最外层wrap结束  -->
<jsp:include page="include/inc_footer.jsp"/>
</body>
<script type="text/javascript">
	$(document).ready(function(){
		
		$.ajax({
			url : "get_space_info.json",
			type : "POST",
		    success : function(result) {
			if (!result.errorCode) {
				var data = result.data;
				$("#spaceId").textbox("setValue",data.id);
				$("#school").textbox("setValue",data.school);
				$("#college").textbox("setValue",data.college);
				$("#major").textbox("setValue",data.major);
				$("#banbie").textbox("setValue",data.banbie);
				$("#studentId").textbox("setValue",'${user.studentid}');
				$("#admissionDate").datebox("setValue",data.admissiondate);
				$("#birthday").datebox("setValue",data.birthday);
				$("#address").textbox("setValue",data.address);
				$("#name").textbox("setValue",'${user.name}');
				$("#qq").textbox("setValue",'${user.qq}');
				$("#phone").textbox("setValue",'${user.phone}');
				$("#sex").combobox('setValue','${user.sex}');
				$("#hobbies").textbox("setValue",data.hobbies);
				$("#inttroduction").textbox("setValue",data.inttroduction);
			} else {
				alert(result.errorMsg);
			}
		  }
		});
		
		
	  $("#save").click(function(){
		 if(!validateObj.validate()){
			return false;
		} 
		
	   $.ajax({
			url : "save_space_info.json",
			type : "POST",
			data : {
				id : $("#spaceId").val(),
				school : $("#school").val(),
				college: $("#college").val(),
				major: $("#major").val(),
				banbie: $("#banbie").val(),
				studentId: $("#studentId").val(),
				admissionDate: $("#admissionDate").datebox('getValue'),
				birthday: $("#birthday").datebox('getValue'),
				address: $("#address").val(),
				name: $("#name").val(),
				qq: $("#qq").val(),
				phone: $("#phone").val(),
				sex: $("#sex").combobox('getValue'),
				hobbies: $("#hobbies").val(),
				inttroduction: $("#inttroduction").val()
			},
			dataType : "json",
			success : function(result) {
				if (!result.errorCode) {
					window.location.href = "space_show.xhtml";
				} else {
					alert(result.errorMsg);
				}
			 }
		 });
	});

		//数据校验模块
		var validateObj = {};
		$.extend(validateObj, {
			validate : function() {
				var shool = $("#shool").val();
				if (shool) {
					$.messager.alert('警告','学校必须输入','warning');
					return false;
				}
				return true;
			}
		});

	});
</script>
</html>