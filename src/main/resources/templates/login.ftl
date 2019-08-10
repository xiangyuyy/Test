<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<span style="color:red;">show:${message}</span>
<span style="color:red;">tatal:${teacherIPage.total}</span>
<#list teacherIPage.records as user>
<span style="color:red;">${user.id}---------${user.name}-------${user.age}<br/></span>
<input value="${user.age}">
</#list>
  <form action="loginaction" method="post">
<input name ="name" id="name"/>
<input name ="age" id="password"/>
<button type="submit">登录</button>
</form>
</body>
</html>