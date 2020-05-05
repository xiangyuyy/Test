package com.example.demo.testdemo;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;

@Data
public class OnlineDTO implements Serializable {
   private static final long serialVersionUID = -3424301417396539142L;
   private Total total;
   private HashMap<String,Total> streams;
}
