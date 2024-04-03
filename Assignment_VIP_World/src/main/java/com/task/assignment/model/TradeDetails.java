package com.task.assignment.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "trade_details")
public class TradeDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "trade_date_time")
    private Date tradeDateTime;

    @Column(name = "stock_name")
    private String stockName;

    @Column(name = "listing_price")
    private double listingPrice;

    private int quantity;

    private String type; // buy/sell

    @Column(name = "price_per_unit")
    private double pricePerUnit;
    
  
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getTradeDateTime() {
		return tradeDateTime;
	}

	public void setTradeDateTime(Date tradeDateTime) {
		this.tradeDateTime = tradeDateTime;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public double getListingPrice() {
		return listingPrice;
	}

	public void setListingPrice(double listingPrice) {
		this.listingPrice = listingPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}


}