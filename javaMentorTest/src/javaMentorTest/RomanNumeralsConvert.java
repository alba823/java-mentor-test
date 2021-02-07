package javaMentorTest;

import java.util.HashMap;  

public class RomanNumeralsConvert {
	
	public static boolean romanParsable(String input) {
		String[] romanLetters = new String[] {"I","V", "X"};
		
		for(int i = 0; i < romanLetters.length; i++) {
			input = input.replace(romanLetters[i], "");
		}
		
		if(input.length() > 0) return false;
		else return true;
	}
	
	//Метод для конвертирования римских чисел в арабские
	public static int convertToInteger(String romanString) throws Exception {
		
		int result = 0;
		
		char[] ch = romanString.toCharArray();
		
		HashMap<String, Integer> map = new HashMap<>();
		map.put("I", 1);
		map.put("V", 5);
		map.put("X", 10);
		map.put("L", 50);
		map.put("C", 100);
		
		for(int i = 0; i < ch.length; i++) {
			if(!map.containsKey(String.valueOf(ch[i]))) {
				throw new Exception("");
			}
			if(i + 1 < ch.length) {
				if(map.get(String.valueOf(ch[i])) < map.get(String.valueOf(ch[i+1]))) {
					result += map.get(String.valueOf(ch[i+1])) - map.get(String.valueOf(ch[i]));
					i++;
					continue;
				}
			}
			result += map.get(String.valueOf(ch[i]));
		}
		return result;
	}
	//метод для конвертирования арабских чисел в римские
	public static String convertToRoman(int number) {
		
		String result = "";
		
		int[] values = new int[] {100 , 90, 50, 40, 10, 9, 5, 4, 1};
		
		HashMap<Integer, String> map = new HashMap<>();
		map.put(100, "C");
		map.put(90, "XC");
		map.put(50, "L");
		map.put(40, "XL");
		map.put(10, "X");
		map.put(9, "IX");
		map.put(5, "V");
		map.put(4, "IV");
		map.put(1, "I");
		
		for(int v : values) {
			while(number >= v) {
				result += map.get(v);
				number -= v;
			}
		}
		return result;
	}
}