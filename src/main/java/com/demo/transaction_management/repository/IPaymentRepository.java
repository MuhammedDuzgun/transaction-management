package com.demo.transaction_management.repository;

import com.demo.transaction_management.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPaymentRepository extends JpaRepository<Payment, Long> {

}
