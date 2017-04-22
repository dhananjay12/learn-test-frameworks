package com.mynotes.testing;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class MathUtilsTest {
	
	@BeforeClass
	public static void beforeClass(){
		System.out.println("### BEFORE CLASS ###");
	}
	
	@Before
	public void beforeEachTest(){
		System.out.println("### BEFORE EACH TEST ###");
	}

	@Test
	public void checkIsEvenWithValidNumberString() {		
		MathUtils aMathUtils=new MathUtils();
		assertEquals("Testing with valid number string 222 ",true,aMathUtils.isEven("222"));			
	}
	
	@Test
	@Ignore
	public void checkIsEvenWithInvalidNumberString() {		
		MathUtils aMathUtils=new MathUtils();
		assertEquals("Testing with valid number string 33 ",false,aMathUtils.isEven("33 "));			
	}
	
	@Test(expected=NumberFormatException.class)
	public void checkIsEvenWithInvalidString() {		
		MathUtils aMathUtils=new MathUtils();
		assertEquals("Testing with valid number string qq ",true,aMathUtils.isEven("qq"));			
	}
	
	@After
	public void afterEachMethod(){
		System.out.println("### AFTER EACH TEST ###");
	}
	
	@AfterClass
	public static void afterClass(){
		System.out.println("### AFTER CLASS ###");
	}

}
