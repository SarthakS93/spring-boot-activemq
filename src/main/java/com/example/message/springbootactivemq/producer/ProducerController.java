/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.message.springbootactivemq.producer;

import javax.jms.Queue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sarthak
 */
@RestController
@RequestMapping("/rest/publish")
public class ProducerController {
    
    private static final Logger log = LoggerFactory.getLogger(ProducerController.class);
    
    @Autowired
    private Queue queue;
    
    
    @Autowired
    private JmsTemplate jmsTemplate;
    
    @RequestMapping(value = "/{msg}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String publish(@PathVariable("msg") String msg) {
        log.info("Publish {} as msg in queue", msg);
        jmsTemplate.convertAndSend(queue, msg);
        return "Published Successfully";        
    }
    
    
    
}
