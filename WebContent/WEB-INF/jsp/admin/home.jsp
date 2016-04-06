<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>班级网后台管理系统</title>
	<link rel="shortcut icon" href="./images/faviconz.ico" />
    <link rel="bookmark" href="./images/faviconz.ico" />
	<link rel="stylesheet" type="text/css" href="./css/admin.css">
	<link rel="stylesheet" type="text/css" href="./easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="./easyui/themes/icon.css">
	<script type="text/javascript" src="./easyui/jquery.min.js"></script>
	<script type="text/javascript" src="./easyui/jquery.easyui.min.js"></script>
</head>
<body >
	<div class="easyui-layout" style="width:100%; height:650px;">
		<div data-options="region:'north'" style="height: 100px">
		   <div id="title">班级网后台管理系统</div>
		</div>
		<!-- title结束 -->
		
		<div data-options="region:'west',split:true" title="菜单" style="width:20%;padding:5px 20px">
		    <ul id="tree" class="easyui-tree">
            <li>
                <span>菜单导航</span>
                <ul>
                    <li data-options="state:'closed'">
                        <span>人员管理</span>
                        <ul>
                            <li><a href="admin_list.xhtml" target="mainframe">人员列表</a></li>
                            <li><a href="admin_edit.xhtml?operType=add" target="mainframe">增加人员</a></li>
                        </ul>
                    </li>
                    
                    <li data-options="state:'closed'">
                        <span>用户管理</span>
                        <ul>
                            <li><a href="#" target="mainframe">Friend</a></li>
                            <li><a href="#" target="mainframe">Friend</a></li>
                            <li><a href="#" target="mainframe">Friend</a></li>
                        </ul>
                    </li>
                    
                    <li data-options="state:'closed'">
                        <span>成绩管理</span>
                        <ul>
                            <li><a href="#" target="mainframe">Friend</a></li>
                            <li><a href="#" target="mainframe">Friend</a></li>
                            <li><a href="#">Friend</a></li>
                        </ul>
                    </li>
                    
                    <li data-options="state:'closed'">
                        <span>班级管理</span>
                        <ul>
                            <li><a href="#" target="mainframe">Friend</a></li>
                            <li><a href="#" target="mainframe">Friend</a></li>
                            <li><a href="#">Friend</a></li>
                        </ul>
                    </li>
                    
                    <li data-options="state:'closed'">
                        <span>相片管理</span>
                        <ul>
                            <li><a href="#" target="mainframe">Friend</a></li>
                            <li><a href="#" target="mainframe">Friend</a></li>
                            <li><a href="#">Friend</a></li>
                        </ul>
                    </li>
                    
                     <li data-options="state:'closed'">
                        <span>留言管理</span>
                        <ul>
                            <li><a href="#" target="mainframe">Friend</a></li>
                            <li><a href="#" target="mainframe">Friend</a></li>
                            <li><a href="#">Friend</a></li>
                        </ul>
                    </li>
                    
                    <li data-options="state:'closed'">
                        <span>公告管理</span>
                        <ul>
                            <li><a href="#" target="mainframe">Friend</a></li>
                            <li><a href="#" target="mainframe">Friend</a></li>
                            <li><a href="#">Friend</a></li>
                        </ul>
                    </li>
                    
                    <li data-options="state:'closed'">
                        <span>积分管理</span>
                        <ul>
                            <li><a href="#" target="mainframe">Friend</a></li>
                            <li><a href="#" target="mainframe">Friend</a></li>
                            <li><a href="#">Friend</a></li>
                        </ul>
                    </li>
                   
                   <li data-options="state:'closed'">
                        <span>登陆管理</span>
                        <ul>
                            <li><a href="#" id="logout" >退出系统</a></li>
                            <li><a href="javascript:window.location.reload()" >重新登陆</a></li>
                        </ul>
                    </li>
                                                                                            
                </ul>
            </li>
          </ul>
		</div>
		<!-- menu结束 -->
		
		<div data-options="region:'center',title:'欢迎你，${admin.adminname}'">
			<iframe id="mainframe" name="mainframe" style="height:auto;width:100%;margin-top:20px;min-height:500px;" marginwidth="0" marginheight="0" border="0" scrolling="auto" frameborder="0">
            </iframe>
		</div>
		<!-- main结束 -->
		
	</div>
</body>
<script type="text/javascript">
$(document).ready(function(){
	
 $("#logout").click( function(){
	 logOut();
 });
 
 function logOut(){
	$.messager.confirm('确认对话框', '您想要退出该系统吗？', function(flag){
		if (flag==true){
		   $.ajax({
				url : "admin_logout.json",
				type : "POST",
				success : function(result) {
				  	var data = result.data;
				  	if(!result.errorCode){		  		
						window.location = "admin_login.xhtml";
				  	}
				}
			})
		}
	});
  }
});
</script>
</html>