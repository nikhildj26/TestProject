/*
 * Author is Nikhil Jaltare
 */

package com.maven.seleniumjava;

import org.junit.Assert;
import org.testng.annotations.Test;

public class SeleniumTestNG {
	
	@Test
	
	public void firstMethod() {
		
		System.out.println("Welcome to Maven world");
		System.out.println("Checking Github upload");
		Assert.assertFalse(true);
		
	}
	
}
