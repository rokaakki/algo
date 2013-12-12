package tree;
public class Node {
	public Node leftChild;
	public Node rightChild;
	public int value;
	public int height;
	public Node parent;
	public Node(int v,Node l,Node r){
		value=v;
		leftChild=l;
		rightChild=r;
		parent=null;
		if(l!=null)
			l.parent=this;
		if(r!=null)
			r.parent=this;
	}
	public Node(int v,Node l,Node r,Node p){
		height=0;
		value=v;
		leftChild=l;
		rightChild=r;
		parent=p;
		if(l!=null)
			l.parent=this;
		if(r!=null)
			r.parent=this;
	}
	public boolean isLeaf(){
		return (height==0);
	}
	public int maxChildHeight(){
		if(leftChild==null&&rightChild==null)
			return -1;
		else if(leftChild==null)
			return rightChild.height;
		else if(rightChild==null)
			return leftChild.height;
		else{
			if(leftChild.height>rightChild.height)
				return leftChild.height;
			else
				return rightChild.height;
		}
	}
	public int Balance(){
		int left,right;
		if(leftChild==null)
			left=-1;
		else
			left=leftChild.height;
		if(rightChild==null)
			right=-1;
		else
			right=rightChild.height;
		return (left-right);
	}
}
