import java.util.ArrayList;

import tools.StringCalculator;

public class MainClass {

	public static void main(String[] args) {
		
		//test cases
		ArrayList<String> numbers = new ArrayList<String>();
		numbers.add("1,2,5"); //8
		numbers.add("1\n,2,3"); //6
		numbers.add("1,\n2,4"); //7
		numbers.add("//;\n1;3;4"); //8
		numbers.add("//$\n1$2$3"); //6
		numbers.add("//@\n2@3@8"); //13
		numbers.add("//,\n1,2,5"); //8
		numbers.add("99999,8888,1,3"); //4
		numbers.add("//***\n1***2***3"); //6
		numbers.add("//$$,@\n1$$2@3$$4$$5@1"); //16
		numbers.add("//$$$\n-2$$$3$$$-1"); //negative value, 3
		
		for (String data : numbers) {
			System.out.println(StringCalculator.add(data));
		}
		
	}

}
