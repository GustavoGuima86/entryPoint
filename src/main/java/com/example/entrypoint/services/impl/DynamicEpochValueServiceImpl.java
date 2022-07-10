package com.example.entrypoint.services.impl;

import com.example.entrypoint.DTO.datainput.DataInput;
import com.example.entrypoint.DTO.datainput.DataSource;
import com.example.entrypoint.DTO.dataoutput.DynamicEpochValue;
import com.example.entrypoint.components.QueueSender;
import com.example.entrypoint.services.DynamicEpochValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DynamicEpochValueServiceImpl implements DynamicEpochValueService {

    @Autowired
    private QueueSender queueSender;

    /**
     * create and send data createAndSendDynamicEpochValueInput to Rabbit
     * not validating here we're only enqueue the messages individually to a second system process it and save
     * @param data
     */
    @Override
    public void inputDataEpoch(List<DataInput> data) {
        data.forEach(dataInput -> {
            dataInput.getDataSources().forEach(dataSource -> {
                dataSource.getData().forEach(dynamicEpochValueInput -> {
                    createAndSendDynamicEpochValueInput(dataInput, dataSource, dynamicEpochValueInput);
                });
            });
        });
    }

    private void createAndSendDynamicEpochValueInput(DataInput dataInput, DataSource dataSource, com.example.entrypoint.DTO.datainput.DynamicEpochValue dynamicEpochValueInput) {
        //using a Builder and values to value creation, but we could create a modelMapper to do it for part of the object
        var dynamicEpochValueOutput = DynamicEpochValue.builder()
                .authenticationToken(dataInput.getAuthenticationToken())
                .dataSource(dataSource.getDataSource())
                .startTimestampUnix(dynamicEpochValueInput.getStartTimestampUnix())
                .endTimestampUnix(dynamicEpochValueInput.getEndTimestampUnix())
                .createdAtUnix(dynamicEpochValueInput.getCreatedAtUnix())
                .dynamicValueType(dynamicEpochValueInput.getDynamicValueType())
                .value(dynamicEpochValueInput.getValue())
                .valueType(dynamicEpochValueInput.getValueType()).build();

        queueSender.send(dynamicEpochValueOutput);
    }
}
