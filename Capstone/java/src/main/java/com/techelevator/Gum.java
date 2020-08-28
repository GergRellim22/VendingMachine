package com.techelevator;

import java.math.BigDecimal;


public class Gum extends Product {

	public Gum(String snackID, String snackName, BigDecimal snackPrice, int quantityRemaining, String snackType) {

		super(snackID, snackName, snackPrice, quantityRemaining, snackType);

	}

	@Override
	public String dispenseMessage() {
		if (getQuantityRemaining() > 0) {
			return "Chew Chew, Yum!";
		} else {
			return "SOLD OUT";
		}
	}

}
