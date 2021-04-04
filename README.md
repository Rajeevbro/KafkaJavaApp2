## Rajeev Chapagain 
## Kafka app2
 - ### Command to run zookeeper
 ```
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
```
 - ### Command to start kafka
 ```
.\bin\windows\kafka-server-start.bat .\config\server.properties
```
- ### Command to create new topic
```
.\bin\windows\kafka-topics.bat --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --create --topic test2
```
- ### Open the root directory and run this command
```
mvn clean compile assembly:single
```

- ### starting consumer (Open the root directory and run this command)
```
java -cp target/kafka-java-app-group-1.0-SNAPSHOT-jar-with-dependencies.jar nwmsu.bigdata.kafkajava.sec01.group02.Consumer test2 group02
```
- ### starting producer (Open the root directory and run this command)
```
java -cp target/kafka-java-app-group-1.0-SNAPSHOT-jar-with-dependencies.jar nwmsu.bigdata.kafkajava.sec01.group02.ProducerByRajeev test2
```