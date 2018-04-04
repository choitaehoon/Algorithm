package 알고리즘연습;

import java.util.Random;

public class BinaryTree {

	static class Node {
		int value;
		Node left;
		Node right;

		public Node(int value) {
			this.value = value;
			this.left = null;
			this.right = null;
		}

		public void add(int value) {
			if (value < this.value) {
				if (left == null)
					left = new Node(value);
				else
					left.add(value);
			} else if (value > this.value) {
				if (right == null)
					right = new Node(value);
				else
					right.add(value);
			}
		}

		public void print() {
			if (left != null)
				left.print();
			System.out.printf("%d ", value);
			if (right != null)
				right.print();
		}

		public boolean contains(int value) 
		{
			if(this.value == value) //값이 있다면 true
				return true;
			if(left == null && right == null) //다음 노드가 없다면 false
				return false;
			else if(this.value < value) //값이 크면 오른쪽으로 가기
			{
				if(right == null) //하지만 오른쪽이 없으면 false
					return false;
				else	
					return right.contains(value);
			}
			else //값이 작으면 왼쪽으로 가기
			{
				if(left == null) // 하지만 왼쪽이 비었다면 false
					return false;
				else
					return left.contains(value);	
			}
			
		}
	}

	public static void main(String[] args) {
		Random random = new Random();
		Node root = new Node(random.nextInt(20));
		for (int i = 0; i < 15; ++i)
			root.add(random.nextInt(20));
		root.print();
		System.out.println();
		for (int i = 0; i < 20; ++i) {
			int value = random.nextInt(20);
			System.out.printf("%d %s\n", value, root.contains(value));
		}
	}
}