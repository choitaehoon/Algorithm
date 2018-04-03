package 알고리즘연습;

public class 재귀호출 {
	
	static void print(int[] a)
	{
		for(int i=0; i<a.length; ++i)
			System.out.printf("%d", a[i]);
		System.out.println();
			
	}
	
	static void selectionSort(int [] a)
	{
		for(int i=1; i<a.length-1; ++i)
		{
			int min=a[i-1];
			if(min > a[i])
				min = a[i];
			print(a);
		}
	}
	
	public static void main(String[] args) {
		int[] a = {7,4,1,9,3};
		selectionSort(a);
	}
}
// 0 1 2 3 4 5 6 7 8 9 10
