package 알고리즘연습;

import java.util.Scanner;

class LinkedList
{
	Node root;
	
	class Node
	{
		int data;
		Node left;
		Node right;
		
		public Node(int data)
		{
			this.data = data;
		}
	}
	
	public void insert(int data) //원소 삽입
	{
		Node newNode = new Node(data);
		Node temp = root;
		if(root == null)
			root = newNode;
		else
		{
			while(temp.right != null)
				temp = temp.right;
			temp.right = newNode;
			newNode.left = temp;
		}
	}
	
	public void remove(int data)
	{
		Node temp = root;
		if(temp == null)
		{
			System.out.println("원소가 없습니다");
			return ;
		}
		else
		{
			while(temp.data != data)
				temp = temp.right;
			if(temp.left == null && temp.right == null) //원소가 하나일때
				root = null;
			else if(temp.left == null && temp.right != null) // 원소가 두개 일때
				root = temp.right;
			else if(temp.left != null && temp.right != null) //원소가 중간 값 일때
				temp.left.right = temp.right;
			else // 원소가 끝 일때
			{
				temp.left.right = null;
				temp.left = null;
			}
		}
	}
	
	public void search()
	{
		Node temp = root;
		if(root == null)
			System.out.println("원소가 없습니다");
		else
		{
			while(temp != null)
			{
				System.out.print(temp.data+" ");
				temp = temp.right;
			}
		}
		System.out.println();
	}
}

public class DoubleLinkedList 
{
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		int num = 0;
		int value = 0;
		LinkedList l = new LinkedList();
		
		do
		{
			System.out.println("1.삽입  2.삭제  3.조회  4.종료  -->");
			num = input.nextInt();
			
			switch(num)
			{
				case 1:
					System.out.println("삽입 할 원소를 입력 하세요 -->");
					value = input.nextInt();
					l.insert(value);
					break;
				case 2 :
					System.out.println("삭제 할 원소를 입력 하세요  --> ");
					value = input.nextInt();
					l.remove(value);
					break;
				case 3:
					System.out.println("조회 합니다");
					l.search();
					break;
			}
		}while(num != 4);
	}
}
