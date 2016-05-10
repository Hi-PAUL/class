 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title>相册墙</title>
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
	<div style="margin-top:18px;">    
	  <div id="my_class" class="easyui-panel" title="你现在的位置   >> 相片墙" style="width:100%;height:750px;">
	    <div id="toolbar" style="background:#F4F4F4">
	        <a id="add_album" href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="$('#w').window('open')">增加相册</a>
	        <div id="w" class="easyui-window" title="创建相册" closed="true" data-options="iconCls:'icon-save'" style="width:420px;height:250px;padding:5px 50px;">
		        <div class="easyui-layout" data-options="fit:true">
		            <div style="margin-bottom:20px">
				       <div>标 题：</div>
				       <input id="albumName"  class="easyui-textbox" data-options="prompt:'Enter a title...'" style="width:300px;height:32px">
				    </div>
				    <div style="margin-bottom:20px">
				       <div>介绍：</div>
				       <input id="albumDesc" class="easyui-textbox" data-options="prompt:'Enter the content...',multiline:true"  style="width:300px;height:70px">
				    </div>
		            <div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
		                <a id="create_album" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" href="javascript:void(0)" style="width:80px">发表</a>
		                <a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" href="javascript:void(0)" onclick="$('#w').window('close')" style="width:80px">取消</a>
		            </div>
		        </div>
			</div>
		   <!-- window结束-->
	    </div>
	   
	    <ul class="picList" id="picList">
	        <c:forEach items="${albumList}" var="list">
	            <li>
	              <img src="./images/icons/${list.imagefm}.jpg" />
	              <a href='photo.xhtml?albumid=${list.id}'>${list.albumname}<br/>
	                                     介绍 : ${list.albumdesc}<br/>
	                                     时间 : ${list.createdate}                              
	            </a>  
	            </li>
	        </c:forEach>
	    </ul>
	    <!--album_list结束 -->
	     
	  </div>
	</div>    
<!-- my_class结束 -->
</div> 
<jsp:include page="include/inc_footer.jsp"/>
</body>
<script type="text/javascript">
 $(document).ready(function(){
	
	  //创建相册
	   $("#create_album").click(function(){
		   if(!validateObj.validate()){
			 return false;
		   } 
			
		   $.ajax({
				url : "save_album.json",
				type : "POST",
				data : {
					albumname: $("#albumName").val(),
					albumdesc : $("#albumDesc").val()
				},
				dataType : "json",
				success : function(result) {
					if (!result.errorCode) {
						$('#w').window('close');
						$("#albumName").val("");
						$("#albumDesc").val("");
						$.messager.show({
			                title:'信息',
			                msg:'相册创建成功.',
			                timeout:5000,
			                showType:'slide'
			            });
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
				var albumName = $("#albumName").val();
				if (!albumName) {
					$.messager.alert("警告", "标题必须输入！");
					return false;
				}
				
				var albumDesc = $("#albumDesc").val();
				if (!albumDesc) {
					$.messager.alert("警告", "介绍必须输入！");
					return false;
				}
				
				return true;
			}
		});
	 
 });
 	
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