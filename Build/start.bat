@ECHO OFF
cd /d "%~dp0"
:loop

java -Xincgc -Xms1024M -Xmx1024M -Dfile.encoding=UTF-8 -jar 1.9.4.jar

goto loop