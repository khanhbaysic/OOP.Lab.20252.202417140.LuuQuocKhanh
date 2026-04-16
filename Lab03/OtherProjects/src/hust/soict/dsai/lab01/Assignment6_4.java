package hust.soict.dsai.lab01;
import java.util.Scanner;
public class Assignment6_4 {
	public static boolean isLeapYear(int x) {
		if(x%4 !=0) return false;
		if(x%100==0 && x%400!=0) {
			return false;
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter month: ");
		int monthNum = -1;
		String month;
		while(monthNum == -1) {
			month = sc.nextLine();
			if(month.equals("January")||month.equals("Jan")||month.equals("Jan.")||month.equals("1")) {
				monthNum = 1;
			}
			else if(month.equals("February")||month.equals("Feb")||month.equals("Feb.")||month.equals("2")) {
				monthNum = 2;
			}
			else if(month.equals("March")||month.equals("Mar")||month.equals("Mar.")||month.equals("3")) {
				monthNum = 3;
			}
			else if(month.equals("April")||month.equals("Apr")||month.equals("Apr.")||month.equals("4")) {
				monthNum = 4;
			}
			else if(month.equals("May")||month.equals("5")) {
				monthNum = 5;
			}
			else if(month.equals("June")||month.equals("Jun")||month.equals("6")) {
				monthNum = 6;
			}
			else if(month.equals("July")||month.equals("Jul")||month.equals("7")) {
				monthNum = 7;
			}
			else if(month.equals("August")||month.equals("Aug")||month.equals("Aug.")||month.equals("8")) {
				monthNum = 8;
			}
			else if(month.equals("September")||month.equals("Sep")||month.equals("Sep.")||month.equals("9")) {
				monthNum = 9;
			}
			else if(month.equals("October")||month.equals("Oct")||month.equals("Oct.")||month.equals("10")) {
				monthNum = 10;
			}
			else if(month.equals("November")||month.equals("Nov")||month.equals("Nov.")||month.equals("11")) {
				monthNum = 11;
			}
			else if(month.equals("December")||month.equals("Dec")||month.equals("Dec.")||month.equals("12")) {
				monthNum = 12;
			}
			else {
				System.out.print("Invalid month, Enter again: ");
			}
		}
		System.out.print("Enter Year: ");
		int year = -1;
		while(year < 0) {
		    String yearInput = sc.nextLine();
		    try {
		        year = Integer.parseInt(yearInput);
		        if(year < 0) {
		            System.out.print("Invalid year, enter again: ");
		        } 
		    } catch(NumberFormatException e) {
		        System.out.print("Invalid year, enter again: ");
		    }
		}
		if (monthNum == 2) {
			if(isLeapYear(year)) {
				System.out.println("29");
			}
			else System.out.println("28");
		}
		else if(monthNum==1|| monthNum==3||monthNum==5||monthNum==7||monthNum==8||monthNum==10||monthNum==12) System.out.println("31");
		else System.out.println("30");
	}
}
