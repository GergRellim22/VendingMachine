package com.techelevator;

import java.math.BigDecimal;

public class Candy extends Product {

	public Candy(String snackID, String snackName, BigDecimal snackPrice, int quantityRemaining, String snackType) {

		super(snackID, snackName, snackPrice, quantityRemaining, snackType);

	}

	@Override
	public String dispenseMessage() {
		if (getQuantityRemaining() > 0) {
			return "Munch Munch, Yum!";
		} else {
			return "SOLD OUT";
		}
	}

}
