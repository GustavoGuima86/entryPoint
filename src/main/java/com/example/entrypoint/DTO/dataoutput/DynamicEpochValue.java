package com.example.entrypoint.DTO.dataoutput;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
/**
 * The goal here is create an event for each DynamicEpochValue given in the input
 * this way we could process a big inputted JSON file in small messages in
 */
public class DynamicEpochValue {

    private String authenticationToken;
    private Integer dataSource;

    private Object startTimestampUnix;
    private Object endTimestampUnix;
    private Object createdAtUnix;
    private Integer dynamicValueType;
    private String value;
    private String valueType;
}
