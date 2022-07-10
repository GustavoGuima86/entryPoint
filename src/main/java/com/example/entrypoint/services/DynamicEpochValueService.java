package com.example.entrypoint.services;

import com.example.entrypoint.DTO.datainput.DataInput;

import java.util.List;

public interface DynamicEpochValueService {

    void inputDataEpoch(List<DataInput> data);
}
