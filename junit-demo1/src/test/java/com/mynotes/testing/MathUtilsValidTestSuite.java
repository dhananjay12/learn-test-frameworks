package com.mynotes.testing;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Categories.class)
@IncludeCategory(MathUtilsValidTestCategory.class)
@SuiteClasses({MathUtilsTests.class,
	MathUtilsMoreValidTests.class})
public class MathUtilsValidTestSuite {

}
