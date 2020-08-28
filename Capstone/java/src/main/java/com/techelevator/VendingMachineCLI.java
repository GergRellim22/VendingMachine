package com.techelevator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.techelevator.view.Menu;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE };
	private static final String[] PURCHASE_MENU = { "Feed Money", "Select Product", "Finish Transaction", "Back" };																											
	private static final String[] MONEY_MENU = { "$1 Bill", "$2 Bill", "$5 Bill", "$10 Bill", "Back" }; 
	private Menu menu;
	Inventory inventory = new Inventory();
	Product product = new Product();
	Transactions money = new Transactions();
	BigDecimal converter;
	int totalCents;
	int quarters, dimes, nickels, pennies;
	int remaining1, remaining2;
	int change;
	int totalChange;
	BigDecimal oneDollar, twoDollar, fiveDollar, tenDollar;
	String feedOptions;

	public int getQuarters() {
		return quarters;
	}

	public int getDimes() {
		return dimes;
	}

	public int getNickels() {
		return nickels;
	}

	public BigDecimal getOneDollar() {
		return oneDollar;
	}

	public BigDecimal getTwoDollar() {
		return twoDollar;
	}

	public BigDecimal getFiveDollar() {
		return fiveDollar;
	}

	public BigDecimal getTenDollar() {
		return tenDollar;
	}

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() throws Exception {
		inventory.inventoryFile();

		while (true) {

			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {

				displayProductItems();
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {

				processPurchaseMenuOptions();

			}
		}
	}

	public void processPurchaseMenuOptions() throws Exception {
		String purchaseMenuOption = "";

		while (!purchaseMenuOption.equals("Back")) {
			purchaseMenuOption = (String) menu.getChoiceFromOptions(PURCHASE_MENU);

			if (purchaseMenuOption.equals("Feed Money")) {
				processMoneyFeed();
			} else if (purchaseMenuOption.equals("Select Product")) {
				chooseItem();

			} else if (purchaseMenuOption.equals("Finish Transaction")) {
				finishTransaction();
				purchaseMenuOption = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			} else if (purchaseMenuOption.equals("Back"))
				run();
		}
	}

	public void processMoneyFeed() throws Exception {
		Date date = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("MM/dd/yyyy" + " " + "hh:mm:ss");
		feedOptions = "";
		String message = "";

		Log.log(ft.format(date) + " Feed Money: ");

		while (!feedOptions.equals("Back")) {
			feedOptions = (String) menu.getChoiceFromOptions(MONEY_MENU);
			if (feedOptions.equals("$1 Bill")) {
				oneDollar = new BigDecimal(1.00);
				money.setMoneyInput(oneDollar);
				System.out.println("Current Money Provided $" + money.getMoneyInput());
				message = "$1.00 $" + money.getMoneyInput() + ".00 ";
				Log.log(message);
			} else if (feedOptions.equals("$2 Bill")) {
				twoDollar = new BigDecimal(2.00);
				money.setMoneyInput(twoDollar);
				System.out.println("Current Money Provided $" + money.getMoneyInput());
				message = "$2.00 $" + money.getMoneyInput() + ".00 ";
				Log.log(message);
			} else if (feedOptions.equals("$5 Bill")) {
				fiveDollar = new BigDecimal(5.00);
				money.setMoneyInput(fiveDollar);
				System.out.println("Current Money Provided $" + money.getMoneyInput());
				message = "$5.00 $" + money.getMoneyInput() + ".00 ";
				Log.log(message);
			} else if (feedOptions.equals("$10 Bill")) {
				tenDollar = new BigDecimal(10.00);
				money.setMoneyInput(tenDollar);
				System.out.println("Current Money Provided $" + money.getMoneyInput());
				message = "$10.00 $" + money.getMoneyInput() + ".00 ";
				Log.log(message);
			} else if (feedOptions.equals("Back")) {
				money.getMoneyInput();

			}
		}
	}

	public void displayProductItems() throws FileNotFoundException {
		inventory.displayItems();
	}

	public void chooseItem() throws Exception {
		inventory.inventArray();
		String[] newArray = inventory.inventArray();

		String itemNumber = "";

		itemNumber = (String) menu.getChoiceFromOptions(newArray);

		String[] selection = itemNumber.split("\\s+");

		money.purchaseAndDeduct(selection, inventory.productList);

		processPurchaseMenuOptions();
	}

	public void finishTransaction() throws IOException {

		Date date = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("MM/dd/yyyy" + " " + "hh:mm:ss");
		BigDecimal hunnit = new BigDecimal(100.00);
		converter = money.getMoneyInput().multiply(hunnit);

		change = converter.intValue();
		totalChange = change;
		while (change > 0) {

			if (change >= 25) {
				quarters = change / 25;
				change = change % 25;

			}

			else if (change >= 10) {
				dimes = change / 10;
				change = change % 10;

			} else if (change >= 5) {
				nickels = change / 5;
				change = change % 5;

			}
		}
		System.out.println("Your change is: $" + money.getMoneyInput()); 
		System.out.println("Quarters: " + quarters + "\n" + "Dimes: " + dimes + "\n" + "Nickels: " + nickels);
		Log.log(ft.format(date) + " Give Change: $" + money.getMoneyInput() + " $" + money.resetMoney());
	}

	public static void main(String[] args) throws Exception {

		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();

	}
}
