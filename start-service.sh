rm -rf *.log

echo "Starting -> netflix-eureka-service "
cd netflix-eureka-service
mvn spring-boot:run > netflix-eureka-service.log 2>&1 &
cd ..


echo "Starting -> observer-service "
cd observer-service
mvn spring-boot:run > observer-service.log 2>&1 &
cd ..


echo "Starting -> api-gateway "
cd api-gateway
mvn -P api-gateway spring-boot:run > api-gateway.log 2>&1 &
cd ..


echo "Starting -> user-service "
cd user-service
mvn  spring-boot:run > user-service.log 2>&1 &
cd ..

echo "Starting -> order-service "
cd order-service
mvn spring-boot:run > order-service.log 2>&1 &
cd ..