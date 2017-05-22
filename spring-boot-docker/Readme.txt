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
phpmyadmin  localhost:8080
mysql       localhost:3306
spring-boot localhost:8081

--------------------------------
Path log spring boot
--------------------------------
Container :/app/logs/  -> local : /docker/logs