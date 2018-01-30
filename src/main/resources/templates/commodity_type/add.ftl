<!DOCTYPE html>
<html lang="en">
<head>
    <#include "/common/header.ftl">
        </head>
<body class="">
<!--<![endif]-->
<#include "/common/body_header.ftl">
<#include "/common/body_menu.ftl">
<div class="content">
    <ul class="breadcrumb">
        <li><a href="/main">首页</a> <span class="divider">/</span></li>
        <li class="active">商品分类</li><span class="divider">/</span></li>
        <li class="active">新增</li>
    </ul>
    <div class="container-fluid">
        <div class="row-fluid">
            <form id="inputForm" action="/commodity_type/save" method="post">
                <input name="id" value="${entity.id!""}" type="hidden"/>
                <div class="form-group">
                    <label>分类名称：</label>
                    <input type="text" name="name" class="input-xlarge" value="${entity.name!""}">
                </div>
                <div class="form-group">
                    <label>图片上传：</label>
                    <input type="file" name="imageFile" id="imageFile">
                    <input type="hidden" name="image" id="image" value="${entity.image!""}" />
                    <img id="show_image" src="${entity.image!""}"/>
                    <a href="javascript:uploadFile();" class="btn btn-primary">上传</a>
                </div>
            </form>
            <div class="btn-toolbar">
                <button class="btn btn-primary" type="button" name="tijiao"><i class="icon-save"></i> 保存</button>
                <a href="history.go(-1)" data-toggle="modal" class="btn">返回</a>
                <div class="btn-group">
                </div>
            </div>
            <#include "/common/body_footer.ftl">
        </div>
    </div>
</div>
<script type="text/javascript">
    $(function() {
        $('button[name="tijiao"]').click(function(){
            $('form').submit();
        })
    });

    function uploadFile(){
		//layer.alert();
		//判断是否有选择上传文件
        var imgPath = $("#imageFile").val();
        if (imgPath == "") {
            layer.alert("请选择上传图片！");
            return;
        }

        //判断上传文件的后缀名
        var strExtension = imgPath.substr(imgPath.lastIndexOf('.') + 1);
        if (strExtension != 'jpg' && strExtension != 'gif'
        && strExtension != 'png' && strExtension != 'bmp') {
            layer.alert("请选择图片文件!");
            return;
        }
        $("#inputForm").ajaxSubmit({
			type: "POST",
			url:"/image_upload/uploadImage",
			dataType: "text",
		    success: function(data){
		       if(data == ""){
           		 layer.alert("上传失败，请检查网络后重试");
           		 return;
           	   }
		       $("#image").val(data);
		       $("#show_image").prop("src",data);
			}
		});
	}
</script>
</body>
</html>