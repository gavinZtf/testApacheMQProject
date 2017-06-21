/**
 * 
 */
package com.ztf.activemq.consumer;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.TextMessage;
import javax.annotation.Resource;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

/**
 * @author 张腾飞--Gavin
 * 2017年6月22日
 *
 */
@Service
public class ConsumerService {

    @Resource(name="jmsTemplate")
    private JmsTemplate jmsTemplate;
     
    /**
     * 接收消息
     */
    public TextMessage receive(Destination destination) {
        TextMessage tm = (TextMessage) jmsTemplate.receive(destination);
        try {
            System.out.println("从队列" + destination.toString() + "收到了消息：\t"
                    + tm.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
        
        return tm;
        
    }
 
}