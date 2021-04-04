package nwmsu.bigdata.kafkajava.sec01.group02;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.*;
import java.lang.*;

public class ProducerByRajeev {
    private static Scanner in;

    public static void main(String[] argv) throws Exception {
        if (argv.length != 1) {
            System.err.println("Please specify 1 parameter (the name of the topic)");
            System.exit(-1);
        }
        String topicName = argv[0];
        in = new Scanner(System.in);
        System.out.println("Thank you for providing the topic " + topicName + "\n");
        System.out.println("Enter message (type exit to quit).\n");

        // Configure the Producer
        Properties configProperties = new Properties();
        configProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        configProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.ByteArraySerializer");
        configProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringSerializer");
        System.out.println("The configuration properties are: " + configProperties.toString());
        System.out.println("\nWill use this configuration to create a producer.\n");

        org.apache.kafka.clients.producer.Producer producer = new KafkaProducer(configProperties);

        // Make our own messages - create your custom logic here
        Random rand=new Random();

        for(int i = 1;i<11;i++) {
            
            int rand_int1 = rand.nextInt(100);
            String distance = "The numer "+rand_int1+" is "+(100-rand_int1)+" far from number 100 ";

            
            ProducerRecord<String, String> rec = new ProducerRecord<String, String>(topicName, distance);
            producer.send(rec);

        }


        String line = in.nextLine();
        while (!line.equals("exit")) {
            ProducerRecord<String, String> rec = new ProducerRecord<String, String>(topicName, line);
            producer.send(rec);
            line = in.nextLine();
        }

        in.close();
        producer.close();
    }
}
