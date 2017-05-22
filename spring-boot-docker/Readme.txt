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