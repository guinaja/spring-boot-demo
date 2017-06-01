KAFKA
---------------------------------------------------
http://kafka.apache.org/
-download
    https://www.apache.org/dyn/closer.cgi?path=/kafka/0.10.2.1/kafka_2.10-0.10.2.1.tgz
-command
    cd D:\APPSERVER\kafka_2.10-0.10.2.1
    .\bin\windows\kafka-server-start.bat .\config\server.properties

ZOOKEEPER
---------------------------------------------------
https://zookeeper.apache.org/
-download
    http://www.apache.org/dyn/closer.cgi/zookeeper/
-command
    D:\APPSERVER\zookeeper-3.4.10\bin\zkServer.cmd

---------------------------------------------------
KAFKA-MANAGER (Docker)
---------------------------------------------------
https://github.com/yahoo/kafka-manager
-download
    https://hub.docker.com/r/dockerkafka/kafka-manager/
-command
    docker run -d --name kafkadocker_manager -p 9000:9000 -e ZK_HOSTS=prayoon-pc:2181 dockerkafka/kafka-manager

---------------------------------------------------
REFERENCE
---------------------------------------------------
https://saixiii.com/apache-kafka/
