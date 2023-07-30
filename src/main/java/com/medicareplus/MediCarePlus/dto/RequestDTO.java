package com.medicareplus.MediCarePlus.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data

public class RequestDTO {

    private String code;
    private String messege;
    private Object content;
}
