package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventory {

	String[] inventoryFile;
	List<Product> productList = new ArrayList<>();

	public boolean inventoryFile() throws FileNotFoundException {

		File newFile = new File("vendingmachine.csv");

		try (Scanner inputScanner = new Scanner(newFile)) {

			if (!newFile.exists()) {
				return false;
			}

			while (inputScanner.hasNextLine()) {
				String newLine = inputScanner.nextLine();
				inventoryFile = newLine.split("\\|");

				if (inventoryFile[3].equals("Chip")) {

					BigDecimal bigDecimalConvert = new BigDecimal(inventoryFile[2]);
					productList.add(new Chips(inventoryFile[0], inventoryFile[1], bigDecimalConvert, 5, "Chips"));

				} else if (inventoryFile[3].equals("Candy")) {
					BigDecimal bigDecimalConvert = new BigDecimal(inventoryFile[2]);
					productList.add(new Candy(inventoryFile[0], inventoryFile[1], bigDecimalConvert, 5, "Candy"));

				} else if (inventoryFile[3].equals("Drink")) {
					BigDecimal bigDecimalConvert = new BigDecimal(inventoryFile[2]);
					productList.add(new Drink(inventoryFile[0], inventoryFile[1], bigDecimalConvert, 5, "Drink"));

				} else if (inventoryFile[3].equals("Gum")) {
					BigDecimal bigDecimalConvert = new BigDecimal(inventoryFile[2]);
					productList.add(new Gum(inventoryFile[0], inventoryFile[1], bigDecimalConvert, 5, "Gum"));

				}

			}
		}
		return true;
	}

	public void displayItems() {
		System.out.println(String.format("%10s %20s %13s %12s %12s", "Slot", "Name", "Price", "Type", "Inventory\n"));

		for (Product item : productList) {
			System.out.printf("%10s %20s %13s %12s %12s %5s", item.getSnackID(), item.getSnackName(),
					item.getSnackPrice(), item.getSnackType(), item.getQuantityRemaining(), "\n");
		}
	}

	public String[] inventArray() {
		String[] inventArray = new String[productList.size()];

		int count = 0;
		for (Product item : productList) {
			inventArray[count] = item.toString();

			count++;

		}
		return inventArray;
	}

}
