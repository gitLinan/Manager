# Manager模块说明

## build 部署模块
docker.sh 构建docker容器脚本，使用方法：sh docker.sh 模块名称 版本 Tag

### 提供两种docker应用部署方案

#### 第一种 docker-swarm
docker-compose.yml 在docker-swarm集群执行以下命令来部署微服务

docker stack up -c docker-compose.yml manager --with-registry-auth

#### 第二种 K8S
docker-k8s.yaml 在k8s集群执行以下命令来部署微服务

kubectl create -f docker-k8s.yaml


## docker 创建镜像模块
DockerFile      创建image使用

check_start.py  辅助脚本，检查nacos是否可用

check_start.sh  辅助脚本，检查nacos是否可用


## docs 文档模块
manager.sql     DDL
RestApi.html    Rest API documentation


## src  java源码模块

### aop         切面模块，执行切面方法
### common      公共模块，提供全局异常处理、统一返回类型控制等
### config      配置模块，提供项目运行组件必须的配置Bean
### controller  控制器模块，控制器方法
### exception   异常模块，自定义异常
### mapper      mybatis-plus的mapper模块
### model       模型模块，有实体对象，VO，BO等
### service     服务模块，主要处理业务逻辑
### soa         soa模块，提供其他服务的RPC调用抽象本地化 
### utils       工具类模块     



