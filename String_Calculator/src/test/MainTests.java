package test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class MainTests {
	
   //main class to run junit test only
   public static void main(String[] args) {
      Result result = JUnitCore.runClasses(JunitTests.class);
		
      for (Failure failure : result.getFailures()) {
         System.out.println(failure.toString());
      }
		
      System.out.println("were the tests successfull : " + result.wasSuccessful());
   }
}  