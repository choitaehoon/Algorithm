package 알고리즘연습;

import java.util.Scanner;

public class Virus 
{
	static int[][] search; //원소저장
	static int count; //수 증가
	
	static void exploration() // 원소 탐색 메소드
	{
		
	}
	
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		int num = input.nextInt(); //컴퓨터 수 입력
		
		int rising = input.nextInt(); //노드 선 몇개 그을지 정하기
		for(int i=0; i<rising; ++i)
			search[input.nextInt()][input.nextInt()] = 1; //노드 선 이으기
		
		
	}
}
