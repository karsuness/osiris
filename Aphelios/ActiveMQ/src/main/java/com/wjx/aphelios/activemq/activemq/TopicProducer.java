package com.wjx.aphelios.activemq.activemq;

/**
 * @author WJX
 * @since 2018/4/27 20:48
 */

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * PTP模式生产者
 */
public class TopicProducer {
    public static void main(String[] args) throws JMSException {
        //1.创建连接工厂
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.25.131:61616");
        //2.创建连接
        Connection connection = connectionFactory.createConnection();
        //3.启动连接
        connection.start();
        //4.获取session会话对象，参数1表示是否开启事务，false的话自动提交，参数2消息的确认方式
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //5.创建队列对象,参数是队列名称，随意
        Topic topic = session.createTopic("topic");
        //6.创建消息生产对象
        MessageProducer producer = session.createProducer(topic);
        //7.创建消息
        TextMessage message = session.createTextMessage("ptp");
        //8.发送消息
        producer.send(message);
        //9.关闭资源
        producer.close();
        session.close();
        connection.close();
    }
}