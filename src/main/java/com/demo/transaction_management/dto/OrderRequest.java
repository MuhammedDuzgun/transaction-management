package com.demo.transaction_management.dto;

import com.demo.transaction_management.entity.Order;
import com.demo.transaction_management.entity.Payment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {
    private Order order;
    private Payment payment;
}
