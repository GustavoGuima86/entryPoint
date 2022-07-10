package com.example.entrypoint.DTO.datainput;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DataSource {

    private Integer dataSource;

    private List<DynamicEpochValue> data;
}
