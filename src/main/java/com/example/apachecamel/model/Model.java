package com.example.apachecamel.model;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@ToString
@Accessors(chain = true)
public class Model implements Serializable {

    private static long serialVersionUID = 1L;

    private Long id;
    private String message;
}
