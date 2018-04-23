package 알고리즘연습;

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

		public boolean contains(int value) {
			if (value < this.value)
				return left != null && left.contains(value);
			else if (value > this.value)
				return right != null && right.contains(value);
			return true;
		}

		public int getLeftMostValue() 
		{
			Node temp; //원소탐색노드
			for(temp = this; temp.left!= null;)
				 temp = temp.left;
			return temp.value;
		}

		public void remove(int value, Node parent) {
			if (value < this.value) {
				if (left != null)
					left.remove(value, this);
			} else if (value > this.value) {
				if (right != null)
					right.remove(value, this);
			} else {
				if (left != null && right != null) {
					int temp = right.getLeftMostValue();
					this.value = temp;
					right.remove(temp, this);
				} else {
					Node child = (left != null) ? left : right;
					if (parent.left == this)
						parent.left = child;
					else
						parent.right = child;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] a = { 5, 18, 1, 12, 7, 2, 14, 6, 9, 15 };
		Node root = new Node(10);
		for (int i = 0; i < a.length; ++i)
			root.add(a[i]);
		root.print();
		System.out.println();
	}
}
