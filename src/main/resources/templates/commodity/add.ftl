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
            <form id="inputForm" action="/commodity/save" method="post">
                <input name="id" value="${entity.id!""}" type="hidden"/>
                <div class="form-group">
                    <label>商品标题：</label>
                    <input type="text" name="title" class="input-xlarge" value="${entity.title!""}">
                </div>
                <div class="form-group">
                    <label>商品分类：</label>
                    <select name="commodityType.id">
                        <option value="">--请选择--</option>
                        <#list commodityTypeList as e>
                            <option value="${e.id}">${e.name}</option>
                        </#list>
                    </select>
                </div>
                <div class="form-group">
                    <label>价格：</label>
                    <input type="text" name="price" class="input-xlarge" value="${entity.price!""}">
                </div>
                <div class="form-group">
                    <label>原价：</label>
                    <input type="text" name="marketPrice" class="input-xlarge" value="${entity.marketPrice!""}">
                </div>
                <div class="form-group">
                    <label>详情：</label>
                    <input type="text" name="content" class="input-xlarge" value="${entity.content!""}">
                </div>
                <div class="form-group">
                    <label>列表图片：</label>
                    <input type="file" name="imageFile_other" id="imageFile3" class="imageFile">
                    <input type="hidden" name="image" id="image" value="${entity.image!""}" />
                    <img id="show_image3" src="${entity.image!""}" style="width: 15%;"/>
                    <a href="javascript:uploadFile('3');" class="btn btn-primary">上传</a>
                </div>
                <div class="form-group">
                    <label>图片1：</label>
                    <input type="file" name="imageFile_other" id="imageFile0" class="imageFile">
                    <input type="hidden" name="imagesList[0].image" id="image0" value="${entity.image!""}" />
                    <img id="show_image0" src="${entity.image!""}" style="width: 15%;"/>
                    <a href="javascript:uploadFile('0');" class="btn btn-primary">上传</a>
                </div>
                <div class="form-group">
                    <label>图片2：</label>
                    <input type="file" name="imageFile_other" id="imageFile1" class="imageFile">
                    <input type="hidden" name="imagesList[1].image" id="image1" value="${entity.image!""}" />
                    <img id="show_image1" src="${entity.image!""}" style="width: 15%;"/>
                    <a href="javascript:uploadFile('1');" class="btn btn-primary">上传</a>
                </div>
                <div class="form-group">
                    <label>图片3：</label>
                    <input type="file" name="imageFile_other" id="imageFile2" class="imageFile">
                    <input type="hidden" name="imagesList[2].image" id="image2" value="${entity.image!""}" />
                    <img id="show_image2" src="${entity.image!""}" style="width: 15%;"/>
                    <a href="javascript:uploadFile('2');" class="btn btn-primary">上传</a>
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

    function uploadFile(idx){
		//layer.alert(idx);
		//判断是否有选择上传文件
        var imgPath = $("#imageFile" + idx).val();
        if (imgPath == "") {
            layer.alert("请选择上传图片！");
            return;
        }

        $('.imageFile').each(function(i){
            $(this).attr('name', 'imageFile_other');
            if(i == idx){
                $(this).attr('name', 'imageFile');
            };
        })

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
		       $("#image" + idx).val(data);
		       $("#show_image" + idx).prop("src",data);
			}
		});
	}
</script>
</body>
</html>