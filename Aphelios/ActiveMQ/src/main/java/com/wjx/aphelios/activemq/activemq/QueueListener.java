package com.wjx.aphelios.activemq.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

/**
 * @author WJX
 * @since 2018/4/29 17:01
 */
public class QueueListener {
    public static void main(String[] args) throws JMSException, IOException {
        //1.创建JMS工厂
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.25.131:61616");
        //2.创建连接
        Connection connection = connectionFactory.createConnection();
        //3.开启连接
        connection.start();
        //4.创建session,参数1是否使用事物，false为自动提交，参数2为提交的方式
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //5.创建队列
        Queue queue = session.createQueue("queue");
        //6.创建消费者
        MessageConsumer consumer = session.createConsumer(queue);
        //7.设置监听
        //匿名内部类版
        /*consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage) message;
                try {
                    System.out.println(textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
    });*/
        //lambda版
        consumer.setMessageListener(e->{
            TextMessage message = (TextMessage) e;
            try {
                System.out.println(message.getText());
            } catch (JMSException exception) {
                exception.printStackTrace();
            }
        });
        //8.等待状态
        System.in.read();
        //9.关闭资源
        consumer.close();
        session.close();
        connection.close();
    }
}
