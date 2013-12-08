package Tree;
public class Node {
	public Node leftChild;
	public Node rightChild;
	public int value;
	public Node(int v,Node l,Node r){
		value=v;
		leftChild=l;
		rightChild=r;
	}
}
