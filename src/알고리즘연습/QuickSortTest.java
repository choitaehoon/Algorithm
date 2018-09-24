package 알고리즘연습;

import java.util.Arrays;

public class QuickSortTest 
{
	static void swap(int[] a, int i, int j)
	{
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	static int partition(int[] a, int start, int end)
	{
		int value = a[end];
		int i = start-1;
		
		for(int j=start; j<end; ++j)
			if(a[j] < value) //1구역에 있다면
				swap(a,++i,j);
		swap(a,++i, end); //기준값하고 i값하고 바꾸기
		return i;
	}
	
	static void quickSort(int[] a, int start, int end)
	{
		if(start >= end) return; //원소가 하나면 리턴하라.
		int middle = partition(a,start,end);
		System.out.println(middle);
		quickSort(a,start,middle-1);
		quickSort(a,middle+1,end);
	}
	
	public static void main(String[] args) 
	{
		int[] a = {0,1,2,3,4,5,6,7,8,9};
		quickSort(a,0,a.length-1);
		System.out.println(Arrays.toString(a));
	}
}
