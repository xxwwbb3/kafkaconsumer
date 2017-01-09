package com.wenbo.kafkaconsumer;

public class App {
    public static void main(String[] args) {
        String brokerList = "192.168.237.129:9092";
        String groupId = "testGroup1";
        String[] topics = { "test", "test1" };
        int consumerNum = 4;

        ConsumerGroup consumerGroup = new ConsumerGroup(consumerNum, groupId, topics, brokerList);
        consumerGroup.execute();
    }
}
