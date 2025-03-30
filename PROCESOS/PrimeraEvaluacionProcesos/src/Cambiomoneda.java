import java.util.Scanner;

public class Cambiomoneda {


	public static void main(String[] args) {
		int[] coin = { 200, 100, 50, 20, 10, 5, 2, 1 };
		System.out.println("Introduce money");
		Scanner sc = new Scanner(System.in);
		double money = sc.nextDouble();

		System.out.println("The money is " + money + " euros");
		int moneyincents = (int)(money * 100);
		seeChange(moneyincents, coin);

	}

	public static void seeChange(int money, int[] coin) {
		System.out.println("The exchange would be: ");
		for (int i : coin) {
			int count=money/i;
			if (count>0) {
				String exchange=(count>1) ? ("coins"): ("coin");
				System.out.println(count+" of "+exchange+ " of "+(i/100.0) +" euros");
				
			money=money%i;
			}
			
		}
		
	}

}
