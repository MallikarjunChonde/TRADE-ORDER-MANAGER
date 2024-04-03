package com.task.assignment.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.task.assignment.exception.OrderMasterNotFoundException;
import com.task.assignment.model.OrderMaster;
import com.task.assignment.repository.OrderMasterRepository;
import com.task.assignment.repository.TradeDetailsRepository;
import com.task.assignment.service.OrderMasterService;
import com.task.assignment.utility.ResponseStructure;

@Service
public class OrderMasterServiceImpl implements OrderMasterService{
	
	@Autowired
	private OrderMasterRepository repo;
	@Autowired
	private TradeDetailsRepository tradeRepo;
	@Autowired
	private ResponseStructure<OrderMaster> responseStructure;
	@Autowired
	private ResponseStructure<List<OrderMaster>> responseStructureList;
	    

	@Override
	public ResponseEntity<ResponseStructure<OrderMaster>> createOrder(int tradeId) {
		return tradeRepo.findById(tradeId).map(trade -> {
			OrderMaster order = new OrderMaster();
			order.setTradeDetails(trade);
			order.setOrderStatus("CREATED");
			order = repo.save(order);
			return ResponseEntity.ok(responseStructure.setData(order)
					.setMessgae("Order Master Created")
					.setStatusCode(HttpStatus.OK.value()));
		}).orElseThrow();
	}

	@Override
	public ResponseEntity<ResponseStructure<List<OrderMaster>>> getAllOrders() {
		List<OrderMaster> allOrders = repo.findAll();
		return ResponseEntity.ok(responseStructureList.setStatusCode(HttpStatus.OK.value())
														.setMessgae("all orders are founded Sucessfully!!")
														.setData(allOrders));
	}


	@Override  
	public ResponseEntity<ResponseStructure<OrderMaster>> findOrderById(Integer id) {
		return repo.findById(id).map(ordermaster->ResponseEntity.ok(responseStructure.setStatusCode(HttpStatus.OK.value())
																		.setMessgae("OrderMaster Found")
																		.setData(ordermaster)))
																		.orElseThrow(()->new OrderMasterNotFoundException("Invalid input"));
		}
}