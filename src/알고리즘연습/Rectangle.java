package 알고리즘연습;

import java.util.Scanner;

public class Rectangle 
{
	static int min(int i, int j)
	{
		return i<j ? i : j;
	}
	
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		int x,y,w,h;
		
		x = input.nextInt();
		y = input.nextInt();
		w = input.nextInt();
		h = input.nextInt();
		
		System.out.printf("%d",min(x,min(y,min(w-x,h-y))));
	}
}
