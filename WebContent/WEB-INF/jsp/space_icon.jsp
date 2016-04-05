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
<div class="top">
  <div class="top_content">
    <ul>
      <li><a href="lang?langType=en&path=space_icon">English</a></li>
      <li><a href="lang?langType=zh&path=space_icon">中文</a></li>
      <li><a href="#"><spring:message code="help"/></a></li>
      <li><a onclick="AddFavorite(window.location,document.title)" href="javascript:void(0)"><spring:message code="StoreUp"/></a></li>
      <li><a href="#"><spring:message code="logout"/></a></li>
      <li><a href="#">${user.username}</a></li>
    </ul>
  </div>
</div>
<!--页面顶端top结束-->

<div class="wrap">
  <div  class="logo">
    <div class="logo_left"><img src="images/logoz.jpg" /></div>
    <div class="logo_right"><img src="images/tel.jpg" width="28" height="28" /><spring:message code="Hotline"/>：<span class="tel">123-456-7890</span></div>
  </div>
  <!--logo结束-->
  
  <div class="nav">
    <div  class="nav_left"></div>
    <div class="nav_mid">
      <div class="nav_mida_left">
        <ul>
          <li><a href="activity.xhtml">首页</a></li>
          <li><a href="my_class.xhtml">我的班级</a></li>
          <li><a href="#">相册墙</a></li>
          <li><a href="address_book.xhtml">通讯录</a></li>
          <li><a href="chat_room.xhtml">聊天室</a></li>
          <li><a href="space_show.xhtml">唯空间</a></li>
          <li><a href="result.xhtml">成绩表</a></li>
        </ul>
      </div>
      <!--nav_mid_left结束-->
      <div class="nav_mid_right">
        <form action="" method="post">
          <input type="text" class="search_text" />
          <!--<input type="text" class="search_text" x-webkit-speech />-->
        </form>
      </div>
      <!--nav_mid_right结束--> 
    </div>
    <!--导航主体nav_mid结束-->
    <div class="nav_right"></div>
  </div>
  <!--nav结束-->
  
  <div class="easyui-layout" style="margin-top:18px; width:1000px;height:550px;">
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
<div class="copyright">
  <div class="copyright_content">
    <ul>
      <li>关于
        <ul>
          <li>品牌故事</li>
          <li>联系我们</li>
          <li>加入我们</li>
          <li>版权声明</li>
        </ul>
      </li>
      <li>活动
        <ul>
          <li>十大歌手</li>
          <li>最美班花</li>
          <li>百里徒步</li>
          <li>青年志愿者</li>
        </ul>
      </li>
      <li>关注
        <ul>
          <li>新浪微博</li>
          <li>腾讯微博</li>
          <li>企业微信</li>
          <li>QQ空间</li>
        </ul>
      </li>
      <li>留言
        <ul>
          <li>意见反馈</li>
          <li>问题留言</li>
          <li>媒体联络</li>
          <li>在线客服</li>
        </ul>
      </li>     
    </ul>
  </div>
  <!--copyright_content结束--> 
</div>
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