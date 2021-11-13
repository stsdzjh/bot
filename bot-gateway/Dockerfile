FROM java:8
MAINTAINER stsd_zjh@126.com
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
RUN mkdir -p /bot-gateway
WORKDIR /bot-gateway
EXPOSE 80
ADD ./target/bot-gateway-1.0.1.jar ./
CMD java -Djava.security.egd=file:/dev/./urandom -jar bot-gateway-1.0.1.jar