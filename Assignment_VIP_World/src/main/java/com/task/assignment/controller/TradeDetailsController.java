package com.task.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.task.assignment.model.TradeDetails;
import com.task.assignment.service.TradeDetailsService;
import com.task.assignment.utility.ResponseStructure;

@RestController
@CrossOrigin
public class TradeDetailsController {
	
	@Autowired
	private TradeDetailsService tradeDetailService;
	
	@PostMapping(value = "/trade-details/save")
	public ResponseEntity<ResponseStructure<TradeDetails>> createTradeDetails(@RequestBody TradeDetails tradeDetails) {
		return tradeDetailService.createTradeDetails(tradeDetails);
	}
	
	@GetMapping(value = "/trade-details/fetchAll")
	public ResponseEntity<ResponseStructure<List<TradeDetails> >>getAllTradeDetails(){
		return tradeDetailService.getAllTradeDetails();
	}

	@GetMapping(value = "/trade-details/{id}")
	public ResponseEntity<ResponseStructure<TradeDetails>> findTradeDetailsById(@PathVariable Integer id) {
		return tradeDetailService.findTradeDetailsById(id);
	}
	
	@PutMapping(value ="/trade-details/update/{id}" )
	public ResponseEntity<ResponseStructure<TradeDetails>> updateTradeDetails(@PathVariable Integer id,@RequestBody TradeDetails tradeDetails){
		return tradeDetailService.updateTradeDetails(id,tradeDetails);
	}
	
	@DeleteMapping(value ="/trade-details/delete/{id}" )
	public void deleteTradeDetails(@PathVariable Integer id){
		tradeDetailService.deleteTradeDetails(id);
	}
	
	

}
