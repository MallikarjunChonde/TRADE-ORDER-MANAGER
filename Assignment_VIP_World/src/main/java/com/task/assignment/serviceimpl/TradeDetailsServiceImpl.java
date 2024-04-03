package com.task.assignment.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.task.assignment.exception.TradeDetailsNotFoundException;
import com.task.assignment.model.OrderMaster;
import com.task.assignment.model.TradeDetails;
import com.task.assignment.repository.OrderMasterRepository;
import com.task.assignment.repository.TradeDetailsRepository;
import com.task.assignment.service.TradeDetailsService;
import com.task.assignment.utility.ResponseStructure;


@Service
public class TradeDetailsServiceImpl implements TradeDetailsService{

	@Autowired
	private TradeDetailsRepository repo;
	@Autowired
	private OrderMasterRepository orderMasterRepo;
	@Autowired
	private ResponseStructure<TradeDetails> responseStructure;
	@Autowired
	private ResponseStructure<List<TradeDetails>> responseStructureList;

	@Override
	public ResponseEntity<ResponseStructure<TradeDetails>> createTradeDetails(TradeDetails tradeDetails) {
		TradeDetails createdTrade = repo.save(tradeDetails);
		return ResponseEntity.ok(responseStructure
				.setStatusCode(HttpStatus.OK.value())
				.setMessgae("tradeDetails founded Sucessfully!!").setData(createdTrade));
	}
	
	@Override
	public ResponseEntity<ResponseStructure<List<TradeDetails>>> getAllTradeDetails() {
		List<TradeDetails> trades = repo.findAll();
		return ResponseEntity.ok(responseStructureList
							.setStatusCode(HttpStatus.OK.value())
							.setMessgae("tradeDetails founded Sucessfully!!")
							.setData(trades));
	}

	@Override
	public ResponseEntity<ResponseStructure<TradeDetails>> findTradeDetailsById(Integer id) {
		return repo.findById(id).map(trade-> ResponseEntity.ok(responseStructure.setStatusCode(HttpStatus.OK.value())
				.setMessgae("Details Found Sucessfully!!")
				.setData(trade)))
				.orElseThrow(()-> new TradeDetailsNotFoundException("Invalid Input!!"));
	}

	@Override
	public ResponseEntity<ResponseStructure<TradeDetails>> updateTradeDetails(Integer id,
			TradeDetails tradeDetails) {

		return repo.findById(id).map(updatetradeDetails->{
			updatetradeDetails.setTradeDateTime(tradeDetails.getTradeDateTime());
			updatetradeDetails.setStockName(tradeDetails.getStockName());
			updatetradeDetails.setListingPrice(tradeDetails.getListingPrice());
			updatetradeDetails.setQuantity(tradeDetails.getQuantity());
			updatetradeDetails.setType(tradeDetails.getType());
			updatetradeDetails.setPricePerUnit(tradeDetails.getPricePerUnit());
			repo.save(updatetradeDetails); 
			return  ResponseEntity.ok(responseStructure.setStatusCode(HttpStatus.OK.value())
					.setMessgae("Data Updated Sucessfully!!")
					.setData(updatetradeDetails));
		}).orElseThrow(()-> new TradeDetailsNotFoundException("TraidDetails Not found Exception!!"));
	}

//	@Override
//	public void deleteTradeDetails(Integer id) {
//		TradeDetails tradeDetails = repo.findById(id)
//										.orElseThrow(() -> new TradeDetailsNotFoundException("Invalid Id"));
//		repo.delete(tradeDetails);
//		ResponseEntity.ok(responseStructure.setStatusCode(HttpStatus.OK.value())
//				.setMessgae("TradeDetails Deleted Sucessfully!!")
//				.setData(tradeDetails));
//	}
	@Override
	public void deleteTradeDetails(Integer id) {
	    TradeDetails tradeDetails = repo.findById(id)
	                                    .orElseThrow(() -> new TradeDetailsNotFoundException("Invalid Id"));

	    List<OrderMaster> orderMasters = orderMasterRepo.findByTradeDetails(tradeDetails);
	    for (OrderMaster orderMaster : orderMasters) {
	        orderMaster.setTradeDetails(null); // Remove the reference to the deleted TradeDetails
	    }

	
	    repo.delete(tradeDetails);

	    ResponseEntity.ok(responseStructure.setStatusCode(HttpStatus.OK.value())
	            .setMessgae("TradeDetails Deleted Successfully!!")
	            .setData(tradeDetails));
	}




}
