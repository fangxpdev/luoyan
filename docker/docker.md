docker run 
docker pull
docker run

批量删除docker容器
docker rm $(docker ps -qa)

启动不退出容器
docker run -it centos

docker exec ${id} /bin/bash

--启动不退出
docker run centos /bin/bash -c "while true; do echo hello world; sleep 2; done"

停止
docker stop
docker kill

安装mysql
docker run --name mysql -e MYSQL_ROOT_PASSWORD=123456 -p 3307:3306 -d mysql:5.7.29

安装jdk
docker pull 

docker pull tomcat:8.5.53-jdk8


docker pull nginx:

数据卷：实现数据的持久化
docker run -it -v /mydatas:/container/datas centos

dockerfile:是镜像的描述文件，描述了我们的镜像是如何一步步构成的。

FROM 
MAINTAINER
ADD
COPY
RUN
ENV
CMD
WORKDIR
ENTRYPOINT

