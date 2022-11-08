package com.practice.kafka.demo.controller;

import com.practice.kafka.demo.kafka.payload.User;
import com.practice.kafka.demo.kafka.producer.JsonKafkaProducer;
import com.practice.kafka.demo.kafka.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/kafka/")
public class KafkaMessageController {

    @Autowired
    KafkaProducer kafkaProducer;

    @Autowired
    JsonKafkaProducer jsonKafkaProducer;


//  http:localhost:8090/api/kafka/publish?msg=hello world
    @GetMapping("publish")
    public ResponseEntity<String> publish(@RequestParam("msg") String msg){
       kafkaProducer.sendMessage(msg);
       return ResponseEntity.ok("message sent successfully");
    }



    @PostMapping("publish_json")
    public ResponseEntity<String> publish_json(@RequestParam("id")int id,
                                               @RequestParam("firstname")String firstname,
                                               @RequestParam("lastname")String lastname){

        User user = new User();
        user.setId(id);
        user.setFirstname(firstname);
        user.setLastname(lastname);

        jsonKafkaProducer.sendMessage(user);
        return ResponseEntity.ok("json sent successfully");
    }

}
