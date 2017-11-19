
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>超市账单管理系统</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/public.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/js/bootstrap/css/bootstrap.min.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jQuery1.11.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-easyui-1.2.6/jquery.easyui.min.js"></script>
  <%--  <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.pagination.js"></script>--%>
    <script type="text/javascript">
      var  returnData;

    jQuery.noConflict();
    var del;
    jQuery(function($){
        $.messager.confirm("温馨提示！","确认要删除该记录吗?",function (r) {//到底点击的是确定还是取消
            if(r){  //确定
                //获取用户选择的记录
                var dellist= $("#list-content input:checked");
                //拼接要删除的数据
                var ids=[];
                $.each(dellist,function (i,dom) { //一个复选框DOM对象
                    ids+="id="+dom.value+"&";
                })
                ids=ids.substring(0,ids.length-1);
                alert(ids);

            }
        });

      //模糊查询
        $("#btnSelect").click(function () {
            load2(0);
        });
        //加载数据
        load(0);
        function  load(index) {
            $.ajax({
                url:"/user/getUserInfo",
                type:"post",
                data:{"pageIndex":index},
                success:function (data) {

                    //模拟ajax去后端读取页数，获取数据并渲染列表的过程
                    $('#list-content').html('')
                    $.each(data.list,function (i,dom) {
                        $('#list-content').append('<tr><td>' + dom.id + '</td><td>' + dom.userCode + '</td><td>' + dom.userName + '</td><td>' + (dom.gender?"男":"女") + '</td><td>' + dom.birthday + '</td><td>' + dom.phone + '</td><td>' + dom.address + '</td></tr>');
                    });

                    //渲染分页
                       if(date.totalPages>0){
                           $('#pagination').pagination({
                               total:date.totalRecords,//总计录数
                               pageSize:pageSize,//页面大小
                               pageNumber:index+1,  //当前页码
                               pageList:[2,3,5,10],//5表示页显示5条数据，10表示页显示10条数据
                               onSelectpage:function (pageNumber,pageSize) {
                                   load(pageNumber-1,pageSize);
                               }
                           });
                       }else {
                           $('#pagination').html("<span style='color:red;font-size: 18px'>没有检索到结果~~~~~！！！！！！</span>");
                       }



                }
            });
        }
        function  load2(index) {
            var userName=$("[name=userName]").val();
            $.ajax({
                url:"/user/GetUsert",
                type:"post",
                data:{"pageIndex":index,"userName":userName},
                success:function (data) {
                    //模拟ajax去后端读取页数，获取数据并渲染列表的过程
                    $('#list-content').html('')
                    $.each(data.list,function (i,dom) {
                        $('#list-content').append('<tr><td>' + dom.id + '</td><td>' + dom.userCode + '</td><td>' + dom.userName + '</td><td>' + (dom.gender?"男":"女") + '</td><td>' + dom.birthday + '</td><td>' + dom.phone + '</td><td>' + dom.address + '</td>' +
                            '<td><a href="${pageContext.request.contextPath}/user/All/'+dom.id+'"><img src="../../img/read.png" alt="查看" title="查看"/></a>'+
                            '<a href="${pageContext.request.contextPath}/user/getall/'+dom.id+'"><img src="../../img/xiugai.png" alt="修改" title="修改"/></a>'+
                            '<a href="${pageContext.request.contextPath}/user/deleteuser/'+dom.id+'" class="removeUser"><img src="../../img/schu.png"  alt="删除" title="删除"/></a>'+
                            '</td></tr>');
                    });
                    //渲染分页
                    $('#pagination').pagination(data.totalRecords, {
                        current_page : index, //当前页索引
                        items_per_page : data.pageSize, //每页记录数
                        num_display_entries :4, //显示页码块数量
                        callback :load2,
                        load_first_page : true,
                        prev_text : '上一页',
                        next_text : '下一页'
                    });
                }
            });
        }
    });
</script>




    <style type="text/css">
        ul li{
            float: left;
            margin: auto;
            padding: inherit;
        }
        .pagination{
            font-size:20px;
            margin:0 auto;
        }


    </style>


</head>

<body>
<!--头部-->
    <header class="publicHeader">
        <h1>超市账单管理系统</h1>
        <div class="publicHeaderR">
            <p><span>下午好！</span><span style="color: #fff21b">admin</span> , 欢迎你！</p>
            <a href="login.jsp">退出</a>
        </div>
    </header>
<!--时间-->
    <section class="publicTime">
        <span id="time">2015年1月1日 11:11  星期一</span>
        <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
    </section>
