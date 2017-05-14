package com.mynotes.testing;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import org.junit.Test;

@RunWith(Parameterized.class)
public class MathUtilsParameterizedTest {
	
	
	private String input;
	private boolean expectedOutput;
	
	public MathUtilsParameterizedTest(String input, boolean expectedOutput) {
		this.input = input;
		this.expectedOutput = expectedOutput;
	}

	@Parameters
	public static Collection<Object[]> testConditions() {
		Object expectedOutputs[][] = { 
				{ "23", false }, 
				{ "34", true },
				{ "1", false },
				{ "10", true }};
		return Arrays.asList(expectedOutputs);
	}
	
	@Test
	public void checkIsEvenWithValidNumberString() {		
		MathUtils aMathUtils=new MathUtils();
		assertEquals(expectedOutput,aMathUtils.isEven(input));			
	}

}
