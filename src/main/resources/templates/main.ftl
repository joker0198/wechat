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
        <li><a href="index.html">首页</a>
    </ul>
    <div class="container-fluid">
        <div class="row-fluid">
            <div class="row-fluid">
            </div>
            <#include "/common/body_footer.ftl">
        </div>
    </div>
</div>

<script src="/static/lib/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript">
    $("[rel=tooltip]").tooltip();
    $(function() {
        $('.demo-cancel-click').click(function(){return false;});
    });
</script>
</body>
</html>