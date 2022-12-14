<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title></title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->

    <link
            href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css"
            rel="stylesheet">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script
            src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://cdn.bootcss.com/layer/2.3/layer.js"></script>
</head>
<body>
<br/>
<h3 align="center">图书列表</h3>
<form action="${pageContext.request.contextPath }/Book/listquery.do"
      method="post">

    <div class="form-inline" style="margin-left: 38%;">
        <div class="form-group">

            请输入图书名称&nbsp;&nbsp;<input type="text" name="name" value="${name }"
                                      class="form-control"/> &nbsp;&nbsp; <input type="submit"
                                                                                 value="查询" class="btn btn-success"/>

            &nbsp;&nbsp;
            <a class="btn btn-info" href="${pageContext.request.contextPath}/add.jsp">添加图书</a>

        </div>
    </div>
</form>
<br/>
<div style="width: 70%; margin-left: 15%">
    <table class="table table-bordered">
        <tr class="success">
            <th>序号</th>
            <th>图书名称</th>
            <th>图书种类</th>
            <th>图书作者</th>
            <th>上传时间</th>
            <th>图书图片</th>
            <th>图书txt</th>

            <th>修改</th>
            <th>删除</th>

        </tr>
        <c:forEach varStatus="vs" var="v" items="${list}">
            <tr class="">
                <td>${vs.index+1 }</td>
                <td>${v.name }</td>
                <td>${v.category }</td>
                <td>${v.author }</td>
                <td>${v.times }</td>
                <td>
                    <img src="${pageContext.request.contextPath}/uploadimg/${v.imgsrc}" width="50px" height="50px"/>
                </td>


                <td><a
                        href="${pageContext.request.contextPath}/Book/showtxt.do?id=${v.id}">查看</a>
                </td>

                <td><a
                        href="${pageContext.request.contextPath}/Book/toupdate.do?id=${v.id}">修改</a>
                </td>
                <td><a
                        href="${pageContext.request.contextPath}/Book/del.do?id=${v.id}"
                        onclick='return confirm("确认要删除吗?")'>删除</a></td>


            </tr>

        </c:forEach>


    </table>


</div>
</body>
</html>