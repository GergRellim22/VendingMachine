package com.techelevator;

import static org.junit.Assert.*;

import java.io.IOException;
import java.math.BigDecimal;

import org.junit.Test;

public class VendingMachingCLITests {

	
	@Test
	public void quartersTest() throws Exception {
		VendingMachineCLI cli = new VendingMachineCLI(null);
		BigDecimal five = new BigDecimal(5.00);
		
		cli.money.setMoneyInput(five);
	
		cli.finishTransaction();
		cli.getQuarters();
		
		assertEquals(20, cli.getQuarters());
		}
	
	
	@Test
	public void quartersTest4() throws Exception {
		VendingMachineCLI cli = new VendingMachineCLI(null);
		BigDecimal four = new BigDecimal(4.00);
		
		cli.money.setMoneyInput(four);
	
		cli.finishTransaction();
		//cli.getQuarters();
		
		assertEquals(16, cli.getQuarters());
		}
	
	
	@Test
	public void nickelsTest() throws Exception {
		VendingMachineCLI cli = new VendingMachineCLI(null);
		BigDecimal OneFive = new BigDecimal(1.05);
		
		cli.money.setMoneyInput(OneFive);
	
		cli.finishTransaction();
		//cli.getQuarters();
		
		assertEquals(1, cli.getNickels());
		assertEquals(0, cli.getDimes());
		}
	
	
	}


