package com.Analyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{
	
	public int testCounter  = 0;
	public int retryLimit = 3;
	
	public boolean retry(ITestResult result) {
		if(testCounter < retryLimit) {
			testCounter++;
			return true;
		}
		return false;
	}
}
