<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

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
     <link rel="stylesheet" type="text/css" href="./js/jquery.Jcrop.min.css">
     <script type="text/javascript" src="./js/jquery.Jcrop.min.js"></script>     
</head>
<body>
<jsp:include page="include/inc_header.jsp"/>
<div class="wrap">
  <div class="easyui-layout" style="margin-top:10px; width:1000px;height:560px;">
       <div id="p" data-options="region:'west'" title="你现在的位置  : 唯空间 >> 修改头像" style="width:22%;padding:50px">
           <div style="margin-bottom:20px">
             <a href="#"><img alt="点击上传头像" src="./images/icons/${user.cdkey}.jpg" style="width:100px;height:100px"></a>
           </div>
           <div class="username" style="margin-bottom:10px">
             <a href="#">Hi,${user.username}</a>
           </div>
            <div class="username" style="margin-bottom:10px">
             <a href="#">积分 : ${user.username}</a>
           </div>
           <div style="margin-bottom:25px">
             <ul class="message_list" >
             <li style="background-image: url('./images/space_1.jpg');"></li>
             <li><a href="#">上传头像</a></li>
             <li><a href="#">上传头像</a></li>
             <li><a href="#">上传头像</a></li>
             </ul>
           
           </div>
       </div>
       <!--West结束-->
        
       <div data-options="region:'center'" title="上传头像" style="padding:60px 120px">
       
         <div style="width: 450px;height:400px" >
            <div class="photo_frame"> 
                 <img alt="" src="" id="cutimg">
            </div>
            <form name="form" action="uploadHeadImage" class="form-horizontal" method="post" enctype="multipart/form-data">
            <div style="float:left;margin: 0 10px 0 10px;vertical-align:middle"> 
               <div id="avatar_preview">
                  <img alt="" src="" id="cutimg2">
               </div>
               <div id="div_avatar_upload">
                      <input class="photo-file" type="file" name="imgFile" size="45" id="avatar_file_upload" onchange="readURL(this);"/>
                      <input type="hidden" id="x" name="x"/>
                      <input type="hidden" id="y" name="y"/>
                      <input type="hidden" id="w" name="w"/>
                      <input type="hidden" id="h" name="h"/>
               </div>
                <div>    
                    <input class="upload_submit" type="submit" value="确定修改">
                    <div class="upload_type1"></div>
                    <div class="upload_type2"></div>
                </div> 
              </div>
            </form>
         </div>
       <!--photo结束-->
              
      </div>
      <!--Center结束-->
    </div>
  <!--ad结束-->
  
</div>
<!--最外层wrap结束  -->
<jsp:include page="include/inc_footer.jsp"/>
</body>
 <script type="text/javascript">
      //定义一个全局api，这样操作起来比较灵活
        var api = null;
        function readURL(input) {
        	  var jcrop_api,
              boundx,
              boundy
              
            if (input.files && input.files[0]) {
                var reader = new FileReader();
                reader.readAsDataURL(input.files[0]);
                reader.onload = function (e) {
                    $('#cutimg').removeAttr('src');
                    $('.upload_submit').show();
                    $('.upload_type1').hide();
                    $('.upload_type2').show();
                    $('#cutimg').attr('src', e.target.result);
                    $('#cutimg2').attr('src', e.target.result);
                    api = $.Jcrop('#cutimg', {
                        setSelect: [ 20, 20, 200, 200 ],
                      // setSelect: [ 0, 0, 200, 200 ],
                        aspectRatio: 1,
                        onSelect: updateCoords,
                        onChange: updatePreview
                    },function(){
                        var bounds = this.getBounds();
                        boundx = bounds[0];
                        boundy = bounds[1];
                      });
                };
                if (api != undefined) {
                    api.destroy();
                }
            }
        	  
            function updateCoords(obj) {
                $("#x").val(obj.x);
                $("#y").val(obj.y);
                $("#w").val(obj.w);
                $("#h").val(obj.h);      
            };
                     
            function updatePreview(c)
            {
              if (parseInt(c.w) > 0)
              {
                var rx = 50 / c.w;
                var ry = 50 / c.h;
                $('#cutimg2').css({
                  width: Math.round(rx * boundx) + 'px',
                  height: Math.round(ry * boundy) + 'px',
                  marginLeft: '-' + Math.round(rx * c.x) + 'px',
                  marginTop: '-' + Math.round(ry * c.y) + 'px'
                });
              }
            };
        }
    </script>
</html>