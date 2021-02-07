package javaMentorTest;

public class Calculator {
	
	public static int firstNumber;
	public static int secondNumber;
	public static String operation;
	public static boolean isRoman;
	
		//Проверка на валидность ввода данных
		public void getVariables(String input) throws Exception {
			
			String[] array = input.split(" ");

			if(array.length != 3) {
				throw new Exception("Некорректный ввод данных");
			}
			if(intParsable(array[0]) && intParsable(array[2])) {
				if(Integer.parseInt(array[0]) >= 1 && Integer.parseInt(array[0]) <= 10 &&
				   Integer.parseInt(array[0]) >= 1 && Integer.parseInt(array[0]) <= 10 ) {
					firstNumber = Integer.parseInt(array[0]);
					secondNumber = Integer.parseInt(array[2]);
					operation = array[1];
					isRoman = false;
				}
				else {
					throw new Exception("Вводимые числа должны быть не меньше 1 и не больше 10");
				}
			}
			else {
				
				if(RomanNumeralsConvert.romanParsable(array[0]) && RomanNumeralsConvert.romanParsable(array[2])) {
					if(RomanNumeralsConvert.convertToInteger(array[0]) >= 1 &&
					   RomanNumeralsConvert.convertToInteger(array[0]) <= 10 &&
					   RomanNumeralsConvert.convertToInteger(array[2]) >= 1 &&
					   RomanNumeralsConvert.convertToInteger(array[2]) <= 10) {
						firstNumber = RomanNumeralsConvert.convertToInteger(array[0]);
						secondNumber =RomanNumeralsConvert.convertToInteger(array[2]);
						operation = array[1];
						isRoman = true;
					}
					else {
						throw new Exception("Вводимые числа должны быть не меньше I и не меньше X");
					}
				}
				else {
					throw new Exception("Некорректный ввод данных");
				}
			}
		}
		
		//Расчет
		public int calculate() throws Exception {
			switch(operation) {
				case "+":
					return firstNumber + secondNumber;
				case "-":
					return firstNumber - secondNumber;
				case "*":
					return firstNumber * secondNumber;
				case "/":
					return firstNumber / secondNumber;
				default:
					throw new Exception("Операция не найдена");
			}
		}
		
		//Проверка можно ли конвертировать из String в Integer
		private static boolean intParsable(String stringNumber) {
			if(stringNumber == null) return false;
			try {
				Integer.parseInt(stringNumber);
			}
			catch(NumberFormatException ex) {
				return false;
			}
			return true;
		}
}
