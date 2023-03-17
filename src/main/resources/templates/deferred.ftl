<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>长轮询</title>
</head>
<body>

<b>长轮询小栗子</b>
<div id="message"></div>

<script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.js"></script>
<script>

    $(function () {

        function getMessage() {
            $.ajax({
                //  /longPollingServlet
                url:"/handleReqDefResult"
                ,data:{}
                ,type:"get"
                ,timeout:5000 //定义超时时间为5秒
                ,success:function(rs){
                    if(rs !=''){
                        $("#message").append("<p>"+rs+"</p>");
                    }
                }
                ,complete:function(rs){
                    console.log("重新发起");
                    getMessage();
                }
            });
        }

        getMessage();
    });


</script>

</body>
</html>