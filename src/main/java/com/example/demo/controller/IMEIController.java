package com.example.demo.controller;

import com.example.demo.beans.IMEI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path="/home",produces="application/json")
@CrossOrigin(origins="*")       
public class IMEIController {
  @PostMapping(consumes="application/json")
  public ResponseEntity<Integer> postTaco(@RequestBody IMEI i) {
    if(!i.isValid()){
      return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
    i.correct();
    return new ResponseEntity<>(i.getLastDigit(), HttpStatus.OK);
  }
}