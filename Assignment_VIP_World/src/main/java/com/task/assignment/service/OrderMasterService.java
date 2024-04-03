package com.task.assignment.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.task.assignment.model.OrderMaster;
import com.task.assignment.utility.ResponseStructure;

public interface OrderMasterService  {

	ResponseEntity<ResponseStructure<List<OrderMaster>>> getAllOrders();

	ResponseEntity<ResponseStructure<OrderMaster>> createOrder(int tradeId);

	ResponseEntity<ResponseStructure<OrderMaster>> findOrderById(Integer orderId);


}
