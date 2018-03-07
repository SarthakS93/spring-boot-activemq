/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.message.springbootactivemq.config;

import javax.jms.Queue;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

/**
 *
 * @author sarthak
 */
@Configuration
@EnableJms
public class Config {
    
    @Bean
    public Queue queue() {
        return new ActiveMQQueue("inmemory.queue");
    }
    
}
