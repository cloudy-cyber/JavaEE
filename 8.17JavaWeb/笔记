步骤：

1、创建javaweb工程

2、在web目录下，添加html页面 --- regist.html

3、在src目录下创建Servlet --- RegistServlet，配置Servlet的urlPatterns --- /regist.do

4、在html中，添加form，表单中元素，submit类型的按钮

​	在form 标签中添加action属性，action 属性写的是servlet的路径

​	当用户点击submit按钮，浏览器就会向服务器发送请求，地址是action属性

​	地址的后面会跟上参数 表单元素name=表单元素value

5、服务器端，tomcat接收到浏览器请求后，解析解析请求的内容，封装到Request对象中，

并且依据请求路径，去找对应的Servlet，调用Servlet 对象中的doGet方法，并且把Request对象

和Response对象传入到doGet方法中

6、在doGet方法中利用request.getParameter("表单元素name") 获取浏览器提交的参数的值

7、利用response对象，得到io流对象，利用io流对象，将html代码返回给浏览器