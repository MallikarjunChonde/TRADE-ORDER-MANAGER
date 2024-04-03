package com.task.assignment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.assignment.model.OrderMaster;
import com.task.assignment.model.TradeDetails;

public interface OrderMasterRepository extends JpaRepository<OrderMaster, Integer> {
	List<OrderMaster> findByTradeDetails(TradeDetails tradeDetails);
}
