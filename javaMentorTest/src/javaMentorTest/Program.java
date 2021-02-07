package javaMentorTest;

import java.util.Scanner;
import static java.lang.System.*;

public class Program {
	
	public static Calculator c = new Calculator();
	public static String input;
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		input = in.nextLine();
		in.close();
		
		try {
			c.getVariables(input);
			if(!c.isRoman) out.print(c.calculate());
			else out.print(RomanNumeralsConvert.convertToRoman(c.calculate()));
		}
		catch(Exception ex) {
			out.print(ex.getMessage());
		}
	}
	
}