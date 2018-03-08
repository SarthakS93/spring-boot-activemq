/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.message.springbootactivemq.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 *
 * @author sarthak
 */
@Component
public class Consumer {
    
    private static final Logger log = LoggerFactory.getLogger(Consumer.class);
   
    @JmsListener(destination = "standalone.queue")
    public void consume(String msg) {
        log.info("Received msg : {}", msg);
    }
    
}
