<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="resources/js/jquery.min.js"></script>
<title>登录</title>
</head>
<body>

<form>
	<input type="hidden" name="_method" value="GET"> 
	用户名：<input type="text" name="userName" id="userName" /><br>
	    密码：<input type="text" name="password" id="password"/><br>
		 <input type="button" value="登录" id="login">
		 <input type="button" value="点击" id="clicks" >
</form>
	
</body>
<script type="text/javascript">
	/* $("#clicks").click(function(){
		var array = new Array();
		for (var i = 0; i < 5; i++) {
			array[i]=i;
		}
		alert(array[2]);
	}) */
	
	$("#login").click(function(){
		var userName = $("#userName").val();
		var password = $("#password").val();
		$.ajax({
			url:"<%=basePath%>users/user",
			type:"GET",
			async:"false",
			dataType:"json",
			data:{"userName":userName,"password":password},
			success:function(data){
				if(data.states==0){
					window.location.href="<%=basePath%>users/userlist";
				}else{
					alert("失败了啊啊："+data.status);
				}
			}
		})
	}) 
	
	function login(){
		var userName = document.getElementById("userName").value;
		var password = document.getElementById("password").value;
		$.ajax({
			url:"<%=basePath%>users/user",
			type:"GET",
			dataType:"json",
			async:"false",
			data:{"userName":userName,"password":password},
			success:function(data){
				if(data.staus=='ok'){
					alert("成功了");
					
				}else{
					
				}
			}
		})
	}

</script>

</html>