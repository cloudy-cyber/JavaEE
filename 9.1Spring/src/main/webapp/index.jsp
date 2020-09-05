<%--
  Created by IntelliJ IDEA.
  User: edz
  Date: 2020/9/1
  Time: 10:58 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="parent/test?param=value">TestController</a>
<br/>
<a href="parent/test">不带参TestController</a>
<br/>
<a href="parent/test4/xss">TestController With Value</a>
<br/>
<a href="parent/test5">Read Cookie</a>

<form action="parent/test3" method="post">
    <input type="text" name="userId" value="234" />
    <br/>
    <input type="text" name="username" value="中文"/>
    <br/>
    <input type="password" name="password" value="dsfljl"/>
    <br/>
    <input type="text" name="birth" value="3/3/2000"/>
    <br/>
    <input name="fav" type="checkbox" value="music" checked/>music
    <input name="fav" type="checkbox" value="movie" checked/>movie
    <input name="fav" type="checkbox" value="football" checked/>football
    <br/>
    <br/>
    <hr>
    <input type="text" name="userAddress[0].province" value="JiangSu" />
    <input type="text" name="userAddress[0].city" value="NanJing">
    <hr/>
    <input type="text" name="userAddress[1].province" value="JiangSu"/>
    <input type="text" name="userAddress[1].city" value="ZhengJiang">
    <hr/>
    <input type="text" name="userAddress[2].province" value="JiangSu"/>
    <input type="text" name="userAddress[2].city" value="YangZhou">
    <hr/>
    <br/>
    <input type="text" name="userAdrMap['one'].province" value="JiangSu" />
    <input type="text" name="userAdrMap['one'].city" value="NanJing">
    <hr/>
    <input type="text" name="userAdrMap['two'].province" value="JiangSu"/>
    <input type="text" name="userAdrMap['two'].city" value="ZhengJiang">
    <hr/>
    <input type="text" name="userAdrMap['thr'].province" value="JiangSu"/>
    <input type="text" name="userAdrMap['thr'].city" value="YangZhou">
    <hr/>
    <input type="submit" value="提交"/>
</form>

</body>
</html>