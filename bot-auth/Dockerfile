FROM java:8
MAINTAINER stsd_zjh@126.com
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
RUN mkdir -p /bot-auth
WORKDIR /bot-auth
EXPOSE 8081
ADD ./target/bot-auth-1.0-SNAPSHOT.jar ./
CMD java -Djava.security.egd=file:/dev/./urandom -jar bot-auth-1.0-SNAPSHOT.jar