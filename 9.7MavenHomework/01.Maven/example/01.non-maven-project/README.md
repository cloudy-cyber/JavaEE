
编译单元测试
```
javac -cp lib/junit-4.12.jar App.java AppTest.java 
```

运行单元测试

必须指定classpath 中的./

必须增加 hamcrest-core-1.3.jar 运行单元测试 
```
java -cp lib/*:./ org.junit.runner.JUnitCore AppTest
```


编译命令

```
javac -cp lib/dom4j-1.6.1.jar src/club/banyuan/main/Main.java src/club/banyuan/servlet/*.java -d out
```

直接执行class文件的运行命令
```
java -cp out:lib/dom4j-1.6.1.jar:resources club.banyuan.main.Main
```


压缩jar包命令
```
jar cf app.jar -C out club
```

给与脚本执行权限
```
chmod 777 run.sh
```