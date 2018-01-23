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
            <form action="/commodity_type/save" method="post">
                <label>分类名称：</label>
                <input type="text" name="name" class="input-xlarge">
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
<script src="/static/lib/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript">
    $(function() {
        $('button[name="tijiao"]').click(function(){
            $('form').submit();
        })
    });
</script>
</body>
</html>