@echo off
echo 当前盘符：%~d0
echo 当前盘符和路径：%~dp0
echo 当前盘符和路径的短文件名格式：%~sdp0
echo 当前批处理全路径：%~f0
echo 当前CMD默认目录：%cd%
set page=%cd%\src\main\webapp
set todir=%cd%\project
xcopy  %page% %todir% /c/q/e
if exist %cd%\project (
   echo 已经存在文件夹
) else (
    echo 创建工程文件夹
	md %cd%\project
)
if exist %cd%\target\classes (
   echo 删除指定目录：%cd%\target\classes
)
rd /s /q %cd%\target\classes
echo 编译项目源代码...
mvn compile
echo 编译项目源代码成功！

pause