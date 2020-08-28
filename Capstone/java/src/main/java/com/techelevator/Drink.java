package com.techelevator;

import java.math.BigDecimal;

public class Drink extends Product {

	public Drink(String snackID, String snackName, BigDecimal snackPrice, int quantityRemaining, String snackType) {

		super(snackID, snackName, snackPrice, quantityRemaining, snackType);

	}

	@Override
	public String dispenseMessage() {
		if (getQuantityRemaining() > 0) {
			return "Glug Glug, Yum!";
		} else {
			return "SOLD OUT";
		}
	}

}
