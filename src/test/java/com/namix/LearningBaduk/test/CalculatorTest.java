package com.namix.LearningBaduk.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest {

	@Test
	void testSum() {
		Calculator calculator = new Calculator();
		assertEquals(6, calculator.sum(2, 4));
		
	}

}
