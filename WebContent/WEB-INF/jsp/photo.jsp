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
</head>
<body>
<jsp:include page="include/inc_header.jsp"/>
<div class="wrap">
<div  style="margin-top:10px;">    
  <div id="my_class" class="easyui-panel" title="你现在的位置  : 相片墙 >> 班级相片" style="width:100%;height:750px;">
    <div id="toolbar" style="background:#F4F4F4">
        <a id="add_album" href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="$('#w').window('open')">增加相片</a>
        <a href="javascript:history.go(-1);" class="easyui-linkbutton" iconCls="icon-undo" plain="true" >返回</a>
        
        <form id="from" action="save_photo.action" method="post" enctype="multipart/form-data" onsubmit="return check()"> 
           <div id="w" class="easyui-window" title="创建相册" closed="true" data-options="iconCls:'icon-save'" style="width:420px;height:310px;padding:5px 50px;">
	        <div class="easyui-layout" data-options="fit:true">
	            <div style="margin-bottom:15px"> <!--  class="easyui-filebox" -->
			       <div>相 片：</div>
			       <input id="photofile"  class="easyui-filebox"  data-options="prompt:'Choose a file...'" style="width:300px;height:32px">
			    </div>
	            <div style="margin-bottom:15px">
			       <div>标 题：</div>
			       <input id="title" name="title" class="easyui-textbox" data-options="prompt:'Enter a title...'" style="width:300px;height:32px">
			    </div>
			    <div style="margin-bottom:15px">
			       <div>介 绍：</div>
			       <input id="contents" name="contents" class="easyui-textbox" data-options="prompt:'Enter the content...',multiline:true"  style="width:300px;height:70px">
			    </div>
	            <div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
	                <input type="hidden" name="albumid" value="${albumid}"/>
	                <a id="save_photo" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" style="width:80px">确定</a>
	                <a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" href="javascript:void(0)" onclick="$('#w').window('close')" style="width:80px">取消</a>
	            </div>
	        </div>
		  </div>
	   </form>
	   <!-- window结束-->
    </div>
   
    <ul class="picList" id="picList">
        <c:forEach items="${photoList}" var="list">
            <li>
              <img src="./images/icons/${list.path}.jpg" />
              <a href='#'>${list.title}<br/>
                                     介绍 : ${list.contents}<br/>
                                     相册: ${list.albumname}<br/>                      
                                     时间 : ${list.pubdate}                              
            </a>  
            </li>
        </c:forEach>
    </ul>
    <!--album_list结束 -->
     
  </div>
</div>    
<!-- my_class结束 -->
  
<jsp:include page="include/inc_footer.jsp"/>
</body>
<script type="text/javascript">
 $(document).ready(function(){
	 
	 /* $('#photofile').change(function() { 
		 alert();
		 var formdata = new FormData(); 
		 var v_this = $(this); 
		 var fileObj = v_this.get(0).files; 
		 formdata.append("imgFile", fileObj[0]); 
	 }); */
	
	 $("#save_photo").click(function(){
		// alert();
		$("#from").submit();
		
		
		
		
		
		
		
		
		
		
		
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

 	
 function imgDisplay(){
	var Div = document.getElementById('picList').getElementsByTagName('li');
	var divHeight = 160;
	for(var i =0 ;i<Div.length;i++){
		Div[i].onmouseover = showMeg;
		Div[i].onmouseout = hideMeg;
		}
	function showMeg(){
		this.getElementsByTagName('a')[0].style.top = 0;
		}
	function hideMeg(){
		this.getElementsByTagName('a')[0].style.top = divHeight+'px';
		}
   }
	imgDisplay();
	
</script>
</html>