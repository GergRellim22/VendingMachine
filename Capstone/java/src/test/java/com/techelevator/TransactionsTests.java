package com.techelevator;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class TransactionsTests {

	Transactions transactions = new Transactions();
	
	@Test
	public void test() {
		
		BigDecimal five = new BigDecimal(5.00);
		BigDecimal expectedResult = new BigDecimal(5.00);
		BigDecimal actualResult = new BigDecimal(transactions.getMoneyInput2(five).toString());
		assertEquals(expectedResult, actualResult);
		
	}

}
