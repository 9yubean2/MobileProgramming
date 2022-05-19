
public class VariableCalculation {
	public static void main (String[] args) {
		int number = 3;
		double average = 11.1;
		final int j;
		j = 10;
		//j = 5; Error : j는 상수이기 때문에
		
		//type
		boolean isFun = true;
		char c = 'f';
		float f = 32.4f;
		long big = 3456789L;
		
		//casting
		//명시적(강제)
		long x = 5;
		int y = (int)x;
		
		//암묵적(묵시적)
		int x2 = 4;
		long y2 = x2;
		
		int a = (int)(Math.random()*10); 
		
		//연산자 우선순위
		int operator = 5;
		System.out.println(operator++ - 5); //operator++ - 5 = 0 Vs. ++operator - 5 = 1
		System.out.println(operator); //6
		
		
		
	}
}
