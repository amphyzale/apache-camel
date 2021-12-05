package com.example.apachecamel.model;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@ToString
@Accessors(chain = true)
public class Info implements Serializable {

    private static long serialVersionUID = 1L;

    private String stringData;
    private Long longData;
    private BigDecimal numberData;
    private LocalDateTime dateTimeData;

}
