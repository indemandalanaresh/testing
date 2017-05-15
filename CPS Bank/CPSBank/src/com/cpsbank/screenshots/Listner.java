package com.cpsbank.screenshots;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Listner {
	
	@Test(priority=1)
	public void method1(){
		System.out.println("method one");
		Assert.assertTrue(false);
	}
	@Test(priority=2)
	public void method2(){
		System.out.println("method two");
		Assert.assertTrue(true);
	}
	@Test(priority=3)
	public void method3(){
		System.out.println("method three");
		Assert.assertTrue(true);
	}
	@Test(priority=4)
	public void method4(){
		System.out.println("method four");
		Assert.assertTrue(false);
	}

}
