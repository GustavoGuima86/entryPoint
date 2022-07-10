package com.example.entrypoint.controllers;

import com.example.entrypoint.DTO.datainput.DataInput;
import com.example.entrypoint.services.DynamicEpochValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/epoch")
public class DynamicEpochValueController {

    @Autowired
    DynamicEpochValueService dynamicEpochValueService;

    @PostMapping()
    public void createClient(@RequestBody List<DataInput> epochSource){
        dynamicEpochValueService.inputDataEpoch(epochSource);
    }
}
