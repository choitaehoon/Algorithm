package 알고리즘연습;

import java.util.Arrays;

public class 병합정렬 {
	
	static void mergeSort(int[] a,int start,int end)
	{
		if(start< end)
		{
			int middle = (start+end)/2;
			mergeSort(a,start,middle);
			mergeSort(a,middle+1,end);
			merge(a,start,middle,end);
		}
	}

	static void merge(int[] a,int start, int middle, int end)
	{
		int s= start;
		int m= middle+1;
		int[] temp = new int[end-start+1]; 
		int count =0;
		
		while(s<=middle && m<=end)
		{
			if(a[s] > a[m])
				temp[count++] = a[m++];
			else
				temp[count++] = a[s++];
		}
		
		while(s<=middle)
			temp[count++] = a[s++];
		while(m<=end)
			temp[count++] = a[m++];
		
		for(int i=0; i<temp.length; ++i)
			a[start+i] = temp[i]; 		
		
	}
	
	public static void main(String[] args) {
		int[] a = { 31, 3, 65, 73, 8, 11, 20, 29, 48, 15 };
		mergeSort(a, 0, a.length - 1);
		System.out.println(Arrays.toString(a));
	}
}
