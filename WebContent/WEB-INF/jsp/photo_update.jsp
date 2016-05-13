 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<head>
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <title>班级相片</title>
     <link rel="shortcut icon" href="./images/faviconz.ico" />
     <link rel="bookmark" href="./images/faviconz.ico" />
     <link rel="stylesheet" type="text/css" href="./css/main.css" >
     <link rel="stylesheet" type="text/css" href="./css/album.css" >
     <link rel="stylesheet" type="text/css" href="./easyui/themes/default/easyui.css">
     <link rel="stylesheet" type="text/css" href="./easyui/themes/icon.css">
     <script type="text/javascript" src="./easyui/jquery.min.js"></script>
     <script type="text/javascript" src="./easyui/jquery.easyui.min.js"></script>
     <script type="text/javascript" src="./js/jquery-form.js"></script>     
</head>
<body>
<jsp:include page="include/inc_header.jsp"/>
<div class="wrap">
<div  style="margin-top:10px;">    
  <div id="my_class" class="easyui-panel" title="你现在的位置  : 相片墙 >> 增加相片" style="width:100%;height:750px;">
    <div id="toolbar" style="background:#F4F4F4">
        <a href="javascript:history.go(-1);" class="easyui-linkbutton" iconCls="icon-undo" plain="true" >返回</a>
    </div>    
        <div style="width:300px;margin:30px auto;">
        <form id="from" action="save_photo.action" method="post" enctype="multipart/form-data" onsubmit="return check()"> 
            <div style="margin-bottom:15px"> 
		       <div>相 片：</div>
		       <input id="photofile" name="photofile" value="" class="easyui-filebox"  data-options="prompt:'Choose a file...'" style="width:300px;height:32px">
		    </div>
            <div style="margin-bottom:15px">
		       <div>标 题：</div>
		       <input id="title" name="title" value="" class="easyui-textbox" data-options="prompt:'Enter a title...'" style="width:300px;height:32px">
		    </div>
		    <div style="margin-bottom:15px">
		       <div>介 绍：</div>
		       <input id="contents" name="contents" value="" class="easyui-textbox" data-options="prompt:'Enter the content...',multiline:true"  style="width:300px;height:70px">
		    </div>
            <div data-options="region:'south',border:false" style="text-align:left;padding:5px 0 0;">
                <input type="hidden" id="albumid" name="albumid" value="${albumid}"/>
                <a id="save_photo" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" style="width:80px">确定</a>
            </div>
	   </form>
	   </div>
	   <!-- window结束-->
      
  </div>
</div>    
<!-- my_class结束 -->
  
<jsp:include page="include/inc_footer.jsp"/>
</body>
<script type="text/javascript">
 $(document).ready(function(){
	 
	 $("#save_photo").click(function(){
		if(check){
		$("#from").submit();
		}			
	 });
	 
 });
 
   //数据校验模块
   function check() {
		var title = $("#title").val();
		if (!title) {
			$.messager.alert("警告", "标题必须输入！");
			return false;
		}
		
		var contents = $("#contents").val();
		if (!contents) {
			$.messager.alert("警告", "介绍必须输入！");
			return false;
		}
		return true;
	 }	
</script>
</html>