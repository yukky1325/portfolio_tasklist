FROM mysql:8.0-debian
RUN apt-get update
RUN apt-get -y install locales-all
ENV LANG ja_JP.UTF-8
ENV LANGUAGE ja_JP:ja
ENV LC_ALL ja_JP.UTF-8
COPY ./conf/mysql/my.cnf /etc/my.cnf
FROM mysql:latest
COPY conf/mysql/my.cnf /etc/mysql/my.cnf
RUN chmod 644 /etc/mysql/my.cnf && chown root:root /etc/mysql/my.cnf
RUN mkdir -p /var/run/mysqld && chown mysql:mysql /var/run/mysqld
