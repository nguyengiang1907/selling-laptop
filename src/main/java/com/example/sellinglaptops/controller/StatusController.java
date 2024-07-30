package com.example.sellinglaptops.controller;

import com.example.sellinglaptops.model.Status;
import com.example.sellinglaptops.service.status.IStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/status")
public class StatusController {
    @Autowired
    private IStatusService iStatusService;
    @GetMapping
    private ResponseEntity<List<Status>> getAllStatus(){
        List<Status> statusList = (List<Status>) iStatusService.findAll();
        if (statusList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(statusList,HttpStatus.OK);
        }
    }
}
