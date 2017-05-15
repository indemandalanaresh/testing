package com.nareshmaven.example;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestngListner extends TestListenerAdapter{
		
		public void onTestFailure(ITestResult tr){
		System.out.println("failed test cases are"+tr.getName());
			
		}
		
		public void onTestSuccess(ITestResult tr){
			
			System.out.println("passed test cases are"+tr.getName());
		}

	}


