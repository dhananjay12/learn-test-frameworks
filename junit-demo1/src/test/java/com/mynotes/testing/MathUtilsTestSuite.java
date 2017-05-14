package com.mynotes.testing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({MathUtilsTest.class,
				MathUtilsParameterizedTest.class})
public class MathUtilsTestSuite {

}
