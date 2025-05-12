package dharani.TestComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class retry implements IRetryAnalyzer{
	int count=0;
	int MaxTry=2;

	@Override
	public boolean retry(ITestResult result) {
		if(count<MaxTry)
		{
			count++;
			return true;
		}
		
		return false;
	}

}
