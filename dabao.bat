@echo off
echo ��ǰ�̷���%~d0
echo ��ǰ�̷���·����%~dp0
echo ��ǰ�̷���·���Ķ��ļ�����ʽ��%~sdp0
echo ��ǰ������ȫ·����%~f0
echo ��ǰCMDĬ��Ŀ¼��%cd%
set page=%cd%\src\main\webapp
set todir=%cd%\project
xcopy  %page% %todir% /c/q/e
if exist %cd%\project (
   echo �Ѿ������ļ���
) else (
    echo ���������ļ���
	md %cd%\project
)
if exist %cd%\target\classes (
   echo ɾ��ָ��Ŀ¼��%cd%\target\classes
)
rd /s /q %cd%\target\classes
echo ������ĿԴ����...
mvn compile
echo ������ĿԴ����ɹ���

pause