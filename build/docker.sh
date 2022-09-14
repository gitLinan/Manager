#!/bin/bash

function buildModule()
{
  if [ "$1" = "base" ] ; then
    echo -e "FROM centos:7\\f
            MAINTAINER mobai\\f
            RUN yum update -y &&  yum install -y kde-l10n-Chinese glibc-common && localedef -c -f UTF-8 -i zh_CN zh_CN.utf8 && \
            export LANG=zh_CN.UTF-8 && echo 'export LANG=zh_CN.UTF-8' >> /etc/locale.conf\\f
            ENV LANG zh_CN.UTF-8\\f
            ENV LC_ALL zh_CN.UTF-8\\f
            RUN yum -y install java-1.8.0-openjdk java-1.8.0-openjdk-devel &&  mkdir -p /opt/manager && \
        cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && echo Asia/Shanghai > /etc/timezone" > Dockerfile && \
        docker build -t base:v1 . && rm -rf Dockerfile
  else
    cd ../ && mvn clean install -pl $1 -U -e -am && \
        cd $1 && \
        mvn com.spotify:docker-maven-plugin:1.2.2:build && \
        docker login xxx.com -u user -p password && \
        docker tag mobai/$1:latest xxx.com/manager-$1-$2:$3 && \
        docker push xxx.com/manager-$1-$2:$3
  fi
}

if [ $# == 3 ];then
  buildModule $1 $2 $3
else
    echo "请检查参数，第一个参数为模块，第二个参数为版本，第三个参数为tag"
fi
