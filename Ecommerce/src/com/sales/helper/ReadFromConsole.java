package com.sales.helper;

import java.util.Scanner;

public class ReadFromConsole {
	
	private static Scanner scan=new Scanner(System.in);
	
	public static String readString(String prompt)
	{
		System.out.println(prompt);
		return scan.next();
	}
	public static int readInt(String prompt)
	{
		System.out.println(prompt);
		return scan.nextInt();
	}
	public static double readDouble(String prompt)
	{
		System.out.println(prompt);
		return scan.nextDouble();
	}
	
	public static boolean readBoolean(String prompt)
	{
		System.out.println(prompt);
		return scan.nextBoolean();
	}

}
