package com.task.assignment.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.task.assignment.model.TradeDetails;
import com.task.assignment.utility.ResponseStructure;

public interface TradeDetailsService {

	ResponseEntity<ResponseStructure<TradeDetails>> createTradeDetails(TradeDetails tradeDetails);
	
	ResponseEntity<ResponseStructure<List<TradeDetails>>> getAllTradeDetails();

	ResponseEntity<ResponseStructure<TradeDetails>> findTradeDetailsById(Integer id);

	ResponseEntity<ResponseStructure<TradeDetails>> updateTradeDetails(Integer id,
			TradeDetails updateTradeDetails);

	void deleteTradeDetails(Integer id);



	

	

}
