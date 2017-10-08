#!/usr/bin/env bash
rm nohup.out 2> /dev/null;
nohup mvn clean install tomcat7:run &
echo $! > nohupPid.txt;
chmod 777 nohup.out;
tail -f nohup.out;