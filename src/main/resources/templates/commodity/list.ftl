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
                    <a class="btn btn-primary" href="/commodity/add"><i class="icon-plus"></i> 新增</a>
                </div>
                <form id="inputForm" action="/commodity_type/list" method="post">
                </form>
                <div class="well">
                    <table class="table">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>标题</th>
                            <th>价格</th>
                            <th>原价</th>
                            <th>分类</th>
                            <th style="width: 26px;"></th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list page.content as e>
                        <tr>
                            <td>${e.id}</td>
                            <td>${e.title}</td>
                            <td>${e.price}</td>
                            <td>${e.marketPrice}</td>
                            <td>${e.commodityType.name}</td>
                            <td>
                                <a href="#"><i class="icon-pencil"></i></a>
                                <a href="#myModal" role="button" data-toggle="modal"><i class="icon-remove"></i></a>
                            </td>
                        </tr>
                        </#list>
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