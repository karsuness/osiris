package com.wjx.aphelios.activemq.springjms;

/**
 * @author WJX
 * @since 2018/4/29 18:51
 */

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * spring整合后PTP消息发送生产者
 */
@Component("queueProducer")
public class QueueProducer {
    @Resource(name="queueDestination")
    private Destination destination;

    @Resource(name = "jmsTemplate")
    private JmsTemplate jmsTemplate;

    public void sendTextMessage(String text){
        jmsTemplate.send(destination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(text);
            }
        });
    }
}
