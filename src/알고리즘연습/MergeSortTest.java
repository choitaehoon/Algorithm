package 알고리즘연습;

import java.util.Arrays;

public class MergeSortTest 
{
	static void merge(int[] a, int start ,int middle ,int end)
	{
		int[] temp = new int[end-start+1]; //임시 배열
		int search1 = start;
		int search2 = middle+1;
		int search3 = 0; //임시 변수 원소 이동
		
		while(search1<=middle && search2<=end)
		{
			if(a[search1]<a[search2])
				temp[search3++] = a[search1++];
			else
				temp[search3++] = a[search2++];
		}
		
		while(search1<=middle)
			temp[search3++] = a[search1++];
		while(search2<=end)
			temp[search3++] = a[search2++];
		
		for(search3 =0; search3<temp.length; ++search3)
			a[start+search3] = temp[search3];
	}
	
	static void mergeSort(int[] a, int start, int end)
	{
		if(start >= end) return; //원소가 하나 일때 리턴
		int middle = (start+end)/2; //반으로 쪼갬
		mergeSort(a, start ,middle);
		mergeSort(a, middle+1, end);
		merge(a,start,middle,end);
	}
	
	public static void main(String[] args) 
	{
		int[] a = {31 ,3, 65, 73, 8, 11};
		mergeSort(a,0,a.length-1);
		System.out.println(Arrays.toString(a));
	}
	
}
