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
            <li class="active">商品分类</li>
        </ul>
        <div class="container-fluid">
            <div class="row-fluid">
                <div class="btn-toolbar">
                    <a class="btn btn-primary" href="/commodity_type/add"><i class="icon-plus"></i> 新增</a>
                </div>
                <form id="inputForm" action="/commodity_type/list" method="post">
                </form>
                <div class="well">
                    <table class="table">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>分类名称</th>
                            <th>图片</th>
                            <th style="width: 26px;"></th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list page.content as e>
                        <tr>
                            <td>${e.id}</td>
                            <td>${e.name}</td>
                            <td><#if (e.image)??><img src="${e.image }"  style="width: 35px; height: 35px;" class="images"></#if></td>
                            <td>
                                <a href="/commodity_type/edit/${e.id}"><i class="icon-pencil"></i></a>
                                <a href="#" onclick="del('${e.id}');" role="button" data-toggle="modal"><i class="icon-remove"></i></a>
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
            $('.images').click(function(){
                var image_url = $(this).attr('src');
                 if(image_url == ''){
                    layer.alert('图片不存在！');
                    return;
                }

                layer.open({
                    type: 1,
                    skin: 'layui-layer-demo', //样式类名
                    closeBtn: 1,
                    anim: 2,
                    area: ['35%', '45%'],
                    shadeClose: true, //开启遮罩关闭
                    content: '<div style="width: 100%; text-align: center;"><img src="' + image_url + '"/></div>'
                });
            })
        });

        function del(id){
            layer.confirm('确定删除？', function(){
                var url = '/commodity_type/delete?id=' + id;
                $('#inputForm').attr('action', url);
                $('#inputForm').submit();
            }, function(){
                layer.closeAll();
            })
        };
    </script>
</body>
</html>