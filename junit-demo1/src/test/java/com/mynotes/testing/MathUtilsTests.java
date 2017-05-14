package com.mynotes.testing;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.experimental.categories.Category;

public class MathUtilsTests {
	
	@Test
	@Category(MathUtilsValidTestCategory.class)
	public void checkIsEvenWithValidNumberString() {		
		MathUtils aMathUtils=new MathUtils();
		assertEquals(true,aMathUtils.isEven("222"));			
	}
	
	@Test
	public void checkIsEvenWithInvalidNumberString() {		
		MathUtils aMathUtils=new MathUtils();
		assertEquals(false,aMathUtils.isEven("3 3"));			
	}
	
	@Test(expected=NumberFormatException.class)
	public void checkIsEvenWithInvalidString() {		
		MathUtils aMathUtils=new MathUtils();
		assertEquals(true,aMathUtils.isEven("qq"));			
	}

}
