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
            <li class="active">商品详细</li>
        </ul>
        <div class="container-fluid">
            <div class="row-fluid">
                <div class="btn-toolbar">
                    <button class="btn btn-primary"><i class="icon-plus"></i> 新增</button>
                </div>
                <div class="well">
                    <table class="table">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>名称</th>
                            <th>图片</th>
                            <th>类型</th>
                            <th>价格</th>
                            <th>单位</th>
                            <th style="width: 26px;"></th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>1</td>
                            <td>Mark</td>
                            <td>Tompson</td>
                            <td>the_mark7</td>
                            <td>the_mark7</td>
                            <td>the_mark7</td>
                            <td>
                                <a href="user.html"><i class="icon-pencil"></i></a>
                                <a href="#myModal" role="button" data-toggle="modal"><i class="icon-remove"></i></a>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div class="pagination">
                    <ul>
                        <li><a href="#">Prev</a></li>
                        <li><a href="#">1</a></li>
                        <li><a href="#">2</a></li>
                        <li><a href="#">3</a></li>
                        <li><a href="#">4</a></li>
                        <li><a href="#">Next</a></li>
                    </ul>
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