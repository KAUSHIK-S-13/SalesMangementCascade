package com.sales.management.BaseResponse;


import lombok.Getter;
import lombok.Setter;
@Getter
@Setter


public class APIResponse<T> {

    int recordCount;
    T response;
}