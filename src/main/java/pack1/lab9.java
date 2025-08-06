package pack1;

import java.util.Scanner;

public class lab9 {
	String str;
	public lab9(String str) {
		this.str = str;
	}
	public void addString() {
		System.out.println("Result: " + str + str);
	}


	public static void main(String[] args) {
		while(true) {
		System.out.println("String operations");
		System.out.println("1.Add the string itself");
		System.out.println("2.replace odd positions with #");
		System.out.println("3.remove duplicate characters in the string");
		System.out.println("4.change odd characters to upper case");

		Scanner sc=new Scanner (System.in);
		System.out.print("Enter the string: ");

		String input = sc.nextLine();
		lab9 obj = new lab9(input);

		System.out.println("enter the choice:");
		int choice=sc.nextInt();


		switch(choice) {
		case 1:
			obj.addString();
			break;
		case 2:
			obj.replaceWith();
			break;
		case 3:
			obj.removeDuplicates();
			break;
		case 4:
			obj.oddToUpper();
			break;
		default:
			System.out.println("Invalid choice.");
		}
	}
	}
	private void replaceWith() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder(str);
		for (int i = 1; i < sb.length(); i += 2) {
			sb.setCharAt(i, '#');
		}
		System.out.println("result:"+sb.toString());
	}
	private void oddToUpper() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (i % 2 == 1) {
				sb.append(Character.toUpperCase(ch));
			} else {
				sb.append(ch);
			}
		}
		System.out.println( "result:"+sb.toString());
	}
	private void removeDuplicates() {
		// TODO Auto-generated method stub
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (result.indexOf(String.valueOf(ch)) == -1) {
				result.append(ch);
			}
		}
		System.out.println("Result: " + result.toString());
	}
}