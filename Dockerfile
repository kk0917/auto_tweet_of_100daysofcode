FROM centos:7

LABEL maintainer="KKKK"

ENV JAVA_HOME=/usr/lib/jvm/java-11-openjdk \
    SCALA_HOME=/usr/local/scala \
    SCALA_VERSION=scala-2.13.1

WORKDIR /usr/local/lib/

SHELL ["/bin/bash", "-c"]

RUN : " *** nginx install ***" \
  && { \
        echo '[nginx-stable]'; \
        echo 'name=nginx stable repo'; \
        echo 'baseurl=http://nginx.org/packages/centos/$releasever/$basearch/'; \
        echo 'gpgcheck=1'; \
        echo 'enabled=1'; \
        echo 'gpgkey=https://nginx.org/keys/nginx_signing.key'; \
        echo 'gpgkey=https://nginx.org/keys/nginx_signing.key'; \
     } > /etc/yum.repos.d/nginx.repo \
  && yum -y update \
  && yum -y install nginx \
  && yum clean all \
  && systemctl enable nginx \
  && nginx -v \
  && : " *** JDK install ***" \
  && yum -y install java-11-openjdk-devel.x86_64 \
  && yum clean all \
  && export JAVA_HOME=${JAVA_HOME}/bin \
  && export PATH=$PATH:${JAVA_HOME}/bin \
  && java -version \
  && javac -version \
  && : " *** Scala install ***" \
  && curl -Os https://downloads.lightbend.com/scala/2.13.1/scala-2.13.1.tgz \
  && tar zxvf scala-2.13.1.tgz \
  && ln -s ${SCALA_VERSION} scala \
  && mv ${SCALA_VERSION} ${SCALA_HOME} \
  && echo "SCALA_HOME=${SCALA_HOME}/bin" >> /etc/profile.d/scala.sh \
  && echo "PATH=$PATH:${SCALA_HOME}/bin" >> /etc/profile.d/scala.sh \
  && source /etc/profile.d/scala.sh \
  && cd \
  && scala -version \
  && : "*** sbt install ***" \
  && curl https://bintray.com/sbt/rpm/rpm | tee /etc/yum.repos.d/bintray-sbt-rpm.repo \
  && yum -y install sbt \
  && yum clean all \
  && sbt -version \
  && ln -sf /usr/share/zoneinfo/Asia/Tokyo /etc/localtime \
  && mkdir -p -m 755 ./app

WORKDIR /app

EXPOSE 80

CMD ["/sbin/init"]