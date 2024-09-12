package com.demo.transaction_management.repository;

import com.demo.transaction_management.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<Order, Long> {
}
