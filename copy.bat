@echo off
echo ��ǰ�̷���%~d0
echo ��ǰ�̷���·����%~dp0
echo ��ǰ�̷���·���Ķ��ļ�����ʽ��%~sdp0
echo ��ǰ������ȫ·����%~f0
echo ��ǰCMDĬ��Ŀ¼��%cd%
set page=%cd%\src\main\webapp
set todir=%cd%\project
set classes = %cd%\target\classes
rd /s /q %todir%
xcopy  %page% %todir% /c/q/e
xcopy %cd%\target\classes %cd%\project\WEB-INF\classes /c/q/e
pause