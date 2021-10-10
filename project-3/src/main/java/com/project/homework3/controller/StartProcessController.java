package com.project.homework3.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.homework3.entity.StartProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

/**
 * @author Habib
 * @on 10/6/21 - 7:52 AM
 */
@RestController
@RequestMapping("/api")
public class StartProcessController {
    private final static String  URL = "http://localhost:8080/actuator/metrics/process.start.time";

    @Autowired
    RestTemplate restTemplate;
    //http://localhost:8080/actuator/metrics/process.start.time
    @GetMapping("/get/time")
    public ResponseEntity<String> getTimeProcess() throws JsonProcessingException

    {
        StartProcess startProcess= restTemplate.getForObject(URL,StartProcess.class);
        long timeInSeconds = (long) startProcess.getMeasurements().stream().findFirst().get().getValue();
      //  LocalDateTime localDateTime = LocalDateTime.ofEpochSecond(timeInSeconds, 0, ZoneOffset.UTC);
        LocalDateTime localDateTime= Instant.ofEpochSecond(timeInSeconds).atZone(ZoneId.systemDefault()).toLocalDateTime();

//ofEpochSeconde olmalı malli değil

        ObjectMapper objectMapper =new ObjectMapper();
       ResponseEntity<String> startProcessDifferentWay = restTemplate.getForEntity(URL,String.class);

      StartProcess startProcess1=  objectMapper.readValue(startProcessDifferentWay.getBody(),StartProcess.class);
      LocalDateTime localDateTime1= Instant.ofEpochSecond((long) startProcess1.getMeasurements().get(0).getValue())
              .atZone(ZoneId.systemDefault()).toLocalDateTime();


        return new ResponseEntity<>("server was started in "+localDateTime1,HttpStatus.OK );

      //  return new ResponseEntity<>("server was started in "+localDateTime,HttpStatus.OK );
    }
}
