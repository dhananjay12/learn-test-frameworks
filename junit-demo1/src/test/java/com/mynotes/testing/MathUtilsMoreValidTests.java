package com.mynotes.testing;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(MathUtilsValidTestCategory.class)
public class MathUtilsMoreValidTests {
	
	@Test
	public void checkIsEvenWithValidNumberString() {		
		MathUtils aMathUtils=new MathUtils();
		assertEquals(true,aMathUtils.isEven("10"));			
	}
	
	@Test
	public void checkIsEvenWithInvalidNumberString() {		
		MathUtils aMathUtils=new MathUtils();
		assertEquals(false,aMathUtils.isEven("33"));			
	}

}
