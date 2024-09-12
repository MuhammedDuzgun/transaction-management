package com.demo.transaction_management.service.impl;

import com.demo.transaction_management.dto.OrderRequest;
import com.demo.transaction_management.dto.OrderResponse;
import com.demo.transaction_management.entity.Order;
import com.demo.transaction_management.entity.Payment;
import com.demo.transaction_management.exception.PaymentException;
import com.demo.transaction_management.repository.IOrderRepository;
import com.demo.transaction_management.repository.IPaymentRepository;
import com.demo.transaction_management.service.IOrderService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderServiceImpl implements IOrderService {

    private final IOrderRepository orderRepository;
    private final IPaymentRepository paymentRepository;

    public OrderServiceImpl(IOrderRepository orderRepository, IPaymentRepository paymentRepository) {
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    public OrderResponse placeOrder(OrderRequest orderRequest) {
        Order order = orderRequest.getOrder();
        order.setStatus("IN_PROGRESS");
        order.setOrderTrackingNumber(UUID.randomUUID().toString());
        orderRepository.save(order);

        Payment payment = orderRequest.getPayment();

        if(!payment.getType().equals("DEBIT")) {
            throw new PaymentException("Debit card is not supported");
        }

        payment.setOrderId(order.getId());
        paymentRepository.save(payment);

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderTrackingNumber(order.getOrderTrackingNumber());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setMessage("Order placed successfully");

        return orderResponse;
    }
}
