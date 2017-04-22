package com.mynotes.testing;

public class MathUtils {

	public boolean isEven(String number) {
		int x = Integer.parseInt(number);
		if (x % 2 == 0) {
			return true;
		}
		return false;
	}
}