<!--主体内容-->
    <section class="publicMian ">
        <div class="left">
            <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
            <nav>
                <ul class="list">
                    <li><a href="${pageContext.request.contextPath}/getbill">账单管理</a></li>
                    <li><a href="${pageContext.request.contextPath}/prolist">供应商管理</a></li>
                    <li  id="active"><a href="${pageContext.request.contextPath}/user/showUserList">用户管理</a></li>
                    <li><a href="${pageContext.request.contextPath}/user/Upwds">密码修改</a></li>
                    <li><a href="login.jsp">退出系统</a></li>
                </ul>
            </nav>
        </div>
        <div class="right">
            <div class="location">
                <strong>你现在所在的位置是:</strong>
                <span>用户管理页面</span>
            </div>
            <form method="post" id="stuForm">
            <div class="search">
                <span>用户名：</span>
                <input type="text" name="userName"  placeholder="请输入用户名"/>
                <input type="button" id="btnSelect" value="查询"/>
                <a href="${pageContext.request.contextPath}/user/userAdd">添加用户</a>
                <a href="${pageContext.request.contextPath}/user/userAdd">添加用户2</a>
                <a href="${pageContext.request.contextPath}/user/exceoll">导出数据</a>
            </div>
            </form>
            <!--用户-->
           <form method="post" action="" name="form1" id="form1" >
            <table class="providerTable" cellpadding="0" cellspacing="0">
                <tr class="firstTr">
                    <th width="10%">编号</th>
                    <th width="10%">用户编码</th>
                    <th width="20%">用户名称</th>
                    <th width="10%">性别</th>
                    <th width="10%">出生日期</th>
                    <th width="10%">电话</th>
                    <th width="10%">地址</th>
                    <th width="30%">操作</th>

                </tr>

                <tbody id="list-content"></tbody>



               </table>


              <div style="" class="pagination" id="pagination" ></div>


           </form>

        </div>

    </section>


<%--

               <div>
                   <ul>
                       <li>当前页数：[${page.pageIndex} / ${page.totalpages}
                           ]&nbsp;&nbsp;&nbsp;</li>
                       <li><a href="/UserServlet?action=LodingUserList&PageIndex=1">首页</a>&nbsp;&nbsp;&nbsp;</li>
                       <c:if test="${page.totalpages==1}">
                           <li><a onclick="up();">上一页</a>&nbsp;&nbsp;&nbsp;</li>
                           <li><a onclick="down();">下一页</a>&nbsp;&nbsp;&nbsp;</li>
                       </c:if>

                       <c:if test="${page.pageIndex < page.totalpages && page.pageIndex==1}">
                           <li><a onclick="up();">上一页</a>&nbsp;&nbsp;&nbsp;</li>
                           <li><a href="/UserServlet?action=LodingUserList&PageIndex=${page.pageIndex+1}">下一页</a>&nbsp;&nbsp;&nbsp;</li>
                       </c:if>

                       <c:if  test="${page.pageIndex < page.totalpages && page.pageIndex!=1}">
                           <li><a href="/UserServlet?action=LodingUserList&PageIndex=${page.pageIndex-1}">上一页</a>&nbsp;&nbsp;&nbsp;</li>
                           <li><a href="/UserServlet?action=LodingUserList&PageIndex=${page.pageIndex+1}">下一页</a>&nbsp;&nbsp;&nbsp;</li>
                       </c:if>

                       <c:if test="${page.pageIndex >= page.totalpages && page.pageIndex>1}">
                           <li><a href="/UserServlet?action=LodingUserList&PageIndex=${page.pageIndex-1}">上一页</a>&nbsp;&nbsp;&nbsp;</li>
                           <li><a onclick="down();">下一页</a>&nbsp;&nbsp;&nbsp;</li>

                       </c:if>
                       <li><a href="/UserServlet?action=LodingUserList&PageIndex=${page.totalpages}">尾页</a>&nbsp;&nbsp;&nbsp;</li>
                   </ul>
               </div>
--%>




<!--点击删除按钮后弹出的页面-->
<%--<div class="zhezhao"></div>
<div class="remove" id="removeUse">
    <div class="removerChid">
        <h2>提示</h2>
        <div class="removeMain">
            <p>你确定要删除该用户吗？</p>
            <a href="" id="yes">确定</a>
            <a href="#" id="no">取消</a>
        </div>
    </div>
</div>--%>

    <footer class="footer">
        版权归北大青鸟
    </footer>

<script src="../../js/jquery.js"></script>
<script src="../../js/js.js"></script>
<script src="../../js/time.js"></script>

</body>
</html>