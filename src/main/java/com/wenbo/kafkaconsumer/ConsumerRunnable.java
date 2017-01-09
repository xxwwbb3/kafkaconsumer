package com.wenbo.kafkaconsumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

public class ConsumerRunnable implements Runnable {

    // ÿ���߳�ά��˽�е�KafkaConsumerʵ��
    private final KafkaConsumer<String, String> consumer;

    public ConsumerRunnable(String brokerList, String groupId, String[] topics) {
        Properties props = new Properties();
        props.put("bootstrap.servers", brokerList);
        props.put("group.id", groupId);
        props.put("enable.auto.commit", "true");        //����ʹ���Զ��ύλ��
        props.put("auto.commit.interval.ms", "1000");
        props.put("session.timeout.ms", "30000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        this.consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList(topics));   // ����ʹ�÷��������Զ��������
    }

    @Override
    public void run() {
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(200);   // ����ʹ��200ms��Ϊ��ȡ��ʱʱ��
            for (ConsumerRecord<String, String> record : records) {
                // ������д������Ϣ���߼���������ֻ�Ǽ򵥵ش�ӡ��Ϣ
                System.out.println(Thread.currentThread().getName() + " consumed " +"topic: "+record.topic() + ", "+ record.partition() +
                        ", messageOffset: " + record.offset()+", value: "+ record.value());
            }
        }
    }
}