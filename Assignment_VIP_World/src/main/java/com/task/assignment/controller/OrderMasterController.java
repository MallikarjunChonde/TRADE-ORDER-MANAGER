package com.task.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.assignment.model.OrderMaster;
import com.task.assignment.service.OrderMasterService;
import com.task.assignment.utility.ResponseStructure;

@RestController
@CrossOrigin
public class OrderMasterController {
	
	@Autowired
	private OrderMasterService orderMasterService;
	
	@PostMapping(value = "/trade-details/{tradeId}/order-masters")
	public ResponseEntity<ResponseStructure<OrderMaster>> createOrder(@PathVariable int tradeId) {
		return orderMasterService.createOrder(tradeId);
	}
	
	
	@GetMapping(value = "/order-master/find-by-trade/{orderId}")
	public ResponseEntity<ResponseStructure<OrderMaster>> findOrderById(@PathVariable Integer orderId) {
		return orderMasterService.findOrderById(orderId);
	}
	
	
	@GetMapping(value = "/order-master/fetchAll")
	public ResponseEntity<ResponseStructure<List<OrderMaster>>>getAllOrders(){
		return orderMasterService.getAllOrders();
	}
	

}
