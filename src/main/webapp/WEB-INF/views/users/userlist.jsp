<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
</head>
<body>

<shiro:guest>
	登录
</shiro:guest>
		<shiro:hasRole name="系统管理员">
			<span>admin</span>
		</shiro:hasRole>
		<table>
			<tr>
				<td>序号</td>
				<td>用户名</td>
				<td>密码</td>
				<td>联系方式</td>
				<td>年龄</td>
			</tr>
			<c:forEach var="user" varStatus="" items="${userlist}">
			<tr>
				<td></td>
				<td>${user.userName}</td>
				<td>${user.password}</td>
				<td>${user.userPhone}</td>
				<td>${user.userAge}</td>
			</tr>
			</c:forEach>
		</table>
</body>
</html>