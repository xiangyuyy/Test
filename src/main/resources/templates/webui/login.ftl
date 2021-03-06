<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>登入 - Admin</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
<link rel="stylesheet" href="../../layuiadmin/layui/css/layui.css"
	media="all">
<link rel="stylesheet" href="../../layuiadmin/style/admin.css"
	media="all">
<link rel="stylesheet" href="../../layuiadmin/style/login.css"
	media="all">
</head>
<body>

	<div class="layadmin-user-login layadmin-user-display-show"
		id="LAY-user-login" style="display: none;">

		<div class="layadmin-user-login-main">
			<div class="layadmin-user-login-box layadmin-user-login-header">
				<h2>Admin</h2>
				<p>后台管理系统</p>
			</div>
			<div
				class="layadmin-user-login-box layadmin-user-login-body layui-form">
				<div class="layui-form-item">
					<label
						class="layadmin-user-login-icon layui-icon layui-icon-username"
						for="LAY-user-login-username"></label> <input type="text"
						name="username" id="LAY-user-login-username" lay-verify="required"
						placeholder="用户名" class="layui-input">
				</div>
				<div class="layui-form-item">
					<label
						class="layadmin-user-login-icon layui-icon layui-icon-password"
						for="LAY-user-login-password"></label> <input type="password"
						name="password" id="LAY-user-login-password" lay-verify="required"
						placeholder="密码" class="layui-input">
				</div>
				<div class="layui-form-item">
					<button class="layui-btn layui-btn-fluid" lay-submit
						lay-filter="LAY-user-login-submit">登 入</button>
				</div>
			</div>
		</div>

	</div>

	<script src="../../layuiadmin/layui/layui.js"></script>
	<script>
  layui.config({
    base: '../../layuiadmin/' //静态资源所在路径
  }).extend({
    index: 'lib/index' //主入口模块
  }).use(['index', 'user'], function(){
    var $ = layui.$
    ,setter = layui.setter
    ,admin = layui.admin
    ,form = layui.form
    ,router = layui.router()
    ,search = router.search;

    form.render();

    //提交
    form.on('submit(LAY-user-login-submit)', function(obj){
    
      //请求登入接口
      admin.req({
        url:'/loginin' //实际使用请改成服务端真实接口
        ,data: obj.field
        ,done: function(res){                  
          //登入成功的提示与跳转
          if(res.sucess){
          layer.msg('登入成功', {
            offset: '15px'
            ,icon: 1
            ,time: 1000
          }, function(){
            location.href = '../'; //后台主页
          });
        }
          else{
              layer.msg(res.msg, {
                  offset: '15px'
                  ,icon: 2
                  ,time: 1000
                });
          }
        }
      });
      
    });  
  });
  </script>
</body>
</html>