<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title>个人空间</title>
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
  <div class="easyui-layout" style="margin-top:10px; width:1000px;height:1200px;">
       <div id="p" data-options="region:'west'" title="你现在的位置  : 唯空间 >> 个人空间" style="width:22%;padding:50px">
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
           <!--   <li><a href="#">上传头像</a></li>
             <li><a href="#">上传头像</a></li>
             <li><a href="#">上传头像</a></li> -->
             </ul>
           </div>
       </div>
       <!--West结束-->
        
       <div data-options="region:'center'" title="个人资料" style="padding:50px 200px">
         <div style="margin-bottom:20px">
            <div>学  校 :</div>
            <a href="#" class="easyui-linkbutton" style="width:100%;height:32px">${space.school}</a>
         </div>
         <div style="margin-bottom:20px">
            <div>学  院 :</div>
            <a href="#" class="easyui-linkbutton" style="width:100%;height:32px">${space.college}</a>
         </div>
         <div style="margin-bottom:20px">
            <div>专  业 :</div>
            <a href="#" class="easyui-linkbutton" style="width:100%;height:32px">${space.major}</a>
         </div>
         <div style="margin-bottom:20px">
            <div>班  别 :</div>
            <a href="#" class="easyui-linkbutton" style="width:100%;height:32px">${space.banbie}</a>
         </div>
         <div style="margin-bottom:20px">
            <div>学  号 :</div>
            <a href="#" class="easyui-linkbutton" style="width:100%;height:32px">${user.studentid}</a>
         </div>  
         <div style="margin-bottom:20px">
            <div>入学时间 :</div>
            <a href="#" class="easyui-linkbutton" style="width:100%;height:32px">${space.admissiondate}</a>
         </div>
         <div style="margin-bottom:20px">
            <div>出生日期 :</div>
            <a href="#" class="easyui-linkbutton" style="width:100%;height:32px">${space.birthday}</a>
         </div>
         <div style="margin-bottom:20px">
            <div>地  址 :</div>
            <a href="#" class="easyui-linkbutton" style="width:100%;height:32px">${space.address}</a>
         </div>
         <div style="margin-bottom:20px">
            <div>姓  名 :</div>
            <a href="#" class="easyui-linkbutton" style="width:100%;height:32px">${user.name}</a>
         </div>
         <div style="margin-bottom:20px">
            <div>QQ :</div>
            <a href="#" class="easyui-linkbutton" style="width:100%;height:32px">${user.qq}</a>
         </div>
         <div style="margin-bottom:20px">
            <div>电  话 :</div>
            <a href="#" class="easyui-linkbutton" style="width:100%;height:32px">${user.phone}</a>
         </div>
         <div style="margin-bottom:20px">
            <div>性  别 :</div>
            <c:if test="${user.sex==1}">
               <a href="#" class="easyui-linkbutton" style="width:100%;height:32px">男</a>
            </c:if>
            <c:if test="${user.sex==0}">
               <a href="#" class="easyui-linkbutton" style="width:100%;height:32px">女</a>
            </c:if>
         </div>
         <div style="margin-bottom:20px">
            <div>兴趣爱好 :</div>
            <a href="#" class="easyui-linkbutton" style="width:100%;height:32px">${space.hobbies}</a>
         </div>
         <div style="margin-bottom:20px">
            <div>个人介绍 :</div>
            <a href="#" class="easyui-linkbutton" style="width:100%;height:32px">${space.inttroduction}</a>
         </div>
         <div style="margin-bottom:20px">
            <div style="height:16px"></div>
            <a href="space_add.xhtml" id="save" class="easyui-linkbutton" iconCls="icon-ok" style="width:100%;height:32px">修改</a>
        </div>
      </div>
      <!--Center结束-->
    </div>
  <!--ad结束-->
  
</div>
<!--最外层wrap结束  -->
<jsp:include page="include/inc_footer.jsp"/>
</body>
</html>