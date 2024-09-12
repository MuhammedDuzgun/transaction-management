package com.demo.transaction_management.service;

import com.demo.transaction_management.dto.OrderRequest;
import com.demo.transaction_management.dto.OrderResponse;

public interface IOrderService {
    OrderResponse placeOrder(OrderRequest orderRequest);
}
