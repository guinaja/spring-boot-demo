Build
--------------------------------
mvn -U clean package

--------------------------------
Run
--------------------------------
docker-compose up -d

--------------------------------
Logging by container-id
--------------------------------
docker logs -f mysql
docker logs -f spring-boot

--------------------------------
Environment
--------------------------------
phpmyadmin  localhost:8080      localhost:8080  [root/pass]
mysql       localhost:3306      localhost:3306  [root/pass]
spring-boot localhost:8081      http://localhost:8081/superhero

--------------------------------
Path log spring boot
--------------------------------
Container :/app/logs/  -> local : /docker/logs


--------------------------------
ElasticSearch config bat file
--------------------------------
set JAVA_HOME="D:\JAVA_JDK\jdk1.8.0_20"
set JAVA="%JAVA_HOME%\bin\java.exe"
set ES_HOME="D:\APPSERVER\ELK\elasticsearch-5.4.0"

** path elasticsearch node / data on %ES_HOME%/config/elasticsearch.yml

elasticsearch.bat

http://localhost:9200/_search?pretty

--------------------------------
Logstash config bat file
--------------------------------
set LS_HOME="D:\APPSERVER\ELK\logstash-5.4.0"

*reference to external config file
logstash.bat -f D:\_WORK\project-intelliJ\spring-boot-demo\spring-boot-docker\src\main\resources\logstash\logstash-custom.conf

refresh spring boot / check log console
http://localhost:9600

--------------------------------
Kibana
--------------------------------

kibana.bat

http://localhost:5601