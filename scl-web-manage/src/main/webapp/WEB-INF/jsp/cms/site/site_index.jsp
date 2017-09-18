<%--
  Created by IntelliJ IDEA.
  User: shengchenglong
  Date: 17/3/3
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>站点管理</title>
</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<style>
    .tableButton-container{padding-bottom: 10px;}
</style>

<div class="row">
    <div class="col-xs-12">
        <div class="clearfix">
            <div class="pull-right tableButton-container"></div>
        </div>
        <div class="table-header">
            站点列表
        </div>

        <!-- div.table-responsive -->

        <!-- div.dataTables_borderWrap -->
        <div>
            <table id="site-table" class="table table-striped table-bordered table-hover">
                <thead>
                    <tr>
                        <th class="center">
                            <label class="pos-rel">
                                <input type="checkbox" class="ace selectAll" />
                                <span class="lbl"></span>
                            </label>
                        </th>
                        <th class="center">
                            序号
                        </th>
                        <th class="center">名称</th>
                        <th class="center">语言版本</th>
                        <th class="center">操作</th>
                        <th class="center">设置</th>
                    </tr>
                </thead>

                <tbody>
                    <%--循环主站点--%>
                    <c:forEach var="site" items="${siteList}" varStatus="vs">
                        <c:if test="${fn:length(site.childSites) > 0}">
                            <tr>
                                <td class="center">
                                    <label class="pos-rel">
                                        <input type="checkbox" class="ace selectOne" siteId="${site.id}" />
                                        <span class="lbl"></span>
                                    </label>
                                </td>
                                <td class="center">
                                    ${vs.count}
                                </td>
                                <td>
                                    ${site.name}
                                </td>

                                <td>
                                    ${site.languageVersion}
                                </td>
                                <td>
                                    <div class="hidden-sm hidden-xs action-buttons">
                                        <a class="blue" href="javascript:void(0);">
                                            <i class="ace-icon fa fa-search-plus bigger-130"></i>
                                        </a>

                                        <a class="green" href="${ctx}/manage/site/toUpdate?siteId=${site.id}">
                                            <i class="ace-icon fa fa-pencil bigger-130"></i>
                                        </a>

                                        <a class="red" href="javascript:void(0);">
                                            <i class="ace-icon fa fa-trash-o bigger-130"></i>
                                        </a>
                                    </div>
                                </td>

                                <td>
                                    设置
                                </td>
                            </tr>

                        </c:if>
                    </c:forEach>

                </tbody>
            </table>
        </div>
    </div>
</div>
<!-- page specific plugin scripts -->
<script src="${ctx}/static/manage/ace-master/assets/js/jquery.dataTables.min.js"></script>
<script src="${ctx}/static/manage/ace-master/assets/js/jquery.dataTables.bootstrap.min.js"></script>
<script src="${ctx}/static/manage/ace-master/assets/js/dataTables.buttons.min.js"></script>
<script src="${ctx}/static/manage/ace-master/assets/js/buttons.flash.min.js"></script>
<script src="${ctx}/static/manage/ace-master/assets/js/buttons.html5.min.js"></script>
<script src="${ctx}/static/manage/ace-master/assets/js/buttons.print.min.js"></script>
<script src="${ctx}/static/manage/ace-master/assets/js/buttons.colVis.min.js"></script>
<script src="${ctx}/static/manage/ace-master/assets/js/dataTables.select.min.js"></script>

<script>
    $(function() {
        initDataTable();
        selectAllFN();
        selectOneFN();
    });

    /**
     * dataTable初始化
     */
    function initDataTable() {

        var siteTable = $('#site-table').DataTable();

        // dataTable 按钮初始化
        new $.fn.dataTable.Buttons( siteTable, {
            buttons: [
                {
                    "text": '<button class="addBtn btn btn-white btn-success btn-round">' +
                    '<i class="ace-icon fa fa-plus"></i>' +
                    '新增' +
                    '</button>',
                    columns: ':not(:first):not(:last)'
                },
                {
                    "text": '<button class="addBtn btn btn-white btn-success btn-round">' +
                    '<i class="ace-icon fa fa-trash-o"></i>' +
                    '批量删除' +
                    '</button>',
                    columns: ':not(:first):not(:last)'
                }
            ]
        } );

        // 将按钮append到dom元素中
        siteTable.buttons().container().appendTo( $('.tableButton-container') );

        // 给上面添加的按钮绑定事件
        var addSiteAction = siteTable.button(0).action(function() {
            window.location.href = "${ctx}/manage/site/toCreate";
        });

        var deleteBatchAction = siteTable.button(1).action(function() {
            var hasSelect = $(".selectOne:checked").size();
            if(hasSelect == 0) {
                layer.alert("请勾选待删除项");
                return ;
            }

            var ids = [];
            var idsString = "";
            $.each($(".selectOne"), function(index, item) {
                if($(item).prop("checked")) {
                    ids.push($(item).attr("siteId"));
                }
            });

            for(var i = 0; i < ids.length; i++) {
                if(i != ids.length - 1) {
                    idsString = idsString + ids[i] + ",";
                } else {
                    idsString = idsString + ids[i];
                }
            }

            $.post("${ctx}/user/site/deleteBatch", {"idsString" : idsString}, function(data) {
                if(data.success) {
                    layer.alert("删除成功", function() {
                        window.location.href = "${ctx}/manage/site/index";
                    });
                } else {
                    layer.alert("删除失败");
                }
            });
        });


    }

    /**
     * 处理全选checkbox单击事件
     */
    function selectAllFN() {
        $(".selectAll").click(function() {
            $(".selectOne").prop("checked", $(this).prop("checked"));
        });
    }

    /**
     * 处理单选checkbox单击事件
     */
    function selectOneFN() {
        $(".selectOne").click(function() {
            var allChecked = true;
            $.each($(".selectOne"), function(index, item) {
                allChecked = allChecked && $(item).prop("checked");
            });
            if(allChecked) {
                $(".selectAll").prop("checked", true);
            } else {
                $(".selectAll").prop("checked", false);
            }
        });

    }

</script>
</body>
</html>
