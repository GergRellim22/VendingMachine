package com.techelevator;

import java.math.BigDecimal;


public  class Product  {

	private String snackName;
	private BigDecimal snackPrice;
	private String snackID;
	private int quantityRemaining = 5;
	private String snackType;
	
	public String dispenseMessage() {
		return null;
	}		
	
	public Product() {
		
	}
	
	public Product(String snackID, String snackName, BigDecimal snackPrice, int quantityRemaining, String snackType) {
		super();
		this.snackID = snackID;
		this.snackName = snackName;
		this.snackPrice = snackPrice;
		this.quantityRemaining = 5;
		this.snackType = snackType;
	}

	
	public String getSnackName() {
		return snackName;
	}

	public BigDecimal getSnackPrice() {
		return snackPrice;
	}


	public String getSnackID() {
		return snackID;
	}

	public int getQuantityRemaining() {
		return quantityRemaining;
	}
	
	public void setQuantityRemaining(int quantityRemaining) {
		this.quantityRemaining = quantityRemaining;
	}

	public String getSnackType() {
		return snackType;
	}
	
	public int removeInventoryLevel() {
		return this.quantityRemaining - 1;
	}

	@Override
	public String toString() {
		return (String.format("%-10s %-20s %-13s %-12s %-12s", getSnackID(), getSnackName(), getSnackPrice(), getSnackType(), getQuantityRemaining()));
	}
	
}


