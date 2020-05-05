package com.example.demo.testdemo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Total implements Serializable {
    private static final long serialVersionUID = -3424301417396539142L;
    private int bandwidth;
    private int count;
}
