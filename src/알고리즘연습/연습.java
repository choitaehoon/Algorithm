package 알고리즘연습;

import java.util.Arrays;

public class 연습 
{
	static void mergeSort(int[] a,int start,int end)
	{
		if(start < end)
		{
			int middle = (start+end)/2;
			mergeSort(a,start,middle);
			mergeSort(a,middle+1,end);
			merge(a,start,middle,end);
		}
	}
	
	static void merge(int[] a,int start, int middle, int end)
	{
		int[] temp = new int[end-start+1];
		int s = start;
		int m = middle;
		
		
	}
	
	public static void main(String[] args) 
	{
		int[] a = { 31, 3, 65, 73, 8, 11};
		mergeSort(a, 0, a.length - 1);
		System.out.println(Arrays.toString(a));
	}
}

