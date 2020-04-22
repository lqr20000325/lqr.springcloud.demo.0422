package com.lqr.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class Order implements Serializable {
    private Integer id;
    private String orderno;
    private Integer userid;
    private String username;
}
