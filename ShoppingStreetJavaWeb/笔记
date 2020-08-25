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



MVC开发流程

1、根据业务需求，完善dao和service

2、添加一个servlet

3、前端页面，修改form中的action或者修改超链接，将跳转的url指向第二步的Servlet

4、在Servlet中

​		接收参数

​		调用Service，得到结果

​		分支判断，依据判断结果，把相应的信息放入到request的Attribute中

​		请求转发到一个页面

5、在结果页面中，取出request中的Attribute中的值，显示

