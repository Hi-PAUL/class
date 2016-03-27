<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="./jcrop/jquery.Jcrop.min.css">
    <script type="text/javascript" src="./easyui/jquery.min.js"></script>
    <script type="text/javascript" src="./jcrop/jquery.Jcrop.min.js"></script>  
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
                    $('#cutimg').attr('src', e.target.result);
                    $('#cutimg2').attr('src', e.target.result);
                    api = $.Jcrop('#cutimg', {
                        setSelect: [ 20, 20, 200, 200 ],
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
</head>


<body>
<form name="form" action="<%=request.getContextPath()%>/uploadHeadImage" class="form-horizontal"
      method="post" enctype="multipart/form-data">
    <div class="modal-body text-center">
        <div class="zxx_main_con">
            <div class="zxx_test_list">
                <input class="photo-file" type="file" name="imgFile" id="fcupload" onchange="readURL(this);"/>
                <img alt="" src="" id="cutimg"/>
               
                <input type="hidden" id="x" name="x"/>
                <input type="hidden" id="y" name="y"/>
                <input type="hidden" id="w" name="w"/>
                <input type="hidden" id="h" name="h"/>
            </div>
        </div>
    </div>
     
    <div class="modal-footer">
        <button id="submit" onclick="">上传</button>
    </div>
</form>

 <div style=" width: 50px; height:50px;overflow: hidden;border: 3px;border-color: red">
 <img alt="" src="" id="cutimg2" width=100 height=100/>
 </div>
</body>
</html>