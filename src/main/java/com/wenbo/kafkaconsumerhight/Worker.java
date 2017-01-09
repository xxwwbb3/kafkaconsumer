package com.wenbo.kafkaconsumerhight;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public class Worker implements Runnable {

    private ConsumerRecord<String, String> consumerRecord;

    public Worker(ConsumerRecord record) {
        this.consumerRecord = record;
    }

    @Override
    public void run() {
        // ����д�����Ϣ�����߼���������ֻ�Ǽ򵥵ش�ӡ��Ϣ
        System.out.println(Thread.currentThread().getName() + " consumed " +"topic: "+consumerRecord.topic() + ", "+ consumerRecord.partition() +
                ", messageOffset: " + consumerRecord.offset()+", value: "+ consumerRecord.value());
    }
}