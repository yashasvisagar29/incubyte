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
	public void test1Plus2() {
		Assert.assertEquals(3, sc.add("1,2"));
	}
	
	@Test
	public void testEmptyString() {
		Assert.assertEquals(0, sc.add(""));
	}
	
	@Test
	public void test1() {
		Assert.assertEquals(1, sc.add("1"));
	}

}
