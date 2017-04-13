@echo off
echo 当前盘符：%~d0
echo 当前盘符和路径：%~dp0
echo 当前盘符和路径的短文件名格式：%~sdp0
echo 当前批处理全路径：%~f0
echo 当前CMD默认目录：%cd%
set page=%cd%\src\main\webapp
set todir=%cd%\project
set classes = %cd%\target\classes
rd /s /q %todir%
xcopy  %page% %todir% /c/q/e
xcopy %cd%\target\classes %cd%\project\WEB-INF\classes /c/q/e
pause