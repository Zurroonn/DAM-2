import java.util.Scanner;

public class Fecha {

	public static void main(String[] args) {
	
			Scanner sc= new Scanner(System.in);
			System.out.println("Introduce the date ");
			System.out.println("day");
			int day= sc.nextInt();
			System.out.println("month");
			int month=sc.nextInt();
			System.out.println("year");
			int year=sc.nextInt();
			if(ValidDate(day,month,year)){
				System.out.println("Valid");
				
			}else {
				System.out.println("Not valid");
			}
			
		}
		
		
		public static boolean ValidDate (int day, int month, int year) {
		boolean boo =true;
		boolean leapyear=(year%4==0 && (year%400==0||year%100!=0));
			if(month==4 || month == 6 || month == 9 || month == 11) {
				if (day>30) {
					boo=false;
				}
				
				
			}else if(month==2) {
				if(leapyear) {
					if (day>29) {
						boo=false;
					}
				}else if(!leapyear) {
					if(day>28) {
						boo=false;
					}
				}
			}else {
				if (day>31) {
					boo=false;
				}
			}
			if (day>31 ||day<1||month>12||month<1||year>2024||year<1) {
				boo=false;
			}
			

		return boo;

	}
	}
