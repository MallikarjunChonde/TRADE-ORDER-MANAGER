package com.task.assignment.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_master")
public class OrderMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "trade_Details")      //--> USE TO ESTABLISH THE CONNECTION BETWEEN OrderMaster and TradeDetails
	private TradeDetails tradeDetails;

	private String orderStatus;

//	*************************************************
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public TradeDetails getTradeDetails() {
		return tradeDetails;
	}

	public void setTradeDetails(TradeDetails tradeDetails) {
		this.tradeDetails = tradeDetails;
	}
	

	
}
