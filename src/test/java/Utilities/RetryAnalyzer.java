package Utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{
	
	private int count =0;
	private static final int MAX_RETRY = 2;
	
	public boolean retry(ITestResult result)
	{
		if(count < MAX_RETRY)
		{
			count++;
			System.out.println("Retrying test: " + result.getName() + " | Attempt " + (count+1));
			return true;
		}
		return false;
		
	}
	
	

}
