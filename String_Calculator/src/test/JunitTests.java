package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import tools.StringCalculator;

public class JunitTests {
	
	/* I created j-unit test cases for this exercise to help me check for every progress that i made, 
	 * to make sure that my regression test were successful as i add more feature/function to the code. 
	 * 
	 * I include the junir.jar in the project package to make sure that it will run right of the box.
	 */
   @Test
   public void testadd() {
    
	    //sample test cases #1 
		assertEquals(StringCalculator.add("1,2,5"),8);
		assertEquals(StringCalculator.add(",,,,1,2,5"),8);
		assertEquals(StringCalculator.add("1,,,2,,,5,,"),8);
		assertEquals(StringCalculator.add(",1,2,,1,"),4);
		assertEquals(StringCalculator.add(" , , 1,2,5, , , "),8);
		
		
		//sample test cases #2 
		assertEquals(StringCalculator.add("1,\n2,4"),7);
		assertEquals(StringCalculator.add("1\n,2,3"),6);
		assertEquals(StringCalculator.add("1\n,2\n,\n3"),6);
		assertEquals(StringCalculator.add("\n1\n,2,3"),6);
		assertEquals(StringCalculator.add("1,2,3\n"),6);
		
		//sample test cases #3 
		assertEquals(StringCalculator.add("//$\n1$2$3"),6);
		assertEquals(StringCalculator.add("//@\n2@3@8"),13);
		assertEquals(StringCalculator.add("//&\n1&1&1"),3);
		assertEquals(StringCalculator.add("// $ \n 1 $ 2 $ 3 "),6);
		//assertEquals(StringCalculator.add("//,\n 2,3, 8"),13);
		
		//sample test cases #4
		//assertEquals(StringCalculator.add("//$$$\n-2$$$3$$$-1"),"Negatives not allowed : -2 -1");
		//assertEquals(StringCalculator.add("-1,-2,-5"),"Negatives not allowed : -1 -2 -5");
		
		//sample test cases for bonus 
		assertEquals(StringCalculator.add("1001,2,9,3040"),11);
		assertEquals(StringCalculator.add("10,2,9,98484"),21);
		assertEquals(StringCalculator.add("-1,2,-5"),2);
		assertEquals(StringCalculator.add("//$\n1$-2$3"),4);
		assertEquals(StringCalculator.add("//***\n1***2***3"),6);
		assertEquals(StringCalculator.add("//@@\n1@@2@@1"),4);
		assertEquals(StringCalculator.add("//++++\n1++++2++++1++++1++++3++++2"),10);
		assertEquals(StringCalculator.add("//$$,@\n1$$2@3$$4$$5@1"),16);
		
   }
   
}
