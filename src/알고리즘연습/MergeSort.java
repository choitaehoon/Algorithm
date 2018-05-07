package 알고리즘연습;

import java.util.Arrays;

public class MergeSort {

	static void merge(int[] a, int start, int middle, int end) { 
		int[] array = new int[end-start+1]; //임시 저장 변수
		int i=0; //임시 저장변수 첫번째 
		int index1 = start;
		int index2 = middle+1;
		
		while(index1<= middle && index2<= end)
		{
			if(a[index1] < a[index2])
				array[i++] = a[index1++];
			else
				array[i++] = a[index2++];
		}
		while(index1 <=middle)
			array[i++] = a[index1++];
		
		while(index2 <=end)
			array[i++] = a[index2++];
		
		for(i=0; i<array.length; ++i)
			a[start+i] = array[i];
	}
		
	

	static void mergeSort(int[] array, int start, int end) {
		if (start >= end)
			return;
		else {
			int middle = (start + end) / 2;
			mergeSort(array, start, middle);
			mergeSort(array, middle + 1, end);
			merge(array, start, middle, end);
		}
	}

	public static void main(String[] args) {
		int[] array = { 8, 19, 10, 7, 23, 15 };
		System.out.println(Arrays.toString(array));
		mergeSort(array, 0, array.length - 1);
		System.out.println(Arrays.toString(array));
	}
}
