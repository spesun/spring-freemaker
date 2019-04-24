<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <title>注册</title>
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
 layui.use(['form'], function(){
  var form = layui.form;
 
  //自定义验证规则
  form.verify({
    pass: [/(.+){6,12}$/, '密码必须6到12位']
    ,repass:function(value){
    	var pvalue = $("input[name='password']").val();
    	if(pvalue!=value){
    		return "两次输入的密码不一致";
    	}
    }
  }); 

  //监听提交
  form.on('submit(demo1)', function(data){
    var agreeChecked = data.field.agree;
    if(agreeChecked!="on"){
    	alert("未同意隐私条款");
    	return false;//阻止表单提交
    }
  });
});
</script>

<fieldset class="layui-elem-field layui-field-title" style="margin-top:30px;">
    <legend style="text-align:center;">注册新账户</legend>
</fieldset>
<!--th:action="@{/user/register.html}" -->
<form id="reform" class="layui-form layui-form-pane"  method="POST" action="/saveRegister">
    <div class="layui-form-item">
        <label class="layui-form-label">邮箱</label>
        <div class="layui-input-block">
        <input type="text" name="email" lay-verify="email" placeholder="请输入" autocomplete="off" class="layui-input" value="sss@163.com" />
        </div>
    </div>
         
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
        <label class="layui-form-label">重复密码</label>
        <div class="layui-input-block">
            <input type="password" name="repassword"   lay-verify="repass" placeholder="请输入密码" autocomplete="off" class="layui-input" />
        </div>
    </div>
        
    <div class="layui-form-item">
        <button  class="layui-btn layui-btn-fluid" lay-submit="" lay-filter="demo1">注册</button>
    </div>
        
    <div style="text-align:center;margin-top:15px;">
        <input type="checkbox" name="agree"  lay-skin="primary" checked=""/>
                               我已阅读并同意
        <a href="#" id="agreementLink">《隐私条款》</a>
    </div>
</form>

</head>
<body>
</body>
</html>
