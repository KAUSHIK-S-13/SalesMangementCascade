package com.sales.management.ExceptionHandling;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@Component
public class CustomException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private String errorCode;
    private String errorMsg;

    public CustomException(String errorCode,String errorMsg){
        super();
        this.errorCode=errorCode;
        this.errorMsg=errorMsg;
    }
}
