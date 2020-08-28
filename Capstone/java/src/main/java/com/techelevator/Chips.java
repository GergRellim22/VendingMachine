package com.techelevator;
import java.math.BigDecimal;


public class Chips extends Product{
	
	public Chips(String snackID, String snackName, BigDecimal snackPrice, int quantityRemaining, String snackType) {
		
		super(snackID, snackName, snackPrice, quantityRemaining, snackType);

	}

	@Override
	public String dispenseMessage() {
		if (getQuantityRemaining() > 0) {
			return "Cruch Cruch, Yum!";
		} else {
			return "SOLD OUT";
		}
	}

}
