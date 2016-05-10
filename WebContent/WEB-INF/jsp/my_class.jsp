 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <title>我的班级</title>
     <link rel="shortcut icon" href="./images/faviconz.ico" />
     <link rel="bookmark" href="./images/faviconz.ico" />
     <link rel="stylesheet" type="text/css" href="./css/main.css" >
     <link rel="stylesheet" type="text/css" href="./css/class.css" >
     <link rel="stylesheet" type="text/css" href="./easyui/themes/default/easyui.css">
     <link rel="stylesheet" type="text/css" href="./easyui/themes/icon.css">
     <script type="text/javascript" src="./easyui/jquery.min.js"></script>
     <script type="text/javascript" src="./easyui/jquery.easyui.min.js"></script>     
</head>
<body>
<jsp:include page="include/inc_header.jsp"/>
<div class="wrap">
<div  style="margin-top:18px;">    
  <div id="my_class" class="easyui-panel" title="你现在的位置   >> 我的班级" style="width:100%;height:700px;">
    <div id="class_logo">
    </div>
    <table id="warm">
      <tr>
        <td>学    院 : </td>
        <td>${classes.college}</td>
        <td>专 业 : </td>
        <td>${classes.major}</td>
      </tr>
       <tr>
        <td>班级名称 ：</td>
        <td>${classes.classname}</td>
        <td>班主任 : </td>
        <td>${classes.classadviser}</td>
      </tr>
       <tr>
        <td>人  数 : </td>
        <td>${classes.number}</td>
        <td>创建时间 : </td>
        <td>${classes.createdate}</td>
      </tr>
       <tr>
        <td>班级口号 : </td>
        <td>${classes.slogan}</td>
        <td>班级介绍 : </td>
        <td>${classes.introduce}</td>
      </tr>
       <tr>
        <td>荣  誉 : </td>
        <td>${classes.honour}</td>
        <td>荣 誉  : </td>
        <td>${classes.feature}</td>
      </tr>
    </table>
  </div>
</div>    
<!-- my_class结束 -->
</div>
<jsp:include page="include/inc_footer.jsp"/>
</body>
</html>