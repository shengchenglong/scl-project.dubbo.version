<%--
  Created by IntelliJ IDEA.
  User: shengchenglong
  Date: 17/4/14
  Time: 13:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>数据字典</title>
</head>
<body>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row">
    <div class="col-xs-12">
        <div class="clearfix">
            <div class="pull-right tableButton-container"></div>
        </div>
        <div class="table-header">
            字典列表
        </div>

        <!-- div.table-responsive -->

        <!-- div.dataTables_borderWrap -->
        <div>
            <table id="dictionary-table" class="table table-striped table-bordered table-hover">
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
                    <th class="center">英文名称</th>
                    <th class="center">描述</th>
                    <th class="center">操作</th>
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

        });


    }

</script>

</body>
</html>
