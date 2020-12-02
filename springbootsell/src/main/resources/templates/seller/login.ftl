<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>饿了么用户登录</title>
</head>
<style>
    body{
        margin:0;
        padding: 0;
        font-family: sans-serif;
        background-color: #7c5aae;
        background-size: cover;
    }
    .box
    {
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%,-50%);
        width:400px;
        padding: 40px;
        background:rgba(0,0,0,.8);
        box-sizing:border-box;
        box-shadow:0 15px 25px rgba(0,0,0,.5);
        border-radius: 10px;/*登录窗口边角圆滑*/
    }
    .box h2
    {
        margin:0 0 30px;
        padding:0;
        color:#fff;
        text-align:center;
    }
    .box .inputBox
    {
        position:relative;
    }
    .box .inputBox input
    {
        width: 100%;
        padding: 10px 0;
        font-side:16px;
        color: #fff;
        letter-spacing: 1px;
        margin-bottom:30px;/*输入框设置*/
        border:none;
        border-bottom:1px solid #fff;
        outline:none;
        background:transparent;
    }
    .box .inputBox label
    {
        position: absolute;
        top: 0;
        left: 0;
        padding: 10px 0;
        font-size: 16px;
        color: #fff;
        pointer-events: none;
        transition: .5s;
    }
    .box .inputBox input:focus ~ label,
    .box .inputBox input:valid ~ label
    {
        top: -18px;
        left: 0;
        color: #03a9f4;
        font-size: 12px;
    }
    .box  input[type="submit"]
    {
        background: transparent;
        border: none;
        outline: none;
        color: #fff;
        background: #03a9f4;
        padding: 10px 20px;
        cursor: pointer;
        border-radius: 5px;
    }

</style>
<body>
<div class="box">
    <h2>饿了么系统用户登录</h2>
    <form>
        <div class="inputBox">
            <input type="text" name="username" required="" >
            <label>用户名</label>
        </div>
        <div class="inputBox">
            <input type="password" name="password" required="">
            <label>密码</label>
        </div>
<#--        <#list sellerInfo.content as ></#list>-->

<#--        <input type="submit" name="" value="登录">-->

        <button type="submit">
            <a href="/seller/product/list" style="text-decoration: none">登录</a>
        </button>

    </form>
</div>
</body>
</html>
