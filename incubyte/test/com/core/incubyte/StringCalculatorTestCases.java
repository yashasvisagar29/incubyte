package com.core.incubyte;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringCalculatorTestCases {

	StringCalculator sc = null;

	@Before
	public void setUp() throws Exception {
		sc = new StringCalculator();
	}

	@Test
	public void testEmptyString() throws NegationNumberCustomException {
		Assert.assertEquals(0, sc.add(""));
	}

	@Test
	public void test1() throws NegationNumberCustomException {
		Assert.assertEquals(1, sc.add("1"));
	}

	@Test
	public void test1Plus2() throws NegationNumberCustomException {
		Assert.assertEquals(3, sc.add("1,2"));
	}

	@Test
	public void testUnknownAmountOfNumbers() throws NegationNumberCustomException {
		Assert.assertEquals(74, sc.add("1,1,1,1,1,1,11,1,1,1,1,1,1,1,1,1,11,1,1,1,1,1,1,1,11,11,1,1,1,2,3"));
	}

	@Test
	public void testNewLineAdditionOfNumbers() throws NegationNumberCustomException {
		Assert.assertEquals(6, sc.add("1\n2,3"));
	}

	@Test
	public void testNewDelimiterAdditionOfNumbers() throws NegationNumberCustomException {
		Assert.assertEquals(3, sc.add("//;\n1;2"));
	}

	@Test
	public void testNegativeAdditionOfNumbers() throws NegationNumberCustomException {
		Assert.assertEquals("Exception Occur", sc.add("1,-3"));
	}

	@Test
	public void testMultipleNegativeAdditionOfNumbers() throws NegationNumberCustomException {
		Assert.assertEquals("Exception Occur", sc.add("-1,-3"));
	}

	@Test
	public void testNumberGreaterThan1000() throws NegationNumberCustomException {
		Assert.assertEquals(2, sc.add("2,1001"));
	}

	@Test
	public void testDelimiterOfAnyLength() throws NegationNumberCustomException {
		Assert.assertEquals(6, sc.add("//[***]\n1***2***3"));
	}


	
}

