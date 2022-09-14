#!/bin/sh

python check_start.py
if [ $? -eq 0 ]; then
  exec java $JAVA_OPTS -jar -Djava.security.egd=file:/dev/./urandom manager.jar
else
  exit 1
fi