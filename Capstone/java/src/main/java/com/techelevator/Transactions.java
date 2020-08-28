package com.techelevator;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Transactions {

	private BigDecimal moneyInput;
	Log newLog = new Log();

	public Transactions() {
		this.moneyInput = new BigDecimal(0.00);
	}

	public BigDecimal getMoneyInput() {
		return this.moneyInput;
	}

	public BigDecimal getMoneyInput2(BigDecimal a) {
		return a;
	}

	public void setMoneyInput(BigDecimal moneyInput) {
		this.moneyInput = this.moneyInput.add(moneyInput);
	}

	Inventory inventory = new Inventory();
	Product product = new Product();

	public BigDecimal resetMoney() {
		BigDecimal zero = new BigDecimal(0.00);
		moneyInput = zero;
		setMoneyInput(moneyInput);
		return moneyInput;
	}

	public void purchaseAndDeduct(String[] selection, List<Product> a) throws Exception {

		Date date = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("MM/dd/yyyy" + " " + "hh:mm:ss");

		for (Product item : a) {

			if (selection[0].equals(item.getSnackID())) {

				if (item.getSnackPrice().compareTo(getMoneyInput()) < 0) {

					if (item.getQuantityRemaining() > 0) {
						Log.log(ft.format(date) + " " + item.getSnackName() + " " + item.getSnackID() + " $"
								+ getMoneyInput());

						item.setQuantityRemaining(item.removeInventoryLevel());

						setMoneyInput(item.getSnackPrice().multiply(new BigDecimal(-1.00)));
						Log.log(" $" + getMoneyInput() + " ");
						
						if (item.getSnackType().contains("Chip")) {
							System.out.println("Crunch Crunch, Yum");
						} else if (item.getSnackType().contentEquals("Candy")) {
							System.out.println("Munch Munch, Yum");
						} else if (item.getSnackType().contentEquals("Drink")) {
							System.out.println("Glug Glug, Yum");
						} else if (item.getSnackType().contentEquals("Gum")) {
							System.out.println("Chew Chew, Yum");
						}
						System.out.println(item.getSnackName());
						System.out.println("Current balance: $" + getMoneyInput());

					} else {
						System.out.println("SOLD OUT");

					}
				} else {
					System.out.println("Please insert more money");

				}
			}
		}

	}

}
