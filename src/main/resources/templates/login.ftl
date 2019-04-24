<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <title>登陆</title>
<#--  <link rel="stylesheet" href="https://heerey525.github.io/layui-v2.4.3/layui/css/layui.css" media="all">
  <script src="https://heerey525.github.io/layui-v2.4.3/layui/layui.js"></script>
  <script src="https://layui.hcwl520.com.cn/jquery/jquery-3.3.1.min.js?v=201804251754"></script>-->

    <link rel="stylesheet" href="/layui/css/layui.css">
    <script src="/layui/layui.js"></script>
    <script src="/js/jquery-3.1.0.min.js"></script>
  <style>
    body{margin: 10px;}
    .demo-carousel{height: 200px; line-height: 200px; text-align: center;}
  </style>
  <script>
</script>

<fieldset class="layui-elem-field layui-field-title" style="margin-top:30px;">
    <legend style="text-align:center;">登陆</legend>
</fieldset>
<!--th:action="@{/user/register.html}" -->
<form id="reform" class="layui-form layui-form-pane"  method="POST" action="/checkLogin">
    <div class="layui-form-item">
        <label class="layui-form-label">用户名</label>
        <div class="layui-input-block">
            <input type="text" name="name" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input" />
        </div>
    </div>
         
    <div class="layui-form-item">
        <label class="layui-form-label">密码</label>
        <div class="layui-input-block">
            <input type="password" name="password"  lay-verify="pass" placeholder="请输入密码" autocomplete="off" class="layui-input" />
        </div>
    </div>
    <div class="layui-form-item">
        <button  class="layui-btn layui-btn-fluid" lay-submit="" lay-filter="demo1">登陆</button>
    </div>

</form>

</head>
<body>
</body>
</html>
