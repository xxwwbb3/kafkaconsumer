package com.wenbo.kafkaconsumerhight;

public class Hight {
       public static void exe(String[] args) {
           String brokerList = "192.168.237.129:9092";
           String groupId = "group2";
           String[] topics = {"test","test1"};
           int workerNum = 5;

           ConsumerHandler consumers = new ConsumerHandler(brokerList, groupId, topics);
           consumers.execute(workerNum);
           try {
               Thread.sleep(1000000);
           } catch (InterruptedException ignored) {}
           consumers.shutdown();
       }
}
