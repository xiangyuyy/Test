

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>添加商品类型 </title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <link rel="stylesheet" href="../../../layuiadmin/layui/css/layui.css" media="all">
</head>
<body>

  <div class="layui-form" lay-filter="layuiadmin-app-form-list" id="layuiadmin-app-form-list" style="padding: 20px 30px 0 0;">
    <div class="layui-form-item">
      <label class="layui-form-label">类型 名称</label>
      <div class="layui-input-inline">
      <input name="id" value="${goodtype.id!}" hidden>
        <input type="text" name="name" value="${goodtype.name!}" lay-verify="required" placeholder="类型 名称" autocomplete="off" class="layui-input">
      </div>
    </div>
    <div class="layui-form-item">
      <label class="layui-form-label">描述</label>
      <div class="layui-input-inline">
        <textarea name=describe lay-verify="" placeholder="描述" style="width: 400px; height: 150px;" autocomplete="off" class="layui-textarea">${goodtype.describe!}</textarea>
      </div>
    </div>
    <div class="layui-form-item">
      <label class="layui-form-label">状态</label>
      <div class="layui-input-inline">
      <#if goodtype.status ==1>
              <input  type="radio" name="status" value="1" title="上架" checked >
              <input  type="radio" name="status" value="0" title="下架">
              </#if>
                    <#if goodtype.status ==0>
              <input  type="radio" name="status" value="1" title="上架" >
              <input  type="radio" name="status" value="0" title="下架" checked>
              </#if>
      </div>
    </div>
    <div class="layui-form-item layui-hide">
      <input type="button" lay-submit lay-filter="layuiadmin-app-form-submit" id="layuiadmin-app-form-submit" value="确认添加">
      <input type="button" lay-submit lay-filter="layuiadmin-app-form-edit" id="layuiadmin-app-form-edit" value="确认编辑">
    </div>
  </div>

  <script src="../../../layuiadmin/layui/layui.js"></script>  
  <script>
  layui.config({
    base: '../../../layuiadmin/' //静态资源所在路径
  }).extend({
    index: 'lib/index' //主入口模块
  }).use(['index', 'form'], function(){
    var $ = layui.$
    ,admin = layui.admin
    ,form = layui.form;
    
    //监听提交
    form.on('submit(layuiadmin-app-form-submit)', function(data){
      var field = data.field; //获取提交的字段
      var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引  

      //提交 Ajax 成功后，关闭当前弹层并重载表格
      //$.ajax({});
      var index1 = layer.load(1, {
          shade: [0.5,'#000'] //0.1透明度的背景
          });   
      layui.$.ajax({
          type: "post",
          url: "/goodtype/update",
          data: field,
          dataType: "json",
          success: function(res){
              if(res.sucess){
              layer.msg(res.msg, {
                offset: '15px'
                ,icon: 1
                ,time: 500
              }, function(){
//                  parent.layui.table.reload('LAY-app-content-list'); //重载表格
//                  parent.layer.close(index); //再执行关闭 
                  parent.layui.table.reload('LAY-app-content-list'); //重载表格
                  parent.layer.close(index); //再执行关闭 
                  layer.close(index1);    //返回数据关闭loading
              });
            }
             else{
                  layer.msg(res.msg, {
                      offset: '15px'
                      ,icon: 2
                      ,time: 500
                   });
                  layer.close(index1);    //返回数据关闭loading
              }
            }
      });
/* 	    admin.req({
            url:'/goodtype/update' //实际使用请改成服务端真实接口
            ,data: field
            ,done: function(res){                  
              if(res.sucess){
              layer.msg(res.msg, {
                offset: '15px'
                ,icon: 1
                ,time: 1000
              }, function(){
                  parent.layui.table.reload('LAY-app-content-list'); //重载表格
                  parent.layer.close(index); //再执行关闭 
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
          }); */
    });
  })
  </script>
</body>
</html>