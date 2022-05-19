import java.util.Calendar;
import java.util.Scanner;

public class ControlFlowStatement {
	public int IfTest(int value) {
		
		int ret = 0;
		if (value % 3 == 0 ) {
			ret = 3;
		}
		else if (value % 4 == 0) {
			ret = 4;
		}
		
		return ret;
	}
	
	public boolean isAgeDiscountable(int age) {
		boolean isDiscount = false;
		if (age>=60 || age<=19) {
			isDiscount = true;
		} else {
			isDiscount = false;
		}
	
		return isDiscount;
	}
	
	

	public static void main(String[] args) {
		ControlFlowStatement cont = new ControlFlowStatement();
		//System.out.println(cont.IfTest(6)); //3
		//System.out.println(cont.IfTest(8)); //4
		//System.out.println(cont.isAgeDiscountable(15));//t
		//System.out.println(cont.isAgeDiscountable(27));//f
		//System.out.println(cont.isAgeDiscountable(61));//t
		
		//삼항연산자
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		String ampm;
		ampm = (hour < 12)?"오전":"오후";
		System.out.println("지금시간은"+hour+"시이고"+ampm+"입니다.");
		
		//switch
		int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
		String season = "";
		switch(month) {
		case 12 : case 1 : case 2 :
			season = "겨울";
		break;
		case 3 : case 4 : case 5 :
			season = "겨울";
		break;
		case 6 : case 7 : case 8 :
			season = "겨울";
		break;
		case 9 : case 10 : case 11 :
			season = "겨울";
		break;

		}
		System.out.println(month+"월은"+ season +"입니다.");
		
		//while
		int i = 1;
		while (i<11) {
			System.out.println(i);
			i ++;
		}
		
		int i2 = 1;
		while (i2<11) {
			if(i2%2==0)
				System.out.println(i2);
			i2 ++;
		}
		
		//dowhile
		Scanner scan = new Scanner(System.in);
		int value = 0;
		int sum = 0;
		
		do {
			value = scan.nextInt();
			sum += value;
		} while (value  < 100);
		System.out.println("sum:"+sum);
		
		//for
		for (int forI = 1; forI<=100; forI++ ) {
			if(forI % 2 == 0) {
				System.out.println(forI);
			}
		}

	}

}
