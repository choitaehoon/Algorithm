package 알고리즘연습;

import java.util.Arrays;

public class QuickSort {

	static void swap(int[] a, int i, int j) 
	{
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	static int partition(int[] a, int start, int end) { //기준값이 앞일때
		int value = a[start];
		int i=end+1; //1구역
		for(int j=end; j>=start+1; --j)
			if(value < a[j])
				swap(a, --i, j);
		swap(a, i-1, start);
		return i-1;
	}

	static void quickSort(int[] a, int start, int end) {
		if(start >= end) return;
		int middle = partition(a,start,end);
		quickSort(a, start, middle-1);
		quickSort(a, middle+1, end);
	}

	public static void main(String[] args) {
		int[] a = {19,2,55,43,1};
		System.out.println(Arrays.toString(a));
		quickSort(a, 0, a.length - 1);
		System.out.println(Arrays.toString(a));
	}
	
}
