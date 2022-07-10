package com.example.entrypoint.DTO.datainput;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DynamicEpochValue {

    private Long startTimestampUnix;
    private Long endTimestampUnix;
    private Long createdAtUnix;
    private Integer dynamicValueType;
    private String value;
    private String valueType;
}
