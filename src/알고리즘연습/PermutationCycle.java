package 알고리즘연습;

import java.util.Scanner;

public class PermutationCycle 
{
	static boolean[] search; //탐색 배열
	static int[] put;
	static int count; //탐색 갯수 
	
	static void depthFirstSearch(int j)
	{
		if(search[j]) //true라면
		{
			count++; //사이클 수 세기
			return;
		}
		
		search[j] = true;
		depthFirstSearch(put[j]);
	}
	
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		System.out.println("몇개의 사이클을 입력하시겠습니까?");
		int num1 = input.nextInt();
		
		for(int i=0; i<num1; ++i)
		{
			System.out.println("몇개의 원소를 입력하시겠습니까?");
			int temp = input.nextInt();
			put = new int[temp+1];
			search = new boolean[temp+1];
			
			for(int j=1; j<temp+1; ++j)
				put[j] = input.nextInt();
			
			for(int j=1; j<temp+1; ++j)
				if(!search[j])
					depthFirstSearch(j);
			System.out.println(count);
			count = 0; //수 초기화
		}
	}
}
