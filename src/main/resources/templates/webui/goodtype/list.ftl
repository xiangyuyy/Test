

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>商品类型 列表</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <link rel="stylesheet" href="../../../layuiadmin/layui/css/layui.css" media="all">
  <link rel="stylesheet" href="../../../layuiadmin/style/admin.css" media="all">
</head>
<body>

  <div class="layui-fluid">
    <div class="layui-card">
      <div class="layui-form layui-card-header layuiadmin-card-header-auto">
        <div class="layui-form-item">
          <div class="layui-inline">
            <label class="layui-form-label">ID</label>
            <div class="layui-input-inline">
              <input type="text" name="id" placeholder="" autocomplete="off" class="layui-input">
            </div>
          </div>
          <div class="layui-inline">
            <label class="layui-form-label">类型名称</label>
            <div class="layui-input-inline">
              <input type="text" name="name" placeholder="" autocomplete="off" class="layui-input">
            </div>
          </div>
          <div class="layui-inline">
            <button class="layui-btn layuiadmin-btn-list" lay-submit lay-filter="LAY-app-contlist-search">
              <i class="layui-icon layui-icon-search layuiadmin-button-btn"></i>
            </button>
          </div>
        </div>
      </div>

      <div class="layui-card-body">
        <div style="padding-bottom: 10px;">
<!--           <button class="layui-btn layuiadmin-btn-list" data-type="batchdel">删除</button> -->
          <button class="layui-btn layuiadmin-btn-list" data-type="add">添加</button>
        </div>
        <table id="LAY-app-content-list" lay-filter="LAY-app-content-list"></table> 
        <script type="text/html" id="buttonTpl">
          {{#if (d.status == 1){ }}
            <button class="layui-btn layui-btn-xs">上架</button>
          {{#  } else { }}
            <button class="layui-btn layui-btn-primary layui-btn-xs">下架</button>
          {{#  } }}
        </script>
        <!--时间格式化-->
    <script src="/layuiadmin/date-format.js" type="text/javascript" charset="utf-8"></script>
    <script type="text/html" id="updatetime" >
    {{#   
    var date = new Date();
    return date.Format(d.updatetime); 
    }} 
    </script>
        <script type="text/html" id="createtime" >
    {{# 
    var date = new Date();
    return date.Format(d.createtime); 
    }} 
    </script>
        <script type="text/html" id="table-content-list">
          <a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="edit"><i class="layui-icon layui-icon-edit"></i>编辑</a>
        </script>
      </div>
    </div>
  </div>

  <script src="../../../layuiadmin/layui/layui.js"></script>  
  <script>
  layui.config({
    base: '../../../layuiadmin/' //静态资源所在路径
  }).extend({
    index: 'lib/index' //主入口模块
  }).use(['index', 'goodtype', 'table'], function(){
    var table = layui.table
    ,form = layui.form;
    
    //监听搜索
    form.on('submit(LAY-app-contlist-search)', function(data){
      var field = data.field;
      
      //执行重载
      table.reload('LAY-app-content-list', {
        where: field
      });
    });
    
    var $ = layui.$, active = {
      batchdel: function(){
        var checkStatus = table.checkStatus('LAY-app-content-list')
        ,checkData = checkStatus.data; //得到选中的数据

        if(checkData.length === 0){
          return layer.msg('请选择数据');
        }
      
        layer.confirm('确定删除吗？', function(index) {
          
          //执行 Ajax 后重载
          /*
          admin.req({
            url: 'xxx'
            //,……
          });
          */
          table.reload('LAY-app-content-list');
          layer.msg('已删除');
        });
      },
      add: function(){
        layer.open({
          type: 2
          ,title: '添加商品类型'
          ,content: '/goodtype/listform'
          ,maxmin: true
          ,area: ['550px', '550px']
          ,btn: ['确定', '取消']
          ,yes: function(index, layero){
            //点击确认触发 iframe 内容中的按钮提交
            var submit = layero.find('iframe').contents().find("#layuiadmin-app-form-submit");
            submit.click();
          }
        }); 
      }
    }; 

    $('.layui-btn.layuiadmin-btn-list').on('click', function(){
      var type = $(this).data('type');
      active[type] ? active[type].call(this) : '';
    });

  });
  </script>
</body>
</html>
