package com.wjx.aphelios.activemq.springjms;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * @author WJX
 * @since 2018/4/29 22:44
 */
@Component("topicProducer")
public class TopicProducer {
    @Resource(name = "jmsTemplate")
    private JmsTemplate jmsTemplate;
    @Resource(name = "topicDestination")
    private Destination topicDestination;

    public void send(String context) {
        jmsTemplate.send(topicDestination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
               return session.createTextMessage(context);
            }
        });
    }
}
